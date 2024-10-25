class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        for (int i=left; i<= right; i++) {
            if (check(i)) answer += i;
            else answer -= i;
        }
        return answer;
    }
    
    public static boolean check(int x) {
        int cnt = 0;
        for (int i=1; i<=x; i++) {
            if (x % i == 0) {
                cnt++;
            }
        }
        
        if (cnt % 2 == 0) {
            return true;
        }
        else return false;
    }
}   