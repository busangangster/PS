import java.util.*;

class Solution{
    public int solution(String s) {
        int answer = 0;
        Stack<Character> stack = new Stack<Character>();
        
        for (int i=0; i<s.length(); i++) {
            Character tmp = s.charAt(i);
            if (stack.isEmpty()) stack.add(tmp);
            else {
                if (stack.peek() == tmp) stack.pop();
                else {
                    stack.add(tmp);
                }
            }
        }
        
        if (stack.isEmpty()) answer = 1;

        return answer;
    }
}