import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int[] tmp = new int[people.length];
        
        Arrays.sort(people);
        
        for (int i=0; i<people.length; i++) {
            tmp[i] = people[people.length-i-1];
        }
        
        int lt = 0;
        int rt = tmp.length-1;
        
        answer = bs(lt,rt,limit,tmp);
        
        return answer;
    }
    
    public static int bs(int lt, int rt, int limit, int[] tmp) {
        int cnt = 0;
        while (lt <= rt) {
            int mid = tmp[lt] + tmp[rt];
            if (mid > limit) {
                cnt++;
                lt++;
            }
            else {
                cnt++;
                lt++;
                rt--;
            }
        }
        return cnt;
    }
}