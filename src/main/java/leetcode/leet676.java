package leetcode;

public class leet676 {




    //set
/*
    class MagicDictionary {


        Set<String> set=new HashSet<>();
        */
/** Initialize your data structure here. *//*

        public MagicDictionary() {
  
        }

        public void buildDict(String[] dictionary) {
            for (String s : dictionary) {
                set.add(s);
            }
        }

        public boolean search(String searchWord) {
            char[] chars = searchWord.toCharArray();
            for (int i = 0; i < chars.length; i++) {
               char pre=chars[i];
               for(int j=0;j<26;j++){
                 char c=(char)('a'+j);
                 if(c==chars[i]) continue;
                 chars[i]=c;
                 if(set.contains(new String(chars))) return true;
                 chars[i]=pre;
               }
            } 
       return false;
        }
    }
*/


    //字典树

 class MagicDictionary {


       TireTree head=new TireTree('#');
        /** Initialize your data structure here. */
        public MagicDictionary() {

        }

        public void buildDict(String[] dictionary) {
            for (String s : dictionary) {
                head.add(s);
            }
        }

        public boolean search(String searchWord) {
            return  head.find(head,searchWord,0,0);
        }
    }

     class TireTree{
        boolean flag;
        char aChar;
        TireTree[] arr=new TireTree[26];

        public TireTree(char aChar) {
            this.aChar = aChar;
        }

        void  add(String s){
           TireTree cur=this;
            for (char c : s.toCharArray()) {
              if(cur.arr[c-'a']==null) {
                  cur.arr[c-'a']=new TireTree(c);
              }
              cur=cur.arr[c-'a'];
            }

            cur.flag=true;
        }

       boolean find(TireTree node,String s,int index,int count){
            if(index>=s.length()){
                if(count==1&&node.flag)
                return true;
                else return false;
            }

            if(count>1) return false;

            for (TireTree tireTree : node.arr) {
             if(tireTree!=null){
                 if(tireTree.aChar ==s.charAt(index)) {
                    if(find(tireTree,s,index+1,count))return true;
                 }else {
                    if( find(tireTree,s,index+1,count+1))return true;
                 }
             }
            }
            return false;

        }

    }

    public static void main(String[] args) {
     /*   MagicDictionary m=new MagicDictionary();
        m.buildDict(new String[]{"heo"});
        m.search("hap");*/
    }
}
