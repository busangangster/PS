import java.util.*;
import java.io.*;

public class Main {
  public static int N;
  public static char[][] arr;
  public static boolean[][] visited;
  public static int[] dx = { 0, 1, 0, -1 };
  public static int[] dy = { 1, 0, -1, 0 };

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    N = Integer.parseInt(br.readLine());

    arr = new char[N][N];
    for (int i = 0; i < N; i++) {
      String s = br.readLine();
      for (int j = 0; j < N; j++) {
        arr[i][j] = s.charAt(j);
      }
    }

    int first = 0;
    visited = new boolean[N][N];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (!visited[i][j]) {
          bfs1(i, j);
          first++;
        }
      }
    }

    int second = 0;
    visited = new boolean[N][N];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (!visited[i][j]) {
          bfs2(i, j);
          second++;
        }
      }
    }

    System.out.println(second + " " + first);

  }

  public static void bfs1(int x, int y) {
    Queue<Node> q = new ArrayDeque<>();
    visited[x][y] = true;
    q.offer(new Node(x, y));

    while (!q.isEmpty()) {
      Node cur = q.poll();

      for (int i = 0; i < 4; i++) {
        int nx = cur.x + dx[i];
        int ny = cur.y + dy[i];

        if (check(nx, ny)) {
          if (!visited[nx][ny]) {
            if (arr[cur.x][cur.y] != 'B') {
              if (arr[nx][ny] == 'R' || arr[nx][ny] == 'G') {
                visited[nx][ny] = true;
                q.offer(new Node(nx, ny));
              }
            } else {
              if (arr[nx][ny] == 'B') {
                visited[nx][ny] = true;
                q.offer(new Node(nx, ny));
              }
            }
          }
        }
      }
    }
  }

  public static void bfs2(int x, int y) {
    Queue<Node> q = new ArrayDeque<>();
    visited[x][y] = true;
    q.offer(new Node(x, y));

    while (!q.isEmpty()) {
      Node cur = q.poll();

      for (int i = 0; i < 4; i++) {
        int nx = cur.x + dx[i];
        int ny = cur.y + dy[i];

        if (check(nx, ny)) {
          if (!visited[nx][ny]) {
            if (arr[cur.x][cur.y] == arr[nx][ny]) {
              q.offer(new Node(nx, ny));
              visited[nx][ny] = true;
            }
          }
        }
      }
    }
  }

  public static boolean check(int x, int y) {
    return (0 <= x && x < N && 0 <= y && y < N);
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