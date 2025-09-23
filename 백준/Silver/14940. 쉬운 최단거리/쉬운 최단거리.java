import java.util.*;
import java.io.*;

public class Main {
  public static int N, M, tx, ty;
  public static int[][] arr;
  public static int[][] ans;
  public static boolean[][] visited;
  public static int[] dx = { 0, 1, 0, -1 };
  public static int[] dy = { 1, 0, -1, 0 };

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    arr = new int[N][M];
    ans = new int[N][M];
    visited = new boolean[N][M];

    for (int[] a : ans) {
      Arrays.fill(a, -1);
    }

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        int tmp = Integer.parseInt(st.nextToken());
        if (tmp == 2) {
          tx = i;
          ty = j;
        } else if (tmp == 0) {
          ans[i][j] = 0;
        }
        arr[i][j] = tmp;
      }
    }

    bfs(tx, ty);
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        sb.append(ans[i][j]).append(" ");
      }
      sb.append("\n");
    }

    System.out.println(sb);

  }

  public static void bfs(int x, int y) {
    Queue<int[]> q = new ArrayDeque<>();
    visited[x][y] = true;
    ans[x][y] = 0;
    q.offer(new int[] { x, y, 0 });

    while (!q.isEmpty()) {
      int[] cur = q.poll();

      for (int i = 0; i < 4; i++) {
        int nx = cur[0] + dx[i];
        int ny = cur[1] + dy[i];

        if (check(nx, ny)) {
          if (!visited[nx][ny]) {
            if (arr[nx][ny] == 0) {
              visited[nx][ny] = true;
            } else {
              ans[nx][ny] = cur[2] + 1;
              visited[nx][ny] = true;
              q.offer(new int[] { nx, ny, cur[2] + 1 });
            }
          }
        }
      }
    }
  }

  public static boolean check(int x, int y) {
    return (0 <= x && x < N && 0 <= y && y < M);
  }
}
