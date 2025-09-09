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
    M = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());

    arr = new char[N][M];
    for (int i = 0; i < N; i++) {
      String s = br.readLine();
      for (int j = 0; j < M; j++) {
        char tmp = s.charAt(j);
        if (tmp == 'T') {
          sx = i;
          sy = j;
        } else if (tmp == 'E') {
          tx = i;
          ty = j;
        }
        arr[i][j] = tmp;
      }
    }

    INF = 9 * 250000 + 1;
    min_dis = new int[N][M];
    for (int[] m : min_dis) {
      Arrays.fill(m, INF);
    }

    dijkstra();

    System.out.println(min_dis[tx][ty] == INF ? -1 : min_dis[tx][ty]);

  }

  public static void dijkstra() {
    PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
    min_dis[sx][sy] = 0;
    pq.offer(new Node(sx, sy, 0));

    while (!pq.isEmpty()) {
      Node cur = pq.poll();

      if (min_dis[cur.x][cur.y] < cur.cost)
        continue;

      // System.out.println(cur.x + " " + cur.y);

      for (int i = 0; i < 4; i++) {
        int cx = cur.x;
        int cy = cur.y;
        int sum = 0;
        while (true) {
          int nx = cx + dx[i];
          int ny = cy + dy[i];

          if (!check(nx, ny)) {
            break;
          } else {
            if (arr[nx][ny] == 'H') {
              break;
            } else if (arr[nx][ny] == 'R') {
              if (min_dis[cx][cy] > cur.cost + sum) {
                min_dis[cx][cy] = cur.cost + sum;
                pq.offer(new Node(cx, cy, cur.cost + sum));
              }
              break;
            } else if (arr[nx][ny] == 'E') {
              if (min_dis[nx][ny] > cur.cost + sum) {
                min_dis[nx][ny] = cur.cost + sum;
              }
              break;
            } else {
              sum += arr[nx][ny] - '0';
            }
          }
          cx = nx;
          cy = ny;
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

  public Node(int x, int y, int cost) {
    this.x = x;
    this.y = y;
    this.cost = cost;
  }
}