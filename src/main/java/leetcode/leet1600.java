package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class leet1600 {
    class ThroneInheritance {
Map<String ,List<String>> map=new HashMap<>();
Set<String> set=new HashSet<>();
String King="";
        public ThroneInheritance(String kingName) {
           map.put(kingName,new ArrayList<>());
           King=kingName;
        }

        public void birth(String parentName, String childName) {
       if(!map.containsKey(parentName)) map.put(parentName,new ArrayList<>());

       map.get(parentName).add(childName);
        }

        public void death(String name) {
      set.add(name);
        }

        List<String> res=new ArrayList<>();
        public List<String> getInheritanceOrder() {
    res=new ArrayList<>();
     Successor(King);
     return res;
        }

        void Successor(String parent){
          if(!set.contains(parent)){
             // System.out.println(parent);
              res.add(parent);
          }

          if(!map.containsKey(parent)||map.get(parent).size()==0)return;
          else {
              for (String s : map.get(parent)) {
                 Successor(s);
              }
          }
        }
    }
}
