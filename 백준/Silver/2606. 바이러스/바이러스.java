import java.util.*;
import java.io.*;

public class Main {
  public static int N, M;
  public static boolean[] visited;
  public static ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    N = Integer.parseInt(br.readLine());
    M = Integer.parseInt(br.readLine());

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

    visited = new boolean[N + 1];

    int res = bfs();
    System.out.println(res);

  }

  public static int bfs() {
    Queue<Integer> q = new ArrayDeque<>();
    visited[1] = true;
    q.offer(1);
    int cnt = 0;

    while (!q.isEmpty()) {
      int cur = q.poll();

      for (int next : arr.get(cur)) {
        if (!visited[next]) {
          visited[next] = true;
          q.offer(next);
          cnt++;
        }
      }
    }
    return cnt;
  }
}