package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leet638 {
    //mine
/*    int minPrice=Integer.MAX_VALUE;
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
       DFS(price,special,needs,0,new int[needs.size()],0);
       return minPrice;
    }

    void DFS(List<Integer> price, List<List<Integer>> special,List<Integer> needs,int index,int[]items,int sumPrice){
     //当没有大礼包可选的时候
        if(index>=items.length){
            for (int i = 0; i < items.length; i++) {
                sumPrice+=(needs.get(i)-items[i])*price.get(i);
            }
            minPrice=Math.min(sumPrice,minPrice);
            return;
        }
        //每次都检查是否满足needs
            boolean check = true;
            for (int i = 0; i < items.length; i++) {
                if (items[i] != needs.get(i)) {
                    check = false;
                    break;
                }
            }
            if (check) {
                minPrice = Math.min(minPrice, sumPrice);
                return;
            }


        List<Integer> offer=special.get(index);

        //若是不选这个礼包
        DFS(price,special,needs,index+1,items.clone(),sumPrice);

        while (true){
          //先检查一遍能不能选
            boolean flag=false;
            for (int i = 0; i < offer.size()-1; i++) {
                if(items[i]+offer.get(i)>needs.get(i)){
                    flag=true;
                    break;
                }

            }
            if(flag) break;
            //可以选这个礼包
            for (int i = 0; i < offer.size()-1; i++) {
                 items[i]+=offer.get(i);
            }
            sumPrice+=offer.get(offer.size()-1);

            DFS(price,special,needs,index+1,items.clone(),sumPrice);


        }
    }*/






    //简要分析一下这个做法  我的更像广度优先，这个更像深度优先
    //他跟们没有调用所有都没选的请情况  ，所以每次都要计算local——，min
    //递归的代价远高于遍历
   //Map<List<Integer>,Integer>  map=new HashMap<>();
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
            return helper(price, special, needs, 0);
        }

        private int helper(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int pos) {

            //if(map.containsKey(needs)) return map.get(needs);
             //全选单个的
            int local_min=directPurchase(price, needs);
          /*  int  local_min = Integer.MAX_VALUE;
            if(pos>=special.size()){
                local_min=directPurchase(price, needs);
                return local_min;
            }*/


            //从pos开始循环礼包 ，包括第一个礼包为0的情况
            for (int i = pos; i < special.size(); i++) {
                List<Integer> offer = special.get(i);
                List<Integer> temp = new ArrayList<>();
                for (int j= 0; j < needs.size(); j++) {
                    //不符合条件 退出循环
                        if (needs.get(j) < offer.get(j)) { // check if the current offer is valid
                            temp =  null;
                            break;
                    }
                    //更新needs
                    temp.add(needs.get(j) - offer.get(j));
                }
                //可以继续使用这个礼包
                if (temp != null) { // use the current offer and try next
                    local_min = Math.min(local_min, offer.get(offer.size() - 1) + helper(price, special, temp, i));
                }
            }
           // local_min = Math.min(local_min,  helper(price, special,needs, pos+1));
         //  map.put(needs,local_min);
            return  local_min;
        }

        private int directPurchase(List<Integer> price, List<Integer> needs) {
            int total = 0;
            for (int i = 0; i < needs.size(); i++) {
                total += price.get(i) * needs.get(i);
            }
            return total;
        }

    public static void main(String[] args) {
        List<Integer> a=new ArrayList<>();

        a.add(1);
        a.add(2);

        List<Integer> b=new ArrayList<>(a);
         //list重写了hashcode方法
        Map<List<Integer>, Integer> map=new HashMap<>();
        map.put(a,1);
        map.put(b,2);
        System.out.println(map.size());
            }
}
