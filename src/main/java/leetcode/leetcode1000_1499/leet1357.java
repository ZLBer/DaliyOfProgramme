package leetcode.leetcode1000_1499;

import java.util.HashMap;
import java.util.Map;

public class leet1357 {
    class Cashier {
     Map<Integer,Integer> map=new HashMap<>();
     int count;
     int temp;
     int discount;
        public Cashier(int n, int discount, int[] products, int[] prices) {
            for (int i = 0; i < prices.length; i++) {
                map.put(products[i],prices[i]);
            }
            this.count=n;
            this.temp=n;
            this.discount=discount;
        }

        public double getBill(int[] product, int[] amount) {
              temp--;
              if(temp==0){
                  temp=count;
                  return getOldPrice(product,amount)*(1-discount)/100;
              }
              else {
                  return getOldPrice(product,amount);
              }
        }
        double getOldPrice(int[]product,int[]amount){
            double res=0d;
            for (int i = 0; i < product.length; i++) {
                res+=map.get(product[i])*amount[i];
            }
            return res;
        }
    }
}
