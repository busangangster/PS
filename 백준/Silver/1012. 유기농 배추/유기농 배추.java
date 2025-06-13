import java.util.*;
import java.io.*;

public class Main {
  public static int N, M, K;
  public static int[][] arr;
  public static boolean[][] visited;
  public static int[] dx = { 0, 1, 0, -1 };
  public static int[] dy = { 1, 0, -1, 0 };

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    int t = Integer.parseInt(br.readLine());

    while (t-- > 0) {
      st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());
      K = Integer.parseInt(st.nextToken());

      arr = new int[N][M];
      visited = new boolean[N][M];
      int cnt = 0;

      for (int i = 0; i < K; i++) {
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        arr[a][b] = 1;
      }

      for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
          if (!visited[i][j] && arr[i][j] == 1) {
            bfs(i, j);
            cnt++;
          }
        }
      }
      sb.append(cnt).append("\n");
    }
    System.out.println(sb);
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
          if (!visited[nx][ny] && arr[nx][ny] == 1) {
            q.offer((new Node(nx, ny)));
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