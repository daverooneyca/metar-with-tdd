package com.saphala.tdd.metar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class MetarParseTests {

   private static final String RAW_METAR = "KDTW 210453Z 10006KT 9SM FEW025 BKN055 OVC110 23/20 A2987 RMK AO2 RAE35 SLP111 P0000 T02330200 402830194";

   @Test
   void stationShouldBeTheFirstElement() {
      String station = getItemAt(0);

      assertThat(station).isEqualTo("KDTW");
   }

   @Test
   void reportTimeShouldBeTheSecondElement() {
      String reportTime = getItemAt(1);

      assertThat(reportTime).isEqualTo("210453Z");

   }
   
   @Test
   void windsShouldBeTheThirdElement() {
      String winds = getItemAt(2);
      
      assertThat(winds).isEqualTo("10006KT");
   }
   
   @Test
   void visibilityShouldBeTheFourthElement() {
      String visibility = getItemAt(3);
            
      assertThat(visibility).isEqualTo("9SM");
   }
   
   
   private String getItemAt(int index) {
      return RAW_METAR.split(" ")[index];
   }

}
