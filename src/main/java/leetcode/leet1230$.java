package leetcode;

public class leet1230$ {
    //TLE
/*    public double probabilityOfHeads(double[] prob, int target) {
        memo=new Double[prob.length+1][target+1];
        DFS(prob,0,0,target,1);
        return res;
    }
    double res=0;
    Double [][]memo;
    void  DFS(double[]prob,int deep,int front,int target,double chance){
        if(deep>=prob.length){
            if(front==target)
                res+=chance;
            return ;
        }
        //剪枝
        if(front>target||(prob.length-deep)<target-front) return;
        //正面
        double cha=chance*prob[deep];
        DFS(prob,deep+1,front+1,target,cha);
        //反面
        cha=chance*(1-prob[deep]);
        DFS(prob,deep+1,front,target,cha);
    }*/
    public double  probabilityOfHeads(double[] prob, int target) {
       memo=new Double[prob.length+1][target+1];
    return    DFS(prob,target,0);
    }

    Double [][]memo;
    double DFS(double[]prob,int target,int index){
         if(index>=prob.length&&target==0)
             return 1;
         if(index>=prob.length)
             return 0;
       if(memo[index][target]!=null) return memo[index][target];
         double res=0.0;
        if(target>0)
            res+=DFS(prob,target-1,index+1)*prob[index];
         res+=DFS(prob,target,index+1)*(1-prob[index]);

      memo[index][target]=res;
      return res;
    }

}
