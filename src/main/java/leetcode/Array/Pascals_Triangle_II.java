package leetcode.Array;

import java.util.Arrays;
import java.util.List;

/**
 * Created by libin on 2017/10/12.
 */
public class Pascals_Triangle_II {
    public List<Integer> getRow(int rowIndex) {
        Integer []row=new Integer[rowIndex+1];
        row[rowIndex]=1;
    for(int i=1;i<=rowIndex;i++){
        for(int j=rowIndex-i+1;j<rowIndex;j++){
            row[j]=row[j]+row[j+1];
        }
        row[rowIndex-i]=1;
        for(Integer c:row){
            System.out.print(c+" ");
        }
    }
return Arrays.asList(row);
    }
}
