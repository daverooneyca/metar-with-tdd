package com.saphala.tdd.metar;

import java.util.HashMap;
import java.util.Map;

public class FakeMetarSource extends MetarSource {
   
   private Map<String, String> rawMetars;
   
   public FakeMetarSource() {
      this.rawMetars = new HashMap<String, String>();
      
      this.rawMetars.put("KDTW", "KDTW 210453Z 10006KT 9SM FEW025 BKN055 OVC110 23/20 A2987 RMK AO2 RAE35 SLP111 P0000 T02330200 402830194");
      this.rawMetars.put("KORD", "KORD 111751Z VRB04KT 10SM FEW043 25/13 A3016 RMK AO2 SLP209 T02500128 10250 20144 58003");
   }
   
   @Override
   public Metar metarFor(String station) {
      Metar metar = new Metar();

      MetarParser parser = new MetarParser(this.rawMetars.get(station));

      metar.setStation(parser.extractStation());
      metar.setReportTime(parser.extractReportTime());
      metar.setWinds(parser.extractWinds());
      metar.setVisibility(parser.extractVisibility());
      metar.setClouds(parser.extractClouds());
      metar.setTemperature(parser.extractTemperature());
      metar.setAltimeter(parser.extractAltimeter());

      return metar;
   }
}
