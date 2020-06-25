package leetcode._jianzhioffer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class p38 {

    //mine set去重  不好
/*    public String[] permutation(String s) {
        char[] arr=s.toCharArray();
    List<String> res=new ArrayList<>();
        heler(arr,0);
    return set.toArray(new String[res.size()]);
    }
    Set<String> set=new HashSet<>();
    void heler(char[]arr, int i){
  if(i>=arr.length){
      set.add(new String(arr));
      return;
  }
  for(int j=i;j<arr.length;j++){
   swap(arr,i,j);
  heler(arr,i+1);
   swap(arr,i,j);
  }
   }
   void swap(char []arr,int i,int j){
      char temp=arr[i];
      arr[i]=arr[j];
      arr[j]=temp;
   }*/


  //不用set去重
    public String[] permutation(String s) {
        char[] arr=s.toCharArray();
        List<String> res=new ArrayList<>();
        heler(arr,0,res);
        return set.toArray(new String[res.size()]);
    }
    Set<String> set=new HashSet<>();
    void heler(char[]arr, int i, List<String> res){
        if(i>=arr.length){
            set.add(new String(arr));
            return;
        }
        Set<Character> set=new HashSet<>();
        for(int j=i;j<arr.length;j++){
            if(set.contains(arr[j])) continue; //表示arr[j]已经在i位置放置过了
            set.add(arr[j]);
            swap(arr,i,j);
            heler(arr,i+1,res);
            swap(arr,i,j);
        }
    }
    void swap(char []arr,int i,int j){
        char temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
