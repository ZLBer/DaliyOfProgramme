package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class leet526 {


    //mine DFS
   /* int count=0;
    public int countArrangement(int N) {
      boolean [] isvisited=new boolean[N];
DFS(isvisited,1,N);
return count;
    }

    void DFS(boolean[]isvisited,int deep,int N){
        if(deep>N) {
            count++;
            return;
        }
        for (int i = 0; i < isvisited.length; i++) {
           if(!isvisited[i]&&((i+1)%deep==0||deep%(i+1)==0)){
                isvisited[i]=true;
                DFS(isvisited,deep+1,N);
                isvisited[i]=false;
           }
        }
    }*/


//缓存一些情况 相当于剪枝
  /*  public int countArrangement(int N) {
        char[] currState = new char[N + 1];
        Arrays.fill(currState, 'f');  // f means not selected, t means selected
        return helper(new HashMap<String, Integer>(), currState, 1);
    }

    public int helper(Map<String, Integer> map, char[] currState, int index) {
        if(index == currState.length) return 1;
        String key = String.valueOf(currState);
        if(map.containsKey(key)) return map.get(key);
        int count = 0;
        for(int i = 1; i < currState.length; i++) {
            if(currState[i] == 'f' && (i % index == 0 || index % i == 0)) {
                currState[i] = 't';
                count += helper(map, currState, index + 1);
                currState[i] = 'f';
            }
        }
        map.put(key, count);
        return count;
    }
*/


  //避免了很多没必要的for循环 相当于把合适的都往后放， 每次deep后 for循环的次数越来越少
    //同时从后往前deep 导致 一开始分支较少
    private int count = 0;
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    private void helper(int[] nums, int start) {
        if (start == 0) {
            count++;
            return;
        }
        for (int i = start; i > 0; i--) {
            swap(nums, start, i);
            if (nums[start] % start == 0 || start % nums[start] == 0) helper(nums, start-1);
            swap(nums,i, start);
        }
    }
    public int countArrangement(int N) {
        if (N == 0) return 0;
        int[] nums = new int[N+1];
        for (int i = 0; i <= N; i++) nums[i] = i;
        helper(nums, N);
        return count;
    }
}
