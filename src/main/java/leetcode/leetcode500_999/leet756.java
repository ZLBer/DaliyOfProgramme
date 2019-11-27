package leetcode.leetcode500_999;

import java.util.*;

public class leet756 {


    // 广度优先   TLE
/* static    public boolean pyramidTransition(String bottom, List<String> allowed) {
       List<Character> [][]pyramid=new List[bottom.length()][bottom.length()];
        for (int i = 0; i < pyramid.length; i++) {
            for(int j=0;j<pyramid[0].length;j++){
                pyramid[i][j]=new ArrayList<>();
            }
        }
       char[]arr=bottom.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            pyramid[pyramid.length-1][i].add(arr[i]);
        }

        for(int deep=pyramid.length-2;deep>=0;deep--){
              for(int left=0;left<=deep;left++){
                  List<Character> here=pyramid[deep][left];
               List<Character> l1=pyramid[deep+1][left];
               List<Character> l2=pyramid[deep+1][left+1];
                  for (int i = 0; i < l1.size(); i++) {
                      for (int j = 0; j < l2.size(); j++) {
                          String start=l1.get(i)+""+l2.get(j);
                          for (String s : allowed) {
                              if(s.startsWith(start)) here.add(s.charAt(2));
                          }
                      }
                  }

                  if(pyramid[0][0].size()>0) return true;
              }
        }

         return false;
    }*/


    //深度优先  TLE
/*    public boolean pyramidTransition(String bottom, List<String> allowed) {
          char[][]pyramid=new char[bottom.length()][bottom.length()];
          char []arr=bottom.toCharArray();
        for (int i = 0; i < arr.length; i++) {
             pyramid[pyramid.length-1][i]=arr[i];
        }

        return DFS(pyramid,allowed,bottom.length()-2,0);
    }


    boolean DFS(char[][]pyramid,List<String> allowed,int deep,int leftIndex){
          if(deep<0){
              if(pyramid[0][0]>'A')
                  return true;
              else return false;
          }

        for(int left=leftIndex;left<=deep;left++){
            System.out.println(deep+"  "+left);
            String start=pyramid[deep+1][left]+""+pyramid[deep+1][left+1];
        for (int i = 0; i < allowed.size(); i++) {
             if(allowed.get(i).startsWith(start)){
                 pyramid[deep][left]=allowed.get(i).charAt(2);
                 if(left<=deep)
                   if(DFS(pyramid,allowed,deep,left+1)) return true;
                 else
                  if(DFS(pyramid,allowed,deep-1,0)) return true;
             }
        }
        }
        return false;
    }*/


    public static void main(String[] args) {
        // pyramidTransition("BDBBAA", Arrays.asList("ACB","ACA","AAA","ACD","BCD","BAA","BCB","BCC","BAD","BAB","BAC","CAB","CCD","CAA","CCA","CCC","CAD","DAD","DAA","DAC","DCD","DCC","DCA","DDD","BDD","ABB","ABC","ABD","BDB","BBD","BBC","BBA","ADD","ADC","ADA","DDC","DDB","DDA","CDA","CDD","CBA","CDB","CBD","DBA","DBC","DBD","BDA"));
    }
/*
    //第一次  TLE 57 / 63 test cases passed.
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        char[][]pyramid=new char[bottom.length()][bottom.length()];
        char []arr=bottom.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            pyramid[pyramid.length-1][i]=arr[i];
        }
        Map<String, List<Character>> map = new HashMap<>();
        for (String s : allowed) {
            String key = s.substring(0,2);
            if (!map.containsKey(key)) map.put(key, new ArrayList<Character>());
            map.get(key).add(s.charAt(2));
        }
        return DFS(pyramid,allowed,bottom.length()-2,0,map);
    }


    boolean DFS(char[][]pyramid,List<String> allowed,int deep,int leftIndex,  Map<String, List<Character>> map){
        if(deep<0){
            if(pyramid[0][0]>'A')
                return true;
            else return false;
        }
        for(int left=leftIndex;left<=deep;left++){
            // System.out.println(deep+"  "+left);
            String start=pyramid[deep+1][left]+""+pyramid[deep+1][left+1];
            List<Character >list=map.get(start);
            if(list==null) return false;
            for (int i = 0; i < list.size(); i++) {
                pyramid[deep][left]=list.get(i);
                if(left<=deep){  //这个条件和上面的for循环矛盾了，所以不会向下制行 ，应该把else的放在外面，每次DFS判断leftINdex越界了没
                    if(DFS(pyramid,allowed,deep,left+1,map)) return true;
                }
                else{
                    if(DFS(pyramid,allowed,deep-1,0,map)) return true;
                }

            }
        }
        return false;
    }*/

