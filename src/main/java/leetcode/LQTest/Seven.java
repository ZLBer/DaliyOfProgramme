package leetcode.LQTest;

/**
 * Created by libin on 2018/3/31.
 */
public class Seven {
    static int sum = 0; // 记录手中的牌的数目
    static int ans = 0; // 记录结果
    private static void cal(int n){
        if (sum > 13) return;
        if (n==14){ // 13种牌型以及全部搜索
            if (sum == 13){
                ans++;
                return;
            }
        }else{
            for(int i = 0; i<5; i++){
                sum+=i;
                cal(n+1);
                sum-=i; // 还原
            }
        }
    }

    public static void main(String[] args) {
        cal(1); // 从第一个牌搜索
        System.out.println(ans);
    }
}
