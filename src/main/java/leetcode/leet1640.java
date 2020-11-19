package leetcode;

public class leet1640 {

    public boolean canFormArray(int[] arr, int[][] pieces) {
        boolean[] visie = new boolean[pieces.length];

        int i = 0;
        while (i < arr.length) {
            int t=i;
            for (int j = 0; j < pieces.length; j++) {
                if (visie[j]) continue;
               if(check(pieces[j],i,arr)){
                   visie[j]=true;
                   i+=pieces[j].length;
               }
            }
            if(i==t) return false;
        }
        return true;

    }

    boolean check(int []piece,int i,int[] arr){
        for (int j = 0; j < piece.length; j++) {
            if(arr[i++]==piece[j])continue;
            else {
                return false;
            }
        }
        return true;
    }






    public static void main(String[] args) {

    }
}
