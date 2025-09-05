import java.util.*;
import java.io.*;

public class Main {
  public static int N, M, fx, fy, sx, sy;
  public static char[][] arr;
  public static int[] dx = { 0, 1, 0, -1 };
  public static int[] dy = { 1, 0, -1, 0 };
  public static Queue<Node> q = new ArrayDeque<>();
  public static boolean[][][][] visited;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    arr = new char[N][M];
    visited = new boolean[N][M][N][M];
    int num = 1;
    for (int i = 0; i < N; i++) {
      String s = br.readLine();
      for (int j = 0; j < M; j++) {
        char tmp = s.charAt(j);
        if (tmp == 'o') {
          if (num == 1) {
            fx = i;
            fy = j;
          } else {
            sx = i;
            sy = j;
          }
          num++;
        }
        arr[i][j] = tmp;
      }
    }

    q.offer(new Node(fx, fy, sx, sy, 0));
    visited[fx][fy][sx][sy] = true;
    int res = bfs();
    System.out.println(res);

  }

  public static int bfs() {
    while (!q.isEmpty()) {
      Node cur = q.poll();

      if (cur.cnt >= 10) {
        return -1;
      }

      for (int i = 0; i < 4; i++) {
        int nx1 = cur.x1 + dx[i];
        int ny1 = cur.y1 + dy[i];
        int nx2 = cur.x2 + dx[i];
        int ny2 = cur.y2 + dy[i];

        boolean out1 = check(nx1, ny1);
        boolean out2 = check(nx2, ny2);

        // 안떨어졌지만 벽인 경우
        if (out1 && arr[nx1][ny1] == '#') {
          nx1 = cur.x1;
          ny1 = cur.y1;
        }
        if (out2 && arr[nx2][ny2] == '#') {
          nx2 = cur.x2;
          ny2 = cur.y2;
        }

        // 둘다 떨어진 경우
        if (!out1 && !out2)
          continue;

        if ((out1 && !out2) || (!out1 && out2)) {
          return cur.cnt + 1;
        }

        if (!visited[nx1][ny1][nx2][ny2]) {
          visited[nx1][ny1][nx2][ny2] = true;
          q.offer(new Node(nx1, ny1, nx2, ny2, cur.cnt + 1));
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
  int x1;
  int y1;
  int x2;
  int y2;
  int cnt;

  public Node(int x1, int y1, int x2, int y2, int cnt) {
    this.x1 = x1;
    this.y1 = y1;
    this.x2 = x2;
    this.y2 = y2;
    this.cnt = cnt;
  }
}