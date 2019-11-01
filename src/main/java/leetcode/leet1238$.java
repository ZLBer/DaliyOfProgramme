package leetcode;

import java.util.*;

public class leet1238$ {
/*   static List<Integer> result;
  static   public List<Integer> circularPermutation(int n, int start) {
     result= new ArrayList<>();

        Queue<Integer> queue=new LinkedList<>();

        int maxdeep=(int) Math.pow(2,n)-1;
        boolean []visitde=new boolean[maxdeep+1];
        result.add(start);
        DFS(result,1,visitde,maxdeep);
        return result;
    }

   static    boolean  DFS(List<Integer> result,int deep,boolean []visitde ,int maxdppe){
        if(deep>maxdppe){
            if(Math.abs(Integer.bitCount(result.get(0)^result.get(result.size()-1)))==1) return true;
            else return false;
        }
         if(visitde[result.get(deep-1)]) return false;
          visitde[result.get(deep-1)]=true;





          for (int i = 0; i < visitde.length; i++) {
            if(visitde[i])continue;
              if(Math.abs(Integer.bitCount(i^result.get(deep-1)))==1){
                  result.add(i);

                  if(DFS(result,deep+1,visitde,maxdppe))  return true;

                  result.remove(result.size()-1);
              }
          }
          visitde[result.get(deep-1)]=false;
            return false;
      }*/

/*    public List<Integer> circularPermutation(int n, int start) {
        Set<Integer> set=new HashSet<>();
      List<Integer> result=new ArrayList<>();
      set.add(start);
      result.add(start);
      DFS(set,n,result);
      return result;
    }

    boolean DFS(Set<Integer> set,int n,List<Integer> result){
        if(set.size()==Math.pow(2,n)){
           int x=result.get(result.size()-1)^result.get(0);
            return Integer.bitCount(x)==1;
        }
       int last=result.get(result.size()-1);
        for(int i=0;i<=n;i++){
            int next=last^(1<<i);
          if(next<=Math.pow(2,n)&&!set.contains(next)){
              set.add(next);
              result.add(next);
             if(DFS(set,n,result)) return true;
              result.remove(result.size()-1);
              set.remove(next);
          }
        }
        return false;
    }*/

   //格雷码..
    //https://leetcode.com/problems/circular-permutation-in-binary-representation/discuss/414203/JavaC%2B%2BPython-4-line-Gray-Code
    public List<Integer> circularPermutation(int n, int start) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < 1 << n; ++i)
            res.add(start ^ i ^ (i >> 1));
        return res;
    }

//这个就比上面的好理解点了  先生成格雷码，然后找到start拼接
/*    public List<Integer> circularPermutation(int n, int start) {
        List<Integer> res = new ArrayList<>();
        List<Integer> tmp = oneBitDiffPermutation(n); // generate one bit diff permutations

        // rotate the tmp list to make it starts from "start"
        // before: {0, 1, ..., start, ..., end}
        // after:  {start, ..., end, 0, 1, ...}
        int i = 0;
        for( ; i < tmp.size(); i ++){
            if(tmp.get(i) == start){
                break;
            }
        }

  *//*      for(int k = i; k < tmp.size(); k ++){
            res.add(tmp.get(k));
        }

        for(int q = 0; q < i; q ++){
            res.add(tmp.get(q));
        }*//*

        //可以调函数
        Collections.rotate(res, -i);

        return res;
    }

    // generate one bit diff permutations
    // 0, 1
    // 0, 1, 11, 10
    // 000, 001, 011, 010, 110, 111, 101, 100
    //详细解释地址 https://leetcode.com/problems/circular-permutation-in-binary-representation/discuss/414153/Java-AC-solution%3A-generate-%22one-bit-diff%22-list-then-make-it-start-from-%22start%22
    public List<Integer> oneBitDiffPermutation(int n){
        List<Integer> tmp = new ArrayList<>();
        tmp.add(0);
        if(n == 0){
            return tmp;
        }

        for(int i = 0; i < n; i ++){
            for(int j = tmp.size() - 1; j >= 0; j --){
                tmp.add(tmp.get(j) + (1 << i));
            }
        }

        return tmp;
    }*/
    public static void main(String[] args) {
      //  circularPermutation(2,3);

    }
}
