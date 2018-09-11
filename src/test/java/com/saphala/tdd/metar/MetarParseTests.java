package com.saphala.tdd.metar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class MetarParseTests {

   private static final int STATION_INDEX = 0;
   private static final int REPORT_TIME_INDEX = 1;
   private static final int WINDS_INDEX = 2;
   private static final int VISIBILITY_INDEX = 3;
   private static final int CLOUDS_BEGIN_INDEX = 4;
   private static final int CLOUDS_END_INDEX = 6;
   private static final int TEMPERATURE_INDEX = 7;
   private static final int ALTIMETER_INDEX = 8;

   private static final String METAR_DETROIT = "KDTW 210453Z 10006KT 9SM FEW025 BKN055 OVC110 23/20 A2987 RMK AO2 RAE35 SLP111 P0000 T02330200 402830194";
   private static final String METAR_CHICAGO = "KORD 111751Z VRB04KT 10SM FEW043 25/13 A3016 RMK AO2 SLP209 T02500128 10250 20144 58003";
   
   private String metar = METAR_DETROIT;
   
   
   @Test
   void stationShouldBeTheFirstElement() {
      String station = getItemAt(STATION_INDEX);

      assertThat(station).isEqualTo("KDTW");
   }

   @Test
   void reportTimeShouldBeTheSecondElement() {
      String reportTime = getItemAt(REPORT_TIME_INDEX);

      assertThat(reportTime).isEqualTo("210453Z");

   }
   
   @Test
   void windsShouldBeTheThirdElement() {
      String winds = getItemAt(WINDS_INDEX);
      
      assertThat(winds).isEqualTo("10006KT");
   }
   
   @Test
   void visibilityShouldBeTheFourthElement() {
      String visibility = getItemAt(VISIBILITY_INDEX);
            
      assertThat(visibility).isEqualTo("9SM");
   }
   
   @Test
   void cloudsShouldBeTheFifthThroughSeventhElements() {
      List<String> clouds = new ArrayList<String>();
      
      for (int i = CLOUDS_BEGIN_INDEX; i <= CLOUDS_END_INDEX; i++) {
         clouds.add(getItemAt(i));
      }
      
      assertThat(clouds).containsExactly("FEW025", "BKN055", "OVC110");
   }
   
   @Test
   void temperatureShouldBeTheEightElement() {
      String temperature = getItemAt(TEMPERATURE_INDEX);
      
      assertThat(temperature).isEqualTo("23/20");
   }
   
   @Test
   void altimeterShouldBeTheNinthElement() {
      String altimeter = getItemAt(ALTIMETER_INDEX);
      
      assertThat(altimeter).isEqualTo("A2987");
   }
   
   @Test
   void stationForChicagoShouldBeKORD() {
      metar = METAR_CHICAGO;
      
      String station = getItemAt(STATION_INDEX);
      
      assertThat(station).isEqualTo("KORD");
   }
   
   private String getItemAt(int index) {
      return metar.split(" ")[index];
   }

}
