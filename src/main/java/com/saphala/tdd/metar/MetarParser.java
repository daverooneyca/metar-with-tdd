package com.saphala.tdd.metar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MetarParser { 

   private static final int STATION_INDEX = 0;
   private static final int REPORT_TIME_INDEX = 1;
   private static final int WINDS_INDEX = 2;
   private static final int VISIBILITY_INDEX = 3;
   
   private static final int TEMPERATURE_OFFSET = 0;
   private static final int ALTIMETER_OFFSET = 1;

   
   private String[] rawMetar;

   public MetarParser(String metar) {
      this.rawMetar = metar.split(" ");
   }

   public List<String> extractClouds() {
      return Arrays.asList(rawMetar).subList(getCloudsBeginIndex(), getCloudsEndIndex());
   }

   public String extractTemperature() {
      return getItemAt(getCloudsEndIndex() + TEMPERATURE_OFFSET);
   }

   public String extractAltimeter() {
      return getItemAt(getCloudsEndIndex() + ALTIMETER_OFFSET);
   }

   public List<String> extractWeather() {
      List<String> weather = new ArrayList<String>();
      
      for (int i = VISIBILITY_INDEX + 1; i < getCloudsBeginIndex(); i++) {
         weather.add(rawMetar[i]);
      }
      
      return weather;
   }

   public String extractStation() {
      return getItemAt(MetarParser.STATION_INDEX);
   }

   public String extractReportTime() {
      return getItemAt(MetarParser.REPORT_TIME_INDEX);
   }

   public String extractWinds() {
      return getItemAt(MetarParser.WINDS_INDEX);
   }

   public String extractVisibility() {
      return getItemAt(MetarParser.VISIBILITY_INDEX);
   }

   private String getItemAt(int index) {
      return rawMetar[index];
   }

   private int getCloudsEndIndex() {
      int cloudsBeginIndex = getCloudsBeginIndex();
      int cloudsEndIndex = cloudsBeginIndex;
      
      for (int i = cloudsBeginIndex; i < rawMetar.length; i++) {
         if(Character.isDigit(rawMetar[i].charAt(0))) {
            break;
         }
         
         cloudsEndIndex++;
      }
      return cloudsEndIndex;
   }

   private int getCloudsBeginIndex() {
      int cloudsBeginIndex = VISIBILITY_INDEX;
      
      List<String> cloudPrefixes = Arrays.asList(new String[]{"SKC", "FEW", "SCT", "BKN", "OVC"});
      
      for (int i = VISIBILITY_INDEX; i < rawMetar.length; i++) {
         String element = rawMetar[i];
         
         String prefix = prefixFrom(element);
         
         if(cloudPrefixes.contains(prefix)) {
            break;
         }
         
         cloudsBeginIndex++;
      }
      
      return cloudsBeginIndex;
   }

   private String prefixFrom(String element) {
      if (element.length() < 3) {
         return element;
      }
      
      return element.substring(0, 3);
   }

}
