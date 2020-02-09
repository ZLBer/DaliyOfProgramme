package leetcode;

public class leet1323 {
    public int maximum69Number (int num) {
        String n=String.valueOf(num);
        for(int i=0;i<n.length();i++){
          if(n.charAt(i)=='6'){
              return Integer.valueOf(n.substring(0,i)+"9"+n.substring(i+1));
          }
        }
        return num;
    }



  /*  public int maximum69Number(int num) {
        char[] chars = Integer.toString(num).toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '6') {
                chars[i] = '9';
                break;
            }
        }
        return Integer.parseInt(new String(chars));
    }*/

    public static void main(String[] args) {
        System.out.println("123".substring(3));
    }
}
