import java.util.*;
import java.io.*;

public class Main {
  public static int N, M, INF, tx, ty, sx, sy;
  public static char[][] arr;
  public static int[][][] min_dis;
  public static int[] dx = { -1, 0, 1, 0 };
  public static int[] dy = { 0, -1, 0, 1 };
  public static PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    M = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());

    arr = new char[N][M];
    min_dis = new int[N][M][4];

    INF = 100 * 100 + 1;
    int num = 1;

    for (int i = 0; i < N; i++) {
      String s = br.readLine();
      for (int j = 0; j < M; j++) {
        char tmp = s.charAt(j);
        if (tmp == 'C') {
          if (num == 1) {
            sx = i;
            sy = j;
          } else {
            tx = i;
            ty = j;
          }
          num++;
        }
        arr[i][j] = tmp;
      }
    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        Arrays.fill(min_dis[i][j], INF);
      }
    }
    min_dis[sx][sy][0] = 0;
    for (int i = 0; i < 4; i++) {
      int nx = sx + dx[i];
      int ny = sy + dy[i];
      if (check(nx, ny)) {
        if (arr[nx][ny] != '*') {
          pq.offer(new Node(nx, ny, 0, i));
        }
      }
    }

    dijkstra();

    System.out.println(Arrays.stream(min_dis[tx][ty]).min().getAsInt());

  }

  public static void dijkstra() {

    while (!pq.isEmpty()) {
      Node cur = pq.poll();

      if (min_dis[cur.x][cur.y][cur.d] < cur.cost)
        continue;

      for (int i = 0; i < 4; i++) {
        int nx = cur.x + dx[i];
        int ny = cur.y + dy[i];

        if (check(nx, ny)) {
          if (arr[nx][ny] != '*') {
            if ((cur.d + 2) % 4 == i)
              continue;
            if (cur.d == i) {
              if (min_dis[nx][ny][i] > cur.cost) {
                min_dis[nx][ny][i] = cur.cost;
                pq.offer(new Node(nx, ny, cur.cost, i));
              }
            } else {
              if (min_dis[nx][ny][i] > cur.cost + 1) {
                min_dis[nx][ny][i] = cur.cost + 1;
                pq.offer(new Node(nx, ny, cur.cost + 1, i));
              }
            }
          }
        }
      }
    }

  }

  public static boolean check(int x, int y) {
    return (0 <= x && x < N && 0 <= y && y < M);
  }
}

class Node {
  int x;
  int y;
  int cost;
  int d;

  public Node(int x, int y, int cost, int d) {
    this.x = x;
    this.y = y;
    this.cost = cost;
    this.d = d;
  }
}