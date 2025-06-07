import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    int n = Integer.parseInt(br.readLine());

    int[] stack = new int[n];
    int[] arr = new int[n];
    int[] ans = new int[n];
    Arrays.fill(ans, -1);

    st = new StringTokenizer(br.readLine());

    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    int top = 0;
    for (int i = 0; i < n; i++) {
      while (top > 0 && arr[stack[top - 1]] < arr[i]) {
        ans[stack[--top]] = arr[i];
      }

      stack[top++] = i;
    }
    for (int i = 0; i < n; i++) {
      sb.append(ans[i]).append(" ");
    }
    System.out.println(sb);
  }
}