import java.util.*;
import java.io.*;

public class Main {
  public static int n, m, largest;
  public static int[][] arr;
  public static boolean[][] visited;
  public static int[] dx = { 0, 1, 0, -1 };
  public static int[] dy = { 1, 0, -1, 0 };

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    visited = new boolean[n][m];
    arr = new int[n][m];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int cnt = 0;
    largest = Integer.MIN_VALUE;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (!visited[i][j] && arr[i][j] == 1) {
          bfs(i, j);
          cnt++;
        }
      }
    }

    System.out.println(cnt);
    System.out.println(cnt == 0 ? 0 : largest);

  }

  public static void bfs(int x, int y) {
    Queue<int[]> q = new ArrayDeque<>();
    visited[x][y] = true;
    q.offer(new int[] { x, y });
    int c = 1;

    while (!q.isEmpty()) {
      int[] cur = q.poll();

      for (int i = 0; i < 4; i++) {
        int nx = cur[0] + dx[i];
        int ny = cur[1] + dy[i];

        if (check(nx, ny)) {
          if (!visited[nx][ny]) {
            if (arr[nx][ny] == 1) {
              c++;
              visited[nx][ny] = true;
              q.offer(new int[] { nx, ny });
            }
          }
        }
      }
    }
    largest = Math.max(largest, c);
  }

  public static boolean check(int x, int y) {
    return (0 <= x && x < n && 0 <= y && y < m);
  }
}