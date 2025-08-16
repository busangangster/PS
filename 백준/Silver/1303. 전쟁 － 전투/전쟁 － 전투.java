import java.util.*;
import java.io.*;

public class Main {
  public static int N, M;
  public static char[][] arr;
  public static boolean[][] visited;
  public static int[] dx = { 0, 1, 0, -1 };
  public static int[] dy = { 1, 0, -1, 0 };

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    M = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());

    arr = new char[N][M];
    visited = new boolean[N][M];

    for (int i = 0; i < N; i++) {
      String s = br.readLine();
      for (int j = 0; j < M; j++) {
        arr[i][j] = s.charAt(j);
      }
    }

    int ours = 0;
    int enemies = 0;

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (!visited[i][j]) {
          int res = bfs(i, j);
          if (arr[i][j] == 'W') {
            ours += Math.pow(res, 2);
          } else {
            enemies += Math.pow(res, 2);
          }
        }
      }
    }

    System.out.println(ours + " " + enemies);

  }

  public static int bfs(int x, int y) {
    Queue<int[]> q = new ArrayDeque<>();
    visited[x][y] = true;
    q.offer(new int[] { x, y });
    int cnt = 1;

    while (!q.isEmpty()) {
      int[] cur = q.poll();

      for (int i = 0; i < 4; i++) {
        int nx = cur[0] + dx[i];
        int ny = cur[1] + dy[i];

        if (check(nx, ny)) {
          if (!visited[nx][ny] && arr[x][y] == arr[nx][ny]) {
            visited[nx][ny] = true;
            q.offer(new int[] { nx, ny });
            cnt++;
          }
        }
      }
    }
    return cnt;
  }

  public static boolean check(int x, int y) {
    return (0 <= x && x < N && 0 <= y && y < M);
  }
}