package leetcode.华科复试;

/**
 * Created by libin on 2019/3/2.
 */
public class longestDigit {
  static   void solution(String s){
        int max=0;
        int index=-1;
        int begin=0;
        for (int i=0;i<s.length();i++){
            if(Character.isLetter(s.charAt(i))&&index==-1) continue;
            else if(Character.isLetter(s.charAt(i))&&index!=-1) {
                max=i-index;
                begin=index;
                index=-1;
            }
            else if(Character.isDigit(s.charAt(i))&&index==-1) index=i;
            else continue;

        }
      if(Character.isDigit(s.charAt(s.length()-1))&&(s.length()-1-index)>max){
            max=s.length()-index;
          begin=index;
      }
      System.out.println(s.substring(begin,begin+max));
      System.out.println(max+"    "+(begin+1));
    }

    public static void main(String[] args) {
       solution("ab125666666ff1234567");
    }
}
