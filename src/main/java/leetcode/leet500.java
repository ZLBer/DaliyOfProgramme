package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by libin on 2017/9/2.
 */
public class leet500 {
    public String[] findWords(String[] words) {
        List<String> list=new ArrayList<String>();
        String Up = "qwertyuiop";
        String Me = "asdfghjkl";
        String Dn = "zxcvbnm";
        for (int i = 0; i < words.length; i++) {
            boolean f=true;
            for (int j = 0;j < words[i].length(); j++) {
              String a = TakeSingleElemet(words[i],j);
                System.out.println(a);
                if (Up.indexOf(a.toLowerCase()) == -1) {
                 f=false;
                }
                if(f==false) break;
                else {

                    continue;
                }
            }
            if(f==true) {
               list.add(words[i]);
                continue;
            }
            else f=true;
            for (int j = 0;j < words[i].length(); j++) {
                String a = TakeSingleElemet(words[i],j);
                if (Me.indexOf(a.toLowerCase()) == -1) {
                    f=false;
                }
                if(f==false) break;
                else {

                    continue;
                }
            }
            if(f==true) {
                list.add(words[i]);
                continue;
            }
            else f=true;
            for (int j = 0;j < words[i].length(); j++) {
                String a = TakeSingleElemet(words[i],j);
                if (Dn.indexOf(a.toLowerCase()) == -1) {
                    f=false;
                }
                if(f==false) break;
                else continue;
            }
            if(f==true)    list.add(words[i]);
        }
        return  list.toArray( new String[list.size()]);

    }

    public String TakeSingleElemet(String Elements,int i){
        String a=Elements.substring(i,i+1);
        if(i==Elements.length()-1)
            a=Elements.substring(i);
        return  a;
    }
}
