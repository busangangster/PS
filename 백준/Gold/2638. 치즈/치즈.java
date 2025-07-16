import java.util.*;
import java.io.*;

public class Main {
  public static int N, M, cheeseCnt;
  public static int[][] arr, canMelt;
  public static boolean[][] visited;
  public static int[] dx = { 0, 1, 0, -1 };
  public static int[] dy = { 1, 0, -1, 0 };

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    arr = new int[N][M];
    cheeseCnt = 0;

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        int v = Integer.parseInt(st.nextToken());
        arr[i][j] = v;
        if (v == 1)
          cheeseCnt++;
      }
    }

    int ans = 0;

    while (true) {
      if (cheeseCnt == 0) {
        System.out.println(ans);
        break;
      }

      visited = new boolean[N][M];
      canMelt = new int[N][M];
      canMelt(0, 0);

      melt();
      ans++;

    }
  }

  public static void canMelt(int x, int y) {
    Queue<int[]> q = new ArrayDeque<>();
    visited[x][y] = true;
    q.offer(new int[] { x, y });

    while (!q.isEmpty()) {
      int[] cur = q.poll();

      for (int i = 0; i < 4; i++) {
        int nx = cur[0] + dx[i];
        int ny = cur[1] + dy[i];

        if (check(nx, ny)) {
          if (arr[nx][ny] == 1) {
            canMelt[nx][ny]++;
          } else {
            if (!visited[nx][ny]) {
              visited[nx][ny] = true;
              q.offer(new int[] { nx, ny });
            }
          }
        }
      }
    }
  }

  public static void melt() {
    for (int i = 1; i < N; i++) {
      for (int j = 1; j < M; j++) {
        if (canMelt[i][j] >= 2) {
          arr[i][j] = 0;
          cheeseCnt--;
        }
      }
    }
  }

  public static boolean check(int x, int y) {
    return (0 <= x && x < N && 0 <= y && y < M);
  }
}