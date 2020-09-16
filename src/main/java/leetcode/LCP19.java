package leetcode;

public class LCP19 {

    //超时了 cccc 这样都超时!!!
/*    static   public int minimumOperations(String leaves) {
        int left=-1,right=leaves.length();
        for (int i = 0; i < leaves.length(); i++) {
            char  c=leaves.charAt(i);
            if(c=='r') left++;
            else break;;
        }
        for (int j = leaves.length()-1; j >= 0; j--) {
            char  c=leaves.charAt(j);
            if(c=='r') right--;
            else break;;
            if(right<=left) return 1; //表示都是r ，所以修改一个即可
        }

        int res=0;
        if(left==-1){
            left++;
            res++;
        }
        if(right==leaves.length()){
            right--;
            res++;
        }



        int []count=new int[leaves.length()+1];

        for (int i = 0; i < leaves.length(); i++) {
            char  c=leaves.charAt(i);
            if(c=='r') count[i+1]+=count[i]+1;
            else  count[i+1]=count[i];
        }



        int ans=Integer.MAX_VALUE;
        for(int i=left+1;i<right;i++){
            int l =  i-left-1- (count[i]-count[left+1]);
            if(l>=ans) break;
            for(int j=i+1;j<=right;j++){ //j不包含
                //左边有r
                int r= right-j- (count[right]-count[j]);//右边有几个r
                int mid=   count[j]-count[i]; //中间有几个r

                ans=Math.min(ans,l+r+mid);
                // if(ans==4)   System.out.println(i+"  "+j+"  "+ans);
            }

        }
        //   System.out.println(res);
        return ans+res;


    }*/

     //mine  在n2的基础上 利用函数极值优化成n
    //不推荐这种写法  太费劲
/*static   public int minimumOperations(String leaves) {
        int left=-1,right=leaves.length();
        for (int i = 0; i < leaves.length(); i++) {
            char  c=leaves.charAt(i);
            if(c=='r') left++;
            else break;;
        }
        for (int j = leaves.length()-1; j >= 0; j--) {
            char  c=leaves.charAt(j);
            if(c=='r') right--;
            else break;;
            if(right<=left) return 1; //表示都是r ，所以修改一个即可
        }

        int res=0;
        if(left==-1){
            left++;
            res++;
        }
        if(right==leaves.length()){
            right--;
            res++;
        }



        int []count=new int[leaves.length()+1];

        for (int i = 0; i < leaves.length(); i++) {
            char  c=leaves.charAt(i);
            if(c=='r') count[i+1]+=count[i]+1;
            else  count[i+1]=count[i];
        }



        int []min= new int[leaves.length()+1];
        int cur=Integer.MAX_VALUE;
        for(int i=left+1;i<right;i++){
            int l = i-left-1- (count[i]-count[left+1])-count[i];
            cur=Math.min(cur,l);
            min[i]=cur;
        }




        int ans=Integer.MAX_VALUE;

        for(int j=left+2;j<=right;j++){
            int r= right-j- (count[right]-count[j]);//右边有几个r
            int mid= count[j]; //中间有几个r

            ans=Math.min(ans,min[j-1]+r+mid);
        }
        //System.out.println(res);
        return ans+res;
    }*/




//前缀和求极值
/*
 static    public int minimumOperations(String leaves) {
        int n = leaves.length();
        char[] array = leaves.toCharArray();
        int[] sum = new int[n + 1];
        for (int i = 0; i < n; i++)
            sum[i + 1] = sum[i] + (array[i] == 'r' ? 1 : 0);
        int[] min = new int[n + 1];
        int currentMin = Integer.MAX_VALUE;
        for (int i = 1; i < n - 1; i++) { //从1到n-1
            currentMin = Math.min(currentMin, i - 2 * sum[i]);
            min[i] = currentMin;
        }
        int result = Integer.MAX_VALUE;
        for (int j = n - 1; j > 1; j--)
            result = Math.min(result, n - sum[n] + min[j - 1] - j + 2 * sum[j]);
        return result;
    }
*/

    //dp   其实看会了就觉得比上面的方法简单多了
    public int minimumOperations(String leaves) {
        int[][] dp = new int[leaves.length() + 1][3];
        for (int i = 1; i <= leaves.length(); i++) {
            char c = leaves.charAt(i - 1);
            dp[i][0] = dp[i - 1][0] + (c == 'r' ? 0 : 1);

            if (i == 1) {

            } else if (i == 2) {
                dp[i][1] = dp[i - 1][0] + (c == 'y' ? 0 : 1);
            } else if (i == 3) {
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]) + (c == 'y' ? 0 : 1);
                dp[i][2] = dp[i - 1][1] + (c == 'r' ? 0 : 1);
            } else {
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]) + (c == 'y' ? 0 : 1);
                dp[i][2] = Math.min(dp[i - 1][1], dp[i - 1][2]) + (c == 'r' ? 0 : 1);
            }



        } return dp[leaves.length()][2];
    }




}
