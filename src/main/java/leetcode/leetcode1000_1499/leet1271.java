package leetcode.leetcode1000_1499;

public class leet1271 {
    public String toHexspeak(String num) {
   String hex= Long.toHexString(Long.valueOf(num)).toUpperCase();
   StringBuilder sb=new StringBuilder();
    for(int i=0;i<hex.length();i++){
        if(hex.charAt(i)=='1') {
            sb.append("I");
        }else if(hex.charAt(i)=='0'){
            sb.append("O");
        }else if(hex.charAt(i)>='A'&&hex.charAt(i)<='F')
            sb.append(hex.charAt(i));
        else {
            return "ERROR";
        }
    }
    return sb.toString();

    }

    public static void main(String[] args) {
        System.out.println( Long.toHexString(Long.valueOf("747823223228")));

    }
}
