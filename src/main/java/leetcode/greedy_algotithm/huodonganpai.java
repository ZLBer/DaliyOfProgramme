package leetcode.greedy_algotithm;

import java.util.Arrays;
import java.util.Comparator;

class action {
	 int s;
	int f;
	int index;
   action(){}
	action(int s,int f,int index){
		this.s=s;
		this.f=f;
		this.index=index;
	}
}

public class huodonganpai {
	
     action []as=new action[]{new action(),new action()};
     action a=new action();


void greedtSelector(int n,action []a,boolean b[]){
	Arrays.sort(a,new cmp1());
	b[1]=true;
	int preEnd=1;
	for(int i=2;i<=n;i++){
		if(a[i].s>=a[preEnd].f){
			b[i]=true;
			preEnd=i;
		}

	}

}
     
}

class cmp1 implements Comparator<action> {
	/*
     * cmp因子
     * 此处为降序排列，所以<返回-1
     */
	public int compare(action A, action B) ///降序排序
	{
		if(A.f>B.f)
		{
			return 1;
		}
		else if(A.f==B.f)
		{
			return 0;
		}
		else
		{
			return -1;
		}

	}
}