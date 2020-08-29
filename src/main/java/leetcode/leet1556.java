package leetcode;

public class leet1556 {

 /*   public String thousandSeparator(int n) {
       String sn=n+"";
     if(sn.length()<=3) return sn;
       StringBuilder sb=new StringBuilder();

      int c=sn.length()%3;


        for (int i = 0; i < sn.length(); i++) {
          if(c>0){
             sb.append(sn.charAt(i));
             c--;
          }else {
              if(i!=0) sb.append(".");
              c=3;
              i--;
          }
        }

     return sb.toString().substring(0,sb.length()-1);
    }
*/
  //反向遍历即可
    public String thousandSeparator(int n) {
        StringBuilder sb = new StringBuilder();
        String s = String.valueOf(n);
        int cnt = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
            cnt++;
            // 如果cnt%3==0，并且i!=0(不是最后一个字符)
            if (cnt % 3 == 0 && i != 0) {
                sb.append(".");
            }
        }
        return sb.reverse().toString();
    }


    public static void main(String[] args) {

    }
}
