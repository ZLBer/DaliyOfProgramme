package leetcode.leetcode1000_1499;

public class leet1432 {
  static   public int maxDiff(int num) {
     StringBuilder max=new StringBuilder(),min=new StringBuilder();
     char maxNum='a',minNum='a';
    String s=num+"";
    if(s.charAt(0)!='1')
        minNum=s.charAt(0);
        for (int i = 0; i < s.length(); i++) {
          if(maxNum=='a'&&s.charAt(i)!='9'){ //找到替换数字
             maxNum=s.charAt(i);
          }
          if(minNum=='a'&&i!=0&&s.charAt(i)!='0'&&s.charAt(i)!=s.charAt(0)){
              minNum=s.charAt(i);
          }
          if(s.charAt(i)==maxNum){
           max.append('9');
          } else
          {
              max.append(s.charAt(i));
          }

          if(s.charAt(i)==minNum) {
           if(s.charAt(0)!='1'){
               min.append('1');
           }else {
               min.append('0');
           }

            } else
             {
             min.append(s.charAt(i));
          }
        }
       return Integer.parseInt(max.toString())-Integer.parseInt(min.toString());
    }



    //简明的版本
/*    public int maxDiff(int num) {
        char[] a = Integer.toString(num).toCharArray(), b = a.clone();
        char x = a[0], y = 0;
        for (int i = 0; i < a.length; ++i) {
            if (a[i] == x) { //若开头不是1也不是9
                a[i] = '9';
                b[i] = '1';
            }else if (x == '1' && a[i] > '0' || x == '9' && a[i] < '9') { //1开头或者9开头
                if (y == 0) { //最左替换这个数字
                    y = a[i];
                }
                if (y == a[i]) {
                    if (x == '1') //1开头就替换min数字为0
                        b[i] = '0';
                    else
                        a[i] = '9'; //9开头就替换max数字为9
                }
            }
        }
        return Integer.parseInt(String.valueOf(a)) - Integer.parseInt(String.valueOf(b));
    }*/
    public static void main(String[] args) {
        maxDiff(123456);
    }
}
