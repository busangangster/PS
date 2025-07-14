import java.util.*;
import java.io.*;

public class Main {
  public static int w, h;
  public static int[][] arr;
  public static boolean[][] visited;
  public static int[] dx = { 1, 0, -1, 0, 1, -1, -1, 1 };
  public static int[] dy = { 0, 1, 0, -1, 1, -1, 1, -1 };

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    while (true) {
      st = new StringTokenizer(br.readLine());
      h = Integer.parseInt(st.nextToken());
      w = Integer.parseInt(st.nextToken());
      if (w == 0 && h == 0)
        break;

      arr = new int[w][h];
      visited = new boolean[w][h];
      int cnt = 0;

      for (int i = 0; i < w; i++) {
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < h; j++) {
          arr[i][j] = Integer.parseInt(st.nextToken());
        }
      }

      for (int i = 0; i < w; i++) {
        for (int j = 0; j < h; j++) {
          if (!visited[i][j] && arr[i][j] == 1) {
            bfs(i, j);
            cnt++;
          }
        }
      }
      sb.append(cnt).append("\n");

    }
    System.out.println(sb);
  }

  public static void bfs(int x, int y) {
    Queue<int[]> q = new ArrayDeque<>();
    visited[x][y] = true;
    q.offer(new int[] { x, y });

    while (!q.isEmpty()) {
      int[] cur = q.poll();

      for (int i = 0; i < 8; i++) {
        int nx = cur[0] + dx[i];
        int ny = cur[1] + dy[i];

        if (check(nx, ny)) {
          if (!visited[nx][ny] && arr[nx][ny] == 1) {
            q.offer(new int[] { nx, ny });
            visited[nx][ny] = true;
          }
        }
      }
    }
  }

  public static boolean check(int x, int y) {
    return (0 <= x && x < w && 0 <= y && y < h);
  }

}