package leetcode.leetcode500_999;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by libin on 2019/1/2.
 */
public class leet929 {
//    public int numUniqueEmails(String[] emails) {
//        Set <String>result=new HashSet();
//        for(String email:emails){
//            String []parts= email.split("@");
//               String []local=parts[0].split("\\+");
//               result.add(local[0].replace(".","")+ "@" + parts[1]);
//
//        }
//        return result.size();
//    }
static  public int numUniqueEmails(String[] emails) {

    Set<String> emailSet = new HashSet<>();

    for (String s : emails) {
        System.out.println(s.substring(s.indexOf('@')));
        emailSet.add(s.substring(s.indexOf('@')));
    }
    return emailSet.size();

}

    public static void main(String[] args) {
        numUniqueEmails(new String[]{"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"});
    }
}
