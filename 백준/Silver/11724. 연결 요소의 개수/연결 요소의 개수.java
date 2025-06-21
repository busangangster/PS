import java.util.*;
import java.io.*;

public class Main {
  public static int N, M;
  public static boolean[] visited;
  public static ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    visited = new boolean[N + 1];
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

    int cnt = 0;
    for (int i = 1; i <= N; i++) {
      if (!visited[i]) {
        bfs(i);
        cnt++;
      }
    }
    System.out.println(cnt);
  }

  public static void bfs(int start) {
    Queue<Integer> q = new ArrayDeque<>();
    visited[start] = true;
    q.offer(start);

    while (!q.isEmpty()) {
      int cur = q.poll();

      for (int x : arr.get(cur)) {
        if (!visited[x]) {
          visited[x] = true;
          q.offer(x);
        }
      }
    }
  }
}