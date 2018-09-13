package com.saphala.tdd.metar;

public class MetarSource {

   public Metar retrieveMetarFor(String station) {
      Metar metar = new Metar();
      
      MetarParser parser = new MetarParser(station);
      
      metar.setStation(parser.extractStation());
      
      return metar;
   }

}
