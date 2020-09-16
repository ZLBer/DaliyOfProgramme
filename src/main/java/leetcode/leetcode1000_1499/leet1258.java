package leetcode.leetcode1000_1499;

import java.util.*;

public class leet1258 {
    public List<String> generateSentences(List<List<String>> synonyms, String text) {
      List<Set<String>> list=new ArrayList<>();
        for (int i = 0; i < synonyms.size(); i++) {
            List<String> sy=synonyms.get(i);
            boolean flag=false;
            for (int j = 0; j < list.size(); j++) {
                Set<String> temp=list.get(j);
                if(temp.contains(sy.get(0))||temp.contains(sy.get(1))){
                    temp.add(sy.get(0));
                    temp.add(sy.get(1));
                    flag=true;
                    break;
                }
            }
            if(!flag){
                Set<String> set=new TreeSet<>();
                set.add(sy.get(0));
                set.add(sy.get(1));
                list.add(set);
             }
        }
        DFS(list,text.split(" "),0,"");
return res;
    }
    List<String> res=new ArrayList<>();
   void DFS(List<Set<String>> list,String[]words,int deep,String sb){
   if(deep>=words.length){
      res.add(sb.substring(0,sb.length()-1));
      return;
   }
      boolean flag=true;
        for (int i = 0; i < list.size(); i++) {
           Set<String> set=list.get(i);
           if(set.contains(words[deep])){
               for (String s : set) {
                   DFS(list,words,deep+1,sb+s+" ");
               }
               flag=false;
               break;
           }
       }
        if(flag){
            DFS(list,words,deep+1,sb+words[deep]+" ");
        }
   }



    //BFS  这个写的并不是很好
  /*  public List<String> generateSentences(List<List<String>> synonyms, String text) {
        Map<String, List<String>> graph = new HashMap<>();
        for (List<String> synonymPair : synonyms) {
            String w1 = synonymPair.get(0), w2 = synonymPair.get(1);
            connect(graph, w1, w2);
            connect(graph, w2, w1);
        }
        // BFS
        Set<String> ans = new TreeSet<>();
        Queue<String> q = new LinkedList<>();
        q.add(text);
        while (!q.isEmpty()) {
            String out = q.remove();
            ans.add(out); // Add to result
            String[] words = out.split("\\s");
            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                if (graph.get(word) == null) continue;
                for (String neighbor : graph.get(word)) {
                    words[i] = neighbor;
                    String newText = Arrays.stream(words).collect(Collectors.joining(" "));
                    if (!ans.contains(newText)) q.add(newText);
                }
            }
        }
        return new ArrayList<>(ans);
    }*/

    private void connect(Map<String, List<String>> graph, String v1, String v2) {
        if (graph.get(v1) == null) graph.put(v1, new LinkedList<>());
        graph.get(v1).add(v2);
    }
}
