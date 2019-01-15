package leetcode;

import java.util.*;

/**
 * Created by libin on 2019/1/14.
 */
public class leet811 {
    public List<String> subdomainVisits(String[] cpdomains) {

        List<String> result=new LinkedList<>();
        HashMap<String,Integer> map= new HashMap<>();
        for(String a:cpdomains){
            String[]tmp=a.split(" ");
            String[] tmpCom=tmp[1].split("\\.");
            int count=Integer.parseInt(tmp[0]);
            for(int i=0;i<tmpCom.length;i++){
                String sum=tmpCom[i];
                for(int j=i+1;j<tmpCom.length;j++)
                    sum+="."+tmpCom[j];

                map.put(sum,map.getOrDefault(sum,0)+count);
            }
        }
        for(java.util.Map.Entry<String,Integer> entry:map.entrySet()){
            result.add(entry.getValue()+" "+entry.getKey());
        }
        return result;
    }

/*    //与我的算法总体一致 ，但细节方面需要注意
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> counts = new HashMap();
        for (String domain: cpdomains) {
            String[] cpinfo = domain.split("\\s+");
            String[] frags = cpinfo[1].split("\\.");
            int count = Integer.valueOf(cpinfo[0]);
            String cur = "";
            //倒着遍历更加效率
            for (int i = frags.length - 1; i >= 0; --i) {
                cur = frags[i] + (i < frags.length - 1 ? "." : "") + cur;
                counts.put(cur, counts.getOrDefault(cur, 0) + count);
            }
        }

        List<String> ans = new ArrayList();
        for (String dom: counts.keySet())
            ans.add("" + counts.get(dom) + " " + dom);
        return ans;
    }

//另一个版本
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap();
        for (String cd : cpdomains) {
            int i = cd.indexOf(' ');
            //从0到i分割字符串，分出数字
            int n = Integer.valueOf(cd.substring(0, i));
            //分出字母
            String s = cd.substring(i + 1);
            //依次放入c从第一个.后面开始的domain
            for (i = 0; i < s.length(); ++i) {
                if (s.charAt(i) == '.') {
                    String d = s.substring(i + 1);
                    map.put(d, map.getOrDefault(d, 0) + n);
                }
            }
            //放入整个
            map.put(s, map.getOrDefault(s, 0) + n);
        }

        List<String> res = new ArrayList();
        for (String d : map.keySet()) res.add(map.get(d) + " " + d);
        return res;
    }*/
}
