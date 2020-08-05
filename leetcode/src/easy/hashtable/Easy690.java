package easy.hashtable;

import java.util.*;

public class Easy690 {
    static class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }

    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, Employee> map = new HashMap<>();
        for(Employee e:employees) {
            map.put(e.id, e);
        }
        Set<Integer> ids = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(id);
        int sum = 0;
        while (!stack.isEmpty()) {
            Integer eid = stack.pop();
            Employee em = map.get(eid);
            if (!ids.contains(em.id)) {
                sum += em.importance;
                ids.add(em.id);
            }
            for (Integer i:em.subordinates) {
                stack.push(i);
            }
        }
        return sum;
    }

}
