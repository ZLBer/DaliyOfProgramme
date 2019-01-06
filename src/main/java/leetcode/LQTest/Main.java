package leetcode.LQTest;

import java.io.BufferedInputStream;
import java.util.*;

/**
 * Created by libin on 2018/3/30.
 */
public class Main {
    //    public static void main(String[] args) {
//        for(int i=2;i<10000;i++){
//            int lifang=(int)Math.pow(i,3);
//           // System.out.println(lifang);
//            int count=0;
//           String a=String.valueOf(lifang);
//            ;
//            while(a.length()>0){
//           //     System.out.println(a.charAt(0));
//               count+= Integer.valueOf(a.substring(0,1));
//              //  System.out.println(count);
//
//                a=a.substring(1);
//            }
//            if(count==i)
//                System.out.println(count);
//        }
//    }
//public static void main(String[] args) {
////      int a,b,c,d;
////      int e,f,g,h;
//      // e,f,c,b,i
//
//        for(int a=0;a<10;a++){
//            for(int b=0;b<10;b++){
//                for(int c=0;c<10;c++){
//                    for(int d=0;d<10;d++){
//                        for(int e=1;e<10;e++){
//                            for(int f=0;f<10;f++){
//                                for(int g=0;g<10;g++){
//
//                                        for(int i=0;i<10;i++) {
//                                            if (a * 1000 + b * 100 + c * 10 + d + e * 1000 + f * 100 + g * 10 + b==e*10000+f*1000+c*100+b*10+i)
//                                            {
//                                                Set<Integer> re=new LinkedHashSet<>();
//                                                  re.addAll(Arrays.asList(a,b,c,d,e,f,g,i));
//                                               // System.out.println(re.size());
//                                                  if(re.size()>=8){
//                                                      System.out.println(a+" "+b+" "+c+" "+d);
//                                                      System.out.println(e+" "+f+" "+g+" "+b);
//                                                      break;
//                                                  }
//
//
//
//                                        }
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }
//    }
//public static int f(int n, int m)
//{
//    n = n % m;
//    Vector v = new Vector();
//
//    for(;;)
//    {
//        v.add(n);
//       // System.out.println(v.get(0));
//        n *= 10;
//        n = n % m;
//       // System.out.println(n);
//        if(n==0) return 0;
//        if(v.indexOf(n)>=0)  return v.size();;  //填空
//    }
//}
//
//    public static void main(String[] args) {
//        System.out.println( f(11,13));
//    }
//    int back(int layer,int sum){
//      for(int i=1;i<47;i++){
//          for(int j=i+2;j<49;j++){
//             if(1225-i-i-1-j-j-1+i*(i+1)+j*(j+1)==2015)
//                 System.out.println(i);
//          }
//      }
//      return 0;
//    }
//
//    public static void main(String[] args) {
//        Main t=new Main();
//        System.out.println(t.back(2,0));
////    }
//    int num = 0;
//    int count = 0;
//
//    void back(int layer) {
//
//
//        if (num > 13) return;
//      //  if(layer==13){
//            if (num == 13) {
//                count++;
//                return;
//            }
//        if (layer > 13) return;
//      //  }
//        for (int i = 0; i <= 4; i++) {
//            num += i;
//            back(layer + 1);
//            num -= i;
//        }
//    }
//    void back1(int layer,int num) {
//
//        if (layer > 13) return;
//       // if (num > 13) return;
//        if(layer==13){
//            if (num == 13) {
//                count++;
//
//            }
//            return;
//        }
//
//        for (int i = 0; i <= 4; i++) {
//
//            back1(layer + 1,num+i);
//
//        }
//    }
//    int sum;
//    int ans;
//    void dfs(int cur)
//    {
//        int i;
//        if (cur>13)     //表示牌的大小
//            return;
//        if (cur==13)
//        {
//            if (sum==13)    //表示牌的张数
//                ans++;
//            return;
//        }
//        for (i=0;i<=4;i++)
//        {
//            sum+=i;
//            dfs(cur+1);
//            sum-=i;
//        }
//    }
//    public static void main(String[] args) {
//        Main t = new Main();
//        t.back(1);
//       System.out.println(t.count);
//        t.dfs(0);
//        System.out.println(t.ans);
//
////        t.back1(0,0);
////        System.out.println(t.count);
//    }
//    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        int n=sc.nextInt();
//        int sum=n;
//        while(n>=3){
//            sum+=n/3;
//            n=n%3+n/3;
//        }
//        System.out.println(sum);
//}
    int binarySearch(int left,int right,int array[],int x){
        while(left<=right){
            int mid=(left+right)/2;
            if(x==array[mid]) return mid;
            if(x<array[mid]) right=mid-1;
            else  left=mid+1;

        }
        return 0;
    }
    public static void main(String[] args) {
        Scanner cs= new Scanner(new BufferedInputStream(System.in));
        int n=cs.nextInt();
        int m=cs.nextInt();
       int []oppose=new int[m];
        for(int i=0;i<m;i++){
           oppose[i]=cs.nextInt()+cs.nextInt();
        }
        cs.close();
        for(int a :oppose){
            System.out.println(a);
        }
//        List<int []> layer=new LinkedList<>();
//        layer.add(new int []{1,2,3,4,5,6});
//        int [] layPosNum=new int [n];
//        layPosNum[0]=6;
//        for(int i=1;i<=n;i++){
//            for(int j=1;j<=6;j++){
//                for(int cu:oppose)
//                    for(int down:layPosNum){
//                    if(j+down==cu)
//                    }
//
//            }
//        }
    }
}
