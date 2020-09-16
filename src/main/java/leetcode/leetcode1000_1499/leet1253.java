package leetcode.leetcode1000_1499;

import java.util.ArrayList;
import java.util.List;

public class leet1253 {

    //DFS超时
/*    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        int cSum=0;
        for (int i = 0; i < colsum.length; i++) {
            cSum+=colsum[i];
        }
        if(cSum>upper+lower) return res;
        DFS(upper,lower,colsum,0,new ArrayList<>(),new ArrayList<>());
        return res;
    }
    List<List<Integer>> res=new ArrayList<>();
    boolean DFS(int upper,int lower,int []colsum,int deep,List<Integer> upperList,List<Integer>lowerList){
        if(deep>=colsum.length) {
           if(upper==0&&lower==0){
               res.add(upperList);
               res.add(lowerList);
               return true;
           }
           return false;
        }

      for(int i=0;i<=colsum[deep];i++){
          int u=i,l=colsum[deep]-i;
          upperList.add(u);
          lowerList.add(l);
          if(DFS(upper-u,lower-l,colsum,deep+1,upperList,lowerList)) return true;
          upperList.remove(deep);
          lowerList.remove(deep);
      }
  return false;
    }*/


//看错题了 啊啊啊啊
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        int cSum=0;
        List<List<Integer>> res=new ArrayList<>();
        for (int i = 0; i < colsum.length; i++) {
            cSum+=colsum[i];
        }
        if(cSum!=upper+lower) return res;
        List<Integer> up=new ArrayList<>();
        List<Integer> lo=new ArrayList<>();
        for (int i = 0; i < colsum.length; i++) {
            if(upper>=colsum[i]) {
                up.add(colsum[i]);
                lo.add(0);
                upper-=colsum[i];
            }else if(lower>=colsum[i]){
                lo.add(colsum[i]);
                up.add(0);
                lower-=colsum[i];
            }
            else {
                if(colsum[i]>upper){
                    up.add(upper);
                    colsum[colsum.length-1]-=upper;
                }
                if(colsum[i]<=lower){
                    lo.add(colsum[colsum.length-1]);
                }
            }
        }

        res.add(up);
        res.add(lo);
        return res;
    }



/*    public List<List<Integer>> reconstructMatrix(int u, int l, int[] cs) {
        boolean[][] res = new boolean[2][cs.length];
        for (int i = 0; i < cs.length; ++i) {
            res[0][i] = cs[i] == 2 || (cs[i] == 1 && l < u);
            res[1][i] = cs[i] == 2 || (cs[i] == 1 && !res[0][i]);
            u -= res[0][i] ? 1 : 0;
            l -= res[1][i] ? 1 : 0;
        }
        System.out.println(Arrays.asList(res[0], res[1]).get(0).length);
        //返回ture false或整数均可
        return l == 0 && u == 0 ? new ArrayList(Arrays.asList(res[0], res[1])) : new ArrayList();
    }*/

}