    // 但是改一下可以过了
   /* public boolean pyramidTransition(String bottom, List<String> allowed) {
        char[][] pyramid = new char[bottom.length()][bottom.length()];
        char[] arr = bottom.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            pyramid[pyramid.length - 1][i] = arr[i];
        }
        Map<String, List<Character>> map = new HashMap<>();
        for (String s : allowed) {
            String key = s.substring(0, 2);
            if (!map.containsKey(key)) map.put(key, new ArrayList<Character>());
            map.get(key).add(s.charAt(2));
        }
        return DFS(pyramid, allowed, bottom.length() - 2, 0, map);
    }
    boolean DFS(char[][] pyramid, List<String> allowed, int deep, int leftIndex, Map<String, List<Character>> map) {
        if (deep < 0) {
            if (pyramid[0][0] > 'A')
                return true;
            else return false;
        }

        //遍历到一行的末尾  需要往下走
        if (leftIndex > deep)
            if (DFS(pyramid, allowed, deep - 1, 0, map)) return true;
        for (int left = leftIndex; left <= deep; left++) {
            String start = pyramid[deep + 1][left] + "" + pyramid[deep + 1][left + 1];
            List<Character> list = map.get(start);
            if (list == null) return false;
            for (int i = 0; i < list.size(); i++) {
                pyramid[deep][left] = list.get(i);
                if (DFS(pyramid, allowed, deep, left + 1, map)) return true;
            }
        }
        return false;
    }*/





    //对每层 和 深度 都进行DFS
/*public boolean pyramidTransition(String bottom, List<String> allowed) {

    Map<String, List<String>> map = new HashMap<>();
    for (String s : allowed) {
        String key = s.substring(0,2);
        if (!map.containsKey(key)) map.put(key, new ArrayList<>());
        map.get(key).add(s.substring(2));
    }
    return DFS(bottom,map);
}


    boolean DFS(String bottom,Map<String, List<String>> map){
        if(bottom.length()==1) return true;
        //剪枝
        for (int i = 0; i<bottom.length()-1; i++) {
            if (!map.containsKey(bottom.substring(i,i+2))) return false;
        }
      List<String> list=new ArrayList<>();
      helper(bottom,new StringBuilder(),list,map,0);
        for (int i = 0; i < list.size(); i++) {
            if(DFS(list.get(i),map)) return true;
        }
return false;
    }



    //DFS求每层的所有情况
    void helper(String bottom,StringBuilder sb,List<String> list,Map<String,List<String>> map,int index){
      if(index==bottom.length()-1){
          list.add(sb.toString());
          return;
      }
      //if(!map.containsKey(bottom.substring(index,index+2))) return;
      for(String s:map.get(bottom.substring(index,index+2))){
          sb.append(s);
          helper(bottom,sb,list,map,index+1);
          sb.deleteCharAt(index);
      }
    }*/


    //把层中序号和深度混在一起做
    //和我想到的思路一样
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        Map<String, Set<Character>> m = new HashMap<>();
        for (String s : allowed) {
            String pre = s.substring(0, 2);
            m.putIfAbsent(pre, new HashSet<>());
            m.get(pre).add(s.charAt(2));
        }
        return dfs(bottom, "", m, 1);
    }

    boolean dfs(String row, String nextRow, Map<String, Set<Character>> allowed, int i) {
        if (row.length() == 1) return true;
        if (nextRow.length() + 1 == row.length())
            return dfs(nextRow, "", allowed, 1);
        for (Character c : allowed.getOrDefault(row.substring(i - 1, i + 1), new HashSet<>()))
            if (dfs(row, nextRow + c, allowed, i + 1))
                return true;
        return false;
    }
}
