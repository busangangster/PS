import java.util.*;
import java.io.*;

public class Main {
  public static int N, INF;
  public static int[][] arr;
  public static int[][] min_dis;
  public static int[] dx = { 0, 1, 0, -1 };
  public static int[] dy = { 1, 0, -1, 0 };

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    int cnt = 1;

    while (true) {
      N = Integer.parseInt(br.readLine());
      if (N == 0)
        break;

      arr = new int[N][N];
      min_dis = new int[N][N];
      INF = 9 * 125 * 125 + 1;
      for (int[] m : min_dis) {
        Arrays.fill(m, INF);
      }

      for (int i = 0; i < N; i++) {
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < N; j++) {
          arr[i][j] = Integer.parseInt(st.nextToken());
        }
      }

      dijkstra();
      sb.append("Problem " + cnt + ": " + min_dis[N - 1][N - 1]).append("\n");
      cnt++;
    }

    System.out.println(sb);

  }

  public static void dijkstra() {
    PriorityQueue<Node> pq = new PriorityQueue<Node>((o1, o2) -> o1.cost - o2.cost);
    min_dis[0][0] = arr[0][0];
    pq.offer(new Node(0, 0, arr[0][0]));

    while (!pq.isEmpty()) {
      Node cur = pq.poll();

      if (min_dis[cur.x][cur.y] < cur.cost)
        continue;

      for (int i = 0; i < 4; i++) {
        int nx = cur.x + dx[i];
        int ny = cur.y + dy[i];

        if (check(nx, ny)) {
          if (min_dis[nx][ny] > cur.cost + arr[nx][ny]) {
            min_dis[nx][ny] = cur.cost + arr[nx][ny];
            pq.offer(new Node(nx, ny, cur.cost + arr[nx][ny]));
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
  int cost;

  public Node(int x, int y, int cost) {
    this.x = x;
    this.y = y;
    this.cost = cost;
  }
}