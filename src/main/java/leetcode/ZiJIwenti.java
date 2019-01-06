package leetcode;

/**
 * Created by libin on 2017/9/1.
 */
public class ZiJIwenti {
    void ZiJi(String a[]){
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a.length;j++){
                for(int k=i;k<=j;k++){
                    System.out.print(a[k]+" ");
                }
                System.out.println();
            }
        }
        System.out.println("¿Õ¼¯");
    }
}
