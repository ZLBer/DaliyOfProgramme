package leetcode.leetcode1_499;

public class leet208 {


    //mine 递归
/*    class Trie {
      TireNode root;
        *//** Initialize your data structure here. *//*
        public Trie() {
       root=new TireNode();
        }

        *//** Inserts a word into the trie. *//*
        public void insert(String word) {
     in(word.toCharArray(),0,root);
        }
        void  in(char[]letters,int deep,TireNode node){

          if(node.letters[letters[deep]-'a']==null){
              node.letters[letters[deep]-'a']=new TireNode();
          }
          if(deep==letters.length-1) {
              node.letters[letters[deep]-'a'].isWord=true;
              return;
          }
          in(letters,deep+1, node.letters[letters[deep]-'a']);
         }
        *//** Returns if the word is in the trie. *//*
        public boolean search(String word) {
           return se(word.toCharArray(),0,root);
        }
        boolean se(char[]letters,int deep,TireNode node){
            //搜索完毕
            if(deep==letters.length-1) {
                if(node.letters[letters[deep]-'a']!=null&&node.letters[letters[deep]-'a'].isWord)
                return true;
                else return false;
            }
            if(node.letters[letters[deep]-'a']==null) return  false;
         return    se(letters,deep+1,node.letters[letters[deep]-'a']);
        }
        boolean seP(char[]letters,int deep,TireNode node){
            //搜索完毕
            if(deep==letters.length) return true;
            if(node.letters[letters[deep]-'a']==null) return false;
         return    seP(letters,deep+1,node.letters[letters[deep]-'a']);
        }

        *//** Returns if there is any word in the trie that starts with the given prefix. *//*
        public boolean startsWith(String prefix) {
            return seP(prefix.toCharArray(),0,root);
        }


         class TireNode{
           boolean isWord=false;
            TireNode []letters=new TireNode[26];
        }

    }*/



        //非递归
    class TrieNode {
        public boolean isWord;
        public TrieNode[] children = new TrieNode[26];
        public TrieNode() {}
        TrieNode(char c){
            TrieNode node = new TrieNode();
        }
    }

    public class Trie {
        private TrieNode root;
        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode ws = root;
            for(int i = 0; i < word.length(); i++){
                char c = word.charAt(i);
                if(ws.children[c - 'a'] == null){
                    ws.children[c - 'a'] = new TrieNode(c);
                }
                ws = ws.children[c - 'a'];
            }
            ws.isWord = true;
        }

        public boolean search(String word) {
            TrieNode ws = root;
            for(int i = 0; i < word.length(); i++){
                char c = word.charAt(i);
                if(ws.children[c - 'a'] == null) return false;
                ws = ws.children[c - 'a'];
            }
            return ws.isWord;
        }

        public boolean startsWith(String prefix) {
            TrieNode ws = root;
            for(int i = 0; i < prefix.length(); i++){
                char c = prefix.charAt(i);
                if(ws.children[c - 'a'] == null) return false;
                ws = ws.children[c - 'a'];
            }
            return true;
        }
    }
}
