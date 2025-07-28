import java.util.*;
import java.io.*;

public class Main {
  public static int N, M, sx, sy, ans;
  public static char[][] arr;
  public static boolean[][] visited;
  public static int[] dx = { 0, 1, 0, -1 };
  public static int[] dy = { 1, 0, -1, 0 };

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    arr = new char[N][M];
    visited = new boolean[N][M];
    ans = 0;

    for (int i = 0; i < N; i++) {
      String s = br.readLine();
      for (int j = 0; j < M; j++) {
        char tmp = s.charAt(j);
        if (tmp == 'I') {
          sx = i;
          sy = j;
        }
        arr[i][j] = tmp;
      }
    }

    bfs();
    System.out.println(ans == 0 ? "TT" : ans);
  }

  public static void bfs() {
    Queue<int[]> q = new ArrayDeque<>();
    visited[sx][sy] = true;
    q.offer(new int[] { sx, sy });

    while (!q.isEmpty()) {
      int[] cur = q.poll();

      for (int i = 0; i < 4; i++) {
        int nx = cur[0] + dx[i];
        int ny = cur[1] + dy[i];

        if (check(nx, ny)) {
          if (!visited[nx][ny]) {
            if (arr[nx][ny] == 'P') {
              visited[nx][ny] = true;
              q.offer(new int[] { nx, ny });
              ans++;
            } else if (arr[nx][ny] == 'O') {
              visited[nx][ny] = true;
              q.offer(new int[] { nx, ny });
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