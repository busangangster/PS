import java.util.*;
import java.io.*;

public class Main {
  public static int N, M, res, ans;
  public static int[][] arr;
  public static int[][] seaCnt;
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
    seaCnt = new int[N][M];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    ans = 0;
    res = 0;
    while (true) {
      if (!iceberg()) {
        System.out.println(ans);
        return;
      }
      seaCheck();
      melt();
    }
  }

  public static boolean iceberg() {
    int cnt = 0;
    visited = new boolean[N][M];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (arr[i][j] != 0 && !visited[i][j]) {
          bfs(i, j);
          cnt++;
        }
        if (cnt >= 2) {
          ans = res;
          return false;
        }
      }
    }
    if (cnt == 0)
      return false;
    res++;
    return true;
  }

  public static void seaCheck() {
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (arr[i][j] != 0) {
          seaCnt[i][j] = lookAround(i, j);
        }
      }
    }
  }

  public static void melt() {
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (arr[i][j] != 0) {
          if (arr[i][j] - seaCnt[i][j] > 0) {
            arr[i][j] = arr[i][j] - seaCnt[i][j];
          } else {
            arr[i][j] = 0;
          }
        }
      }
    }
  }

  public static int lookAround(int x, int y) {
    int sea = 0;
    for (int i = 0; i < 4; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];
      if (arr[nx][ny] == 0) {
        sea++;
      }
    }
    return sea;
  }

  public static void bfs(int x, int y) {
    Queue<Node> q = new ArrayDeque<>();
    visited[x][y] = true;
    q.offer(new Node(x, y));

    while (!q.isEmpty()) {
      Node cur = q.poll();

      for (int i = 0; i < 4; i++) {
        int nx = cur.x + dx[i];
        int ny = cur.y + dy[i];

        if (check(nx, ny)) {
          if (!visited[nx][ny] && arr[nx][ny] != 0) {
            q.offer(new Node(nx, ny));
            visited[nx][ny] = true;
          }
        }
      }
    }
  }

  public static boolean check(int x, int y) {
    return (0 <= x && x < N && 0 <= y && y < M);
  }
}

class Node {
  int x;
  int y;

  public Node(int x, int y) {
    this.x = x;
    this.y = y;
  }
}