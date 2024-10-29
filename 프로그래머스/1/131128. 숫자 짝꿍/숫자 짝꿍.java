import java.util.*;
class Solution {
    public String solution(String X, String Y) {
        String answer = "";
        int[] checkX = new int[10];
        int[] checkY = new int[10];
        StringBuilder sb = new StringBuilder();

        for (char c : X.toCharArray()) {
            checkX[c -'0']++;
        }
        for (char c : Y.toCharArray()) {
            checkY[c -'0']++;
        }
        
        for (int i=9; i>=0; i--) {
            int minValue = Math.min(checkX[i], checkY[i]);
            for (int j=0; j<minValue; j++) {
                sb.append(i);
            }
        }
        
        if (sb.length() == 0) {
            answer = "-1";
        }
        else if (sb.charAt(0) == '0') {
            answer = "0";
        }
        else {
            answer = sb.toString();
        }
        
        
        return answer;
    }
}