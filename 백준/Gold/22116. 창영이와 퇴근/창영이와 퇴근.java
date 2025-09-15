import java.util.*;
import java.io.*;

public class Main {
  public static int N;
  public static long INF;
  public static int[][] arr;
  public static long[][] min_dis;
  public static int[] dx = { 0, 1, 0, -1 };
  public static int[] dy = { 1, 0, -1, 0 };

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    N = Integer.parseInt(br.readLine());

    arr = new int[N][N];
    min_dis = new long[N][N];

    INF = 1000000000L * 1000L + 1L;

    for (int i = 0; i < N; i++) {
      Arrays.fill(min_dis[i], INF);
    }

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    dijkstra();

    System.out.println(min_dis[N - 1][N - 1]);

  }

  public static void dijkstra() {
    PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> (int) (o1.cost - o2.cost));
    min_dis[0][0] = 0;
    pq.offer(new Node(0, 0, 0));

    while (!pq.isEmpty()) {
      Node cur = pq.poll();

      if (min_dis[cur.x][cur.y] < cur.cost)
        continue;

      for (int i = 0; i < 4; i++) {
        int nx = cur.x + dx[i];
        int ny = cur.y + dy[i];

        if (check(nx, ny)) {
          long diff = Math.abs(arr[cur.x][cur.y] - arr[nx][ny]);
          long nextCost = Math.max(diff, cur.cost);
          if (min_dis[nx][ny] > nextCost) {
            min_dis[nx][ny] = nextCost;
            pq.offer(new Node(nx, ny, nextCost));
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
  long cost;

  public Node(int x, int y, long cost) {
    this.x = x;
    this.y = y;
    this.cost = cost;
  }
}