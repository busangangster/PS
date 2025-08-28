import java.util.*;
import java.io.*;

public class Main {
  public static int N, sx, sy, ans, sharkSize, exp, distance;
  public static int[][] arr;
  public static int[] dx = { 0, 1, 0, -1 };
  public static int[] dy = { 1, 0, -1, 0 };
  public static boolean[][] visited;
  public static PriorityQueue<Node> pq;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    N = Integer.parseInt(br.readLine());

    arr = new int[N][N];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        int tmp = Integer.parseInt(st.nextToken());
        if (tmp == 9) {
          sx = i;
          sy = j;
          arr[i][j] = 0;
        } else {
          arr[i][j] = tmp;
        }
      }
    }
    
    ans = 0;
    sharkSize = 2;
    exp = 0;
    play();
  }

  public static void play() {
    while (true) {
      pq = new PriorityQueue<Node>();
      getDistance();
      if (pq.isEmpty()) {
        System.out.println(ans);
        break;
      } else {
        Node tmp = pq.poll();
        sx = tmp.x;
        sy = tmp.y;
        exp++;
        ans += tmp.dis;
        if (exp == sharkSize) {
          exp = 0;
          sharkSize++;
        }
        arr[tmp.x][tmp.y] = 0;
      }
    }
  }

  public static void getDistance() {
    visited = new boolean[N][N];

    Queue<int[]> q = new ArrayDeque<>();
    q.offer(new int[] { sx, sy, 0, 0 });
    visited[sx][sy] = true;

    while (!q.isEmpty()) {
      int[] cur = q.poll();

      if (arr[cur[0]][cur[1]] != 0 && arr[cur[0]][cur[1]] < sharkSize) {
        pq.offer(new Node(cur[0], cur[1], arr[cur[0]][cur[1]], cur[3]));
      }

      for (int i = 0; i < 4; i++) {
        int nx = cur[0] + dx[i];
        int ny = cur[1] + dy[i];

        if (check(nx, ny)) {
          if (!visited[nx][ny] && arr[nx][ny] <= sharkSize) {
            visited[nx][ny] = true;
            q.offer(new int[] { nx, ny, arr[cur[0]][cur[1]], cur[3] + 1 });
          }
        }
      }
    }
  }

  public static boolean check(int x, int y) {
    return (0 <= x && x < N && 0 <= y && y < N);
  }
}

class Node implements Comparable<Node> {
  int x;
  int y;
  int size;
  int dis;

  public Node(int x, int y, int size, int dis) {
    this.x = x;
    this.y = y;
    this.size = size;
    this.dis = dis;
  }

  @Override
  public int compareTo(Node o) {
    if (this.dis == o.dis) {
      if (this.x == o.x) {
        return this.y - o.y;
      }
      return this.x - o.x;
    }
    return this.dis - o.dis;
  }
}