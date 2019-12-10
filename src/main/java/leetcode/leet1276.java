package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leet1276 {
    //mine
/*
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {

     List<Integer> res=new ArrayList<>();
     if(tomatoSlices%2==1) return res;
     int small=tomatoSlices/2;
     for(int i=0;i<=small;i+=2){
        if((small-i)+(i/2)==cheeseSlices) {
            res.add(i/2);
            res.add(small-i);
            return res;
        }
     }
     return res;
    }
*/


    //解方程
    /*
From
jumbo + small = cheese
jumbo * 2 + small = tomate / 2

We can get that
jumb0 = tomate / 2 - cheese
So that
small = cheese * 2 - tomate / 2
     */
    public List<Integer> numOfBurgers(int t, int c) {
        return t % 2 == 0 && c * 2 <= t && t <= c * 4 ? Arrays.asList(t / 2 - c, c * 2 - t / 2) :  new ArrayList();
    }
}
