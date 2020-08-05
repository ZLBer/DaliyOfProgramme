package leetcode;

import java.util.Scanner;

public class byteCamp03 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n=Integer.parseInt(in.nextLine());
    int res=0;
        while (n-->0){
      if(check(n))    res++;
    }
        System.out.println(res);
    }
  static   boolean check(int i){
      if(i%2==0) return true;
      else return false;
    }
}
