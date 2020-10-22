package leetcode.tianchi;


public class tianchi0926 {
/*    public String getString(int n) {
      String s="0";
      while (--n>0){
       StringBuilder temp=new StringBuilder();

       for (int i = 0; i < s.toCharArray().length; i++) {
        if(i%2==0) temp.append("0");
        else temp.append("1");
        temp.append(s.charAt(i));
          }
      if(s.length()%2==1) temp.append("1");
      else temp.append("0");

      s=temp.toString();
      }

      return s;
    }*/
public String getString(int n) {
    findProccess(1,n,true);
    return res;
}
    String res="";
    public  void findProccess(int i,int n,boolean down){
        if(i>n) return ;
        findProccess(i+1,n,true);
        if(down) res+="0";
        else res+="1";
        findProccess(i+1,n,false);
    }


    /*public List<String> stringPermutation(String str) {
        // write your code here

     char []strs=str.toCharArray();
  dfs(strs,new boolean[strs.length],new ArrayList<>());
        Collections.sort(res);
  return res;
    }



   List<String> res=new ArrayList<>();
  void dfs(char []strs, boolean[]visited, List<Character> list){
      if(list.size()==strs.length){
         StringBuilder sb=new StringBuilder();
          for (char aChar : list) {
              sb.append(aChar);
          }
         res.add(sb.toString());
          return;
      }

      for (int i = 0; i < strs.length; i++) {
          if(!visited[i]){

              if(i>0&&strs[i]==strs[i-1]&&!visited[i-1]){
                 continue;
              }
              visited[i]=true;
              list.add(strs[i]);
              dfs(strs,visited,list);
              list.remove(list.size()-1) ;
              visited[i]=false;
          }
      }
  }*/
}
