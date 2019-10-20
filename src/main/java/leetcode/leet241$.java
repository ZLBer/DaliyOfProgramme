package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leet241$ {

    //递归
/*        public List<Integer> diffWaysToCompute(String input) {
            List<Integer> res=new ArrayList<>();

      for(int i=0;i<input.length();i++){
          char c=input.charAt(i);

          if(c=='+'||c=='-'||c=='*'){
              String left=input.substring(0,i);
              String right=input.substring(i+1,input.length());
              List<Integer> leftVal=diffWaysToCompute(left);
              List<Integer> rightVal=diffWaysToCompute(right);
              for (Integer l : leftVal) {
                  for (Integer r : rightVal) {
                       switch (c){
                           case '+': res.add(l+r);break;
                           case  '-':res.add(l-r);break;
                           case '*':res.add(l*r);break;
                       }
                  }
              }
          }

      }
            if(res.size()==0)
                res.add(Integer.parseInt(input));
            return res;

        }*/

//加catch 缓存
    Map<String,List<Integer>> cat=new HashMap<>();
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res=new ArrayList<>();
        if(cat.containsKey(input) ) return cat.get(input);
        for(int i=0;i<input.length();i++){
            char c=input.charAt(i);
            if(c=='+'||c=='-'||c=='*'){
                String left=input.substring(0,i);
                String right=input.substring(i+1,input.length());
                List<Integer> leftVal=diffWaysToCompute(left);
                List<Integer> rightVal=diffWaysToCompute(right);
                for (Integer l : leftVal) {
                    for (Integer r : rightVal) {
                        switch (c){
                            case '+': res.add(l+r);break;
                            case  '-':res.add(l-r);break;
                            case '*':res.add(l*r);break;
                        }
                    }
                }
            }

        }
        if(res.size()==0)
            res.add(Integer.parseInt(input));
        cat.put(input,res);
        return res;

    }


        public static void main(String[] args) {

        }

}
