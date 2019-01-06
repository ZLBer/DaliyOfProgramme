package leetcode.back_track_algorithm;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by libin on 2017/10/15.
 */
 class beibaowenti {
    int NUM=100;
int c;
int n;
int cw;
int cv;
int bestv;

    bags []Q=new bags[NUM];
    {
        Arrays.sort(Q,0,Q.length,new cmp2());
    }
void backtrack(int i){
    if(i+1>n){
        bestv=cv;
        return;
    }
    if(cw+Q[i].w<=c){
        cw+=Q[i].w;
        cv+=Q[i].v;
        backtrack(i+1);
        cw-=Q[i].w;
        cv-=Q[i].v;
    }
    if(Bound(i+1)>bestv) backtrack(i+1);
}
int Bound(int i){
    int cleft=c-cw;
    int b=cv;
    while(i<n&&Q[i].w<=cleft){
        cleft-=Q[i].w;
        b+=Q[i].v;
        i++;
    }
    if(i<n) b+=1.0*cleft*Q[i].v/Q[i].w;
    return b;
}

}

class bags{
    int w;
    int v;
    double d;
}

class cmp2 implements Comparator<bags> {
    /*
     * cmp因子
     * 此处为降序排列，所以<返回-1
     */
    public int compare(bags A, bags B) ///降序排序
    {
        if(A.d<B.d)
        {
            return 1;
        }
        else if(A.d==B.d)
        {
            return 0;
        }
        else
        {
            return -1;
        }

    }
}