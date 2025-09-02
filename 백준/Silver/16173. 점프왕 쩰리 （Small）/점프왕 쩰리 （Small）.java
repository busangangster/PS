import java.util.*;
import java.io.*;

public class Main {
  public static int N;
  public static int[][] arr;
  public static boolean[][] visited;
  public static int[] dx = { 1, 0 };
  public static int[] dy = { 0, 1 };

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    N = Integer.parseInt(br.readLine());

    arr = new int[N][N];
    visited = new boolean[N][N];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    System.out.println(bfs() ? "HaruHaru" : "Hing");
  }

  public static boolean bfs() {
    Queue<int[]> q = new ArrayDeque<>();
    visited[0][0] = true;
    q.offer(new int[] { 0, 0 });

    while (!q.isEmpty()) {
      int[] cur = q.poll();

      if (cur[0] == N - 1 && cur[1] == N - 1) {
        return true;
      }

      for (int i = 0; i < 2; i++) {
        int nx = cur[0] + (arr[cur[0]][cur[1]] * dx[i]);
        int ny = cur[1] + (arr[cur[0]][cur[1]] * dy[i]);

        if (check(nx, ny)) {
          if (!visited[nx][ny]) {
            q.offer(new int[] { nx, ny });
            visited[nx][ny] = true;
          }
        }
      }
    }
    return false;
  }

  public static boolean check(int x, int y) {
    return (0 <= x && x < N && 0 <= y && y < N);
  }
}