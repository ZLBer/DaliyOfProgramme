package leetcode.leetcode1000_;


import java.util.Arrays;
import java.util.Comparator;

public class leet1356 {
/*    public int[] sortByBits(int [] arr) {
        Integer []ar=new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ar[i]=arr[i];
        }
//        Arrays.sort(ar, (Integer a,Integer b)-> (Integer.bitCount(a)-Integer.bitCount(b))*10000+(a-b));
        Arrays.sort(ar, Comparator.comparing(i->Integer.bitCount(i)*10000+i));
        for (int i = 0; i < arr.length; i++) {
            arr[i]=ar[i];
        }
        return arr;
    }*/

    //stream
    public int[] sortByBits(int [] arr) {
      return Arrays.stream(arr).boxed().sorted(Comparator.comparingInt(i -> Integer.bitCount(i) * 10000 + i)).mapToInt(i->i).toArray();
    }
}
