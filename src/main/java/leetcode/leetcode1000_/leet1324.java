package leetcode.leetcode1000_;


import java.util.ArrayList;
import java.util.List;

public class leet1324 {
    public List<String> printVertically(String s) {
      String[] array=s.split(" ");
      int max=0;
        for (int i = 0; i < array.length; i++) {
            max=Math.max(array[i].length(),max);
        }
        List<String> result=new ArrayList<>();
        for(int i=0;i<max;i++){
            StringBuilder temp=new StringBuilder();
            for(int j=0;j<array.length;j++){
               if(i<array[j].length()){
                   temp.append(array[j].charAt(i));
               }else {
                   temp.append(" ");
               }
            }
            //去掉尾部空字符
            int j=temp.length()-1;
            while (j>=0){
                if(temp.charAt(j)!=' ') break;
                j--;
            }
            result.add(temp.substring(0,j+1));
        }
        return result;
    }
}
