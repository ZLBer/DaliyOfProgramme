package leetcode;

public class leet1497 {

    //mine
 /*   public boolean canArrange(int[] arr, int k) {
     int []count=new int[k];
        for (int i : arr) {
            int num=i%k;
            if(num>=0)
            count[num]++;
            else {
             count[k+num]++;
            }
        }

        if(count[0]%2!=0) return false;
     if(k%2==0){
         for (int i = 1; i < count.length/2; i++) {
             if(count[i]!=count[k-i]) return false;
         }
         if(count[k/2]%2!=0) return false;
     }else {

         for (int i = 1; i <= count.length/2; i++) {
            if(count[i]!=count[k-i]) return false;
         }
     }
     return true;
    }*/


    //和我的想法一样  但简洁
    public boolean canArrange(int[] arr, int k) {
        int[] reminderFreq = new int[k];
        for(int a : arr) {
            int rmd = a % k;
            if(rmd < 0) {
                rmd += k;
            }
            reminderFreq[rmd]++;
        }

        for(int i = 1; i <= k/2; i++) {
            if(reminderFreq[i] != reminderFreq[k - i])
                return false;
        }

        return reminderFreq[0] % 2 == 0;
    }

    public static void main(String[] args) {
        System.out.println(-3%2);
    }
}
