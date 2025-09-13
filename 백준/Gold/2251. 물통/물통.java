import java.util.*;
import java.io.*;

public class Main {
  public static int[] size;
  public static boolean[][] visited;
  public static boolean[] possibleC;
  public static int[][] possibleCase = { { 0, 1 }, { 0, 2 }, { 1, 0 }, { 1, 2 }, { 2, 0 }, { 2, 1 } };

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    size = new int[3];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < 3; i++) {
      size[i] = Integer.parseInt(st.nextToken());
    }

    visited = new boolean[201][201];
    possibleC = new boolean[201];

    bfs();
    for (int i = 0; i <= size[2]; i++) {
      if (possibleC[i])
        sb.append(i).append(" ");
    }
    System.out.println(sb);
  }

  public static void bfs() {
    Queue<int[]> q = new ArrayDeque<>();
    q.offer(new int[] { 0, 0 });
    visited[0][0] = true;

    while (!q.isEmpty()) {
      int[] cur = q.poll();
      int a = cur[0];
      int b = cur[1];
      int c = size[2] - a - b;

      if (a == 0)
        possibleC[c] = true;

      int[] res = { a, b, c };
      for (int[] tmp : possibleCase) {
        int from = tmp[0];
        int to = tmp[1];

        if (res[from] == 0)
          continue;

        int[] next = res.clone();
        int water = Math.min(res[from], size[to] - res[to]);

        next[from] -= water;
        next[to] += water;

        int na = next[0];
        int nb = next[1];
        if (!visited[na][nb]) {
          visited[na][nb] = true;
          q.offer(new int[] { na, nb });
        }
      }
    }

  }
}