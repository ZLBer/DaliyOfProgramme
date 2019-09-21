package leetcode.leetcode500_999;

/**
 * Created by libin on 2019/1/2.
 */
public class leet717 {
    // 遇到0就跳一个，遇到1就跳两个
    public boolean isOneBitCharacter(int[] bits) {
        int i=0;
              for( ;i<bits.length-1;){
                  if(bits[i]==1) i+=2;
                  else i++;
              }
              return i==bits.length-1;
    }
}
