import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        boolean flag = true;
        
        for (int i=0; i<s.length(); i++) {
            char cur = s.charAt(i);
            
            if (cur == ' ') {
                answer += cur;
                flag = true;
            }
            else { 
                if (flag) {
                    answer += Character.toUpperCase(cur);
                }
                else {
                    answer += Character.toLowerCase(cur);
                }
                flag = false;
            }
        }
        
        return answer;
    }
}