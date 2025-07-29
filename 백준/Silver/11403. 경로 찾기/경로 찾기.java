import java.util.*;
import java.io.*;

public class Main {
  public static int N;
  public static ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
  public static boolean[] visited;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    N = Integer.parseInt(br.readLine());

    for (int i = 0; i < N; i++) {
      arr.add(new ArrayList<>());
    }

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        int tmp = Integer.parseInt(st.nextToken());
        if (i == j)
          continue;

        if (tmp == 1) {
          arr.get(i).add(j);
        }
      }
    }

    for (int i = 0; i < N; i++) {
      visited = new boolean[N];
      bfs(i);
      for (int j = 0; j < N; j++) {
        if (visited[j])
          sb.append(1);

        else
          sb.append(0);
        sb.append(" ");
      }
      sb.append("\n");
    }
    System.out.println(sb);
  }

  public static void bfs(int start) {
    Queue<Integer> q = new ArrayDeque<>();
    q.offer(start);

    while (!q.isEmpty()) {
      int cur = q.poll();

      for (int next : arr.get(cur)) {
        if (!visited[next]) {
          visited[next] = true;
          q.offer(next);
        }
      }
    }

  }
}