package leetcode;

import java.util.*;

public class leet1452 {


    //mine 居然过了..完全是直接做的..
  /*static   public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
      Set<String>[]sets=new Set[favoriteCompanies.size()];
        for (int i = 0; i < favoriteCompanies.size(); i++) {
            List<String> favoriteCompany=favoriteCompanies.get(i);
            Set<String> set=new HashSet<>();
            set.addAll(favoriteCompany);
            sets[i]=set;
        }

        List<Integer> res=new ArrayList<>();
        for (int i = 0; i < favoriteCompanies.size(); i++) {
            List<String> favoriteCompany = favoriteCompanies.get(i);

            boolean fl=true;
            boolean flag=true;
            for (int j = 0; j < sets.length; j++) {

                if(i==j) continue;

                Set<String> set = sets[j];
                for (String s : favoriteCompany) {
                    if(!set.contains(s)) {  //不含这个子集
                        flag=false;
                        break;
                    }
                }
               if(flag) {  //含有这个子集
                   fl=false;
                   break;
               }
            }

            if(fl) res.add(i);
        }
        return res;
    }
*/



    //额 人家的java写的比你好多了
 /*   public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        Set<String>[] set = new Set[favoriteCompanies.size()];
        for (int i = 0; i < set.length; ++i)
            set[i] = new HashSet<>(favoriteCompanies.get(i));
        List<Integer> res = new ArrayList<>();
        outer:
        for (int i = 0; i < set.length; ++i) {
            for (int j = 0; j < set.length; ++j)
                if (i != j && set[j].containsAll(set[i]))
                    continue outer;
            res.add(i);
        }
        return res;
    }*/





//并查集  没有重复收藏集合的话
     public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        List<Integer> res= new LinkedList<>();
        List<Set<String>> fcs = new LinkedList<>();
        for (List<String> fc: favoriteCompanies) fcs.add(new HashSet<>(fc));
        int l = fcs.size();
        int[] f = new int[l];
        for (int i=0; i<l; i++) f[i]=i;
        for (int i=0; i<l; i++)
            for (int j=i+1; j<l; j++){
                int a = find(f, i), b = find(f, j);
                if (a==b) continue;
                else if (contains(fcs.get(a), fcs.get(b))) f[b]=a;
                else if (contains(fcs.get(b), fcs.get(a))) f[a]=b;
            }
        Set<Integer> set= new HashSet<>();
        for (int i: f) set.add(find(f, i));
        res.addAll(set);
        Collections.sort(res);
        return res;
    }
    public boolean contains(Set<String> a, Set<String> b){
        if (a.size()<=b.size()) return false;
        return a.containsAll(b);
    }
    public int find(int[] f, int i){
        while (f[i]!=i){
            f[i]=f[f[i]];
            i=f[i];
        }
        return i;
    }
    public static void main(String[] args) {
     List<List<String>> list=new ArrayList<>();
     list.add(Arrays.asList("lee"));
     list.add(Arrays.asList("lee","gp"));
    // peopleIndexes(list);
    }
}
