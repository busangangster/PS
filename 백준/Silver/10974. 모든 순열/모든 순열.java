import java.util.*;
import java.io.*;

public class Main {
  public static int[] selected;
  public static boolean[] visited;
  public static int N;
  public static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    selected = new int[N];
    visited = new boolean[N + 1];

    perm(0);
    System.out.println(sb);
  }

  public static void perm(int cnt) {
    if (cnt == N) {
      for (int i = 0; i < N; i++) {
        sb.append(selected[i]).append(" ");
      }
      sb.append("\n");
      return;
    }

    for (int i = 1; i <= N; i++) {
      if (!visited[i]) {
        selected[cnt] = i;
        visited[i] = true;
        perm(cnt + 1);
        visited[i] = false;
      }
    }
  }
}