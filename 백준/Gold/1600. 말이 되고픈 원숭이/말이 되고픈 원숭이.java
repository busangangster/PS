import java.util.*;
import java.io.*;

public class Main {
  public static int K, N, M;
  public static int[][] arr;
  public static boolean[][][] visited;
  public static int[] dx = { 0, 1, 0, -1, -1, -2, -2, -1, 1, 2, 2, 1 };
  public static int[] dy = { 1, 0, -1, 0, -2, -1, 1, 2, 2, 1, -1, -2 };

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    K = Integer.parseInt(br.readLine());

    st = new StringTokenizer(br.readLine());
    M = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());

    arr = new int[N][M];
    visited = new boolean[N][M][K + 1];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int res = bfs();

    System.out.println(res);
  }

  public static int bfs() {
    Queue<Node> q = new ArrayDeque<Node>();
    visited[0][0][0] = true;
    q.offer(new Node(0, 0, 0, 0));

    while (!q.isEmpty()) {
      Node cur = q.poll();

      if (cur.x == N - 1 && cur.y == M - 1) {
        return cur.cnt;
      }

      for (int i = 0; i < 12; i++) {
        int nx = cur.x + dx[i];
        int ny = cur.y + dy[i];

        if (check(nx, ny)) {
          if (i <= 3) {
            if (!visited[nx][ny][cur.k] && arr[nx][ny] == 0) {
              visited[nx][ny][cur.k] = true;
              q.offer(new Node(nx, ny, cur.cnt + 1, cur.k));
            }
          } else {
            if (cur.k < K) {
              if (!visited[nx][ny][cur.k + 1] && arr[nx][ny] == 0) {
                visited[nx][ny][cur.k+1] = true;
                q.offer(new Node(nx, ny, cur.cnt + 1, cur.k + 1));
              }
            }
          }
        }
      }
    }

    return -1;
  }

  public static boolean check(int x, int y) {
    return (0 <= x && x < N && 0 <= y && y < M);
  }
}

class Node {
  int x;
  int y;
  int cnt;
  int k;

  public Node(int x, int y, int cnt, int k) {
    this.x = x;
    this.y = y;
    this.cnt = cnt;
    this.k = k;
  }
}