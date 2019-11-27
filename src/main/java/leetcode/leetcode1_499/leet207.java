package leetcode.leetcode1_499;

import java.util.*;

public class leet207 {

    //mine 拓扑排序  一次过！nice
    public boolean canFinish(int numCourses, int[][] prerequisites) {

       Map<Integer, List<Integer>> map=new HashMap<>();
       int[]count=new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
          int from=  prerequisites[i][1];
          int to=prerequisites[i][0];
          count[to]++;
          if(map.containsKey(from)){
              map.get(from).add(to);
          }else {
              List<Integer> list=new ArrayList<>();
              list.add(to);
              map.put(from,list);
          }
        }

       Queue<Integer> queue=new LinkedList<>();
        for (int i = 0; i < count.length; i++) {
            if(count[i]==0) queue.offer(i);
        }
        while (!queue.isEmpty()){
           int from=queue.poll();
            List<Integer> list=map.get(from);
            if(list==null) continue;
            for (int i = 0; i < list.size(); i++) {
                count[list.get(i)]--;
                if (count[list.get(i)]==0) queue.offer(list.get(i));
                }
            }


        for (int i = 0; i < count.length; i++) {
            if(count[i]!=0) return false;
        }
        return true;
        }

//用数组来存的路径  count记录点数
  /*  public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] matrix = new int[numCourses][numCourses]; // i -> j
        int[] indegree = new int[numCourses];

        for (int i=0; i<prerequisites.length; i++) {
            int ready = prerequisites[i][0];
            int pre = prerequisites[i][1];
            if (matrix[pre][ready] == 0)
                indegree[ready]++; //duplicate case
            matrix[pre][ready] = 1;
        }

        int count = 0;
        Queue<Integer> queue = new LinkedList();
        for (int i=0; i<indegree.length; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }
        while (!queue.isEmpty()) {
            int course = queue.poll();
            count++;
            for (int i=0; i<numCourses; i++) {
                if (matrix[course][i] != 0) {
                    if (--indegree[i] == 0)
                        queue.offer(i);
                }
            }
        }
        return count == numCourses;
    }




      //DFS  不简单啊  需要考虑吧两种状态
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            if(numCourses == 0 || prerequisites == null || prerequisites.length == 0) return true; //??

            // create the array lists to represent the courses
            List<List<Integer>> courses = new ArrayList<List<Integer>>(numCourses);
            for(int i=0; i<numCourses; i++) {
                courses.add(new ArrayList<Integer>());
            }

            // create the dependency graph
            for(int i=0; i<prerequisites.length; i++) {
                courses.get(prerequisites[i][1]).add(prerequisites[i][0]);
            }

            int[] visited = new int[numCourses];

            // dfs visit each course
            for(int i=0; i<numCourses; i++) {
                if (!dfs(i,courses, visited)) return false;
            }

            return true;
        }

        private boolean dfs(int course, List<List<Integer>> courses, int[] visited) {

        //1表示这个分支正在进行访问
            visited[course] = 1; // mark it being visited

            List<Integer> eligibleCourses = courses.get(course); // get its children
            // 访问孩子节点
            for(int i=0; i<eligibleCourses.size(); i++) {
                int eligibleCourse = eligibleCourses.get(i).intValue();

                //表示出现了环
                if(visited[eligibleCourse] == 1) return false; // has been visited while visiting its children - cycle !!!!
                //未访问
                if(visited[eligibleCourse]  == 0) { // not visited
                    if (!dfs(eligibleCourse,courses, visited)) return false;
                }
            }

            //表示这个分支已经访问完成
            visited[course] = 2; // mark it done visiting
            return true;

        }*/
    }

