import java.util.*;
import java.io.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    while (true) {
      String s = br.readLine();
      if (s.charAt(0) == '.') {
        System.out.println(sb);
        System.exit(0);
      }

      Stack<Character> stack = new Stack<>();

      for (int i = 0; i < s.length(); i++) {
        char tmp = s.charAt(i);
        if (tmp == '(' || tmp == '[') {
          stack.push(tmp);
        } else if (tmp == ')') {
          if (!stack.isEmpty() && stack.peek() == '(') {
            stack.pop();
          } else
            stack.push(tmp);
        } else if (tmp == ']') {
          if (!stack.isEmpty() && stack.peek() == '[') {
            stack.pop();
          } else
            stack.push(tmp);
        }
      }

      if (!stack.isEmpty()) {
        sb.append("no");
      } else
        sb.append("yes");
      sb.append("\n");

    }

  }
}