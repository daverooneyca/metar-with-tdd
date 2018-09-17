package com.saphala.tdd.metar;

import java.util.List;

public class MetarResult {
   private int results;
   private List<String> data;
   
   public int getResults() {
      return results;
   }
   public void setResults(int results) {
      this.results = results;
   }
   public List<String> getData() {
      return data;
   }
   public void setData(List<String> data) {
      this.data = data;
   }
}
