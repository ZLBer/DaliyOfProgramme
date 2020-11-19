package leetcode;

import java.util.ArrayList;
import java.util.List;

public class leet1656 {

    class OrderedStream {
       int ptr=1;
       String []arr;
        public OrderedStream(int n) {
         arr=new String[n+1];
        }

        public List<String> insert(int id, String value) {
           arr[id]=value;
          List<String> res=new ArrayList<>();
           if(id==ptr){
             int i=id;
               while (i<arr.length&&arr[i]!=null) {
                   res.add(arr[i]);
                   i++;
               }
               ptr=i;
           }

           return res;
        }
    }





    public static void main(String[] args) {

    }
}
