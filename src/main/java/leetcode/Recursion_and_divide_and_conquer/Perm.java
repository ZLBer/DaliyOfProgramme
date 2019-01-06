package leetcode.Recursion_and_divide_and_conquer;

//集合的全排列
public class Perm {
	void Perm(int list[],int k,int m){
		if(k==m){
			for(int i=0;i<=m;i++){
				System.out.print(list[i]+" ");
			}
			System.out.println();
		}
		else {
			for(int j=k;j<=m;j++){
			change(list,k,j);
			Perm(list,k+1,m);
			change(list,k,j);
			}		
		}
	}
	public static void change(int a[],int i,int j){
		  int k=a[i];
		a[i]=a[j];
		a[j]=k;
	}
}
