package leetcode.Recursion_and_divide_and_conquer;

//整数分割
public class Split {
 int split(int n,int m){
	 if(n==1||m==1) return 1;
	 else if(n<m) return split(n,n);
	 else if(n==m) return split(n,n-1)+1;
	 else return split(n,m-1)+split(n-m,m);
 }
}
