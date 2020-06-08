
import java.util.*;

import sun.jvm.hotspot.utilities.IntArray;

import java.io.*;

public class P18 {

  public static int getKthlargest(int[] arr, int k) {
    int[] stream = new int[arr.length];
    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
    for (int i = 0; i < arr.length; i++) {
       minHeap.add(arr[i]);
      if (minHeap.size() > k) {
        minHeap.poll();
      }
      if(i<k-1){
      stream[i] = 0;
    }
    else{
      stream[i] = minHeap.peek();
    }
  }

    System.out.println(minHeap);
    System.out.println(Arrays.toString(stream));
    return minHeap.peek();
 
   }

  public static void main(String[] args) {

    int[] arr = new int[] { 10, 20, 11, 70, 50, 40, 100, 5 };
    System.out.println(Arrays.toString(arr));
    int ans = getKthlargest(arr, 3);
    System.out.println(ans);
  }

}
