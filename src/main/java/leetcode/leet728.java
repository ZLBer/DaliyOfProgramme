package leetcode;

import org.omg.PortableServer.LIFESPAN_POLICY_ID;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by libin on 2019/1/14.
 */
public class leet728 {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result=new LinkedList<>();
        for(int i=left;i<=right;i++){
            int number=i;
            while (number!=0) {
                int ws = number % 10;   //计算各个位
                if (ws==0||i % ws != 0) break;
                number = number / 10;
            }
            if(number==0 ) result.add(i);
        }
        return result;
    }
}
