import java.io.*;
import java.util.*;

public class Main {
  public static int N, M, sheep, wolf;
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

    for (int i = 0; i < N; i++) {
      String s = br.readLine();
      for (int j = 0; j < M; j++) {
        arr[i][j] = s.charAt(j);
      }
    }

    sheep = 0;
    wolf = 0;

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (!visited[i][j] && arr[i][j] != '#') {
          bfs(i, j);
        }
      }
    }
    System.out.println(sheep + " " + wolf);
  }

  public static void bfs(int x, int y) {
    Queue<int[]> q = new ArrayDeque<>();
    q.offer(new int[] { x, y });
    visited[x][y] = true;
    int s = 0;
    int w = 0;

    if (arr[x][y] == 'o') {
      s++;
    } else if (arr[x][y] == 'v') {
      w++;
    }

    while (!q.isEmpty()) {
      int[] cur = q.poll();

      for (int i = 0; i < 4; i++) {
        int nx = cur[0] + dx[i];
        int ny = cur[1] + dy[i];

        if (check(nx, ny)) {
          if (!visited[nx][ny] && arr[nx][ny] != '#') {
            if (arr[nx][ny] == 'o') {
              s++;
            } else if (arr[nx][ny] == 'v') {
              w++;
            }
            visited[nx][ny] = true;
            q.offer(new int[] { nx, ny });
          }
        }
      }
    }
    if (s > w)
      sheep += s;
    else
      wolf += w;
  }

  public static boolean check(int x, int y) {
    return (0 <= x && x < N && 0 <= y && y < M);
  }
}