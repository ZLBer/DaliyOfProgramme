package leetcode;

import java.util.Arrays;

public class leet869 {

    // 用全排列做
/*    public boolean reorderedPowerOf2(int N) {
       String []array=(N+"").split("");
       return helper(array,0);
    }

    //全排列
    boolean helper(String[]array,int index){

        if(index==array.length-1&&!"0".equals(array[0])) {

            StringBuilder sb=new StringBuilder();
            for (String s : array) {
                sb.append(s);
            }

            int value = Integer.valueOf(sb.toString());
            System.out.println(value);
            if ((value > 0) && ((value & (value -1)) == 0)) return true;
        }
        for(int i=index;i<array.length;i++){
            swap(array,index,i);
            if(helper(array,index+1))
                return true;
            swap(array,index,i);
        }
        return false;
    }
    void  swap(String []array,int i,int j){
         String temp=array[i];
         array[i]=array[j];
         array[j]=temp;
    }*/


    public boolean reorderedPowerOf2(int N) {
        char []array=(N+"").toCharArray();
        Arrays.sort(array);
       String n=new String(array);
        for(int i=0;i<32;i++){
            char[] t=((1<<i)+"").toCharArray();
             Arrays.sort(t);
             String s=new String(t);
             if(s.equals(n)) return true;
        }
        return false;

    }

  //也是类似排序的思想  求每个数字的10次方
 /*   public boolean reorderedPowerOf2(int N) {
        long c = counter(N);
        for (int i = 0; i < 32; i++)
            if (counter(1 << i) == c) return true;
        return false;
    }
    public long counter(int N) {
        long res = 0;
        for (; N > 0; N /= 10) res += (int)Math.pow(10, N % 10);
        return res;
    }*/

 // 统计数字个数
  /*  public boolean reorderedPowerOf2(int N) {
        for(int ans=1;ans<=Math.pow(10,9);ans*=2)
            if(equal(N,ans))
                return true;
        return false;
    }
    public boolean equal(int num1,int num2){
        char[] str1 = Integer.toString(num1).toCharArray(),str2 = Integer.toString(num2).toCharArray();
        int[] nums = new int[10];
        for(int i=0;i<str1.length;i++) nums[str1[i] - '0']--;
        for(int i=0;i<str2.length;i++) nums[str2[i] - '0']++;
        for(int i:nums)
            if(i!=0) return false;
        return true;
    }*/


}
