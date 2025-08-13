import java.util.*;
import java.io.*;

public class Main {
  public static int N, M, ans;
  public static int[][] arr;
  public static int blank = 0;
  public static int[] dx = { 0, 1, 0, -1 };
  public static int[] dy = { 1, 0, -1, 0 };
  public static int[] selected;
  public static ArrayList<Virus> virus = new ArrayList<Virus>();
  public static Queue<Node> q = new ArrayDeque<>();
  public static boolean[][] visited;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    arr = new int[N][N];
    selected = new int[M];
    ans = Integer.MAX_VALUE;

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        int tmp = Integer.parseInt(st.nextToken());
        if (tmp == 2) {
          virus.add(new Virus(i, j));
          blank++;
        } else if (tmp == 0) {
          blank++;
        }

        arr[i][j] = tmp;

      }
    }

    DFS(0, 0);
    System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);

  }

  public static void DFS(int start, int cnt) {
    if (cnt == M) {
      visited = new boolean[N][N];
      for (int i = 0; i < M; i++) {
        int x = virus.get(selected[i]).x;
        int y = virus.get(selected[i]).y;
        q.offer(new Node(x, y, 0));
        visited[x][y] = true;
      }
      int res = BFS();
      if (res != -1)
        ans = Math.min(ans, res);
      return;
    }

    for (int i = start; i < virus.size(); i++) {
      selected[cnt] = i;
      DFS(i + 1, cnt + 1);
    }
  }

  public static int BFS() {
    int curTime = 0;
    while (!q.isEmpty()) {
      Node cur = q.poll();

      curTime = Math.max(curTime, cur.time);

      for (int i = 0; i < 4; i++) {
        int nx = cur.x + dx[i];
        int ny = cur.y + dy[i];

        if (check(nx, ny)) {
          if (!visited[nx][ny] && arr[nx][ny] != 1) {
            visited[nx][ny] = true;
            q.offer(new Node(nx, ny, cur.time + 1));
          }
        }
      }
    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (!visited[i][j] && arr[i][j] != 1) {
          return -1;
        }
      }
    }
    return curTime;
  }

  public static boolean check(int x, int y) {
    return (0 <= x && x < N && 0 <= y && y < N);
  }
}

class Node {
  int x;
  int y;
  int time;

  public Node(int x, int y, int time) {
    this.x = x;
    this.y = y;
    this.time = time;
  }
}

class Virus {
  int x;
  int y;

  public Virus(int x, int y) {
    this.x = x;
    this.y = y;
  }
}