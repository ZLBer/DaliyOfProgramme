package leetcode.leetcode1000_1499;

public class leet1093 {
    public static double[] sampleStats(int[] count) {
        double min=-1,max=0,mean=0,mode=0,median=0,sum=0;
        int total=0,maxIndex=0;
        for (int i = 0; i < count.length; i++) {
         total+=count[i];
         sum+=count[i]*i;
          if(count[i]>0) max=i;
          if(min==-1&&count[i]>0) min=i;
          if(maxIndex<count[i]) {
              maxIndex=count[i];
              mode=i;
          }
        }
        mean=(double) sum/total;
        //个数为奇数
        if(total%2==1){
            long middle=total/2+1;
            int tempCount=0;
            for (int i = 0; i < count.length; i++) {
                if(middle<=tempCount+count[i]){
                    median=i;
                    break;
                }
                tempCount+=count[i];
            }
        }
        //个数为偶数
        else {
   int m1=total/2;
   int m2=m1+1;
   double middle1=-1,middle2=-1;
   int tempCount=0;
            for (int i = 0; i < count.length; i++) {
                if(m1<=tempCount+count[i]&&middle1==-1){
                    middle1=i;
                }
                if(m2<=tempCount+count[i]){
                    middle2=i;
                    break;
                }
                tempCount+=count[i];
            }

            median=(middle1+middle2)/2;
        }

        return new double[]{min,max,mean,median,mode};
    }

  //求中位数的可以合并成一个来求，从而不用分情况
    //虽然速度上优势不大，但代码明显简洁了不少
   /* public double[] sampleStats(int[] count) {
        int total = 0, mode = 0;
        double median = 0, min = -1, max = 0, avg = 0, sum = 0;
        for (int i = 0; i < 256; ++i) {
            if (count[i] > 0) {
                total += count[i];
                if (min < 0) min = i;
                max = i;
                sum += i * count[i];
                if (count[i] > count[mode]) mode = i;
            }
        }
        avg = sum / total;
        if (total == 1) median = sum; // single element.
        int m1 = (total + 1) / 2, m2 = total / 2 + 1; // m1-th and m2-th items are medians.
        for (int i = 0, cnt = 0; total > 1 && i < 256; ++i) { // more than 1 elements.
            if (cnt < m1 && cnt + count[i] >= m1) // find m1-th item.
                median += i / 2.0d; // add its half.
            if (cnt < m2 && cnt + count[i] >= m2) // find m2-th item.
                median += i / 2.0d; // add its half.
            cnt += count[i];
        }
        return new double[]{min, max, avg, median, mode};
    }*/
    public static void main(String[] args) {
        sampleStats(new int[]{0,1,3,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
    }
}
