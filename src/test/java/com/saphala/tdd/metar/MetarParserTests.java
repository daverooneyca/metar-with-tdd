package com.saphala.tdd.metar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class MetarParserTests {


   private static final String METAR_DETROIT  = "KDTW 210453Z 10006KT 9SM FEW025 BKN055 OVC110 23/20 A2987 RMK AO2 RAE35 SLP111 P0000 T02330200 402830194";
   private static final String METAR_CHICAGO  = "KORD 111751Z VRB04KT 10SM FEW043 25/13 A3016 RMK AO2 SLP209 T02500128 10250 20144 58003";
   private static final String METAR_JFK      = "KJFK 121651Z VRB04KT 6SM BR BKN007 OVC029 25/24 A3024 RMK AO2 SLP239 T02500244";
   private static final String METAR_EDMONTON = "CYEG 121751Z 34013G20KT 5SM -FZDZ BR BKN006 OVC011 M00/M01 A2995 RMK ST7SC1 SLP170";

   @Test
   void stationForDetroit() {
      MetarParser metar = new MetarParser(METAR_DETROIT);
      
      String station = metar.extractStation();

      assertThat(station).isEqualTo("KDTW");
   }

   @Test
   void reportTimeForDetroit() {
      MetarParser metar = new MetarParser(METAR_DETROIT);
      
      String reportTime = metar.extractReportTime();

      assertThat(reportTime).isEqualTo("210453Z");
   }
   
   @Test
   void windsForDetroit() {
      MetarParser metar = new MetarParser(METAR_DETROIT);
      
      String winds = metar.extractWinds();
      
      assertThat(winds).isEqualTo("10006KT");
   }
   
   @Test
   void visibilityForDetroit() {
      MetarParser metar = new MetarParser(METAR_DETROIT);
      
      String visibility = metar.extractVisibility();
            
      assertThat(visibility).isEqualTo("9SM");
   }
   
   @Test
   void cloudsForDetroit() {
      MetarParser metar = new MetarParser(METAR_DETROIT);
      
      List<String> clouds = metar.extractClouds();
      
      assertThat(clouds).containsExactly("FEW025", "BKN055", "OVC110");
   }
   
   @Test
   void temperatureForDetroit() {
      MetarParser metar = new MetarParser(METAR_DETROIT);
      
      String temperature = metar.extractTemperature();
      
      assertThat(temperature).isEqualTo("23/20");
   }
   
   @Test
   void altimeterForDetroit() {
      MetarParser metar = new MetarParser(METAR_DETROIT);
      
      String altimeter = metar.extractAltimeter();
      
      assertThat(altimeter).isEqualTo("A2987");
   }
   
   @Test
   void stationForChicago() {
      MetarParser metar = new MetarParser(METAR_CHICAGO);
      
      String station = metar.extractStation();
      
      assertThat(station).isEqualTo("KORD");
   }
   
   @Test
   void reportTimeForChicago() {
      MetarParser metar = new MetarParser(METAR_CHICAGO);
      
      String reportTime = metar.extractReportTime();
      
      assertThat(reportTime).isEqualTo("111751Z");
   }
   
   @Test
   void windsForChicago() {
      MetarParser metar = new MetarParser(METAR_CHICAGO);
      
      String winds = metar.extractWinds();
      
      assertThat(winds).isEqualTo("VRB04KT");
   }
   
   @Test
   void visibilityforChicago() {
      MetarParser metar = new MetarParser(METAR_CHICAGO);
      
      String visibility = metar.extractVisibility();
      
      assertThat(visibility).isEqualTo("10SM");
   }
   
   @Test
   void cloudsForChicago() {
      MetarParser metar = new MetarParser(METAR_CHICAGO);
      
      List<String> clouds = metar.extractClouds();
      
      assertThat(clouds).containsExactly("FEW043"); 
   }
   
   @Test
   void temperatureForChicago() {
      MetarParser metar = new MetarParser(METAR_CHICAGO);
      
      String temperature = metar.extractTemperature();
      
      assertThat(temperature).isEqualTo("25/13");
   }
   
   @Test
   void altimeterForChicago() {
      MetarParser metar = new MetarParser(METAR_CHICAGO);
      
      String altimeter = metar.extractAltimeter();
      
      assertThat(altimeter).isEqualTo("A3016");
   }
   
   @Test
   void weatherForChicago() {
      MetarParser metar = new MetarParser(METAR_CHICAGO);
      
      List<String> weather = metar.extractWeather();
      
      ArrayList<String> emptyList = new ArrayList<String>();
      
      assertThat(weather).isEqualTo(emptyList);
   }
   
   @Test
   void stationForJFK() {
      MetarParser metar = new MetarParser(METAR_JFK);
      
      String station = metar.extractStation();
      
      assertThat(station).isEqualTo("KJFK");
   }
   
   @Test
   void reportTimeForJFK() {
      MetarParser metar = new MetarParser(METAR_JFK);
      
      String reportTime = metar.extractReportTime();
      
      assertThat(reportTime).isEqualTo("121651Z");
   }
   
   @Test
   void windsForJFK() {
      MetarParser metar = new MetarParser(METAR_JFK);
      
      String winds = metar.extractWinds();
      
      assertThat(winds).isEqualTo("VRB04KT");
   }

   @Test
   void weatherForJFK() {
      MetarParser metar = new MetarParser(METAR_JFK);
      
      List<String> weather = metar.extractWeather();
      
      assertThat(weather).containsExactly("BR");
   }
   
   @Test
   void cloudsForJFK() {
      MetarParser metar = new MetarParser(METAR_JFK);
      
      List<String> clouds = metar.extractClouds();
      
      assertThat(clouds).containsExactly("BKN007", "OVC029");       
   }
   
   @Test
   void weatherForEdmonton() {
      MetarParser metar = new MetarParser(METAR_EDMONTON);
      
      List<String> weather = metar.extractWeather();
      
      assertThat(weather).containsExactly("-FZDZ", "BR");
   }
   

}
