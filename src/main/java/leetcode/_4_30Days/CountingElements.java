package leetcode._4_30Days;

public class CountingElements {
    public int countElements(int[] arr) {
     boolean [] exist=new boolean[arr.length+2];
        for (int i : arr) {
            exist[i]=true;
        }
        int res=0;
        for (int i : arr) {
            if(exist[i+1]==true) res++;
        }
        return res;
    }
}
