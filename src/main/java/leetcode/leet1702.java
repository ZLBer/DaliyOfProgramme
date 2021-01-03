package leetcode;

public class leet1702 {
    public String maximumBinaryString(String binary) {
        int begin = 0;
        int one = 0;
        char[] arr = binary.toCharArray();
        for (int i = 0; i < binary.length(); i++) {
            if (i == begin && arr[i] == '1') {
                begin++;
            } else if (arr[i] == '1') {
                one++;
            }
        }
      if(begin>=arr.length) return binary;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = '1';
        }
        arr[arr.length - one - 1] = '0';
        return new String(arr);
    }
}
