package leetcode;


import java.util.*;

public class leet1245$ {

    //DFS不太行啊
/*     public int treeDiameter(int[][] edges) {
        Map<Integer, List<Integer>> map=new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int from=edges[i][0];
            int to=edges[i][1];
            if(map.containsKey(from)){
                map.get(from).add(to);
            }else {
                List<Integer> l=new ArrayList<>();
                l.add(to);
                map.put(from,l);
            }

            if(map.containsKey(to)){
                map.get(to).add(from);
            }else {
                List<Integer> l=new ArrayList<>();
                l.add(from);
                map.put(to,l);
            }
        }
        for(int key: map.keySet()){
            if(map.get(key).size()==1)
                DFS(map,key,-1,key,0);
        }
return max;
    }
      int max=0;
     Set<Integer> set=new HashSet<>();
      void  DFS(Map<Integer, List<Integer>> map,int orgin,int from,int to,int step){
        List<Integer> l=map.get(to);
        if(from!=-1&&l.size()==1){

            max=Math.max(step,max);
            return;
        }
        for (int i = 0; i < l.size(); i++) {
            int next=l.get(i);
            if(from==next) continue;
            DFS(map,orgin,to,next,step+1);
        }
    }*/



    //DFS打开的方式不太对
    //先从任意点出发找到距离最远的点far，然后从far出发找最远的点就是答案
    //相关证明：https://leetcode.com/problems/tree-diameter/discuss/418820/(Java)-Using-2-BFS
/* static    public int treeDiameter(int[][] edges) {
        Map<Integer, List<Integer>> map=new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int from=edges[i][0];
            int to=edges[i][1];
            if(map.containsKey(from)){
                map.get(from).add(to);
            }else {
                List<Integer> l=new ArrayList<>();
                l.add(to);
                map.put(from,l);
            }

            if(map.containsKey(to)){
                map.get(to).add(from);
            }else {
                List<Integer> l=new ArrayList<>();
                l.add(from);
                map.put(to,l);
            }
        }
        DFSPoint(map,edges[0][0],-1,edges[0][0],0);
        System.out.println(point);
        max=0;
        DFS(map,point,-1,point,0);
        return max;
    }
   static int max=0;
   static void  DFS(Map<Integer, List<Integer>> map,int orgin,int from,int to,int step){
        List<Integer> l=map.get(to);
        if(from!=-1&&l.size()==1){
            max=Math.max(step,max);
            return;
        }
        for (int i = 0; i < l.size(); i++) {
            int next=l.get(i);
            if(from==next) continue;
            DFS(map,orgin,to,next,step+1);
        }
    }
   static int point=-1;
   static void DFSPoint(Map<Integer, List<Integer>> map,int orgin,int from,int to,int step){
        List<Integer> l = map.get(to);
        System.out.println("tesy");
        if (from != -1 && l.size() == 1) {

            if(step>max){
                max=step;
                point=to;
            }
            return;
        }
        for (int i = 0; i < l.size(); i++) {
            int next = l.get(i);
            if (from == next) continue;
            DFSPoint(map, orgin, to, next, step + 1);
        }
    }*/


  //每个节点都要求最大的两个路径和diameter比较，但只返回最大的路径
    public int treeDiameter(int[][] edges) {
        Map<Integer, List<Integer>> map=new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int from=edges[i][0];
            int to=edges[i][1];
            if(map.containsKey(from)){
                map.get(from).add(to);
            }else {
                List<Integer> l=new ArrayList<>();
                l.add(to);
                map.put(from,l);
            }

            if(map.containsKey(to)){
                map.get(to).add(from);
            }else {
                List<Integer> l=new ArrayList<>();
                l.add(from);
                map.put(to,l);
            }
        }

        DFS(map,-1,edges[0][0]);
        return diameter;
    }
    int diameter = 0;
    int DFS(Map<Integer,List<Integer>>map,int pre,int to){

        int max1=0,max2=0;
        for(Integer next:map.get(to)){
            if(next==pre) continue;

            int child=DFS(map,to,next);
            if(child>max1){
                max2=max1;
                max1=child;
            }else if(child>max2){
                max2=child;
            }
        }

diameter=Math.max(max1+max2,diameter);
        return max1+1;
    }
    public static void main(String[] args) {
   /*     treeDiameter(new int[][]{
                {0, 1}, {0, 2}
        });*/
    }
}
