import java.util.*;
import java.io.*;

public class Main {
  public static int N, L, R;
  public static int[][] arr;
  public static boolean[][] visited;
  public static int[] dx = { 0, 1, 0, -1 };
  public static int[] dy = { 1, 0, -1, 0 };
  public static ArrayList<Node> unions;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    L = Integer.parseInt(st.nextToken());
    R = Integer.parseInt(st.nextToken());

    arr = new int[N][N];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int ans = 0;
    while (true) {
      // for (int i = 0; i < 1; i++) {
      visited = new boolean[N][N];
      if (!move())
        break;
      ans++;
    }

    System.out.println(ans);

  }

  public static boolean move() {
    boolean flag = false;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (!visited[i][j]) {
          if (bfs(i, j))
            flag = true;
        }
      }
    }
    return flag;
  }

  public static boolean bfs(int x, int y) {
    Queue<Node> q = new ArrayDeque<>();
    unions = new ArrayList<>();
    visited[x][y] = true;
    q.offer(new Node(x, y));
    unions.add(new Node(x, y));
    boolean flag = false;
    int sum = arr[x][y];

    while (!q.isEmpty()) {
      Node cur = q.poll();

      for (int i = 0; i < 4; i++) {
        int nx = cur.x + dx[i];
        int ny = cur.y + dy[i];

        if (check(nx, ny)) {
          if (!visited[nx][ny] && open(cur.x, cur.y, nx, ny)) {
            visited[nx][ny] = true;
            q.offer(new Node(nx, ny));
            unions.add(new Node(nx, ny));
            sum += arr[nx][ny];
          }
        }
      }
    }

    int population = 0;
    if (unions.size() >= 2) {
      flag = true;
      population = sum / unions.size();
      for (Node u : unions) {
        arr[u.x][u.y] = population;
      }
    }

    return flag;
  }

  public static boolean open(int x, int y, int xx, int yy) {
    int tmp = Math.abs(arr[x][y] - arr[xx][yy]);
    return (L <= tmp && tmp <= R);
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