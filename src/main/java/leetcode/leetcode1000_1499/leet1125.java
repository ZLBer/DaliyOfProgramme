package leetcode.leetcode1000_1499;

import java.util.*;

public class leet1125 {



    //mine 显而易见，肯定会Time Limit Exceeded
/*    List<Integer> result = null;
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        helper(new ArrayList<>(), req_skills, new boolean[req_skills.length], 0, people, 0);
        int[] res = new int[result.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = result.get(i);
        }
        return res;
    }
    void helper(List<Integer> tempList, String[] req_skills, boolean[] isTake, int count, List<List<String>> people, int deep) {
        //剪枝操作
        if(result!=null&&tempList.size()>=result.size()) return;
        if (count == req_skills.length) {
            if (result == null || tempList.size() < result.size())
                result = new ArrayList<>(tempList);
            return;
        }
        if (deep >= people.size()) return;
        //不选择这个人
        helper(tempList, req_skills, isTake, count, people, deep + 1);
        Set aPeople = new HashSet(people.get(deep));
        List<Integer> callBack = new LinkedList<>();

        for (int i = 0; i < req_skills.length; i++) {
            if (isTake[i] == false && aPeople.contains(req_skills[i])) {
                count++;
                isTake[i] = true;
                callBack.add(i);
            }
        }
        tempList.add(deep);

        helper(tempList, req_skills, isTake, count, people, deep + 1);


        tempList.remove(tempList.size() - 1);
        for (int c : callBack) {
            isTake[c] = false;
        }


    }*/




    // 把技能当作深度 ，自然深度就降低了 ；而我用人当作深度，
    /*
1 <= req_skills.length <= 16
1 <= people.length <= 60
     */
    int teamSize;
    HashSet<Integer> resTeam;
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        teamSize = people.size()+1;
        //结果集
        resTeam = new HashSet();

        //<技能,人员编号>
        HashMap<String,List<Integer>> skillMap = new HashMap();
        for(int i=0; i<people.size(); i++){
            for(String skill : people.get(i)){
                if(!skillMap.containsKey(skill)){
                    skillMap.put(skill, new ArrayList<Integer>());
                }
                skillMap.get(skill).add(i);
            }
        }
        find(skillMap, req_skills, 0, new HashSet());

        //结果复制
        int[] res = new int[resTeam.size()];
        int index = 0;
        for(int person : resTeam){
            res[index++] = person;
        }
        return res;
    }


    public void find(HashMap<String,List<Integer>> skillMap, String[] req_skills, int cur, HashSet<Integer> team){
        //剪枝
        if(team.size()>teamSize) return;
        //当技能点满时 判断是否修改结果集
        if(cur==req_skills.length){
            if(team.size()<teamSize){
                teamSize = team.size();
                resTeam = new HashSet<Integer>();
                resTeam.addAll(team);
            }
            return;
        }

        for(int person : skillMap.get(req_skills[cur])){
            //判断是否这个人是新添加的
            boolean isRemove = !team.contains(person);
            team.add(person);
            find(skillMap, req_skills, cur+1, team);
            //新添加的就回退
            if(isRemove) team.remove(person);
        }
    }




 /*   public int[] smallestSufficientTeam(String[] skills, List<List<String>> people) {
        int sLen = skills.length, pLen = people.size();

        Map<String, Integer> skmap = new HashMap<>();
        for(int i = 0; i < sLen; i++)
            skmap.put(skills[i], i);

        Set<Integer>[] skillArr = new Set[1 << sLen];
        skillArr[0] = new HashSet<>();

        for(int ppl = 0; ppl < pLen; ppl++){
            int pplSkill = 0;
            for(String sks : people.get(ppl)){
                pplSkill |= 1 << (skmap.get(sks));
            }

            for(int k = 0; k < skillArr.length; k++){
                if(skillArr[k] == null) continue;
                Set<Integer> currSkills = skillArr[k];
                int combined = k | pplSkill;
                if(combined == k) continue;
                if(skillArr[combined] == null || skillArr[combined].size() > currSkills.size() + 1){
                    Set<Integer> cSkills = new HashSet<>(currSkills);
                    cSkills.add(ppl);
                    skillArr[combined] = cSkills;
                }
            }
        }

        Set<Integer> resSet = skillArr[(1 << sLen) - 1];
        int[] res = new int[resSet.size()];
        int pos = 0;
        for(Integer n : resSet)
            res[pos++] = n;

        return res;
    }*/
}
