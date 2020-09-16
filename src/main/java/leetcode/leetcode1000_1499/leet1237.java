package leetcode.leetcode1000_1499;

public class leet1237 {
  /*  public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
       List<List<Integer>> result=new ArrayList<>();
       for(int i=1;i<=1000;i++){
           for(int j=1;j<=1000;j++){
               if(customfunction.f(i,j)==z){
                   result.add(Arrays.asList(i,j));
               }
           }
       }
       return result;
    }
    //看清题目说的是单调递增  固定x,利用单调性二分搜索
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> result=new ArrayList<>();

        for(int i=1;i<=1000;i++){
            int left=1,right=1000;

            while (left<=right){
                int middle=(left+right)/2;
                int value=customfunction.f(i,middle);
                if(value==z){
                    result.add(Arrays.asList(i,middle));
                    break;
                }
                if(value>z){
                    right=middle-1;
                }
                else {
                    left=middle+1;
                }
            }
        }

return result;
    }

//优化的二分搜索，基于单调递增的特性
    public List<List<Integer>> findSolution(CustomFunction customFunction, int z) {
        List<List<Integer>> ans = new ArrayList<>();
        int left = 1, right = 1001;
        for (int x = 1; x < 1001; ++x) {
            int l = left, r = right;
            //二分查找最近点  和平时用的二分有点小区别
            while (l < r) {
                int y = (l + r) / 2;
                if (customFunction.f(x, y) < z) {
                    l = y + 1;
                }else {
                    r = y;
                }
            }
            int val = customFunction.f(x, l);
            //如果>=z,下一次循环x+1，y必定小于l
            //也就是说随着x的增加y是逐渐减小的，搜索的范围也减小
            if (val >= z) {
                if (val == z) ans.add(Arrays.asList(x, l));
                right = l;
            }else {
                left = l;
            }
        }
        return ans;
    }


    //交叉双指针
    public List<List<Integer>> findSolution(CustomFunction customFunction, int z) {
        List<List<Integer>> ans = new ArrayList<>();
        int x = 1, y = 1000;
        //这个条件很重要
        while (x < 1001 && y > 0) {
            int val = customFunction.f(x, y);
            if (val < z) {
                ++x;
            }else if (val > z) {
                --y;
            }else {
                ans.add(Arrays.asList(x++, y--));
            }
        }
        return ans;
    }*/

}
