package leetcode;

import java.util.*;

public class leet820 {

    //错误的理解  不一定要前面包含后面
 /*   public int minimumLengthEncoding(String[] words) {
        int []indexes=new int[words.length];
       int index=1;
       int left=0;
       int res=0;
       while (index<words.length){
           if(words[left].endsWith(words[index])){
               index++;
           }else {
               res+=(words[left].length()+1);
               left=index;
           }
       }
       res+=(words[left].length()+1);
       return res;
    }*/


 //mine 先排序再操作
/*    public int minimumLengthEncoding(String[] words) {
        Arrays.sort(words,(a,b)->b.length()-a.length());
        Set<String> set=new HashSet<>();
        int res=0;
        for (int i = 0; i < words.length; i++) {
            boolean flag=false;
            for (String s : set) {
                if(s.endsWith(words[i])){
                    flag=true;
                    break;
                }
            }
            if(!flag){
                set.add(words[i]);
          res+=words[i].length()+1;
            }
        }
        return res;
    }*/


    //逆向思考  删除操作
/*    public int minimumLengthEncoding(String[] words) {
        Set<String> set=new HashSet<>(Arrays.asList(words));
        for (String word : words) {
            for (int i = 1; i < word.length(); i++) {
                set.remove(word.substring(i));
            }
        }

        int res=0;
        for (String s : set) {
            res+=s.length()+1;
        }
        return res;
    }*/


//前缀树
/*    class TrieNode{
        TrieNode []children=new TrieNode[26];
       int depth;
    }
    public int minimumLengthEncoding(String[] words) {
        TrieNode root=new TrieNode();
        root.depth=1;
        Set<TrieNode> leaves=new HashSet<>();
         for (int i = 0; i < words.length; i++) {
             TrieNode node=root;
             for (int j = words[i].length()-1; j >= 0; j--) {
               char c=words[i].charAt(j);
               if(node.children[c-'a']==null){
                   node.children[c-'a']=new TrieNode();
                   node.children[c-'a'].depth=node.depth+1;
               }
               node=node.children[c-'a'];
             }
            leaves.add(node);
        }
         int res=0;
        for (TrieNode leaf : leaves) {
            boolean flag=true;
            for (TrieNode child : leaf.children) {
                if(child!=null){
                    flag=false;
                    break;
                }

            }
            if(flag) res+=leaf.depth;
        }
        return res;
    }*/

    //hashmap前缀树
    class TrieNode {
        HashMap<Character, TrieNode> next = new HashMap<>();
        int depth;
    }

        public int minimumLengthEncoding(String[] words) {
            TrieNode root = new TrieNode();
            List<TrieNode> leaves = new  ArrayList<TrieNode>();
            for (String w : new HashSet<>(Arrays.asList(words))) {
                TrieNode cur = root;
                for (int i = w.length() - 1; i >= 0; --i) {
                    char j = w.charAt(i);
                    if (!cur.next.containsKey(j)) cur.next.put(j, new TrieNode());
                    cur = cur.next.get(j);
                }
                cur.depth = w.length() + 1;
                leaves.add(cur);
            }
            int res = 0;
            for (TrieNode leaf : leaves) if (leaf.next.isEmpty()) res += leaf.depth;
            return res;
        }


    static  public int mincostTickets(int[] days, int[] costs) {
     int []dp=new int[days.length+1];
        for (int i = 0; i < days.length; i++) {
           int one=dp[i]+costs[0];
           int index=i;
           while (index>=0&&days[index]+7>days[i]){
             index--;
           }
          int seven=dp[index<0?0:index+1]+costs[1];

           while (index>=0&&days[index]+30>days[i]){
             index--;
           }
           int thrity=dp[index<0?0:index+1]+costs[2];
            //System.out.println(i+" "+one+" "+seven+"  "+thrity);
           dp[i+1]=Math.min(one,Math.min(thrity,seven));
        }
/*        for (int i = 0; i < dp.length; i++) {
            System.out.print(dp[i]+"  ");
        }*/
        return dp[days.length];
    }

    public static void main(String[] args) {
        mincostTickets(new int[]{1,4,6,7,8,20},new int[]{2,7,15});
    }

}
