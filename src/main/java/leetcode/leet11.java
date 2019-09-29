package leetcode;

public class leet11 {


    //mine 这样居然也过了
/*    public int maxArea(int[] height) {
        int maxWater=0;
        for(int i=0;i<height.length;i++){
            for(int j=i+1;j<height.length;j++){
                   maxWater=Math.max(Math.min(height[i],height[j])*(j-i),maxWater);
            }
        }
        return maxWater;
    }*/

    //用数学的方法证明

    //若左边短，则左边++，a0->a1 ,难道没可能a0和右边某个是最大的吗？确实没可能，假设右边为a10，a0<a10,若存在，只可能比（a0，a10）的面积小，因为只能按小的来算，只有抛弃a0继续向右搜索才能无限可能
    public int maxArea(int[] height) {
      int maxWater=0;
      int left=0,right=height.length-1;
      while (left<right){
          maxWater=Math.max(Math.min(height[left],height[right])*(right-left),maxWater);
      if(height[left]>height[right]){
          right--;
      }
      else left++;

      }
      return maxWater;
    }
}
