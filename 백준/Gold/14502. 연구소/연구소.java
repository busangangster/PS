import java.util.*;
import java.io.*;

public class Main {
  public static int N, M, max_v;
  public static int[][] arr;
  public static boolean[][] visited;
  public static ArrayList<Node> virus = new ArrayList<>();
  public static int[] dx = { 0, 1, 0, -1 };
  public static int[] dy = { 1, 0, -1, 0 };

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    arr = new int[N][M];
    max_v = Integer.MIN_VALUE;

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        int tmp = Integer.parseInt(st.nextToken());
        if (tmp == 2)
          virus.add(new Node(i, j));
        arr[i][j] = tmp;
      }
    }

    dfs(0);
    System.out.println(max_v);

  }

  public static void dfs(int cnt) {
    if (cnt == 3) {
      bfs();
      int res = countUp();
      max_v = Math.max(res, max_v);
      return;
    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (arr[i][j] == 0) {
          arr[i][j] = 1;
          dfs(cnt + 1);
          arr[i][j] = 0;
        }
      }
    }
  }

  public static void bfs() {
    Queue<Node> q = new ArrayDeque<>();
    visited = new boolean[N][M];

    for (Node v : virus) {
      visited[v.x][v.y] = true;
      q.offer(new Node(v.x, v.y));
    }

    while (!q.isEmpty()) {
      Node cur = q.poll();

      for (int i = 0; i < 4; i++) {
        int nx = cur.x + dx[i];
        int ny = cur.y + dy[i];

        if (check(nx, ny)) {
          if (!visited[nx][ny] && arr[nx][ny] == 0) {
            visited[nx][ny] = true;
            q.offer(new Node(nx, ny));
          }
        }
      }
    }
  }

  public static int countUp() {
    int ans = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (arr[i][j] == 0 && !visited[i][j])
          ans++;
      }
    }
    return ans;
  }

  public static boolean check(int x, int y) {
    return (0 <= x && x < N && 0 <= y && y < M);
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