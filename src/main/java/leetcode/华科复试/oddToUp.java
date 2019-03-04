package leetcode.华科复试;

/**
 * Created by libin on 2019/3/3.
 */
public class oddToUp {
  static   String solution(String s){
   StringBuilder sb=new StringBuilder();
   for(int i=0;i<s.length();i++){
       char a=s.charAt(i);

       if(i%2==1){
           if(Character.isLetter(a)) sb.append(Character.toUpperCase(a));
           else sb.append(a);
       }
       else sb.append(a);



   }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution("abc4Efg"));
    }
}
