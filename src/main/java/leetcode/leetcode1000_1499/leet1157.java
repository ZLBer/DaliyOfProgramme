package leetcode.leetcode1000_1499;

public class leet1157 {
 //不出意外  Time Limit Exceeded
    /*class MajorityChecker {
       private  int arr[];
        public MajorityChecker(int[] arr) {
         this.arr=arr;
        }
        public int query(int left, int right, int threshold) {
            Map<Integer,Integer> map=new HashMap<>();
            int maxC=0,maxN=arr[left];
            for(int i=left;i<=right;i++){
                int count=map.getOrDefault(arr[i],0);
                map.put(arr[i],count+1);
                if(count+1>maxC){
                    maxC=count+1;
                    maxN=arr[i];
                }
           }
            if(maxC>=threshold) return maxN;
            else return -1;
        }
    }*/

    class MajorityChecker {

        private  int arr[];
        public MajorityChecker(int[] arr) {
            this.arr=arr;
        }
      //  moore's voting
        public int query(int left, int right, int threshold) {
         int vote=-1,count=0;
         for(int i=left;i<=right;i++){
              if(count==0){
                  vote=arr[i];
              }
              if(arr[i]==vote){
                  count++;
              }else {
                  count--;
              }
         }

         //验证这个是不是
         count=0;
            for(int i=left;i<=right;i++){
                if(arr[i]==vote)
                    count++;
            }
            return count>=threshold?vote:-1;
        }
    }
}
