package leetcode.leetcode1000_1499;

import java.util.*;

public class leet1348 {
    class TweetCounts {
        Map<String, TreeMap<Integer,Integer>> map=new HashMap<>();
        public TweetCounts() {
        }

        public void recordTweet(String tweetName, int time) {
         //map.putIfAbsent(tweetName,new TreeMap<Integer, Integer>());
     //   TreeMap<Integer,Integer> treeMap= map.get(tweetName);
            TreeMap<Integer,Integer> treeMap= map.computeIfAbsent(tweetName,k->new TreeMap<>());
        treeMap.put(time,treeMap.getOrDefault(time,0)+1);
        }

        public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
            TreeMap<Integer,Integer> treeMap= map.containsKey(tweetName)?map.get(tweetName):new TreeMap<Integer,Integer>();
              treeMap.ceilingEntry(startTime);
              int delta=getDelta(freq);
              int start=startTime;
              int end=Math.min(startTime+delta,endTime+1);
              List<Integer> result=new ArrayList<>();
              while (start<=endTime){
                  Map.Entry<Integer,Integer> entry=treeMap.ceilingEntry(start);
                  int count=0;
                  while (entry!=null&&entry.getKey()<end){
                      count+=entry.getValue();
                      entry=treeMap.higherEntry(entry.getKey());
                  }
                  result.add(count);
                  start=end;
                  end=Math.min(start+delta,endTime+1);
              }
              return result;

        }
        int getDelta(String freq){
            switch (freq){
                case "minute": return 60;
                case "hour":return 3600;
                case "day": return 86400;
            }
            return 0;
        }
    }
}
