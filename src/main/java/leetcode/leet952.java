package leetcode;

public class leet952 {
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

    long gcd(long a,long b) {
        while(b!=0)
        {
            long temp=a%b;
            a=b;
            b=temp;
        }
        return a;
    }

    //逆向找所有因数
   /* public int largestComponentSize(int[] A) {
       int m=0;
        for (int i : A) {
            m=Math.max(i,m);
        }
        UnionFind unionFind=new UnionFind(m+1);
        for (int i = 0; i < A.length; i++) {
           int up=(int)Math.sqrt(A[i]);
            for(int j=2;j<=up;j++){
                if(A[i]%j==0){
                   unionFind.union(A[i],j);
                   unionFind.union(A[i],A[i]/j);
                }
            }
        }
   int max=0;
     int []count=new int[m+1];
        for (int i = 0; i < A.length; i++) {
           int index=unionFind.find(A[i]);
            count[index]++;
           max=Math.max(count[index],max);
        } 
        return  max;
    }
*/

   //只找质因数
    public int largestComponentSize(int[] A) {
        int m=0;
        for (int i : A) {
            m=Math.max(i,m);
        }
        UnionFind unionFind=new UnionFind(m+1);
        for (int i = 0; i < A.length; i++) {
            int up=(int)Math.sqrt(A[i]);
            int x=A[i];
            int d=2;
            while (d*d<=x){
               //找到一个质因数
                if(x%d==0){
                    System.out.println(A[i]+" "+d);
                    unionFind.union(d,A[i]);
                    //把这个质因数剪掉
                   while (x%d==0){
                      x/=d;
                   }
               }
                d++;
            }
            if(x>1) unionFind.union(x,A[i]);
/*            for(int j=2;j<=up;j++){
                if(A[i]%j==0){
                    unionFind.union(A[i],j);
                    unionFind.union(A[i],A[i]/j);
                }
            }*/
        }
        int max=0;
        int []count=new int[m+1];
        for (int i = 0; i < A.length; i++) {
            int index=unionFind.find(A[i]);
            count[index]++;
            max=Math.max(count[index],max);
        }
        return  max;
    }




}
