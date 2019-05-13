import java.io.*;
import java.util.*;

class Solution {
   
  static int[] getOverlap(int[] slotA, int[] slotB) {
    int[] overlap = new int[2];
    overlap[0] = Math.max(slotA[0], slotB[0]);
    overlap[1] = Math.min(slotA[1], slotB[1]);
    return overlap;
  }
  
  static int[] meetingPlanner(int[][] slotsA, int[][] slotsB, int dur) {
    int ptrA = 0, ptrB = 0;
    
    while (ptrA < slotsA.length && ptrB < slotsB.length) {
      int[] overlap = getOverlap(slotsA[ptrA], slotsB[ptrB]);
      
      if (overlap[1] - overlap[0] >= dur)
        // Return the first interval with the given duration
        return new int[] {overlap[0], overlap[0] + dur};
      
      else
        // Increment the pointer for the earlier slot    
        if (slotsA[ptrA][1] < slotsB[ptrB][1])
          ptrA++;
        else 
          ptrB++;
    }
    
    // No common time slot found
    return new int[0];
  }
}
