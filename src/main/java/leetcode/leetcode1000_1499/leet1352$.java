package leetcode.leetcode1000_1499;

import java.util.ArrayList;
import java.util.List;

public class leet1352$ {
    //注意0处的截断
    class ProductOfNumbers {
       List<Integer> list=new ArrayList<>();
        public ProductOfNumbers() {
          list.add(1);
        }

        public void add(int num) {
       if(num==0){
        list=new ArrayList<>();
        list.add(1);
       }else {
           list.add(list.get(list.size()-1)*num);
       }
        }

        public int getProduct(int k) {
         return  k>=list.size()? 0: list.get(list.size()-1)/list.get(list.size()-k-1);
        }
    }
}
