import java.io.*;
import java.util.*;

public class Main {
  public static int t, ans;
  public static boolean[] visited;
  public static int[] arr = new int[] { 300, 60, 10 };;
  public static int[] selected, answer;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    t = Integer.parseInt(br.readLine());

    visited = new boolean[3];
    selected = new int[3];
    ans = Integer.MAX_VALUE;
    answer = new int[] { 0, 0, 0 };
    perm(0);
    for (int i = 0; i < 3; i++) {
      sb.append(answer[i]).append(" ");
    }
    System.out.println(ans == Integer.MAX_VALUE ? -1 : sb);
  }

  public static void perm(int cnt) {
    if (cnt == 3) {
      cal();
      return;
    }

    for (int i = 0; i < 3; i++) {
      if (!visited[i]) {
        visited[i] = true;
        selected[cnt] = i;
        perm(cnt + 1);
        visited[i] = false;
      }
    }
  }

  public static void cal() {
    int cur = t;
    int time = 0;
    int[] kkk = new int[3];
    for (int i = 0; i < 3; i++) {
      int tmp = selected[i];
      int p = cur / arr[tmp];
      time += p;
      cur %= arr[tmp];
      kkk[i] = p;
    }
    if (cur == 0) {
      if (time < ans) {
        ans = time;
        for (int j = 0; j < 3; j++) {
          answer[j] = kkk[j];
        }
      }
    }
  }
}
