package leetcode.LQTest;


import java.util.HashSet;
import java.util.Set;

/**
 * Created by libin on 2018/3/30.
 */
public class css {
    float [] num={1,2,3,4,5,6,7,8,9};
     int count;
     Set<Integer> s=new HashSet<>();
    void backtrace(int k,int m){

        //if(k>m) return;
if(k==m) {
    if(num[0]+num[1]/num[2]+(num[3]*100+num[4]*10+num[5])/(num[6]*100+num[7]*10+num[8])==10) count++;
}
    for(int i=k;i<num.length;i++){
      swap(num,k,i);
      backtrace(k+1,m);
      swap(num,k,i);
    }
    }
     static  void swap(float []data,int a,int b){
         float tem=data[a];
          data[a]=data[b];
          data[b]=tem;
     }

    public static void main(String[] args) {
        css t=new css();
        t.backtrace(0,8);
        System.out.println(t.count);
        System.out.println(t.s.add(10));
        System.out.println(t.s.add(10));
    }
 }
