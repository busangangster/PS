import java.util.*;
import java.io.*;

public class Main {
  public static int N, M, cheese;
  public static int[][] arr;
  public static boolean[][] visited;
  public static int[] dx = { 0, 1, 0, -1 };
  public static int[] dy = { 1, 0, -1, 0 };

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    cheese = 0;
    int former = 0;
    int cnt = 0;
    arr = new int[N][M];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        int tmp = Integer.parseInt(st.nextToken());
        if (tmp == 1)
          cheese++;
        arr[i][j] = tmp;
      }
    }

    while (true) {
      if (cheese == 0) {
        System.out.println(cnt);
        System.out.println(former);
        break;
      }
      former = cheese;
      bfs();
      cnt++;
    }
  }

  public static void bfs() {
    visited = new boolean[N][M];
    Queue<int[]> q = new ArrayDeque<>();
    q.offer(new int[] { 0, 0 });
    visited[0][0] = true;

    while (!q.isEmpty()) {
      int[] cur = q.poll();

      for (int i = 0; i < 4; i++) {
        int nx = cur[0] + dx[i];
        int ny = cur[1] + dy[i];

        if (check(nx, ny)) {
          if (!visited[nx][ny]) {
            if (arr[nx][ny] == 1) {
              visited[nx][ny] = true;
            } else {
              visited[nx][ny] = true;
              q.offer(new int[] { nx, ny });
            }
          }
        }
      }
    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (arr[i][j] == 1 && visited[i][j]) {
          arr[i][j] = 0;
          cheese--;
        }
      }
    }
  }

  public static boolean check(int x, int y) {
    return (0 <= x && x < N && 0 <= y && y < M);
  }
}