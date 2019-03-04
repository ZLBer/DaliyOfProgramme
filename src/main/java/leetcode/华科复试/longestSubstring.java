package leetcode.华科复试;

/**
 * Created by libin on 2019/3/2.
 */
public class longestSubstring {
//mine
static String solution(String a,String b){
   a= a.replace(" ","");
   b= b.replace(" ","");
    int max=0;
    int begin=0;
    int  end=0;
   int [] column=new int[a.length()];
for (int i=0;i<a.length();i++){
    if(b.charAt(0)==a.charAt(i)) column[i]=1;
}
//    for(int c=0;c<column.length;c++)
//        System.out.print(column[c] + " ");
//    System.out.println();
for(int i=1;i<b.length();i++){
    for(int j=a.length()-1;j>=0;j--){
        if(b.charAt(i)==a.charAt(j)) {
          if(j==0)
              column[j]=1;
          else column[j]=column[j-1]+1;
        }

        else column[j]=0;
        if(column[j]>max) {
            max=column[j];
            begin=j-max+1;
            end=j+1;
        }
    }
//    for(int c=0;c<column.length;c++)
//        System.out.print(column[c] + " ");
//        System.out.println();

}

    return a.substring(begin,end);
}


//灰灰版本
    public static String maxSubstring(String strOne, String strTwo){
// 参数检查
        if(strOne==null || strTwo == null){
            return null;
        }
        if(strOne.equals("") || strTwo.equals("")){
            return null;
        }
// 矩阵的横向长度
        int len1 = strOne.length();
// 矩阵的纵向长度
        int len2 = strTwo.length();
// 保存矩阵的上一行
        int[] topLine = new int[len1];
// 保存矩阵的当前行
        int[] currentLine = new int[len1];
// 矩阵元素中的最大值
        int maxLen = 0;
        int pos = 0;
        char ch = ' ';
        for(int i=0; i<len2; i++){
            ch = strTwo.charAt(i);
// 遍历 str1，填充当前行的数组
            for(int j=0; j<len1; j++){
                if( ch == strOne.charAt(j)){
// 如果当前处理的是矩阵的第一列，单独处理，因为其坐上角的元素不存在
                    if(j==0){
                        currentLine[j] = 1;
                    } else{
                        currentLine[j] = topLine[j-1] + 1;
                    }
                    if(currentLine[j] > maxLen){
                        maxLen = currentLine[j];
                        pos = j;
                    }
                }
            }
// 将矩阵的当前行元素赋值给 topLine 数组; 并清空 currentLine 数组
            for(int k=0; k<len1; k++){
                System.out.print(currentLine[k]+"  ");
                topLine[k] = currentLine[k];
                currentLine[k] = 0;
            }
            System.out.println();
// 或者采用下面的方法
// topLine = currentLine;
// currentLine = new int[len1];
        }
        return strOne.substring(pos-maxLen+1, pos+1);
    }

    public static void main(String[] args) {
        System.out.println(solution("What is your name？","What My name is"));
        System.out.println(maxSubstring("What is your name？","What My name is"));
    }
}
