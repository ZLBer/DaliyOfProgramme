package leetcode.Recursion_and_divide_and_conquer;

//比赛日期分配
public class Table {
	
void table(int k,int a[][]){
	int i,r;
	int n=1<<k;
	for(i=0;i<n;i++){
		a[0][i]=i+1;
	}
	for(r=1;r<n;r<<=1){
		for(i=0;i<n;i+=2*r){
			Copy(r,r+i,0,i,r,a);
			Copy(r,i,0,r+i,r,a);
		}
	}
}
public static void Copy(int tox,int toy,int fromx,int fromy,int r,int a[][]){
	for(int i=0;i<r;i++)
		for(int j=0;j<r;j++)
			a[tox+i][toy+j]=a[fromx+i][fromy+j];
}
}
