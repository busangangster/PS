import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        HashMap<Character,Integer> hm = new HashMap<Character,Integer>();
        
        for (int i=1; i<=skill.length(); i++) {
            hm.put(skill.charAt(i-1),i);            
        }
        
        for (int i=0; i<skill_trees.length; i++) {
            boolean flag = true;
            int cur = 0;
            String res = skill_trees[i];
            for (int j=0; j<res.length(); j++) {
                Character tmp = res.charAt(j);
                if (hm.containsKey(tmp)) {
                    if (cur == hm.get(tmp)-1) {
                        cur = hm.get(tmp);
                    }
                    else {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) {
                answer++;
            }
        }
        return answer;
    }
}