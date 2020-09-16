package leetcode;

public class leet1576 {

    public String modifyString(String s) {
        char []arr=s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
         if(arr[i]!='?') continue;
            int left=i-1,right=i+1;
          char l=' ';
            if(left>=0) l=arr[left];
          char r=' ';
           if(right<arr.length) r=arr[right];

          char begin='a';
          for(int j=0;j<26;j++){
             char c=(char)(begin+j);
           if(c!=left&&c!=right){
              arr[i]=c;
              break;
           }
          }
        }
        return new String(arr);
    }
}
