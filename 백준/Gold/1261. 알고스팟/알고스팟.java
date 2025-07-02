import java.util.*;
import java.io.*;

public class Main {
  public static int M, N;
  public static char[][] arr;
  public static boolean[][] visited;
  public static int[] dx = { 0, 1, 0, -1 };
  public static int[] dy = { 1, 0, -1, 0 };

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    M = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());

    arr = new char[N][M];
    visited = new boolean[N][M];

    for (int i = 0; i < N; i++) {
      String s = br.readLine();
      for (int j = 0; j < M; j++) {
        arr[i][j] = s.charAt(j);
      }
    }

    int res = bfs();
    System.out.println(res);
  }

  public static int bfs() {
    Deque<Node> dq = new ArrayDeque<Node>();
    dq.offer(new Node(0, 0, 0));
    visited[0][0] = true;

    while (!dq.isEmpty()) {
      Node cur = dq.poll();

      if (cur.x == N - 1 && cur.y == M - 1) {
        return cur.cnt;
      }

      for (int i = 0; i < 4; i++) {
        int nx = cur.x + dx[i];
        int ny = cur.y + dy[i];

        if (check(nx, ny)) {
          if (!visited[nx][ny]) {
            if (arr[nx][ny] == '0') {
              dq.addFirst(new Node(nx, ny, cur.cnt));
              visited[nx][ny] = true;
            } else {
              dq.addLast(new Node(nx, ny, cur.cnt + 1));
              visited[nx][ny] = true;
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

  public Node(int x, int y, int cnt) {
    this.x = x;
    this.y = y;
    this.cnt = cnt;
  }
}