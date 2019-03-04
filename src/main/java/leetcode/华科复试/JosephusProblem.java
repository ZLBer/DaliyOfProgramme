package leetcode.华科复试;

/**
 * Created by libin on 2019/3/3.
 */
public class JosephusProblem {
static void solution(int N,int C){

    int count=1;;
    int index=(C-1)%N;
    while(count<=N){
        System.out.print((index+1)+" ");
      count++;
      index=(index+C)%N;
    }
}

    public static void main(String[] args) {
        solution(10,3);
    }

}
