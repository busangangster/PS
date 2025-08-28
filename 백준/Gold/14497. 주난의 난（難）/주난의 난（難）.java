import java.util.*;
import java.io.*;

public class Main {
  public static int N, M, INF, sx, sy, tx, ty;
  public static char[][] arr;
  public static int[][] min_dis;
  public static int[] dx = { 0, 1, 0, -1 };
  public static int[] dy = { 1, 0, -1, 0 };

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    INF = 300 * 300 + 1;
    min_dis = new int[N][M];
    for (int[] m : min_dis) {
      Arrays.fill(m, INF);
    }

    st = new StringTokenizer(br.readLine());
    sx = Integer.parseInt(st.nextToken()) - 1;
    sy = Integer.parseInt(st.nextToken()) - 1;
    tx = Integer.parseInt(st.nextToken()) - 1;
    ty = Integer.parseInt(st.nextToken()) - 1;

    arr = new char[N][M];
    for (int i = 0; i < N; i++) {
      String s = br.readLine();
      for (int j = 0; j < M; j++) {
        arr[i][j] = s.charAt(j);
      }
    }
    // int res = dijkstra();
    dijkstra();
    System.out.println(min_dis[tx][ty]);
  }

  public static void dijkstra() {
    PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
    min_dis[sx][sy] = 0;
    pq.offer(new Node(sx, sy, 0));

    while (!pq.isEmpty()) {
      Node cur = pq.poll();

      if (min_dis[cur.x][cur.y] < cur.cost)
        continue;

      // if (cur.x == tx && cur.y == ty) {
      // return cur.cost;
      // }

      for (int i = 0; i < 4; i++) {
        int nx = cur.x + dx[i];
        int ny = cur.y + dy[i];

        if (check(nx, ny)) {
          if (arr[nx][ny] == '1' || arr[nx][ny] == '#') {
            if (min_dis[nx][ny] > cur.cost + 1) {
              min_dis[nx][ny] = cur.cost + 1;
              pq.offer(new Node(nx, ny, cur.cost + 1));
            }
          } else {
            if (min_dis[nx][ny] > cur.cost) {
              min_dis[nx][ny] = cur.cost;
              pq.offer(new Node(nx, ny, cur.cost));
            }
          }
        }
      }

    }
    // return -1;
  }

  public static boolean check(int x, int y) {
    return (0 <= x && x < N && 0 <= y && y < M);
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