package leetcode;

import java.util.HashMap;
import java.util.Map;

public class leet1410 {

    //mine
   /* public String entityParser(String text) {
    Mark[]marks=new Mark[]{
         new Mark("&quot;",6,"\""),
            new Mark("&apos;",6,"'"),
            new Mark("&amp;",5,"&"),
            new Mark("&gt;",4,">"),
            new Mark("&lt;",4,"<"),
            new Mark("&frasl;",7,"/"),
    };

    StringBuilder sb=new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char ch=text.charAt(i);
            if("&".equals(ch+"")){
                boolean flag=false;
                for (int j = 0; j < marks.length; j++) {
                    if(i+marks[j].length<=text.length()&&marks[j].entity.equals(text.substring(i,i+marks[j].length))){
                        sb.append(marks[j].symbol);
                        i+=marks[j].length-1;
                        flag=true;
                        break;
                    }

                }
                if(!flag) sb.append(ch);
            }else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
    class Mark{
        String entity;
        int length;
        String symbol;
        public Mark(String entity, int length, String symbol) {
            this.entity = entity;
            this.length = length;
            this.symbol = symbol;
        }
    }*/

//稍微简洁点的
    public String entityParser(String text) {
        if(text == null) return null;
        Map<String, String> cmap = new HashMap<>();
        cmap.put("&quot;", "\"");
        cmap.put("&apos;", "'");
        cmap.put("&amp;", "&");
        cmap.put("&gt;", ">");
        cmap.put("&lt;", "<");
        cmap.put("&frasl;", "/");

        StringBuilder res = new StringBuilder();
        int i = 0;
        while(i < text.length()) {
            if(text.charAt(i) == '&') {
                int j = 0;
                while(text.charAt(i + j) != ';') {
                    j++;
                }
                String key = text.substring(i, i + j + 1);
                if(cmap.containsKey(key)) {
                    res.append(cmap.get(key));
                } else {
                    res.append(key);
                }
                i += j + 1;
            } else {
                res.append(text.charAt(i));
                i++;
            }

        }

        return res.toString();
    }
}
