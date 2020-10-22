package leetcode;

public class leet1592 {

    //一个简单题写这么多  你这是有毒啊
    //当时太慌了   就一股脑往上写 各种条件各种判断  唉
/*    public String reorderSpaces(String text) {
     List<String> words=new ArrayList<>();
      int kong=0;
      StringBuilder sb=new StringBuilder();
       for (char c : text.toCharArray()) {
        if(c==' '){
            kong++;
          if(sb.length()!=0){
             words.add(sb.toString());
              sb=new StringBuilder();
          }
        }else {
           sb.append(c);
        }
       }
     if(sb.length()!=0) words.add(sb.toString());
        System.out.println(words.size());

     if(words.size()==1){
        String s="";
      for(int i=0;i<kong;i++){
        s+=" ";
      }
     return words.get(0)+s;
     }
     int per=kong/(words.size()-1);
       // System.out.println(per);
     String p="";
    for(int i=0;i<per;i++){
        p+=" ";
    }
    StringBuilder res=new StringBuilder();
    res.append(words.get(0));

        for (int i = 1; i < words.size(); i++) {
          res.append(p);
          res.append(words.get(i));
        }

      if(per*(words.size()-1)!=kong){
        for(int i=0;i<kong-per*(words.size()-1);i++)
           res.append(" ");
      }
return res.toString();
    }*/



    //人家就是比你写的好
    public String reorderSpaces(String text) {
        // trim去除头尾空格 在JDK11中加入了strip
        String[] splited = text.trim().split("\\s+");

        // 记录多少个单词
        int wordCnt = splited.length;
        // 记录单词总长
        int wordLen = 0;
        for(String word : splited) {
            wordLen += word.length();
        }
        // 空格数量
        int spaceCnt = text.length() - wordLen;
        StringBuilder sb = new StringBuilder();
        // 只用在前n-1个单词后面加空格
        for (int i = 0; i < splited.length - 1; i++) {
            sb.append(splited[i]);
            for (int j = 0; j < spaceCnt / (wordCnt - 1); j++) {
                sb.append(" ");
            }
        }
        // 最后一个单词直接加上去
        sb.append(splited[splited.length - 1]);
        // 补齐剩余的空格
        while (sb.length() < text.length()) {
            sb.append(" ");
        }
        return sb.toString();
    }

}
