package leetcode;

public class leet1399 {
    //mine  应该是可以找规律的  不用map之类
/*    public int countLargestGroup(int n) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 1; i <= n; i++) {
        int su=getSum(i);
            map.put(su,map.getOrDefault(su,0)+1);
        }
        int maxV=0;
       for(int value: map.values()){
         maxV=Math.max(maxV,value);
       }
       int res=0;
       for(int value:map.values()){
          if(value==maxV)res++;
       }
        return res;
    }

    int getSum(int num){
        int res=0;
        while (num>0){
        res+=(num%10);
        num/=10;
        }
        return res;
    }*/

//用个屁的map啊  一个数组解决了  开始想到数组的，但以为不确定
    public int countLargestGroup(int n) {
        final int N = 100;
        int [] counter = new int [N];
        for(int num = 1; num <= n; ++num) {
            int val = num;
            int cnt = 0;
            while(val != 0) {
                cnt += val % 10;
                val /= 10;
            }
            ++counter[cnt];
        }
        int mx = 0;
        for(int i = 0; i < N; ++i) mx = Math.max(mx, counter[i]);
        int ans = 0;
        for(int i = 0; i < N; ++i) {
            if(counter[i] == mx) ++ans;
        }
        return ans;
    }
}
