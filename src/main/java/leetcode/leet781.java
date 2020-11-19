package leetcode;

public class leet781 {

    //mine set
/*    public int numRabbits(int[] answers) {
    Map<Integer,Integer> map=new HashMap<>();
       int res=0;
        for (int i = 0; i < answers.length; i++) {
           int key=answers[i];
            if(answers[i]==0){
                res++;continue;
            }
           if(!map.containsKey(key)){
              map.put(key,key);
              res+=key+1;
           }else {
              if(map.get(key)==0){
                map.put(key,key);
                res+=key+1;
              }else {
                 map.put(key,map.get(key)-1);
              }
           }
        }
        return res;
    }*/

    //直接计数
    public int numRabbits(int[] answers) {
        int[] count = new int[1000];
        for (int x: answers) count[x]++;

        int ans = 0;
        for (int k = 0; k < 1000; ++k) {
            if (count[k] == 0) continue;
            if(count[k]<=(k+1)) ans+=k+1;
            else {
              int c=count[k]/(k+1);
              if(c*(k+1)==count[k]){
                 ans+=(c*(k+1));
              }else {
                  ans+=((c+1)*(k+1));
              }
            }

          //然后上面的所有逻辑可以化简成这一行
            //  ans += Math.floorMod(-count[k], k+1) + count[k];
        }
       return ans;
    }


    public static void main(String[] args) {
        System.out.println(Math.floorMod(-17,15));
    }

}
