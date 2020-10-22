package leetcode;

public class aModular {

    //组合数 Cnm   m>n

     long combination(int m, int n) {
       int k=1;
       long ans=1;
       while (k<=n){
           ans=((m-k+1)*ans)/k;
           k++;
       }
       return ans;

    }


      long gcd(long a,long b) {
        while(b!=0)
        {
            long temp=a%b;
            a=b;
            b=temp;
        }
        return a;
    }

//    方法二：欧几里得算法 递推法(效率最高)

    private static long gcd2(long a,long b){
        return (a==0?b:gcd2(b%a,a));
    }


    public static void main(String[] args) {
    //    System.out.println(combination(5,2));
    }



    //并查集
    class UnionFind{
        public final int[] parents;
        public int count;

        public UnionFind(int n){
            this.parents = new int[n];
            reset();
        }

        public void reset(){
            for(int i =0;i<parents.length;i++){
                parents[i] = i;
            }
            count = parents.length-1;
        }

        public int find(int i){
            int parent = parents[i];
            if(parent == i){
                return i;
            }else{
                int root = find(parent);
                parents[i] = root;
                return root;
            }
        }

        public boolean union(int i, int j){
            int r1 = find(i);
            int r2 = find(j);
            if(r1 != r2){
                count--;
                parents[r1] = r2;
                return true;
            }else{
                return false;
            }
        }

    }

}
