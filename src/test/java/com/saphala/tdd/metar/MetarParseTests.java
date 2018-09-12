package com.saphala.tdd.metar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;

class MetarParseTests {


   private static final String METAR_DETROIT = "KDTW 210453Z 10006KT 9SM FEW025 BKN055 OVC110 23/20 A2987 RMK AO2 RAE35 SLP111 P0000 T02330200 402830194";
   private static final String METAR_CHICAGO = "KORD 111751Z VRB04KT 10SM FEW043 25/13 A3016 RMK AO2 SLP209 T02500128 10250 20144 58003";
   private static final String METAR_JFK     = "KJFK 121651Z VRB04KT 6SM BR BKN007 OVC029 25/24 A3024 RMK AO2 SLP239 T02500244";

   @Test
   void stationForDetroit() {
      Metar metar = new Metar(METAR_DETROIT);
      
      String station = metar.getItemAt(Metar.STATION_INDEX);

      assertThat(station).isEqualTo("KDTW");
   }

   @Test
   void reportTimeForDetroit() {
      Metar metar = new Metar(METAR_DETROIT);
      
      String reportTime = metar.getItemAt(Metar.REPORT_TIME_INDEX);

      assertThat(reportTime).isEqualTo("210453Z");
   }
   
   @Test
   void windsForDetroit() {
      Metar metar = new Metar(METAR_DETROIT);
      
      String winds = metar.getItemAt(Metar.WINDS_INDEX);
      
      assertThat(winds).isEqualTo("10006KT");
   }
   
   @Test
   void visibilityForDetroit() {
      Metar metar = new Metar(METAR_DETROIT);
      
      String visibility = metar.getItemAt(Metar.VISIBILITY_INDEX);
            
      assertThat(visibility).isEqualTo("9SM");
   }
   
   @Test
   void cloudsForDetroit() {
      Metar metar = new Metar(METAR_DETROIT);
      
      List<String> clouds = metar.extractClouds();
      
      assertThat(clouds).containsExactly("FEW025", "BKN055", "OVC110");
   }
   
   @Test
   void temperatureForDetroit() {
      Metar metar = new Metar(METAR_DETROIT);
      
      String temperature = metar.extractTemperature();
      
      assertThat(temperature).isEqualTo("23/20");
   }
   
   @Test
   void altimeterForDetroit() {
      Metar metar = new Metar(METAR_DETROIT);
      
      String altimeter = metar.extractAltimeter();
      
      assertThat(altimeter).isEqualTo("A2987");
   }
   
   @Test
   void stationForChicago() {
      Metar metar = new Metar(METAR_CHICAGO);
      
      String station = metar.getItemAt(Metar.STATION_INDEX);
      
      assertThat(station).isEqualTo("KORD");
   }
   
   @Test
   void reportTimeForChicago() {
      Metar metar = new Metar(METAR_CHICAGO);
      
      String reportTime = metar.getItemAt(Metar.REPORT_TIME_INDEX);
      
      assertThat(reportTime).isEqualTo("111751Z");
   }
   
   @Test
   void windsForChicago() {
      Metar metar = new Metar(METAR_CHICAGO);
      
      String winds = metar.getItemAt(Metar.WINDS_INDEX);
      
      assertThat(winds).isEqualTo("VRB04KT");
   }
   
   @Test
   void visibilityforChicago() {
      Metar metar = new Metar(METAR_CHICAGO);
      
      String visibility = metar.getItemAt(Metar.VISIBILITY_INDEX);
      
      assertThat(visibility).isEqualTo("10SM");
   }
   
   @Test
   void cloudsForChicago() {
      Metar metar = new Metar(METAR_CHICAGO);
      
      List<String> clouds = metar.extractClouds();
      
      assertThat(clouds).containsExactly("FEW043"); 
   }
   
   @Test
   void temperatureForChicago() {
      Metar metar = new Metar(METAR_CHICAGO);
      
      String temperature = metar.extractTemperature();
      
      assertThat(temperature).isEqualTo("25/13");
   }
   
   @Test
   void altimeterForChicago() {
      Metar metar = new Metar(METAR_CHICAGO);
      
      String altimeter = metar.extractAltimeter();
      
      assertThat(altimeter).isEqualTo("A3016");
   }
   
   @Test
   void stationForJFK() {
      Metar metar = new Metar(METAR_JFK);
      
      String station = metar.getItemAt(Metar.STATION_INDEX);
      
      assertThat(station).isEqualTo("KJFK");
   }
   
   @Test
   void reportTimeForJFK() {
      Metar metar = new Metar(METAR_JFK);
      
      String reportTime = metar.getItemAt(Metar.REPORT_TIME_INDEX);
      
      assertThat(reportTime).isEqualTo("121651Z");
   }
   
   @Test
   void windsForJFK() {
      Metar metar = new Metar(METAR_JFK);
      
      String winds = metar.getItemAt(Metar.WINDS_INDEX);
      
      assertThat(winds).isEqualTo("VRB04KT");
   }

   @Test
   void weatherForJFK() {
      Metar metar = new Metar(METAR_JFK);
      
      String weather = metar.getItemAt(Metar.WEATHER_INDEX);
      
      assertThat(weather).isEqualTo("BR");
   }
   
   @Test
   void cloudsForJFK() {
      Metar metar = new Metar(METAR_JFK);
      
      List<String> clouds = metar.extractClouds();
      
      assertThat(clouds).containsExactly("BKN007", "OVC029");       
   }
   

}
