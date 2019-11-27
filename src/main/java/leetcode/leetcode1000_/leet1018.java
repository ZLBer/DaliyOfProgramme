package leetcode.leetcode1000_;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by libin on 2019/4/1.
 */
public class leet1018 {
    //溢出 ,需要另寻他法
//    public List<Boolean> prefixesDivBy5(int[] A) {
//        StringBuilder sb= new StringBuilder();
//        List<Boolean> linkedList=new LinkedList<Boolean>();
//        for(int a:A){
//            sb.append(a);
//            if(Integer.parseInt(sb.toString(),2)%5==0)
//                linkedList.add(true);
//            else linkedList.add(false);
//
//        }
//        return  linkedList;
//
//    }


    //so nice solution
    public List<Boolean> prefixesDivBy5(int[] A) {
        int k = 0;
        List<Boolean> ans = new ArrayList<>();
        for (int a : A) {
            k = (k << 1 | a) % 5;
            ans.add(k == 0);
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(Integer.parseInt("10010100101111111111000010100001"));
    }
}
