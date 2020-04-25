package leetcode;

import java.util.ArrayList;
import java.util.List;

public class leet1417 {
    public String reformat(String s) {
        List<Character> num=new ArrayList<>();
        List<Character> letter=new ArrayList<>();
        for (char c : s.toCharArray()) {
            if(c>='0'&&c<='9'){
                num.add(c);
            }else letter.add(c);
        }
        if(Math.abs(num.size()-letter.size())>=2){
            return "";
        }

        StringBuilder sb=new StringBuilder();
        int i=num.size()-1,j=letter.size()-1;
        while (i>=0&&j>=0){
            sb.append(num.get(i--));
            sb.append(letter.get(j--));
        }

        if(i>=0) sb.append(num.get(i));
        if(j>=0) sb.insert(0,letter.get(j));

        return sb.toString();
    }

}
