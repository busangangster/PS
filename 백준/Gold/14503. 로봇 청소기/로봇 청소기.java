import java.util.*;
import java.io.*;

public class Main {
  public static int N, M, ans, sx, sy, direction;
  public static int[][] arr;
  public static boolean[][] visited;
  public static int[] dx = { -1, 0, 1, 0 };
  public static int[] dy = { 0, 1, 0, -1 };

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    sx = Integer.parseInt(st.nextToken());
    sy = Integer.parseInt(st.nextToken());
    direction = Integer.parseInt(st.nextToken());

    ans = 0;
    arr = new int[N][M];
    visited = new boolean[N][M];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    while (true) {
      clean();

      if (checkSurround()) {
        moveForward();
      } else {
        if (!moveBack()) {
          break;
        }
      }
    }
    System.out.println(ans);
  }

  public static void clean() {
    if (arr[sx][sy] == 0 && !visited[sx][sy]) {
      ans++;
      visited[sx][sy] = true;
    }
  }

  public static boolean checkSurround() {
    for (int i = 0; i < 4; i++) {
      int nx = sx + dx[i];
      int ny = sy + dy[i];

      if (check(nx, ny)) {
        if (arr[nx][ny] == 0 && !visited[nx][ny]) {
          return true;
        }
      }
    }
    return false;
  }

  public static boolean moveBack() {
    int d = (direction + 2) % 4;
    int nx = sx + dx[d];
    int ny = sy + dy[d];

    if (check(nx, ny)) {
      if (arr[nx][ny] != 1) {
        sx = nx;
        sy = ny;
        return true;
      }
    }
    return false;
  }

  public static void moveForward() {
    int cur = direction;
    for (int i = 0; i < 4; i++) {
      int d = (cur + 3) % 4;
      int nx = sx + dx[d];
      int ny = sy + dy[d];

      if (check(nx, ny)) {
        if (arr[nx][ny] == 0 && !visited[nx][ny]) {
          direction = d;
          sx = nx;
          sy = ny;
          return;
        }
      }
      cur = d;
    }
  }

  public static boolean check(int x, int y) {
    return (0 <= x && x < N && 0 <= y && y < M);
  }
}