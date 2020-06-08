import java.util.*;
import java.io.*;

public class P18{
  public static void addNumber(int number, PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers ) {
  //if lowers is empty or number is less than lowers.peek else add in highers
    if(lowers.size()==0 || number<lowers.peek()){
      lowers.add(number); 
    }else{
      highers.add(number);
    }
  }

public static void rebalance(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers ) {
  PriorityQueue<Integer> biggerHeap = lowers.size() > highers.size() ? lowers:highers;
  PriorityQueue<Integer> smallerHeap = lowers.size() < highers.size() ? lowers:highers;
//Balancing Condition
  if(biggerHeap.size()- smallerHeap.size() >=2){
    smallerHeap.add(biggerHeap.poll());
  }
}
public static int getMedian(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers ) {
  PriorityQueue<Integer> biggerHeap = lowers.size() > highers.size() ? lowers:highers;
  PriorityQueue<Integer> smallerHeap = lowers.size()> highers.size() ? highers:lowers;
  if(biggerHeap.size()==smallerHeap.size()){
      return (biggerHeap.peek()+smallerHeap.peek())/2;
  }else{
    return biggerHeap.peek();
  }
}
  public static void getMedians(int[] array) {
    //MAX Heap for the Lower Half
    PriorityQueue<Integer> lowers = new PriorityQueue<Integer>(new Comparator<Integer>() {
          public int compare(Integer a , Integer b){
            return b-a;
          }
    });
    //MIN Heap for the Upper Half
    PriorityQueue<Integer> highers = new PriorityQueue<Integer>();    

    double[] medians = new double[array.length];
    for(int i=0;i<array.length;i++){
      int number = array[i];
      addNumber(number,lowers,highers);
      rebalance(lowers,highers);
      medians[i] = getMedian(lowers,highers);
    }
        System.out.println(Arrays.toString(medians));
  }

public static void main(String[] args) {
  
int[] arr = new int[]{5,15,1,3};
System.out.println(Arrays.toString(arr));
getMedians(arr);
  
} 
}
