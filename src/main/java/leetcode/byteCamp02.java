package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class byteCamp02 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String st=in.nextLine();
        String[] t= st.split("  ");
        //  System.out.println(t[0]+"  "+t[1]);
        int n = Integer.parseInt(t[0]);
        int m=Integer.parseInt(t[1]);
        Map<String,Integer> map=new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] s=in.nextLine().split(" ");
            int id=Integer.parseInt(s[0]);
            String []last=s[1].split("/");
            String key= toBinary(last[0]).substring(0,Integer.parseInt(last[1]));
            map.put(key,id);
        }

        for (int i = 0; i < m; i++) {
            String s=in.nextLine();
            String sb=toBinary(s);

            boolean flag=false;
            int count=0;
            int res=0;
            for (Map.Entry<String, Integer> stringIntegerEntry : map.entrySet()) {
                int l=stringIntegerEntry.getKey().length();
                if(l>count&&sb.substring(0,l).equals(stringIntegerEntry.getKey())){
                    res=stringIntegerEntry.getValue();
                    flag=true;
                    count=l;
                }
            }
            if(!flag){
                System.out.println(-1);
            }else {
                System.out.println(res);
            }
        }
    }

    static  String toBinary(String ip){
        String[] split = ip.split("\\.");
        StringBuilder res=new StringBuilder();
        for (int i = 0; i < split.length; i++) {
            String t=Integer.toBinaryString(Integer.parseInt(split[i]));
            while (t.length()!=8){
                t="0"+t;
            }
            res.append(t);
        }
        return res.toString();
    }
}
