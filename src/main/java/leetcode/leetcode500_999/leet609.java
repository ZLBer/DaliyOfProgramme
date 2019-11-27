package leetcode.leetcode500_999;

import java.util.*;

public class leet609 {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String,List<String>> map=new HashMap<>();
        for (int i = 0; i < paths.length; i++) {
                  String []files= paths[i].split(" ");
                  for(int j=1;j<files.length;j++){
                      int index=files[j].indexOf('(');
                      String key=files[j].substring(index);
                      String value=files[0]+"/"+files[j].substring(0,index);
//                     List<String> list= map.computeIfAbsent(key,(k)->new ArrayList<String>());
////                     list.add(value);
                      //比上面的快一倍的时间
                      List<String> list= map.getOrDefault(key,new ArrayList<String>());
                      list.add(value);
                     map.put(key,list);
                  }
        }
       List<List<String>> result=new LinkedList<>();
        for(List<String> list:map.values()){
            if(list.size()!=1)
             result.add(list);
        }
        return result;
    }

}
