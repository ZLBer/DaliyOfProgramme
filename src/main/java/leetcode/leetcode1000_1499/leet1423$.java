package leetcode.leetcode1000_1499;

public class leet1423$ {
    //mine   MLE
/*    public int maxScore(int[] cardPoints, int k) {
        memo=new int[cardPoints.length+1][cardPoints.length+1];
        return dfs(0,cardPoints.length-1,k,0,0,cardPoints);
    }
    int [][]memo;
    int dfs(int left,int right,int k,int count,int sum,int[]cardPoints){
       if(count==k){
           return sum;
       }
   if(memo[left][right]!=0) return memo[left][right];
      int l=dfs(left+1,right,k,count+1,sum+cardPoints[left],cardPoints);
       int r=dfs(left,right-1,k,count+1,sum+cardPoints[right],cardPoints);

     return memo[left][right]=Math.max(l,r);
    }*/




//TLE
/*    public int maxScore(int[] cardPoints, int k) {
        return dfs(0,cardPoints.length-1,k,0,0,cardPoints);
    }
    Map<Point,Integer> memo=new HashMap<>();
    int dfs(int left,int right,int k,int count,int sum,int[]cardPoints){
        if(count==k){
            return sum;
        }

        Point point=new Point(left,right);
        if(memo.containsKey(point))   return memo.get(point);
        int l=dfs(left+1,right,k,count+1,sum+cardPoints[left],cardPoints);
        int r=dfs(left,right-1,k,count+1,sum+cardPoints[right],cardPoints);

        int val=Math.max(l,r);
        memo.put(point,val);
        return val;
    }
    class Point{
        int left;
        int right;

        public Point(int left, int right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return left == point.left &&
                    right == point.right;
        }

        @Override
        public int hashCode() {
            return Objects.hash(left, right);
        }
    }*/

//滑动窗口  看了hint之后自己写的
/*public int maxScore(int[] cardPoints, int k) {
int window=cardPoints.length-k;

int []preSum=new int[cardPoints.length+1];
    for (int i = 0; i < cardPoints.length; i++) {
        preSum[i+1]=preSum[i]+cardPoints[i];
    }

    int sum=Integer.MAX_VALUE;
    for (int i = 0; i <= cardPoints.length-window; i++) {
       int temp=preSum[i+window]-preSum[i];
       sum=Math.min(sum,temp);
    }
    return preSum[cardPoints.length]-sum;
}*/

//可以不用求presum
/*    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length - k;
        int total = 0;
        int min = Integer.MAX_VALUE;
        int cur = 0;
        int l = 0;
        int r = 0;
        while (r < cardPoints.length) {
            total += cardPoints[r];
            cur += cardPoints[r];
            if (r - l + 1 == n) {
                min =Math.min(min, cur);
                cur -= cardPoints[l++];
            }
            r++;
        }

        return total - (min == Integer.MAX_VALUE ? 0 : min);
    }*/

//原则：一定是前后连续的k的元素  依次比较即可
    public int maxScore(int[] cardPoints, int k) {
        int max = 0, sum = 0;
        for(int i = 0; i<k;i++) sum += cardPoints[i];

        max = sum;
        for(int i = 1; i<=k; i++){
            sum = sum + cardPoints[cardPoints.length -i] - cardPoints[k -i];
            max = Math.max(max, sum);
        }

        return max;
    }
}
