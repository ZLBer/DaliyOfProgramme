package leetcode.leetcode1000_;

public class leet1234 {

    //mine 当时知道用滑动窗口 但是怎么就都写不好，改了好多次，耽误时间了
  /*  public int balancedString(String s) {
    int[]count=new int[4];
    for(char c:s.toCharArray()){
        if(c=='Q')
            count[0]++;
        else if(c=='W')
            count[1]++;
        else if(c=='E')
            count[2]++;
        else count[3]++;
    }

    int div=s.length()/4;
    Map<Character,Integer> map=new HashMap<>();
    int coutMore=0;
        for (int i = 0; i < count.length; i++) {
            count[i]-=div;
            if(count[i]>0)
                coutMore+=count[i];
        }
        if(coutMore==0) return 0;
        if(count[0]>0)
        map.put('Q',count[0]);
        if(count[1]>0)
        map.put('W',count[1]);
        if(count[2]>0)
        map.put('E',count[2]);
        if(count[3]>0)
        map.put('R',count[3]);

        //窗口滑动
       int left=0,right=0;
       char []arr=s.toCharArray();
       int min=Integer.MAX_VALUE;

        while (right<arr.length&&left<arr.length){
            if(map.containsKey(arr[right])){
                map.put(arr[right],map.get(arr[right])-1);
            }
              right++;
            boolean check=true;
            for(int a:map.values()){
              if(a>0) check=false;
            }
            while (check){
                min=Math.min(min,right-left+1);
                if(map.containsKey(arr[left]))
                    map.put(arr[left],map.get(arr[left])+1);

                for(int a:map.values()){
                    if(a>0) check=false;
                }
                left++;
            }

        }

       return min;
    }*/


//看一下别人的滑动窗口
/*    public int balancedString(String s) {

        //直接128个避免QWER映射
        int[] count = new int[128];
        char[] arr = s.toCharArray();

        // 1) count number of QWER chars
        for (char c: arr) {
            count[c]++;
        }

        int need = arr.length / 4;

        // Sliding window
        int left = 0;
        int right = 0;
        int min = arr.length; // min substring length
        while (right <= arr.length) {
            // Move right while any of char count in strin more than 'need'
            //如果窗口不满足条件，就一直向右滑动
            if (count['Q'] > need || count['W'] > need || count['E'] > need || count['R'] > need) {
                if (right >= arr.length)
                    break;
                char rightCh = arr[right];
                count[rightCh]--;
                right++;
                continue;
            }
            //计算最小窗口
            min = Math.min(min, right-left);
            if (min == 0)
                break;
            char leftCh = arr[left];
            count[leftCh]++;
            left++;
        }
        return min;
    }*/

   //又一种滑动窗口  每次移动右边,左边放在while里移动
    public int balancedString(String s) {
        int[] count = new int[128];
        int n = s.length(), res = n, i = 0;
        for (int j = 0; j < n; ++j) {
            ++count[s.charAt(j)];
        }
        int need = s.length() / 4;
        for (int j = 0; j < n; ++j) {
            --count[s.charAt(j)];
            while (i < n && count['Q'] <=need && count['W'] <= need&& count['E'] <= need && count['R'] <=need) {
                res = Math.min(res, j - i + 1);
                ++count[s.charAt(i++)];
            }
        }
        return res;
    }
}
