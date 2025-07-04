import java.util.*;
import java.io.*;

public class Main {
  public static int N, number, ans;
  public static int[][] arr, island;
  public static int[] dx = { 0, 1, 0, -1 };
  public static int[] dy = { 1, 0, -1, 0 };
  public static boolean[][] visited;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    N = Integer.parseInt(br.readLine());

    arr = new int[N][N];
    island = new int[N][N];
    number = 1;
    ans = Integer.MAX_VALUE;

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    makeIsland();
    makeBridge();
    System.out.println(ans);
  }

  public static void makeBridge() {
    for (int i = 1; i <= number; i++) {
      bridge(i);
    }
  }

  public static void bridge(int target) {
    Queue<Node> q = new ArrayDeque<>();
    visited = new boolean[N][N];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (island[i][j] == target) {
          visited[i][j] = true;
          q.offer(new Node(i, j, 0));
        }
      }
    }

    while (!q.isEmpty()) {
      Node cur = q.poll();

      for (int i = 0; i < 4; i++) {
        int nx = cur.x + dx[i];
        int ny = cur.y + dy[i];

        if (check(nx, ny) && !visited[nx][ny]) {
          if (island[nx][ny] == 0) {
            q.offer(new Node(nx, ny, cur.dis + 1));
            visited[nx][ny] = true;
          } else if (island[nx][ny] != target) {
            ans = Math.min(ans, cur.dis);
            return;
          }
        }
      }
    }
  }

  public static void makeIsland() {
    visited = new boolean[N][N];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (arr[i][j] == 1 && !visited[i][j]) {
          bfs(i, j);
          number++;
        }
      }
    }
  }

  public static void bfs(int x, int y) {
    Queue<Node> q = new ArrayDeque<>();
    visited[x][y] = true;
    island[x][y] = number;
    q.offer(new Node(x, y, 0));

    while (!q.isEmpty()) {
      Node cur = q.poll();

      for (int i = 0; i < 4; i++) {
        int nx = cur.x + dx[i];
        int ny = cur.y + dy[i];

        if (check(nx, ny) && !visited[nx][ny]) {
          if (arr[nx][ny] == 1) {
            island[nx][ny] = number;
            q.offer(new Node(nx, ny, 0));
            visited[nx][ny] = true;
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
  int dis;

  public Node(int x, int y, int dis) {
    this.x = x;
    this.y = y;
    this.dis = dis;
  }
}