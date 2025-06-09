import java.util.*;
import java.io.*;

public class Main {
  public static int N, M, day;
  public static int[][] arr;
  public static boolean[][] visited;
  public static Queue<Node> q = new ArrayDeque<Node>();
  public static int[] dx = { 0, 1, 0, -1 };
  public static int[] dy = { 1, 0, -1, 0 };

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    M = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());
    day = 0;

    arr = new int[N][M];
    visited = new boolean[N][M];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        int tmp = Integer.parseInt(st.nextToken());
        if (tmp == 1) {
          q.offer(new Node(i, j, 0));
          visited[i][j] = true;
        } else if (tmp == -1) {
          visited[i][j] = true;
        }
        arr[i][j] = tmp;
      }
    }

    if (verify()) {
      System.out.println(0);
    } else {
      bfs();
      if (verify()) {
        System.out.println(day);
      } else {
        System.out.println(-1);
      }
    }
  }

  public static void bfs() {

    while (!q.isEmpty()) {
      Node cur = q.poll();

      day = cur.cnt;

      for (int i = 0; i < 4; i++) {
        int nx = cur.x + dx[i];
        int ny = cur.y + dy[i];

        if (check(nx, ny)) {
          if (!visited[nx][ny]) {
            if (arr[nx][ny] == 0) {
              visited[nx][ny] = true;
              q.offer(new Node(nx, ny, cur.cnt + 1));
            }
          }
        }
      }
    }
  }

  public static boolean check(int x, int y) {
    return (0 <= x && x < N && 0 <= y && y < M);
  }

  public static boolean verify() {
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (!visited[i][j]) {
          return false;
        }
      }
    }
    return true;
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