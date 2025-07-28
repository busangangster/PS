import java.util.*;
import java.io.*;

public class Main {
  public static int N, M, T;
  public static int[][] arr;
  public static boolean[][][] visited;
  public static int[] dx = { 0, 1, 0, -1 };
  public static int[] dy = { 1, 0, -1, 0 };

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    T = Integer.parseInt(st.nextToken());

    arr = new int[N][M];
    visited = new boolean[N][M][2];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int res = bfs();

    System.out.println(res == -1 ? "Fail" : res);

  }

  public static int bfs() {
    Queue<Node> q = new ArrayDeque<>();
    if (arr[0][0] == 2) {
      visited[0][0][1] = true;
      q.offer(new Node(0, 0, 0, true));
    } else {
      visited[0][0][0] = true;
      q.offer(new Node(0, 0, 0, false));
    }

    while (!q.isEmpty()) {
      Node cur = q.poll();

      if (cur.x == N - 1 && cur.y == M - 1 && cur.time <= T) {
        return cur.time;
      }

      for (int i = 0; i < 4; i++) {
        int nx = cur.x + dx[i];
        int ny = cur.y + dy[i];

        if (check(nx, ny)) {
          if (arr[nx][ny] == 1) {
            if (cur.sword) {
              if (!visited[nx][ny][1]) {
                visited[nx][ny][1] = true;
                q.offer(new Node(nx, ny, cur.time + 1, cur.sword));
              }
            }
          } else if (arr[nx][ny] == 0) {
            if (cur.sword) {
              if (!visited[nx][ny][1]) {
                visited[nx][ny][1] = true;
                q.offer(new Node(nx, ny, cur.time + 1, cur.sword));
              }
            } else {
              if (!visited[nx][ny][0]) {
                visited[nx][ny][0] = true;
                q.offer(new Node(nx, ny, cur.time + 1, cur.sword));
              }
            }
          } else {
            if (!visited[nx][ny][0]) {
              visited[nx][ny][0] = true;
              q.offer(new Node(nx, ny, cur.time + 1, true));
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
  int time;
  boolean sword;

  public Node(int x, int y, int time, boolean sword) {
    this.x = x;
    this.y = y;
    this.time = time;
    this.sword = sword;
  }
}