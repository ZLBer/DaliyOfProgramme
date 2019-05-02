package leetcode;

public class leet686 {
    //mine
    public int repeatedStringMatch(String A, String B) {
    StringBuilder timsA=new StringBuilder(A);
        int count=1;
        int up=B.length()/A.length()+2;
        while (count<up&&!timsA.toString().contains(B)){
            timsA.append(A);
            count++;
        }
        if(timsA.toString().contains(B))
          return count;
  else return -1;
    }



    //和我的想法类似
  /*  public int repeatedStringMatch(String A, String B) {

        int count = 0;
        StringBuilder sb = new StringBuilder();
        while (sb.length() < B.length()) {
            sb.append(A);
            count++;
        }
        if(sb.toString().contains(B)) return count;
        if(sb.append(A).toString().contains(B)) return ++count;
        return -1;
    }*/



//    //逆向思维  删除串
//    public int repeatedStringMatch(String A, String B) {
//        int i = 0, count = 0;
//        //把B里的A都找出来
//        while (i < B.length()) {
//            int idx = B.indexOf(A, i);
//            if (idx == -1) break;
//            i = idx + A.length();
//            count++;
//        }
//        //替换为空串
//        B = B.replaceAll(A, ""); // remaining B if valid, should be smaller than A
//       //如果B非空 ，分情况讨论
//        if (!B.isEmpty()) {
//            if (A.startsWith(B)) count++; // B is substring AND first part of A
//            else if(A.contains(B)) return -1; // B is substring somewhere in between
//            else if ((A + A).contains(B)) count += 2; // B in rotating A
//            else return -1;
//        }
//        return count;
//    }

}
