package leetcode;

public class leet1678 {

    public String interpret(String command) {
        if("".equals(command)) return "";
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < command.length(); i++) {
            if(command.charAt(i)=='G'){
                sb.append("G");
            }else if("()".equals(command.substring(i,i+2))){
                sb.append("o");
                i++;
            }else {
               sb.append("al");
               i+=3;
            }
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        System.out.println("test");
    }
}
