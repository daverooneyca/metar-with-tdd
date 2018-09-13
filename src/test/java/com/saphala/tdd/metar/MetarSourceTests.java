package com.saphala.tdd.metar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class MetarSourceTests {

   @Test
   void metarForDetroit() {
      MetarSource source = new MetarSource() {
         @Override
         protected String retrieveMetarFor(String station) {
            return "KDTW 210453Z 10006KT 9SM FEW025 BKN055 OVC110 23/20 A2987 RMK AO2 RAE35 SLP111 P0000 T02330200 402830194";
         }
      };
      
      Metar metar = source.metarFor("KDTW");
      
      assertThat(metar.getStation()).isEqualTo("KDTW");
      assertThat(metar.getReportTime()).isEqualTo("210453Z");
   }

   @Test
   void metarForChicago() {
      MetarSource source = new MetarSource() {
         @Override
         protected String retrieveMetarFor(String station) {
            return "KORD 111751Z VRB04KT 10SM FEW043 25/13 A3016 RMK AO2 SLP209 T02500128 10250 20144 58003";
         }
      };
      
      Metar metar = source.metarFor("KORD");
      
      assertThat(metar.getStation()).isEqualTo("KORD");
      assertThat(metar.getReportTime()).isEqualTo("111751Z");
   }

}
