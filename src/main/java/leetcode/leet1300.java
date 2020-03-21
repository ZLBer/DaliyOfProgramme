package leetcode;

public class leet1300 {

    //mine  想的超级麻烦 导致contest的时候没做出来
/*  static   public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);
        int[]preSum=new int[arr.length];
        preSum[0]=arr[0];
        for (int i = 1; i < arr.length; i++) {
            preSum[i]=preSum[i-1]+arr[i];
        }
       int left=0;int right=arr.length-1;
       while (left<right){
          // System.out.println(left+" " +right);
           int mid=(left+right)/2;
           int sum=preSum[mid]+(arr.length-mid-1)*arr[mid];
           if(sum==target){
               return arr[mid];
           } else if(sum<target){
               left=mid+1;
           }else right=mid-1;
       }
      //  System.out.println(left);
       int leftL=left-1;
       int leftR=left+1;
       if(left>0&&left<arr.length-1){
           int ll=preSum[leftL]+(arr.length-leftL-1)*arr[leftL];
           int l=preSum[left]+(arr.length-left-1)*arr[left];
           int lR=preSum[leftR]+(arr.length-leftR-1)*arr[left];
           //介于两个之间
           System.out.println(ll+" "+l);
           if(ll<target&&l>target){
              int v1=(target-preSum[leftL])/(arr.length-leftL-1);
               return helper(v1,target,arr.length-leftL-1,preSum[leftL]);
           }else {
               int v1= (target-preSum[leftR])/(arr.length-leftR-1);
               return helper(v1,target,arr.length-left-1,preSum[left]);
           }
       }else if(left==0){
           if(arr[left]*arr.length<target){
               int v1= (target-arr[left])/(arr.length-1);
               return helper(v1,target,arr.length-1,arr[0]);
           }
           else {
               int v1 = target / arr.length;

               return helper(v1,target,arr.length,0);
           }
       }
       //还缺一种情况 但测试用例中没有，遂不想加了

       return arr[left];
    }

  static   int helper(int v1,int target,int length,int preSum){
        int v2 = v1 + 1;
        if (Math.abs(target - v1 * length-preSum) > Math.abs(target - v2 * length-preSum)) {
            return v2;
        } else return v1;
    }*/



//排序后直接做
//害 这比用上边的二分好多了 也不用分那么多情况
/*    public int findBestValue(int[] arr, int target) {
        int s=0, m=-1;
        for(int v:arr) { s += v; m=Math.maxSum(m,v); }
        if(s<=target) return m; // return the maxSum value since we will keep all nums as is

        Arrays.sort(arr);

        int removed=0, lastIx=arr.length-1;
        while(lastIx>=0 && target < s + removed*arr[lastIx]) {
            removed++;
            s -= arr[lastIx];
            lastIx--;
        }

        //当arget > s + removed*arr[lastIx] 停止 表示lastIx这里可以进行切分
        //计算舍去的平均大小
        int v=(target-s)/removed; // rounded down
        //考虑哪种情况更好
        if(Math.abs(target-s-removed*v) <=
                Math.abs(target-s-removed*(v+1))) // check v+1 to compensate round down
            return v;
        return v+1;
    }*/


    //二分法 从1和max开始寻找  找到最优mid   二分的过程不是很好理解
    public int findBestValue(int[] arr, int target) {
        int l, r, mi, s=0, m=-1;
        for(int v:arr) { s += v; m=Math.max(m,v); }

        if(s<=target) return m; // return the maxSum value since we will keep all nums as is

        for(l=1,r=m;l<r;) {
            mi=(l+r)/2;
            s=0;
            for(int v:arr) s += (v>mi)?mi:v;
            if(s>=target) r=mi;
            else          l=mi+1;
        }
        // check if we are 1 step off the target
        //要检查两种情况
        int s1=0,s2=0;
        for(int v:arr) {
            s1 += (v>l)?(l):v;
            s2 += (v>l-1)?(l-1):v;
        }

        return (Math.abs(s2-target) <= Math.abs(s1-target)) ? l-1 : l;
    }

    public static void main(String[] args) {
      //  findBestValue(new int[]{40091,2502,74024,53101,60555,33732,23467,40560,32693,13013},78666);
    }

}
