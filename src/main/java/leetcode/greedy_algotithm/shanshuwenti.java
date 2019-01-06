package leetcode.greedy_algotithm;

public class shanshuwenti {
	void solution(String a,int k){
	if(k>=a.length()) return;
	else while(k>0){
		int i;
		for(i=0;(i<a.length()-1)&&(a.charAt(i)<=a.charAt(i+1));++i);
			a=erase(a,i);System.out.println(a);
			k--;
	}
	while(a.length()>1&&a.charAt(0)=='0')
		a=erase(a,0);
	System.out.println(a);
}
	String erase(String a,int i){
		if(i==0) return a.substring(1);
		else return	a.substring(0,i)+a.substring(i+1,a.length());
	}
	public static void main(String []args){
		shanshuwenti t=new shanshuwenti();
		t.solution("178543", 4);
	}
}
