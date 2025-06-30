import java.util.*;
import java.io.*;

public class Main {
  public static int N, answer;
  public static int[][] arr;
  public static boolean[][] visited;
  public static ArrayList<Node> selected = new ArrayList<>();
  public static int[] dx = { 0, 1, 0, -1 };
  public static int[] dy = { 1, 0, -1, 0 };

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    N = Integer.parseInt(br.readLine());
    arr = new int[N][N];
    answer = Integer.MAX_VALUE;

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    dfs(0);
    System.out.println(answer);
  }

  public static void dfs(int cnt) {
    if (cnt == 3) {
      // System.out.println(selected);
      int res = bfs();
      if (res != -1) {
        answer = Math.min(answer, res);
      }
      return;
    }

    for (int i = 1; i < N - 1; i++) {
      for (int j = 1; j < N - 1; j++) {
        selected.add(new Node(i, j));
        dfs(cnt + 1);
        selected.remove(selected.size() - 1);
      }
    }
  }

  public static int bfs() {
    int ans = 0;
    visited = new boolean[N][N];
    for (Node n : selected) {
      ans += arr[n.x][n.y];
      visited[n.x][n.y] = true;
      for (int i = 0; i < 4; i++) {
        int nx = n.x + dx[i];
        int ny = n.y + dy[i];
        if (visited[nx][ny]) {
          return -1;
        } else {
          visited[nx][ny] = true;
          ans += arr[nx][ny];
        }
      }
    }
    return ans;
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