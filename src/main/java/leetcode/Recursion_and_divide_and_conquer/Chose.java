package leetcode.Recursion_and_divide_and_conquer;

//选择问题
public class Chose {
	int a[]={1,2,3,4};
int select(int left,int right,int k){
	if(left>=right) return a[left];
	int i=left;
	int j=right+1;
	int  pivot=a[left];
	while(true){
		do{
			i=i+1;
		}while(a[i]<pivot);
		do{
			j=j-1;
		}while(a[j]>pivot);
		if(i>=j) break;
		change(a,i,j);
	}
	if(j-left+1==k) return pivot;
	a[left]=a[j];
	a[j]=pivot;
	if(j-left+1<k)
		return select(j+1,right,k-j+left-1);
	else return select(left,j-1,k);
}
public static void change(int a[],int i,int j){
	  int k=a[i];
	a[i]=a[j];
	a[j]=k;
}
public static void main(String args[]){
	Chose c=new Chose();
	System.out.println(c.select(0, 3, 2));
}
}
