package leetcode.leetcode1000_1499;


import java.util.*;

public class leet1338 {

    //mine 贪心  每次取最大
    public int minSetSize(int[] arr) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        PriorityQueue<int[]> priorityQueue=new PriorityQueue<>((int []a,int []b)->b[1]-a[1]);
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            priorityQueue.add(new int[]{entry.getKey(),entry.getValue()});
        }
        int sum=0;
        int res=0;
        while (sum<arr.length/2){
            res++;
            sum+=priorityQueue.poll()[1];
            System.out.println(sum);
        }
        return  res;
    }




    //空间换时间...
/*    public int minSetSize(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer>[] list = new ArrayList[arr.length + 1];

        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int num : map.keySet()) {
            int count = map.get(num);
            if (list[count] == null) {
                list[count] = new ArrayList<Integer>();
            }
            list[count].add(num);
        }

        int steps = 0, res = 0;
        for (int i = arr.length; i > 0; i--) {
            List<Integer> cur = list[i];
            if (cur == null || cur.size() == 0) continue;
            for (int num : cur) {
                steps += i;
                res++;
                if (steps >= arr.length / 2)
                    return res;
            }
        }
        return arr.length;
    }*/


    //再者可以这样  一点也不用复杂对象
/*    public int minSetSize(int[] arr) {
        int a[]=new int[100001];
        for(int i=0;i<arr.length;i++)
            a[arr[i]]++;
        int b[]=new int[100001];
        for(int i=0;i<a.length;i++)
            b[a[i]]++;
        int ans=0,tmp=0;
        for(int i=100000;i>=0;i--){
            if(b[i]!=0){
                tmp+=i;
                b[i]--;
                ans++;
                i++;
            }
            if(tmp>=arr.length/2)
                break;
        }
        return ans;
    }*/
}
