class Solution {
    public String solution(String s) {
        String answer = "";
        int cur = s.length() / 2;
        
        if (s.length() % 2 != 0) {
            answer += s.charAt(cur);
        }
        else {
            answer += s.charAt(cur-1);
            answer += s.charAt(cur);
        }
        
        return answer;
    }
}