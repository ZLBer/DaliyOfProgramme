package leetcode.leetcode1000_;

public class leet1108 {
    public String defangIPaddr(String address) {
     StringBuilder sb=new StringBuilder();
     for(char c:address.toCharArray()){
         if(c>='0'&&c<='9')sb.append(c);
         else sb.append("[.]");
     }
     return sb.toString();
    }
}
