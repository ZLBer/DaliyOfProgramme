package leetcode;

public class leet1361 {
    //mine  层序遍历  可能不太对  要是root不是0
/*    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        Queue<Integer>queue=new LinkedList<>();
        queue.add(0);
        int count=0;
        while (!queue.isEmpty()){
          int index=queue.poll();
          count++;
          if(leftChild[index]==-2||rightChild[index]==-2) return false;
          if(leftChild[index]!=-1){
              queue.add(leftChild[index]);
              leftChild[index]=-2;
          }
          if(rightChild[index]!=-1){
            queue.add(rightChild[index]);
            rightChild[index]=-2;
          }
        }
        if(count==n) return true;
        else return false;
    }*/



    //unionFind 并查集
    int []un;
    int find(int a){
        if(un[a]!=a) return find(un[a]);
        return a;
    }
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        un=new int[n];
        for (int i = 0; i < un.length; i++) {
            un[i] = i;
        }
        for(int i=0;i<n;i++){
          if(leftChild[i]!=-1&&!helper(i,leftChild[i])) return false;
          if(rightChild[i]!=-1&&!helper(i,rightChild[i])) return false;
        }

        int count=0;
        for (int i = 0; i < un.length; i++) {
            if(un[i]==i) count++;
        }
        return count==1;
    }

    boolean  helper(int parent,int child){
          int up=find(parent),uc=find(child);
          if(up==uc) return false; //解决环问题
          if(uc!=child) return false; //已经有树枝进入
          un[child]=up;
          return true;
    }
    }
