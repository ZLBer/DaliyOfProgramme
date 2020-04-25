package leetcode.leetcode1_499;

import java.util.ArrayList;
import java.util.List;

public class leet60 {
    //错误的解法 生成的排列不是有序的
 /*   public String getPermutation(int n, int k) {
       int []arr=new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=i+1;
        }
        helper(arr,0,k);
        return res;
    }

    int count=0;
    String res="";
    void helper(int []arr,int deep,int k){
        if(deep>=arr.length){
            count++;
            if(count==k){
                StringBuilder sb=new StringBuilder();
                for (int i = 0; i < arr.length; i++) {
                    sb.append(arr[i]);
                }
                res=sb.toString();
            System.out.println(sb);
           }
        return;
        }
        for(int i=deep;i<arr.length;i++){
         swap(arr,deep,i);
         helper(arr,deep+1,k);
         swap(arr,deep,i);
        }
    }
    void swap(int []arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
}*/


    //改一下  继续用dfs
    //只能一次次的遍历arr
/*    public String getPermutation(int n, int k) {
        boolean[]arr=new boolean[n];
        helper(arr,0,k,new StringBuilder());
        return res;
    }

    int count=0;
    String res="";
    void helper(boolean []arr,int deep,int k,StringBuilder sb){
       if(deep>=arr.length||count>k){
         count++;
         if(count==k){
             res=sb.toString();
         }
       return;
       }
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==true) continue;
            arr[i]=true;
            sb.append(i+1);
            helper(arr,deep+1,k,sb);
            arr[i]=false;
            sb.deleteCharAt(sb.length()-1);
        }
    }*/


   //强啊   根本不需要生成排列组合
    //https://leetcode.com/problems/permutation-sequence/discuss/22507/%22Explain-like-I'm-five%22-Java-Solution-in-O(n)
    public String getPermutation(int n, int k) {
        int pos = 0;
        List<Integer> numbers = new ArrayList<>();
        int[] factorial = new int[n+1];
        StringBuilder sb = new StringBuilder();

        // create an array of factorial lookup
        int sum = 1;
        factorial[0] = 1;
        for(int i=1; i<=n; i++){
            sum *= i;
            factorial[i] = sum;
        }
        // factorial[] = {1, 1, 2, 6, 24, ... n!}

        // create a list of numbers to get indices
        for(int i=1; i<=n; i++){
            numbers.add(i);
        }
        // numbers = {1, 2, 3, 4}

        //坐标是从0开始的
        k--;

        for(int i = 1; i <= n; i++){
           //查找index的位置
            int index = k/factorial[n-i];
            sb.append(numbers.get(index));
            //删除已经填进去的
            numbers.remove(index);
            //更新k
            k-=index*factorial[n-i];
        }

        return sb.toString();
    }

}
