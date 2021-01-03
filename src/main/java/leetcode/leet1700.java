package leetcode;

public class leet1700 {


    //mine 模拟
/*    public int countStudents(int[] students, int[] sandwiches) {
       Queue<Integer> queue=new LinkedList<>();
       int pre=0;
        for (int student : students) {
            queue.add(student);
        }
       for (int i = 0; i < sandwiches.length;){
          int size=queue.size();
          while (size-->0){
            int a=queue.poll();
           if(a==sandwiches[i]){
               i++;
           }else {
              queue.add(a);
           }
          }
        if(pre==i) return queue.size();
        pre=i;
        }
       return 0;
    }*/

   //计算
    public int countStudents(int[] students, int[] sandwiches) {
        int[] cnt = new int[2];
        for (int student : students) cnt[student]++;
        for (int sandwich : sandwiches) {
            if (cnt[sandwich] > 0) cnt[sandwich]--;
            else break;
        }
        return cnt[0] + cnt[1];
    }
}
