package com.saphala.tdd.metar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Metar {

   public static final int STATION_INDEX = 0;
   public static final int REPORT_TIME_INDEX = 1;
   public static final int WINDS_INDEX = 2;
   public static final int VISIBILITY_INDEX = 3;
   public static final int CLOUDS_BEGIN_INDEX = 4;
   public static final int TEMPERATURE_INDEX = 7;
   public static final int ALTIMETER_INDEX = 8;
   
   private String rawMetar;
   private String[] rawMetarArray;

   public Metar(String metar) {
      this.rawMetar = metar;
      this.rawMetarArray = this.rawMetar.split(" ");
   }

   public List<String> extractClouds() {
      int cloudsEndIndex = getCloudsEndIndex();
      
      List<String> clouds = Arrays.asList(rawMetarArray).subList(CLOUDS_BEGIN_INDEX, cloudsEndIndex);
            
      return clouds;
   }

   public String getItemAt(int index) {
      return rawMetarArray[index];
   }

   public String extractTemperature() {
      return getItemAt(getCloudsEndIndex());
   }

   private int getCloudsEndIndex() {
      int cloudsEndIndex = CLOUDS_BEGIN_INDEX;
      
      for (int i = CLOUDS_BEGIN_INDEX; i < rawMetarArray.length; i++) {
         if(Character.isDigit(rawMetarArray[i].charAt(0))) {
            break;
         }
         
         cloudsEndIndex++;
      }
      return cloudsEndIndex;
   }
}