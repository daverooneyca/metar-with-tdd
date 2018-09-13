package com.saphala.tdd.metar;

public class MetarSource {

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
      return null;
   }

}
