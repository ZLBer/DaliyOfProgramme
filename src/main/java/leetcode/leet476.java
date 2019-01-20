package leetcode;

/**
 * Created by libin on 2019/1/18.
 */
public class leet476 {
    //蛮力法
/*  static   public int findComplement(int num) {
        int count=0;

      LinkedList<Integer> linkedList=new LinkedList<>();
        while (num>0){
            if(num%2==1) linkedList.addFirst(0);
            else linkedList.addFirst(1);
            num/=2;
        }
    for(int i=linkedList.size()-1;i>=0;i--){
            if(linkedList.get(i)==1)  count+=Math.pow(2.0,linkedList.size()-i-1);
    }
return count;
    }*/


      //巧妙方法
    //例如：5的二进制位101，用111减去101，得到010，这与按位取反效果相同
    //所以只需求一个刚好比题中所给的数大的二进制全为1的数
   /*   public static int findComplement(int num) {
          int i = 0;
          while (i < num)
              i = 2 * i + 1;
          return i - num;
      }*/



     //与上面的方法相同 ，但是用bit操作
    static  public int findComplement(int num) {
        //System.out.println(Integer.toBinaryString(num));
          //相同位数但全是1的一串数
                int mask = (Integer.highestOneBit(num) << 1) - 1;
        //System.out.println(Integer.toBinaryString(mask));
               //num取反
                num = ~num;
        //System.out.println(Integer.toBinaryString(num));
        //System.out.println(Integer.toBinaryString(num&mask));
       //其实相当于 mask-num
                return num & mask;
            }

    public static void main(String[] args) {
        System.out.println(findComplement(5));
    }
}
