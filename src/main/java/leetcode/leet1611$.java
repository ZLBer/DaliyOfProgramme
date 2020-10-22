package leetcode;

public class leet1611$ {


    //看了解释自己写的
  /*  Map<Integer,Integer> map=new HashMap<>();
    TreeSet<Integer> set=new TreeSet<>();
    public int minimumOneBitOperations(int n) {

      map.put(0,0);
     int pre=1;
     while (pre<=n){
      map.put(pre,pre*2-1);
      set.add(pre*2);
      pre*=2;
     }
     return helper(n);
    }

    int helper(int n){
      if(n==0) return 0;
     if(map.containsKey(n)) return map.get(n);
    int floor=set.floor(n);
  int res=helper(floor)-helper(n%floor);
 // map.put(n,res); //没必要的操作，n是递减的
  return res;
    }*/


  //利用hashmap源码里的操作
/*    Map<Integer,Integer> map=new HashMap<>();
    public int minimumOneBitOperations(int n) {

        map.put(0,0);
        int pre=1;
        while (pre<=n){
            map.put(pre,pre*2-1);
            pre*=2;
        }
        return helper(n);
    }

    int helper(int n){
        if(n==0) return 0;
        if(map.containsKey(n)) return map.get(n);

        int t=n;
        t|=t>>1;
        t|=t>>2;
        t|=t>>4;
        t|=t>>8;
        t|=t>>16;
        t+=1;
        t>>=1;


        int res=helper(t)-helper(n%t);
        // map.put(n,res); //没必要的操作，n是递减的
        return res;
    }*/


    int f(int n) {//将数字变成0所需要的步数
        if (n <= 1)
            return n;
        int t =Integer.toBinaryString(n).length();
        return (1 << t) + g(n ^ (1 << t), t - 1);
    }
   //t表示位数
    int g(int n, int t) { //将数字变成100..所需要的步数
        if (t == 0)
            return 1 - n;
        if ((n & (1 << t))>0)  //最高位为1 ，只需要将后面的变成0
            return f(n ^ (1 << t));
        return (1 << t) + g(n, t - 1); //最高位为0，则需要先把后面的变成100..
    }
    int minimumOneBitOperations(int n) {
        return f(n);
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(4).length());
    }

}
