package leetcode;


import java.util.Arrays;
import java.util.Comparator;

public class leet937 {
    public String[] reorderLogFiles(String[] logs) {

        Comparator<String> comparator= new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {

                int identifier1=o1.indexOf(' ')+1;
                int  identifier2=o2.indexOf(' ')+1;

                char c1=o1.charAt(identifier1);
                char c2=o2.charAt(identifier2);
                //存在数字的情况
                if(c1<='9'){
                    if(c2<='9') return 0;
                    else return 1;
                }
                if(c2<='9') return -1;
               //字母的情况

                int compute=o1.substring(identifier1).compareTo(o2.substring(identifier2));
             if(compute==0) return o1.substring(0,identifier1-1).compareTo(o2.substring(0,identifier2-1));
return compute;
            }



        };
        Arrays.sort(logs,comparator);
        return logs;
    }
}
