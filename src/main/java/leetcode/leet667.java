package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class leet667 {


    //不应该再用dfs了  太深了，很容易就超时了
/*   private void swap(int []array,int i,int j){
       int tem=array[i];
       array[i]=array[j];
       array[j]=tem;
   }
    public int[] constructArray(int n, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        int[] array=new int[n];
        for (int i = 0; i < array.length; i++) {
            array[i]=i+1;
        }
        int []result=null;
        for(int i=0;i<array.length;i++){
            swap(array,0,i);
            result=dfs(array,1,n,k,map);
            if(result!=null) return result;
            swap(array,0,i);
        }
        return null;
    }

    int[] dfs(int[]array,int start,int n,int k ,Map<Integer,Integer> map){
        if(map.size()>k)
            return null;
       if(start>=n&&map.size()==k){
           return array;
       }

       int []result=null;
       for(int i=start;i<n;i++){
           swap(array,start,i);
           int key=Math.abs(array[start]-array[start-1]);
           int value=map.getOrDefault(key,0)+1;
           map.put(key,value);

           result=dfs(array,start+1,n,k,map);

           if(result!=null)
               return result;
           if(value==1)
               map.remove(key);
           else
               map.put(key,value-1);
           swap(array,start,i);
       }
       return null;
    }*/


//奇偶一大一小
    public int[] constructArray(int n, int k) {
    int[]result=new int[n];
    int i=0,left=1,right=n;
    while (i<k){
        result[i++]=left++;
        if(i<k) result[i++]=right--;
    }

    if(k%2==0)
        while (i<n) result[i++]=right--;
     else
         while (i<n) result[i++]=left++;
     return result;

    }



    public static void main(String[] args) {
        int[] a=null;
        int[]b=new int[1];
        a=b;
    }
}
