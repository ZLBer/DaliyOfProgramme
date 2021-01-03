package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class leet1694 {

    public String reformatNumber(String number) {
        Queue<Integer> queue=new LinkedList<>();

        for (char c : number.toCharArray()) {
            if(c>='0'&&c<='9'){
                queue.add(c-'0');
            }
        }

        StringBuilder sb=new StringBuilder();
       while (queue.size()>4){
           for(int i=0;i<3;i++){
               sb.append(queue.poll());
           }
           sb.append("-");
       }
        //System.out.println(queue.size());
      if(queue.size()==4){
          for(int i=0;i<2;i++){
              sb.append(queue.poll());
          }
          sb.append("-");
          for(int i=0;i<2;i++){
              sb.append(queue.poll());
          }
      }else if(queue.size()==2){
          for(int i=0;i<2;i++){
              sb.append(queue.poll());
          }
      }else if(queue.size()==3){
          for(int i=0;i<3;i++){
              sb.append(queue.poll());
          }
      }

return sb.toString();

    }


    public static void main(String[] args) {

    }
}
