import java.util.*;
import java.io.*;

public class Main {
  public static int R, C, jx, jy;
  public static char[][] arr;
  public static int[][] times;
  public static int[] dx = { 0, 1, 0, -1 };
  public static int[] dy = { 1, 0, -1, 0 };
  public static boolean[][] visited;
  public static ArrayList<Node> fires = new ArrayList<Node>();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    R = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());

    arr = new char[R][C];
    times = new int[R][C];
    for (int[] t : times) {
      Arrays.fill(t, 1000001);
    }

    for (int i = 0; i < R; i++) {
      String s = br.readLine();
      for (int j = 0; j < C; j++) {
        char tmp = s.charAt(j);
        if (tmp == 'J') {
          jx = i;
          jy = j;
        } else if (tmp == 'F') {
          fires.add(new Node(i, j, 0));
        }
        arr[i][j] = tmp;
      }
    }

    fireMove();
    int res = Jihoon();

    System.out.println(res == -1 ? "IMPOSSIBLE" : res);
  }

  public static int Jihoon() {
    Queue<Node> q = new ArrayDeque<>();
    visited = new boolean[R][C];
    q.offer(new Node(jx, jy, 0));
    visited[jx][jy] = true;

    while (!q.isEmpty()) {
      Node cur = q.poll();

      if (escape(cur.x, cur.y)) {
        return cur.t + 1;
      }

      for (int i = 0; i < 4; i++) {
        int nx = cur.x + dx[i];
        int ny = cur.y + dy[i];

        if (check(nx, ny)) {
          if (!visited[nx][ny] && arr[nx][ny] == '.') {
            if (cur.t + 1 < times[nx][ny]) {
              q.offer(new Node(nx, ny, cur.t + 1));
              visited[nx][ny] = true;
            }
          }
        }
      }
    }
    return -1;
  }

  public static void fireMove() {
    Queue<Node> q = new ArrayDeque<>();
    visited = new boolean[R][C];
    for (Node f : fires) {
      visited[f.x][f.y] = true;
      q.offer(new Node(f.x, f.y, 0));
      times[f.x][f.y] = 0;
    }

    while (!q.isEmpty()) {
      Node cur = q.poll();

      for (int i = 0; i < 4; i++) {
        int nx = cur.x + dx[i];
        int ny = cur.y + dy[i];

        if (check(nx, ny)) {
          if (!visited[nx][ny] && arr[nx][ny] != '#') {
            times[nx][ny] = cur.t + 1;
            q.offer(new Node(nx, ny, cur.t + 1));
            visited[nx][ny] = true;
          }
        }
      }
    }
  }

  public static boolean escape(int x, int y) {
    return (x == 0 || x == R - 1 || y == 0 || y == C - 1);
  }

  public static boolean check(int x, int y) {
    return (0 <= x && x < R && 0 <= y && y < C);
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