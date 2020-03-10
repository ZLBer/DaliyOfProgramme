package leetcode;

public class leet1365 {

    //mine list
/*    public int[] smallerNumbersThanCurrent(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int count=0;
            for (List<Integer> l : list) {
                if(l.get(0)>nums[i]){
                    l.set(1,l.get(1)+1);
                }else if(l.get(0)<nums[i]){
                     count++;
                }else continue;
            }
            list.add(Arrays.asList(nums[i],count));
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i]=list.get(i).get(1);
        }
        return nums;
    }*/
    //mine count数组
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] count = new int[501];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }
        int sum = 0;
        for (int i = 0; i < count.length; i++) {
            int temp = count[i];
            count[i] = sum;
            sum += temp;
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = count[nums[i]];
        }
        return nums;
    }
}
