package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class leet1333 {
    //mine stream
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        List<Restaurant> Restaurants=new ArrayList<>();
        for (int i = 0; i < restaurants.length; i++) {
            Restaurants.add(new Restaurant(restaurants[i][0],restaurants[i][1],restaurants[i][2],restaurants[i][3],restaurants[i][4]));
        }
       return Restaurants.stream().filter(r -> veganFriendly==1?r.veganFriendly==veganFriendly:true).filter(r->r.price<=maxPrice).filter(r->r.distance<=maxDistance).sorted((r1,r2)->r2.rating==r1.rating? r2.id-r1.id:r2.rating-r1.rating).map(r->r.id).collect(Collectors.toList());
    }




    class Restaurant{
         int id;
        int rating;
         int veganFriendly;
         int price;
         int distance;
    public Restaurant(int id, int rating, int veganFriendly, int price, int distance) {
        this.id = id;
        this.rating = rating;
        this.veganFriendly = veganFriendly;
        this.price = price;
        this.distance = distance;
    }

    }


    //不用stream
  /*  public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        HashMap<Integer, int[]> map = new HashMap<>();
        List<Integer> IDs = new ArrayList<>();
        for (int[] r : restaurants) {
            if (r[2] >= veganFriendly && r[3] <= maxPrice && r[4] <= maxDistance) {
                IDs.add(r[0]);
                map.put(r[0], r);
            }
        }
        Collections.sort(IDs, (id1, id2) -> {
            int rating1 = map.get(id1)[1], rating2 = map.get(id2)[1];
            if (rating1 == rating2) return id2 - id1; // If same rating, order them by id from highest to lowest
            return rating2 - rating1; // Ordered by rating from highest to lowest
        });
        return IDs;
    }*/
}
