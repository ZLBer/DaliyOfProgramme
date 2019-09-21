package leetcode.leetcode500_999;

import java.util.Arrays;

/**
 * Created by libin on 2019/1/3.
 */
public class leet950 {
    //算法的总体思想：先把deck排序依次遍历， 然后按照每隔一个的顺序开始往result里插入
    //例如 17,13,11,2,3,5,7 排序后是2 3 5 7 11 13 17
      //  一 2插入到result[0] 3插入到result[2] .... 剩下result[1],result[3],result[5] 没有数字 ，还有11 17 13 没有插入
    // 二  是从1还是从3开始插入 ，看上一次遍历是插入的result的最后一个还是倒数的第二个 ，这就是set变量的作用
    //三  直至一次遍历后count未发生变化，表示所有的数字已经插入，flag数组表示该位置是否插入
    //算法时间复杂度是 n*logn
  static   public int[] deckRevealedIncreasing(int[] deck) {
      Arrays.sort(deck);

     int []result=new int[deck.length];
     int  []flag=new int[deck.length];
     int count=2;
     int set=1;
     int j=0;
     //count 表示一趟统计的未插入的数目 ，
      //j是升序数组的遍历位置
      //set表示是否
     while(count!=0){
         count=0;
for(int i=0;i<deck.length;i++){
       if(flag[i]==0) {
           count++;
           set++;
       }
       if(set==2) {
   //        System.out.println(deck[j]);
           flag[i]=1;
           result[i]=deck[j++];
           set=0;
       }
}
    //     System.out.println("set"+set);
//    if(set==0) set=1;
//            else set=0;;
    }
     return result;
}


 //大神的做法  用队列进行操作   将index从0到length入队  每次出队一个人后将另一个再次入队 ，简直666，but比我的慢
//    public int[] deckRevealedIncreasing(int[] deck) {
//        int n= deck.length;
//        Arrays.sort(deck);
//        Queue<Integer> q= new LinkedList<>();
//        for (int i=0; i<n; i++) q.add(i);
//        int[] res= new int[n];
//        for (int i=0; i<n; i++){
//            res[q.poll()]=deck[i];
//            q.add(q.poll());
//        }
//        return res;
//    }
    public static void main(String[] args) {
      //2 3 5 7 17 13 11
       int []a= deckRevealedIncreasing(new int[]{17,13,11,2,3,5,7});
for(int c:a){
    System.out.println(" "+c);
}
    }
}
