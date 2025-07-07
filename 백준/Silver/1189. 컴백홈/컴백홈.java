import java.util.*;
import java.io.*;

public class Main {
  public static int N, M, K, ans;
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
    K = Integer.parseInt(st.nextToken());

    arr = new char[N][M];
    visited = new boolean[N][M];
    ans = 0;

    for (int i = 0; i < N; i++) {
      String s = br.readLine();
      for (int j = 0; j < M; j++) {
        arr[i][j] = s.charAt(j);
      }
    }

    visited[N - 1][0] = true;
    dfs(N - 1, 0, 1);

    System.out.println(ans);
  }

  public static void dfs(int x, int y, int cnt) {
    if (x == 0 && y == M - 1) {
      if (cnt == K) {
        ans++;
      }
      return;
    }

    for (int i = 0; i < 4; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];

      if (check(nx, ny)) {
        if (!visited[nx][ny] && arr[nx][ny] == '.') {
          visited[nx][ny] = true;
          dfs(nx, ny, cnt + 1);
          visited[nx][ny] = false;
        }
      }
    }

  }

  public static boolean check(int x, int y) {
    return (0 <= x && x < N && 0 <= y && y < M);
  }
}