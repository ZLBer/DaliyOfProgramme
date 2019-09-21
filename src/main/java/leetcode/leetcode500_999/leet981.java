package leetcode.leetcode500_999;

import leetcode.LQTest.A;

import java.util.*;

/**
 * Created by libin on 2019/1/27.
 */
//超时
public class leet981 {
  // LinkedList<LinkedList<String[]>>  trunk= new LinkedList<>();

/*   HashMap<String,LinkedList<String[]>> trunk=new HashMap<>();
    *//** Initialize your data structure here. *//*
    public leet981() {

    }

    public void set(String key, String value, int timestamp) {
        String []timestampAvalue=new String[2];
        timestampAvalue[0]=timestamp+"";
        timestampAvalue[1]=value;
        boolean flag=false;
   if(trunk.containsKey(key)){
       LinkedList<String[]> AL=trunk.get(key);
       for(int i=0;i<AL.size();i++){
           int curtime=Integer.parseInt(AL.get(i)[0]);
           if(curtime<timestamp) continue;
           else if(curtime==timestamp) {
               AL.get(i)[1]=value;
               flag=true;//更新操作
           }else  {
               AL.add(i,timestampAvalue);
               flag=true;
           }
       }

       if(flag==false) AL.add(timestampAvalue);


   }else{

       LinkedList<String[]> AL=new LinkedList<>();
       AL.add(timestampAvalue);
       trunk.put(key,AL);
   }





    }

    public String get(String key, int timestamp) {
       if(trunk.containsKey(key)){
           LinkedList<String[]> AL=trunk.get(key);
           for(int i=0;i<AL.size();i++){
               int curtime=Integer.parseInt(AL.get(i)[0]);
               if(curtime<timestamp) continue;
               else if(curtime==timestamp) {
                 return   AL.get(i)[1]; //更新操作
               }else{
                   if(i-1>=0)
                      return AL.get(i-1)[1];
                   else return "";
               }
           }

           return AL.get(AL.size()-1)[1];

       }
       else return null;


    }*/
    class TimeMap {
        Map<String, TreeMap<Integer, String>> trunk;
        public TimeMap() {
            trunk = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {

            if (!trunk.containsKey(key)){
                TreeMap <Integer,String> branch=new TreeMap<>();
                branch.put(timestamp,value);
                trunk.put(key, branch);
            }
            else trunk.get(key).put(timestamp, value);
        }

        public String get(String key, int timestamp) {
            //不存在这个key
            if (!trunk.containsKey(key)) return "";
           // floorKey()方法调用返回的最大键小于等于key,或者null
            Integer k = trunk.get(key).floorKey(timestamp);
            //不存比这个timestamp小或者等于的timestamp
            if(k == null) return "";
            //都存在则返回这个value
            return trunk.get(key).get(k);
        }
    }


}
