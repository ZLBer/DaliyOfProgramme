package leetcode.leetcode1000_;

import java.util.*;

public class leet1202 {


// mine  35 / 36 test cases pased   Time Limit Exceeded
  /*  public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        List<Set<Integer>> setList=new ArrayList<>();
        for (int i = 0; i < pairs.size(); i++) {
            List<Integer> temp=pairs.get(i);
            int a=temp.get(0);
            int b=temp.get(1);
           int aSet=-1,bSet=-1;
            for (int j = 0; j < setList.size(); j++) {
                Set<Integer> set=setList.get(j);
                if(set.contains(a)) aSet=j;
                if(set.contains(b)) bSet=j;
            }
            //合并set
               if(aSet!=-1&&bSet!=-1){
                   if(aSet==bSet) continue;
                   Set<Integer> set=setList.get(aSet);

                   Set<Integer> set1=setList.get(bSet);
                   for (Integer integer : set) {
                       set1.add(integer);
                   }
                   setList.remove(aSet);
               }
               //新建set
               else if(aSet==-1&&bSet==-1){
                   Set<Integer> set=new TreeSet<>();
                   set.add(a);set.add(b);
                   setList.add(set);
               }
               else {
                   Set<Integer> set=setList.get(aSet>-1?aSet:bSet);
                   set.add(a);set.add(b);
               }
            System.out.println(setList.size());
        }
        char[]chars=s.toCharArray();

        for (Set<Integer> set : setList) {
            System.out.println(set.size());
           char [] temp=new char[set.size()];
           int index=0;
            for (Integer integer : set) {
                temp[index++]=chars[integer];
            }
            Arrays.sort(temp);
            index=0;
            for (Integer integer : set) {
                chars[integer]=temp[index++];
            }
        }

        StringBuilder sb=new StringBuilder();
        for (char c : chars) {
            sb.append(c);
        }
        return sb.toString();
    }*/


  //并查集的实现 Weighted Quick-Union  时间复杂度 lg N  lg N
   private class UnionFind{
       private  int[] parent;
       private int[]weight;
      UnionFind(int count){
          parent=new int[count];
          weight=new int[count];
          for (int i = 0; i < count; i++) {
              weight[i] = 1;
              parent[i] = i;
          }
      }

      public  int find(int index){
       while (index!=parent[index]){
           index=parent[index];
       }

       return index;
      }
      public void union(int p,int q){
          int pRoot=find(p);
          int qRoot=find(q);
          if(pRoot==qRoot)
              return ;
         if(weight[pRoot]>weight[qRoot]){
                parent[qRoot]=pRoot;
                weight[pRoot]+=weight[qRoot];
         }else {
             parent[pRoot]=qRoot;
             weight[qRoot]+=weight[pRoot];

         }
      }
   }

 //  Quick-Find  用这种会TLE  时间复杂度 union N  find 1
    /*public class UnionFind {
        private int id[];
        private int count;

        public UnionFind(int N){
            count=N;
            id=new int[N];
            for(int i=0;i<N;i++){
                id[i]=i;
            }
        }

        public int count(){
            return count;
        }

        public boolean connected(int p,int q){
            return find(p)==find(q);
        }

        public int find(int p){
            return id[p];
        }
        public void union(int p,int q){
            int pid=find(p);
            int qid=find(q);
            if(pid==qid)return;
            for(int i=0;i<id.length;i++){
                if(id[i]==pid)id[i]=qid;
            }
            count--;
        }
    }*/
  //TLE 时间复杂度 union 树高  find 树高
/*    public class UnionFind {
        private int id[];
        private int count;

        public UnionFind(int N){
            id=new int[N];
            count=N;
            for(int i=0;i<N;i++){
                id[i]=i;
            }
        }

        public int count(){
            return count;
        }

        public int find(int i){
            while(i!=id[i]){i=id[i];}
            return i;
        }

        public void union(int p,int q){
            if(find(p)==find(q))return;
            id[find(p)]=find(q);
            count--;
        }

        public boolean connected(int p,int q){
            return find(p)==find(q);
        }
    }*/

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        UnionFind uf=new UnionFind(s.length());
        //构造并查集
        for (List<Integer> pair : pairs) {
            uf.union(pair.get(0),pair.get(1));
        }

        /*Map<Integer,List<Character>> intCharMap=new HashMap<>();

        for(int i=0;i<s.length();i++){
            int group=uf.find(i);
            List<Character> list=intCharMap.computeIfAbsent(group,(a)->new ArrayList<>());
            list.add(s.charAt(i));
        }

        for(List<Character> list:intCharMap.values()){
           Collections.sort(list);
        }
     StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            int group=uf.find(i);
           List<Character> list=intCharMap.get(group);
              sb.append(list.get(0));
              list.remove(0);
        }

return  sb.toString();*/
        Map<Integer,PriorityQueue<Character>> intCharMap=new HashMap<>();

        for(int i=0;i<s.length();i++){
            int group=uf.find(i);
            PriorityQueue<Character> queue=intCharMap.computeIfAbsent(group,(a)->new  PriorityQueue<Character>());
            queue.add(s.charAt(i));
        }

        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            sb.append(intCharMap.get(uf.find(i)).poll());
        }

        return sb.toString();



    }


    public static void main(String[] args) {
        Set<Integer> set=new TreeSet<>();
        set.add(2);
        set.add(1);
        set.add(3);
        for(int a:set){
            System.out.println(a);
        }
    }
}
