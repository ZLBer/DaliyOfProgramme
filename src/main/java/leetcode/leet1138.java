package leetcode;

public class leet1138 {
    String  []board ={"abcde","fghij", "klmno", "pqrst", "uvwxy", "z"};
    public String alphabetBoardPath(String target) {
       int []preIndex={0,0};
       StringBuilder sb=new StringBuilder();
       char []chars=target.toCharArray();
        for (int i = 0; i < chars.length; i++) {

            int [] index=getIndex(chars[i]);
            sb.append(append(preIndex,index));
            preIndex=index;

        }

     return sb.toString();

    }

     String append(int[] preindex,int[] index){
       StringBuilder sb=new StringBuilder();
         StringBuilder left=new StringBuilder();
         StringBuilder right=new StringBuilder();

        //原来的点在目标点左边
         if(preindex[0]<=index[0]){
            int sub=index[0]-preindex[0];
             while (sub-->0){
                 left.append("D");
             }
         }
         else {
             int sub=preindex[0]-index[0];
             while (sub-->0){
                 left.append("U");
             }
         }
         if(preindex[1]<=index[1]){
             int sub=index[1]-preindex[1];
             while (sub-->0){
                 right.append("R");
             }
         }
         else {
             int sub=preindex[1]-index[1];
             while (sub-->0){
                 right.append("L");
             }
         }

         if(index[0]==5&&index[1]==0){
             sb.append(right);
             sb.append(left);
             sb.append("!");
             return sb.toString();
         }

         sb.append(left);
         sb.append(right);
         sb.append("!");
         return sb.toString();
     }


    //定位方法
   int[] getIndex(char c){
       for (int i = 0; i < board.length; i++) {
         char[]chars =  board[i].toCharArray();
           for (int j = chars.length - 1; j >= 0; j--) {
               if(c==chars[j]) return new int[]{i,j};
           }
       }

       //其实不存在的情况
       return new int[]{0,0};
   }
}
