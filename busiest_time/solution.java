import java.io.*;
import java.util.*;

class Solution {
	
  static int findBusiestPeriod(int[][] data) {
    int busiestTimestamp = 0;
    int maxVisitors = 0;
    int currentVisitors = 0;
    int prevTimestamp = 0;
    
    for (int i = 0; i < data.length; ++i) {
      
      // Check for next timestamp
      if (prevTimestamp != data[i][0]) {
        
        if (currentVisitors > maxVisitors) {
          // Update the busiest timestamp
          maxVisitors = currentVisitors;
          busiestTimestamp = prevTimestamp;
        }        

        // Update the last timestamp
        prevTimestamp = data[i][0];
      }
      
      if (data[i][2] == 1)
        currentVisitors += data[i][1];
      else 
        currentVisitors -= data[i][1];
    }
    
    // In case the last timstamp was the busiest
    if (currentVisitors > maxVisitors) {
      maxVisitors = currentVisitors;
      busiestTimestamp = prevTimestamp;
    }
    
    return busiestTimestamp;
  }

  public static void main(String[] args) {
    int[][] data = new int[][]{{1, 10, 1}, {1, 10, 0}, {2, 2, 1}};
    int val = findBusiestPeriod(data);
    System.out.println(val);
  }

}
