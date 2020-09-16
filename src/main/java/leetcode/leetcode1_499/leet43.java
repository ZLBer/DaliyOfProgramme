package leetcode.leetcode1_499;

public class leet43 {

    //mine 比较复杂 先算每一个 然后加起来
 /* static   public String multiply(String num1, String num2) {
  int length=Math.min(num1.length(),num2.length());
        List<String > res=new ArrayList<>();

        int count=-1;
     for(int i=num1.length()-1;i>=0;i--){
         int carry=0;
         count++;
         int a=num1.charAt(i)-'0';
       StringBuilder sb=new StringBuilder();
         for (int j = 0; j < count; j++) {
             sb.append('0');
         }
         for(int j=num2.length()-1;j>=0;j--){
       int b=num2.charAt(j)-'0';
       int p=a*b+carry;
       carry=p/10;
        sb.insert(0,p%10);
         }
        if(carry!=0) sb.insert(0,carry);
       res.add(sb.toString());
     }


     String sum= sum(res);
     if(sum.charAt(0)=='0') return "0";
    return sum;
    }

static     String sum(List<String> list){
      String sum=list.get(0);
        for (int i = 1; i < list.size(); i++) {
           // System.out.println(sum+" "+list.get(i));
           sum=sum(sum,list.get(i));
        }
        return sum;
    }

 static    String sum(String a,String b){
        StringBuilder sb=new StringBuilder();
      int i=a.length()-1,j=b.length()-1;
      int carry=0;
      while (i>=0&&j>=0){
       int s=a.charAt(i)-'0'+b.charAt(j)-'0'+carry;
       carry=s/10;
       sb.append(s%10);
       i--;j--;
      }
     while (i>=0){
         int s=a.charAt(i)-'0'+carry;
         carry=s/10;
         sb.append(s%10);
         i--;
     }
        while (j>=0){
            int s=b.charAt(j)-'0'+carry;
            carry=s/10;
            sb.append(s%10);
            j--;
        }
       if(carry!=0) sb.append(carry);

        return sb.reverse().toString();
    }*/



  //呜呜呜 看人家的多么简介  利用一个数组
    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] pos = new int[m + n];

        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + pos[p2];

                pos[p1] += sum / 10;
                pos[p2] = (sum) % 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int p : pos) if(!(sb.length() == 0 && p == 0)) sb.append(p);
        return sb.length() == 0 ? "0" : sb.toString();
    }
    public static void main(String[] args) {
    //    System.out.println( sum("72","810"));
    }

}
