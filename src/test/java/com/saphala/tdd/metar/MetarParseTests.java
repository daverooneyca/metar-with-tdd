package com.saphala.tdd.metar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class MetarParseTests {

   @Test
   void stationShouldBeTheFirstElement() {
      String rawMetar = "KDTW 210453Z 10006KT 9SM FEW025 BKN055 OVC110 23/20 A2987 RMK AO2 RAE35 SLP111 P0000 T02330200 402830194";

      String station = rawMetar.split(" ")[0];

      assertThat(station).isEqualTo("KDTW");
   }

}
