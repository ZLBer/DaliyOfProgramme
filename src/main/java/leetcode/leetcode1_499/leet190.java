package leetcode.leetcode1_499;

public class leet190 {
/*    public int reverseBits(int n) {
        System.out.println(n);
       StringBuilder sb=new StringBuilder(Integer.toBinaryString(n));
       int c=0;
        System.out.println(sb.length());
       if(sb.length()<32) {
           c = 32 - sb.length();
           while (c-- > 0)
               sb.insert(0, 0);
       }
        System.out.println(sb.toString());
       return Integer.parseInt(sb.reverse().toString(),2);
    }*/

/*   //右移循环
    public int reverseBits(int n) {
       int result=0;
       for(int i=0;i<32;i++){
           result=(result<<1)|n&1;
           n=n>>>1;
       }
       return result;
    }
*/


   //字符串
    public int reverseBits(int n) {
        StringBuffer sb = new StringBuffer();
        String s = Integer.toBinaryString(n);

       //凑够32位置
        for(int i = 0; i < 32-s.length(); i++)
            sb.append('0');
        s = sb.toString() + s;

        System.out.println(s);
        char[]  c = s.toCharArray();
        int r = 0;
        //还是进行循环左移操作
        for(int i = 0; i < 32; i++){
            if(c[i] == '1')
                r += (1 << i);
        }
        return r;
    }

    
    /*  
     *    
     01101001
    /        \
  0110          1001
  /      \   /     \
 01     10   10     01
 /\     /\   /\     /\
0 1     1  0 1  0   0  1

*
     */
    //节省了循环
    public int reverseBits2(int n){
       // 先换奇偶位置
        n = ((n & 0xAAAAAAAA ) >>> 1) | ((n & 0x55555555) << 1);
        //然后两个一组交换
        n = ((n & 0xCCCCCCCC ) >>> 2) | ((n & 0x33333333) << 2);
        //四个一组交换
        n = ((n & 0xf0f0f0f0 ) >>> 4) | ((n & 0x0f0f0f0f) << 4);
        //八个一组交换
        n = ((n & 0xff00ff00 ) >>> 8) | ((n & 0x00ff00ff) << 8);
        //十六个一组交换
        n = ((n & 0xffff0000 ) >>> 16) | ((n & 0x0000ffff) << 16);
        return n;
    }

    public static void main(String[] args) {
        int a=0b10111111111111111111111111111111;
        System.out.println(Integer.toBinaryString(a));
        // 符号位填充
        System.out.println(Integer.toBinaryString(a>>1));
        // 0填充
        System.out.println(Integer.toBinaryString(a>>>1));
    }
}
