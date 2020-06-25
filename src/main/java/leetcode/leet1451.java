package leetcode;

import java.util.Arrays;

public class leet1451 {
    //mine
    public String arrangeWords(String text) {
        String[] arr = text.split(" ");
        arr[0]=arr[0].toLowerCase();

        Arrays.sort(arr,(a,b)->a.length()-b.length());


        arr[0]=(arr[0].charAt(0)+"").toUpperCase()+arr[0].substring(1);
/*

        StringBuilder sb=new StringBuilder();

        for (int i = 0; i < arr.length-1; i++) {
            sb.append(arr[i]+" ");
        }
        sb.append(arr[arr.length-1]);
        return sb.toString();*/

        String join = String.join(" ", arr);
        return join;

    }
}
