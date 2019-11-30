package leetcode;

public class leet6 {


    //min 算是找规律吧
    public String convert(String s, int numRows) {
        if(numRows==1) return s;
        int length=s.length();
      int groupNum=numRows+(numRows-2);
      int group=(s.length()/groupNum);
      if(group*groupNum!=s.length()) group++;
      StringBuilder sb=new StringBuilder();
      for(int i=0;i<numRows;i++){
          //一个
        if(i==0||i==groupNum/2) {
            for (int j = 0; j < group; j++) {
                if(j * groupNum+i<length)  sb.append(s.charAt(j * groupNum+i));
            }
        }
        //两个
        else {
            for (int j = 0; j < group; j++) {
                if(j * groupNum+i<length) sb.append(s.charAt(j * groupNum+i));
                if(j * groupNum+groupNum-i<length) sb.append(s.charAt(j * groupNum+groupNum-i));
            }
        }
      }
      return sb.toString();
    }
}
