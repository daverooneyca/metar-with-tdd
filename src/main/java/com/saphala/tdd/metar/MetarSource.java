package com.saphala.tdd.metar;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class MetarSource {

   private String apiKey;

   public MetarSource() {
      this(System.getenv("CHECKWX-API-KEY"));
   }

   public MetarSource(String apiKey) {
      this.apiKey = apiKey;

      Unirest.setObjectMapper(new ObjectMapper() {
         private com.fasterxml.jackson.databind.ObjectMapper jacksonObjectMapper = new com.fasterxml.jackson.databind.ObjectMapper();

         public <T> T readValue(String value, Class<T> valueType) {
             try {
                 return jacksonObjectMapper.readValue(value, valueType);
             } catch (IOException e) {
                 throw new RuntimeException(e);
             }
         }

         public String writeValue(Object value) {
             try {
                 return jacksonObjectMapper.writeValueAsString(value);
             } catch (JsonProcessingException e) {
                 throw new RuntimeException(e);
             }
         }
     });
   }

   public Metar metarFor(String station) {
      Metar metar = new Metar();

      MetarParser parser = new MetarParser(retrieveMetarFor(station));

      metar.setStation(parser.extractStation());
      metar.setReportTime(parser.extractReportTime());
      metar.setWinds(parser.extractWinds());
      metar.setVisibility(parser.extractVisibility());
      metar.setClouds(parser.extractClouds());
      metar.setTemperature(parser.extractTemperature());
      metar.setAltimeter(parser.extractAltimeter());

      return metar;
   }

   protected String retrieveMetarFor(String station) {
      try {
         HttpResponse<MetarResult> metarResponse = 
               Unirest.get("https://api.checkwx.com/metar/{station}/")
                 .header("accept", "application/json")
                 .header("X-API-Key", this.apiKey)
                 .routeParam("station", station)
                 .asObject(MetarResult.class);

         MetarResult result = metarResponse.getBody();

         String rawMetar = result.getData().get(0);

         if (rawMetar.toLowerCase().contains("invalid station")) {
             throw new RuntimeException("No results found for station: " + station);
         }

         if (rawMetar.toLowerCase().contains("currently unavailable")) {
             throw new RuntimeException("METAR currently unavailable for station: " + station);
         }

         return rawMetar;

     } catch (UnirestException e) {
         e.printStackTrace();
         
         throw new RuntimeException(e);
         
     } finally {
         try {
            Unirest.shutdown();
         } catch (Exception e) {
            throw new RuntimeException(e);
         }
     }
   }

}
