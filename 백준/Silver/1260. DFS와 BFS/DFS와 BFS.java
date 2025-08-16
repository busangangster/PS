import java.util.*;
import java.io.*;

public class Main {
  public static int N, M, S;
  public static ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
  public static boolean[] visited;
  public static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    S = Integer.parseInt(st.nextToken());

    for (int i = 0; i <= N; i++) {
      arr.add(new ArrayList<>());
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      arr.get(a).add(b);
      arr.get(b).add(a);
    }

    for (int i = 1; i <= N; i++) {
      Collections.sort(arr.get(i));
    }

    visited = new boolean[N + 1];
    sb.append(S + " ");
    visited[S] = true;
    dfs(S, 1);

    sb.append("\n");
    visited = new boolean[N + 1];
    bfs();

    System.out.println(sb);

  }

  public static void dfs(int cur, int cnt) {
    if (cnt == N) {
      return;
    }

    for (int next : arr.get(cur)) {
      if (!visited[next]) {
        sb.append(next + " ");
        visited[next] = true;
        dfs(next, cnt + 1);
      }
    }

  }

  public static void bfs() {
    Queue<Integer> q = new ArrayDeque<>();
    q.offer(S);
    visited[S] = true;
    sb.append(S + " ");

    while (!q.isEmpty()) {
      int cur = q.poll();

      for (int next : arr.get(cur)) {
        if (!visited[next]) {
          sb.append(next + " ");
          visited[next] = true;
          q.offer(next);
        }
      }
    }
  }
}
