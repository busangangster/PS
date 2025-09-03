import java.util.*;
import java.io.*;

public class Main {
  public static int N, M, ans, space, emptyCnt;
  public static int[][] arr;
  public static int[] dx = { 0, 1, 0, -1 };
  public static int[] dy = { 1, 0, -1, 0 };
  public static ArrayList<Node> virus = new ArrayList<>();
  public static Queue<Node> q;
  public static boolean[][] visited;
  public static boolean[] selected;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    arr = new int[N][N];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        int tmp = Integer.parseInt(st.nextToken());
        if (tmp == 2) {
          virus.add(new Node(i, j, 0));
        } else if (tmp == 0)
          space++;
        arr[i][j] = tmp;
      }
    }
    selected = new boolean[virus.size()];
    ans = Integer.MAX_VALUE;

    if (space == 0) {
      System.out.println(0);
    } else {
      dfs(0, 0);
      System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }

  }

  public static void dfs(int start, int cnt) {
    if (cnt == M) {
      emptyCnt = space;
      q = new ArrayDeque<>();
      visited = new boolean[N][N];

      for (int i = 0; i < virus.size(); i++) {
        if (selected[i]) {
          Node cur = virus.get(i);
          q.offer(new Node(cur.x, cur.y, 0));
          visited[cur.x][cur.y] = true;
        }
      }

      bfs();
      return;
    }

    for (int i = start; i < virus.size(); i++) {
      selected[i] = true;
      dfs(i + 1, cnt + 1);
      selected[i] = false;
    }
  }

  public static void bfs() {

    while (!q.isEmpty()) {
      Node cur = q.poll();

      for (int i = 0; i < 4; i++) {
        int nx = cur.x + dx[i];
        int ny = cur.y + dy[i];

        if (check(nx, ny)) {
          if (!visited[nx][ny] && arr[nx][ny] != 1) {
            if (arr[nx][ny] == 0) {
              emptyCnt--;
            }

            if (emptyCnt == 0) {
              ans = Math.min(ans, cur.cnt + 1);
              return;
            }
            q.offer(new Node(nx, ny, cur.cnt + 1));
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
  int cnt;

  public Node(int x, int y, int cnt) {
    this.x = x;
    this.y = y;
    this.cnt = cnt;
  }
}