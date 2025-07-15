import java.util.*;
import java.io.*;

public class Main {
  public static int N, M;
  public static char[][] arr;
  public static boolean[][][] visited;
  public static int[] dx = { 0, 1, 0, -1 };
  public static int[] dy = { 1, 0, -1, 0 };

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    arr = new char[N][M];
    for (int i = 0; i < N; i++) {
      String s = br.readLine();
      for (int j = 0; j < M; j++) {
        arr[i][j] = s.charAt(j);
      }
    }
    visited = new boolean[N][M][2];

    System.out.println(bfs());

  }

  public static int bfs() {
    Queue<Node> q = new ArrayDeque<>();
    visited[0][0][0] = true;
    q.offer(new Node(0, 0, 1, false));

    while (!q.isEmpty()) {
      Node cur = q.poll();

      if (cur.x == N - 1 && cur.y == M - 1) {
        return cur.cnt;
      }

      for (int i = 0; i < 4; i++) {
        int nx = cur.x + dx[i];
        int ny = cur.y + dy[i];

        if (check(nx, ny)) {
          if (arr[nx][ny] == '1') {

            if (!cur.broke) {
              if (!visited[nx][ny][1]) {
                visited[nx][ny][1] = true;
                q.offer(new Node(nx, ny, cur.cnt + 1, true));
              }
            }
          } else {
            int used = !cur.broke ? 0 : 1;
            if (!visited[nx][ny][used]) {
              visited[nx][ny][used] = true;
              q.offer(new Node(nx, ny, cur.cnt + 1, cur.broke));
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
  boolean broke;

  public Node(int x, int y, int cnt, boolean broke) {
    this.x = x;
    this.y = y;
    this.cnt = cnt;
    this.broke = broke;
  }
}