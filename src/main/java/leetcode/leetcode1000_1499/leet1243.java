package leetcode.leetcode1000_1499;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leet1243 {
    public List<Integer> transformArray(int[] arr) {
        int[] copy = new int[arr.length];
        while (true) {
            copy[0] = arr[0];
            copy[arr.length - 1] = arr[arr.length - 1];
            boolean flag = false;
            for (int i = 1; i < arr.length - 1; i++) {
                if (arr[i] < arr[i - 1] && arr[i] < arr[i + 1]) {
                    copy[i] = arr[i] + 1;
                    flag = true;
                } else if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                    copy[i] = arr[i] - 1;
                    flag = true;
                } else {
                    copy[i]=arr[i];
                }
            }
            if (!flag) {
                List<Integer> res = new ArrayList<>();
                for (int i = 0; i < copy.length; i++) {
                    res.add(copy[i]);
                }
                return res;
            }
            arr = Arrays.copyOf(copy,copy.length);
            copy = new int[arr.length];
        }
    }
}
