package leetcode.leetcode500_999;

import leetcode.Employee;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by libin on 2019/2/15.
 */
public class leet690$ {

    //递归法
    /*public int getImportance(List<Employee> employees, int id) {
        List<Integer> subordinates = new LinkedList<>();
        int result = 0;
        for (Employee e : employees) {
            if (e.id == id) {
                subordinates = e.subordinates;
                result += e.importance;
                break;
            }
        }
        if (subordinates.size() == 0) return result;
        for (int i : subordinates) result += getImportance(employees, i);
        return result;
    }*/

   //用流递归
    int total = 0;
    public int getImportance(List<Employee> employees, int id) {
        Employee manager = employees.stream().filter(e -> e.id == id).collect(Collectors.toList()).get(0);
        total += manager.importance;
        manager.subordinates.forEach(subId -> getImportance(employees, subId));
        return total;
    }
}
