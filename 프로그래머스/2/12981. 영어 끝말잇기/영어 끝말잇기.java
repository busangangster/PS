import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        int ans = 0;
        int turn = 1;
        HashSet<String> hs = new HashSet<String>();
            
        for (int i=0; i<words.length; i++) {
            if (i != 0 && words[i-1].charAt(words[i-1].length()-1) != words[i].charAt(0)) {
                if ((i+1) % n == 0) {
                    ans = n;
                }
                else {
                    ans = (i+1) % n;
                }
                break;
            }
            else if (hs.contains(words[i])) {   
                if ((i+1) % n == 0) {
                    ans = n;
                }
                else {
                    ans = (i+1) % n;
                }
                break;
            }
            else {
                hs.add(words[i]);
                if ((i+1) % n == 0) turn++;

            }
        }
        
        answer[0] = ans;
        if (ans == 0) {
            answer[1] =0;
        }
        else answer[1] = turn;
        
        return answer;
    }
}