package leetcode;

public class leet1598 {
    public int minOperations(String[] logs) {
       int step=0;
        for (int i = 0; i < logs.length; i++) {
            String s=logs[i];
           if(s.startsWith("..")){
             if(step>0) step--;
           }else if(s.startsWith(".")){
              continue;
           }else {
               step++;
           }
        }
        return step;
    }
    public static void main(String[] args) {

    }
}
