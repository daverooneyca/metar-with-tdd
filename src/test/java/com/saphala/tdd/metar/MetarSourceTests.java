package com.saphala.tdd.metar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class MetarSourceTests {

   @Test
   void stationForDetroit() {
      MetarSource source = new MetarSource();
      
      Metar metar = source.retrieveMetarFor("KDTW");
      
      assertThat(metar.getStation()).isEqualTo("KDTW");
   }

   @Test
   void stationForChicago() {
      MetarSource source = new MetarSource();
      
      Metar metar = source.retrieveMetarFor("KORD");
      
      assertThat(metar.getStation()).isEqualTo("KORD");
   }

}
