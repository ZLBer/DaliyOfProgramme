package leetcode.华科复试;

/**
 * Created by libin on 2019/3/3.
 */
public class sqrtPalindrome {
 static    void solution(int begin,int end){
 for(int i=begin;i<=end;i++){
     if(isFullSqrt(i)&&isPalindrome(i)) System.out.println(i);
 }
    }
    static boolean isFullSqrt(int number){
        for(int i=10;i<32;i++){
            if(i*i==number) return true;
            if(i*i>number) return false;
        }
        return false;
    }
    static  boolean isPalindrome(int number){
        int a=number%10;
        int b=number/10%10;
        int c=number/100;

        int num=a*100+b*10+c;
        if(num==number) return true;
        else  return false;


    }

    public static void main(String[] args) {
        solution(100,999);
    }
}
