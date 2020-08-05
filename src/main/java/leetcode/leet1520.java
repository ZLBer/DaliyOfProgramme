package leetcode;

public class leet1520 {

    //mine contest的时候最终还是没做出来 ，就差那么一点点
   /* public List<String> maxNumOfSubstrings(String s) {
   Map<Character,int[]> map=new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
           char c=s.charAt(i);
         if(!map.containsKey(c)){
             map.put(c,new int[]{i,-1}); //结尾位置
         }else {
             map.get(c)[1]=i;//更新结尾
         }
        }
        PriorityQueue<int []> priorityQueue=new PriorityQueue<>((a,b)->(a[1]-a[0])-(b[1]-b[0]));
        for (Map.Entry<Character, int[]> characterEntry : map.entrySet()) {
           int left=characterEntry.getValue()[0],right=characterEntry.getValue()[1];
           if(right==-1) {
               priorityQueue.add(new int[]{left,left});
               continue;
           }
           boolean flag=true;

           for(int i=left+1;i<right;i++){
              int [] test=map.get(s.charAt(i));
             if(test[0]<left) {
                 flag=false;
                 break;
             }
             right=Math.max(test[1],right);
           }


           if(flag)
              priorityQueue.add(new int[]{left,right});

        }
//        for (int[] ints : priorityQueue) {
//            System.out.println(ints[0]+" "+ints[1]);
//        }
        if(priorityQueue.isEmpty()) return new ArrayList<>(Arrays.asList(s));
        List<String> res=new ArrayList<>();
        List<int[]>list=new ArrayList<>();
        list.add(new int[]{priorityQueue.peek()[0],priorityQueue.peek()[1]});
        res.add(s.substring(priorityQueue.peek()[0],priorityQueue.peek()[1]+1));
//        System.out.println(priorityQueue.peek()[0]);
        while (!priorityQueue.isEmpty()){
         int []arr=priorityQueue.poll();
          boolean flag=true;
            for (int[] ints : list) {
                if(arr[0]>ints[1]||arr[1]<ints[0]) continue;
                else {
                    flag=false;
                    break;
                }
            }
            if(flag) {
                res.add(s.substring(arr[0],arr[1]+1));
                list.add(new int[]{arr[0],arr[0]});
            }
      }
        return res;
    }*/



// 别人的 真是比自己又臭又长的解法好多了
    //本质是贪心
/*    int checkSubstr(String s, int i, int l[], int r[]) {
        int right = r[s.charAt(i) - 'a'];
        for (int j = i; j <= right; ++j) {
            if (l[s.charAt(j) - 'a'] < i)   //有交叉，前面的包含了后面的字母
                return -1;
            right = Math.max(right, r[s.charAt(j) - 'a']);
        }
        return right;
    }
    public List<String> maxNumOfSubstrings(String s) {

        //上面就是统计字母的左右边界
        int l[] = new int[26], r[] = new int[26];
        Arrays.fill(l, s.length());
        var res = new ArrayList<String>();
        for (int i = 0; i < s.length(); ++i) {
            var ch = s.charAt(i) - 'a';
            l[ch] = Math.min(l[ch], i);
            r[ch] = Math.max(r[ch], i);
        }
        int right = s.length();
        for (int i = 0; i < s.length(); ++i)
            if (i == l[s.charAt(i) - 'a']) { //到达一个字母的左边界
                int new_right = checkSubstr(s, i, l, r);
                if (new_right != -1) {
                    if (i > right || res.isEmpty()) //i<right 就说明有更小的子串，可以进行替换 ，小的总要比大的要多啊，以此来进行贪心；题目中还说字串总长度要尽量小
                        res.add("");
                    right = new_right;
                    res.set(res.size() - 1, s.substring(i, right + 1));
                }
            }
        return res;
    }*/
}
