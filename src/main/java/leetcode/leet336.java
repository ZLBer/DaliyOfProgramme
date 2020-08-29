package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leet336 {

    //先写个tle的..
/*

    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res=new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if(i!=j){
                String s=words[i]+words[j];
               if(check(s)){
                   res.add(new ArrayList<>(Arrays.asList(i,j)));
               }
                }
            }
        }
        return res;
    }*/
   boolean check(String s){
        int m=s.length()-1;
       for (int i = 0; i < s.length()/2; i++) {
           if(s.charAt(i)==s.charAt(m-i)){
               continue;
           }else {
               return false;
           }
       }
       return true;
   }




    public List<List<Integer>> palindromePairs(String[] words) {
        Map<String,Integer> map=new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(new StringBuilder(words[i]).reverse().toString(),i);
        }
        List<List<Integer>> res=new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            int m=words[i].length();


            //拼接得到字符串
            for (int j = 0; j <= m; j++) {
                String s1=words[i].substring(0,j);
                String s2=words[i].substring(j);
                // System.out.println(s1+" "+s2);
                if(check(s1)&&map.get(s2)!=null&&map.get(s2)!=i){
                    res.add(new ArrayList<>(Arrays.asList(map.get(s2),i)));
                }


                //让s2.length!=0 防止重复计算，
                if(s2.length()!=0&&check(s2)&&map.get(s1)!=null&&map.get(s1)!=i){
                    res.add(new ArrayList<>(Arrays.asList(i,map.get(s1))));
                }

            }
        }
        return res;
    }
}
