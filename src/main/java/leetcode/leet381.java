package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class leet381 {

    class RandomizedCollection {

        Map<Integer, Set<Integer>> idx=new HashMap<>();
        List<Integer> nums=new ArrayList<>();
        /** Initialize your data structure here. */
        public RandomizedCollection() {

        }

        /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
        public boolean insert(int val) {
        if(!idx.containsKey(val)) idx.put(val,new HashSet<>());

        Set<Integer> set = idx.get(val);
        set.add(nums.size());
        nums.add(val);
        return set.size()==1;
        }

        /** Removes a value from the collection. Returns true if the collection contained the specified element. */
        public boolean remove(int val) {
            for (Map.Entry<Integer, Set<Integer>> integerSetEntry : idx.entrySet()) {
                System.out.println(integerSetEntry.getKey()+" ");
                for (Integer integer : integerSetEntry.getValue()) {
                    System.out.print(integer+" ");
                }
                System.out.println();
            }
         if(!idx.containsKey(val)){
             return false;
         }

            Iterator<Integer> iterator = idx.get(val).iterator();
            int id=iterator.next();

           int num = nums.get(nums.size()-1);

           nums.set(id,num);

           idx.get(num).remove(nums.size()-1);


           idx.get(val).remove(id);

            if (id < nums.size() - 1) {
                idx.get(num).add(id);
            }
            if (idx.get(val).size() == 0) {
                idx.remove(val);
            }

            nums.remove(nums.size()-1);

             return true;


        }

        /** Get a random element from the collection. */
        public int getRandom() {
       return nums.get((int) (Math.random()*nums.size()));
        }
    }
}
