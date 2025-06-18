import java.util.*;
import java.io.*;

public class Main {
  public static int N, M;
  public static ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
  public static int[] computers;
  public static boolean[] visited;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    for (int i = 0; i <= N; i++) {
      arr.add(new ArrayList<>());
    }
    computers = new int[N + 1];
    Arrays.fill(computers, -1);

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      arr.get(b).add(a);
    }
    for (int i = 1; i <= N; i++) {
      visited = new boolean[N + 1];
      computers[i] = bfs(i);
    }

    int max_v = Integer.MIN_VALUE;

    for (int i = 1; i <= N; i++) {
      if (computers[i] > max_v) {
        max_v = computers[i];
      }
    }

    for (int i = 1; i <= N; i++) {
      if (computers[i] == max_v) {
        sb.append(i).append(" ");
      }
    }

    System.out.println(sb);
  }

  public static int bfs(int x) {
    Queue<Integer> q = new ArrayDeque<>();
    int ans = 1;
    visited[x] = true;
    q.offer(x);

    while (!q.isEmpty()) {
      int cur = q.poll();

      for (int next : arr.get(cur)) {
        if (!visited[next]) {
          ans++;
          visited[next] = true;
          q.offer(next);
        }
      }
    }
    return ans;
  }
}