package leetcode.leetcode1000_;


import java.util.HashMap;
import java.util.Map;

public class leet1396 {
    //mine  两个map 一个对象封装
/*    class UndergroundSystem {
   Map<Integer,Customer> in=new HashMap<>();
   Map<String,Customer> count=new HashMap<>();
        public UndergroundSystem() {

        }

        public void checkIn(int id, String stationName, int t) {
         in.put(id,new Customer(id,stationName,t));
        }

        public void checkOut(int id, String stationName, int t) {
          Customer c=in.remove(id);
          String travel=c.stationName+"-"+stationName;
          if(count.containsKey(travel)){
            Customer s=count.get(travel);
              count.put(travel,new Customer(s.id+1,"",s.t+t-c.t));
          }else {
              count.put(travel,new Customer(1,"",t-c.t));
          }
        }

        public double getAverageTime(String startStation, String endStation) {
           Customer c=  count.get(startStation+"-"+endStation);
           return  c.t/(double)c.id;
        }
      //起到了两个作用..
        class  Customer{
        int id;
        String stationName;
        int t;
        public Customer(int id, String stationName, int t) {
                this.id = id;
                this.stationName = stationName;
                this.t = t;
            }

        }
    }*/


   //mine 不用对象
    class UndergroundSystem {
        Map<Integer,String[]> in=new HashMap<>();
        Map<String,int []> count=new HashMap<>();
        public UndergroundSystem() {

        }

        public void checkIn(int id, String stationName, int t) {
            in.put(id,new String[]{stationName,t+""});
        }

        public void checkOut(int id, String stationName, int t) {
            String[] c=in.remove(id);
            String travel=c[0]+"-"+stationName;
            if(count.containsKey(travel)){
                int[] s=count.get(travel);
                count.put(travel,new int[]{s[0]+1,s[1]+t-Integer.parseInt(c[1])});
            }else {
                count.put(travel,new int[]{1,t-Integer.parseInt(c[1])});
            }
        }

        public double getAverageTime(String startStation, String endStation) {
           int[]c=  count.get(startStation+"-"+endStation);
            return  c[1]/(double)c[0];
        }

    }


    //pair对
   /* class UndergroundSystem {
        HashMap<String, Pair<Integer, Integer>> checkoutMap = new HashMap<>(); // Route - {TotalTime, Count}
        HashMap<Integer, Pair<String, Integer>> checkInMap = new HashMap<>();  // Uid - {StationName, Time}

        public UndergroundSystem() {}

        public void checkIn(int id, String stationName, int t) {
            checkInMap.put(id, new Pair<>(stationName, t));
        }

        public void checkOut(int id, String stationName, int t) {
            Pair<String, Integer> checkIn = checkInMap.get(id);
            String route = checkIn.getKey() + "_" + stationName;
            int totalTime = t - checkIn.getValue();
            Pair<Integer, Integer> checkout = checkoutMap.getOrDefault(route, new Pair<>(0, 0));
            checkoutMap.put(route, new Pair<>(checkout.getKey() + totalTime, checkout.getValue() + 1));
        }

        public double getAverageTime(String startStation, String endStation) {
            String route = startStation + "_" + endStation;
            Pair<Integer, Integer> checkout = checkoutMap.get(route);
            return (double) checkout.getKey() / checkout.getValue();
        }
    }*/

}
