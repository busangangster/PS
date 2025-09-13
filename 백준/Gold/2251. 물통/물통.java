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
      int c = size[2] - a - b; // 중요

      if (a == 0)
        possibleC[c] = true;

      int[] res = { a, b, c }; // 각각의 물통이 현재 가지고 있는 물의 양
      for (int[] tmp : possibleCase) { // 물 이동 경우의 수
        int from = tmp[0];
        int to = tmp[1];

        if (res[from] == 0) // 옮길 물이 없으면 확인 X
          continue;

        int[] next = res.clone();
        int water = Math.min(res[from], size[to] - res[to]); // 물이 모자라거나, 넘치지 않게 하기 위한 min값

        next[from] -= water;
        next[to] += water;

        if (!visited[next[0]][next[1]]) {
          visited[next[0]][next[1]] = true;
          q.offer(new int[] { next[0], next[1] });
        }
      }
    }
  }
}