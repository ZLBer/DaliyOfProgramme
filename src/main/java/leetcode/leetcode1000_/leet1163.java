package leetcode.leetcode1000_;

public class leet1163 {


    // Time Limit Exceeded
   /* public String lastSubstring(String s) {
       String result="";
        for(int i=0;i<s.length();i++){
           for(int j=i+1;j<=s.length();j++){
               String temp=s.substring(i,j);
              if(temp.compareTo(result)>0)
                  result=temp;
           }
       }

    return result;
    }*/

    // Time Limit Exceeded
  /*  public String lastSubstring(String s) {
        String result="";

       int maxLetter=findMaxLetter(s);
       List<Integer> maxLetterIndex=new ArrayList<>();

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==maxLetter) maxLetterIndex.add(i);
        }

      for(int i:maxLetterIndex){
            for(int j=i+1;j<=s.length();j++){
                if(s.substring(i,j).compareTo(result)>0)
                    result=s.substring(i,j);
            }
      }

        return result;
    }
    char findMaxLetter(String s){
        char result='a'-1;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)>result) result=s.charAt(i);
        }
        return result;
    }*/




  //mine 先遍历寻找最大的字母序号
/*    public String lastSubstring(String s) {
        int maxLetter=findMaxLetter(s);
        List<Integer> maxLetterIndex=new ArrayList<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==maxLetter) maxLetterIndex.add(i);
        }
        if(maxLetterIndex.size()==1) return  s.substring(maxLetterIndex.get(0));
        if(maxLetterIndex.size()==s.length()) return s;
        int index=0;
        int resultIndex=maxLetterIndex.get(index++);int tempIndex=maxLetterIndex.get(index++);
        while (index<=maxLetterIndex.size()){
            int a=resultIndex,b=tempIndex;
            while (a<s.length()&&b<s.length()){
                 if(s.charAt(a)==s.charAt(b)){
                     a++;b++;
                 }
                 else if(s.charAt(a)>s.charAt(b)) {
                     break;
                 }else {
                     resultIndex=tempIndex;
                     break;
                 }

            }
            if(index<maxLetterIndex.size())
             tempIndex=maxLetterIndex.get(index++);
            else break;
        }
           return s.substring(resultIndex);
    }
    char findMaxLetter(String s){
        char result='a'-1;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)>result) result=s.charAt(i);
        }
        return result;
    }*/





   //始终要明白 一定是截至到最后
   public String lastSubstring(String s) {
       int n = s.length();
       //k is the len when we have two candidates
       //i is the first candidate start position, j is the second one (can not be candidate)
       int i = 0, j= 1, k = 0;
       while (i < n && j < n && k < n) {
           if (i + k >= n || j + k >= n) {
               break;
           }
           // they have same start point, then increase the length
           if (s.charAt(i + k) == s.charAt(j + k)) {
               k++;
           } else {
               // now two candidates are different, then which one is larger
               if (s.charAt(i + k) < s.charAt(j + k)) {
                   i = i + k + 1; // j becomes the candidate, i need move forward
               } else {
                   j = j + k + 1; // i becomes the candidate
               }
               if (i == j) {
                   j++; // potational i, j stay at the same position, j move forward(i also can move)
               }
               k = 0; // r
           }
       }
       int l = Math.min(i, j);
       return s.substring(l);
   }
    public static void main(String[] args) {
        System.out.println("abc".compareTo("ab"));
    }
}
