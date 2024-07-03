import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            Stack<Character> stack = new Stack<>();
            for (int j = 0; j < s.length(); j++) {
                if (stack.isEmpty()) {
                    stack.add(s.charAt(j));
                } else {
                    if (stack.peek() == s.charAt(j)) {
                        stack.pop();
                    } else {
                        stack.add(s.charAt(j));
                    }
                }
            }
            if (stack.isEmpty()) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}