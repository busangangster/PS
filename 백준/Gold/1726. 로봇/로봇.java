import java.util.*;
import java.io.*;

public class Main {
  public static int N, M, sx, sy, sd, tx, ty, td;
  public static int[][] arr;
  public static boolean[][][] visited;
  public static int[] dx = { 0, 0, 1, -1 }; 
  public static int[] dy = { 1, -1, 0, 0 };

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    arr = new int[N][M];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    visited = new boolean[N][M][4];

    st = new StringTokenizer(br.readLine());
    sx = Integer.parseInt(st.nextToken()) - 1;
    sy = Integer.parseInt(st.nextToken()) - 1;
    sd = Integer.parseInt(st.nextToken()) - 1;

    st = new StringTokenizer(br.readLine());
    tx = Integer.parseInt(st.nextToken()) - 1;
    ty = Integer.parseInt(st.nextToken()) - 1;
    td = Integer.parseInt(st.nextToken()) - 1;

    int res = bfs();
    System.out.println(res);

  }

  public static int bfs() {
    Queue<Node> q = new ArrayDeque<>();
    visited[sx][sy][sd] = true;
    q.offer(new Node(sx, sy, sd, 0));

    while (!q.isEmpty()) {
      Node cur = q.poll();

      if (reached(cur.x, cur.y, cur.direction)) {
        return cur.cnt;
      }

      int L = turnLeft(cur.direction);
      if (!visited[cur.x][cur.y][L]) {
        visited[cur.x][cur.y][L] = true;
        q.offer(new Node(cur.x, cur.y, L, cur.cnt + 1));
      }

      int R = turnRight(cur.direction);
      if (!visited[cur.x][cur.y][R]) {
        visited[cur.x][cur.y][R] = true;
        q.offer(new Node(cur.x, cur.y, R, cur.cnt + 1));
      }

      for (int i = 1; i <= 3; i++) {
        int nx = cur.x + dx[cur.direction] * i;
        int ny = cur.y + dy[cur.direction] * i;

        if (!check(nx, ny))
          break;
        if (arr[nx][ny] == 1)
          break;
        if (!visited[nx][ny][cur.direction]) {
          visited[nx][ny][cur.direction] = true;
          q.offer(new Node(nx, ny, cur.direction, cur.cnt + 1));
        }
      }
    }
    return -1;
  }

  public static int turnLeft(int d) {
    if (d == 0)
      return 3;
    else if (d == 1)
      return 2;
    else if (d == 2)
      return 0;
    return 1;

  }

  public static int turnRight(int d) {
    if (d == 0)
      return 2;
    else if (d == 1)
      return 3;
    else if (d == 2)
      return 1;
    return 0;
  }

  public static boolean reached(int x, int y, int d) {
    return (x == tx && y == ty && d == td);
  }

  public static boolean check(int x, int y) {
    return (0 <= x && x < N && 0 <= y && y < M);
  }
}

class Node {
  int x;
  int y;
  int direction;
  int cnt;

  public Node(int x, int y, int direction, int cnt) {
    this.x = x;
    this.y = y;
    this.direction = direction;
    this.cnt = cnt;
  }
}