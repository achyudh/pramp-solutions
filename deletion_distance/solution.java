import java.io.*;
import java.util.*;

class Solution {
  
  static int computeDistance(int[][] memo, String word1, String word2, int ptr1, int ptr2) {
      if (ptr1 >= word1.length())
          return word2.length() - ptr2;
      else if (ptr2 >= word2.length())
          return word1.length() - ptr1;

      if (memo[ptr1][ptr2] == -1) {

          if (word1.charAt(ptr1) == word2.charAt(ptr2))
              memo[ptr1][ptr2] = computeDistance(memo, word1, word2, ptr1 + 1, ptr2 + 1);

          else {
              int dist1 = computeDistance(memo, word1, word2, ptr1 + 1, ptr2);
              int dist2 = computeDistance(memo, word1, word2, ptr1, ptr2 + 1);
              memo[ptr1][ptr2] = 1 + Math.min(dist1, dist2);    
          }   
      }

      return memo[ptr1][ptr2];
  }
  
  static int deletionDistance(String str1, String str2) {
        int[][] memo = new int[str1.length()][str2.length()];
    
        for (int[] row : memo)
            Arrays.fill(row, -1);
        
        return computeDistance(memo, str1, str2, 0, 0);
  }
}
