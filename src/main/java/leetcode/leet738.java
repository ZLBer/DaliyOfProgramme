package leetcode;

public class leet738 {

    //贪就完了
/*    public int monotoneIncreasingDigits(int N) {
        char[] chars = (N + "").toCharArray();
        StringBuilder sb=new StringBuilder();
        int pre=-1;
        boolean flag=false;
        for (int i = 0; i < chars.length; i++) {
           if(flag==true){
               sb.append(9);
               continue;
           }
            if(chars[i]>=pre){
               sb.append(chars[i]);
               pre=chars[i];
            }else {
                char c=sb.charAt(sb.length()-1);
                while (sb.length()>0&&sb.charAt(sb.length()-1)==c){
                 sb.deleteCharAt(sb.length()-1);
                 i--;
                }
                sb.append((char)(chars[i]-1));
               flag=true;i--;
            }
        }
        return Integer.valueOf(sb.toString());
    }*/


    //别人的貌似简单多了 哈哈哈 思想是一样的
    public int monotoneIncreasingDigits(int N) {
        char[] arr = (N + "").toCharArray();
        int max = -1, idx = -1;
        for (int i = 0; i < arr.length - 1; i++) {
            if (max < arr[i]) {
                max = arr[i];
                idx = i;
            }
            if (arr[i] > arr[i + 1]) {
                arr[idx] -= 1;
                for(int j = idx + 1;j < arr.length;j++) {
                    arr[j] = '9';
                }
                break;
            }
        }
        return Integer.parseInt(new String(arr));
    }

    //好家伙
    //简单说一下理解
    //就像叠罗汉一样  在保证递增的情况下在9次之内一定可以达到最大
    //  1111
    //   111
    //    11
    //     1
  /*  public int monotoneIncreasingDigits(int N) {
        int ones = 111111111;
        int res = 0;
        for(int i=0;i<9;i++){
            while(res+ones>N){
                ones/=10;
            }
            res += ones;
            if(ones==0)
                break;
        }
        return res;
    }
*/
}
