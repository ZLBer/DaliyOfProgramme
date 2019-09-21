package leetcode.leetcode500_999;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by libin on 2019/4/13.
 */
public class leet990$ {

    // 	Wrong Answer
//    public boolean equationsPossible(String[] equations) {
//       Map<Character,Integer> map=new HashMap<>();
//       int counter=0;
//       for(String equation:equations){
//            char [] cs= equation.toCharArray();
//            //两个变量都包含
//          if(map.containsKey(cs[0])&&map.containsKey(cs[3])){
//              if(cs[1]=='!'&&map.get(cs[0])==map.get(cs[3])) return  false;
//              else if(cs[1]=='='&&map.get(cs[0])!=map.get(cs[3])) return false;
//          }
//          //只包含前变量
//          else if(map.containsKey(cs[0])){
//              if(cs[1]=='!'){
//                  map.put(cs[3],counter++);
//              }
//              else {
//                  map.put(cs[3],map.get(cs[0]));
//              }
//          }
//        //只包含后变量
//
//           else if(map.containsKey(cs[3])){
//              if(cs[1]=='!'){
//                  map.put(cs[0],counter++);
//              }
//              else {
//                  map.put(cs[0],map.get(cs[3]));
//              }
//          }
//
//           //都不包含
//           else{
//               if(cs[0]==cs[3]) return cs[1]=='=';
//              if(cs[1]=='!'){
//                  map.put(cs[0],counter++);
//                  map.put(cs[3],counter++);
//              }
//              else {
//                  map.put(cs[0],counter);
//                  map.put(cs[3],counter++);
//              }
//          }
//
//       }
//
//       return true;
//    }

  //a==b b==c d==e  e==a
   static int[] uf = new int[26];
 static    public boolean equationsPossible(String[] equations) {
        for (int i = 0; i < 26; ++i) uf[i] = i;
        for (String e : equations)
            if (e.charAt(1) == '=')
                uf[find(e.charAt(0) - 'a')] = find(e.charAt(3) - 'a');
        for (String e : equations)
            if (e.charAt(1) == '!' && find(e.charAt(0) - 'a') == find(e.charAt(3) - 'a'))
                return false;
        return true;
    }
   //相当于一个链表 只有当 index=value 时，才存的是结果
 static    public int find(int x) {
        if (x != uf[x]) uf[x] = find(uf[x]);
        return uf[x];
    }

    public static void main(String[] args) {

     equationsPossible(new String[]{"a==b", "a!=c","c==d", "b==c",});
    }
}
