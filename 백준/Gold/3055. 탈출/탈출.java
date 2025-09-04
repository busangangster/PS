import java.util.*;
import java.io.*;

public class Main {
  public static int N, M, sx, sy, tx, ty;
  public static char[][] arr;
  public static int[][] time;
  public static boolean[][] visited;
  public static Queue<Node> water = new ArrayDeque<Node>();
  public static int[] dx = { 0, 1, 0, -1 };
  public static int[] dy = { 1, 0, -1, 0 };

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    arr = new char[N][M];
    time = new int[N][M];

    for (int[] t : time) {
      Arrays.fill(t, 100000);
    }

    visited = new boolean[N][M];

    for (int i = 0; i < N; i++) {
      String s = br.readLine();
      for (int j = 0; j < M; j++) {
        char tmp = s.charAt(j);
        if (tmp == '*') {
          water.add(new Node(i, j, 0));
          visited[i][j] = true;
        } else if (tmp == 'D') {
          tx = i;
          ty = j;
        } else if (tmp == 'S') {
          sx = i;
          sy = j;
        }
        arr[i][j] = tmp;
      }
    }

    waterMove();
    visited = new boolean[N][M];
    int res = move();

    System.out.println(res == -1 ? "KAKTUS" : res);

  }

  public static void waterMove() {
    while (!water.isEmpty()) {
      Node cur = water.poll();

      for (int i = 0; i < 4; i++) {
        int nx = cur.x + dx[i];
        int ny = cur.y + dy[i];

        if (check(nx, ny)) {
          if (!visited[nx][ny] && arr[nx][ny] != 'X' && arr[nx][ny] != 'D') {
            visited[nx][ny] = true;
            time[nx][ny] = cur.t + 1;
            water.add(new Node(nx, ny, cur.t + 1));
          }
        }
      }
    }
  }

  public static int move() {
    Queue<Node> q = new ArrayDeque<>();
    q.offer(new Node(sx, sy, 0));
    visited[sx][sy] = true;

    while (!q.isEmpty()) {
      Node cur = q.poll();

      if (cur.x == tx && cur.y == ty) {
        return cur.t;
      }

      for (int i = 0; i < 4; i++) {
        int nx = cur.x + dx[i];
        int ny = cur.y + dy[i];

        if (check(nx, ny)) {
          if (!visited[nx][ny] && arr[nx][ny] != 'X' && arr[nx][ny] != '*') {
            if (cur.t + 1 < time[nx][ny]) {
              q.offer(new Node(nx, ny, cur.t + 1));
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
  int t;

  public Node(int x, int y, int t) {
    this.x = x;
    this.y = y;
    this.t = t;
  }
}