package leetcode;

public class leet1629 {

    public char slowestKey(int[] releaseTimes, String keysPressed) {
      
        long pre=0;
        long []count=new long[26];
        long max=0;
        for (int i = 0; i < releaseTimes.length; i++) {
            count[keysPressed.charAt(i)-'a']=Math.max(count[keysPressed.charAt(i)-'a'],releaseTimes[i]-pre);
            pre=releaseTimes[i];
        }

        char res='a';
        for (int i = 0; i < count.length; i++) {
            System.out.println(count[i]);
          if(count[i]>=max) {
              max=count[i];
              res=(char)('a'+i);
          }
        }
        return res;

    }


    public static void main(String[] args) {

    }
}
