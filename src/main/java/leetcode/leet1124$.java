package leetcode;

public class leet1124$ {

    //这种题.. 算是一种hash吧，用到了hash表
    //这种题只能自己总结情况，的确不是很好想
    public int maxEqualFreq(int[] A) {
        int[] count = new int[100001], freq = new int[100001];
        int res = 0, N = A.length, a,c,d;
        // n表示长度
        for (int n = 1; n <= N; ++n) {
           //这个位置上的数字
            a = A[n - 1];
            //前一个count统计减一
            --freq[count[a]];
            // a的次数统计加一
            c = ++count[a];
            //新的count统计加一
            ++freq[count[a]];

            //第一种情况： 需要删除的数字在下一个出现，c个freq[c] 无论下一个是什么都可以删除（需要排除没有洗一个的情况）
            if (freq[c] * c == n && n < N)
                res = n + 1;
            //第二种情况： 需要删除的数字在之前出现，算出除去c频率的剩余d，只有frea[d]出现频率为1，且 d的个数为c+1或1 才可以删除其中一个
            d = n - freq[c] * c;
            if ((d == c + 1 || d == 1) && freq[d] == 1)
                res = n;
        }
        return res;
    }
/*    public int maxEqualFreq(int[] A) {
        int[] cnt = new int[100001], freq = new int[100001];
        int maxF=0,res=0;
        for(int i=0;i<A.length;i++){
            int num=A[i];
            cnt[num]++;
            freq[cnt[num]-1]--;
            freq[cnt[num]]++;
            maxF=Math.max(maxF,cnt[num]);
            if(maxF*freq[maxF]==i||(maxF-1)*(freq[maxF-1]+1)==i||maxF==1)
                res = i+1;
        }
        return res;
    }*/

}
