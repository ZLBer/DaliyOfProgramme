package leetcode;

public class leet670 {
 /*   public int maximumSwap(int num) {
    char[] arr=(num+"").toCharArray();
        for (int i = 0; i < arr.length; i++) {
            int max=i;
            for (int j = arr.length-1; j >= i+1; j--) {
             if(arr[j]>arr[i]&&arr[j]>arr[max]){
              max=j;
              }
            }
           if(max!=i){
               System.out.println(i+"  "+max);
            swap(i,max,arr);
            return Integer.parseInt(new String(arr));
           }
        }
        return num;
    }

    void swap(int i,int j,char[]arr){
        char temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
*/

    //优化下 o(n)了为啥还不快
    public int maximumSwap(int num) {
        char[] arr=(num+"").toCharArray();
        int res=num;
        int max=arr.length-1;
        for (int i = arr.length-1; i >=0; i++) {

         if(arr[i]<arr[max]){
          swap(i,max,arr);
          res=Integer.parseInt(new String(arr));
          swap(i,max,arr);
         }

         if(arr[i]>arr[max]){
             max=i;
         }


        }
        return res;
    }

    void swap(int i,int j,char[]arr){
        char temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
