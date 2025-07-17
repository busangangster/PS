import java.util.*;
import java.io.*;

public class Main {
  public static int H, W, sx, sy, ex, ey;
  public static char[][] arr;
  public static int[][] nextWall;
  public static int[][] min_dis;
  public static int[] dx = { 0, 1, 0, -1 };
  public static int[] dy = { 1, 0, -1, 0 };

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    H = Integer.parseInt(st.nextToken());
    W = Integer.parseInt(st.nextToken());

    arr = new char[H][W];
    nextWall = new int[H][W];
    min_dis = new int[H][W];

    for (int[] m : min_dis) {
      Arrays.fill(m, 50000);
    }

    for (int i = 0; i < H; i++) {
      String s = br.readLine();
      for (int j = 0; j < W; j++) {
        char tmp = s.charAt(j);
        if (tmp == 'S') {
          sx = i;
          sy = j;
        } else if (tmp == 'E') {
          ex = i;
          ey = j;
        }
        arr[i][j] = tmp;
      }
    }

    for (int i = 0; i < H; i++) {
      for (int j = 0; j < W; j++) {
        if (arr[i][j] != '#') {
          isNextWall(i, j);
        }
      }
    }

    dijkstra();

    System.out.println(min_dis[ex][ey]);

  }

  public static void isNextWall(int x, int y) {
    for (int i = 0; i < 4; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];

      if (check(nx, ny)) {
        if (arr[nx][ny] == '#') {
          nextWall[x][y] = 1;
          return;
        }
      }
    }
  }

  public static void dijkstra() {
    PriorityQueue<Node> pq = new PriorityQueue<Node>((o1, o2) -> o1.cost - o2.cost);
    min_dis[sx][sy] = 0;
    pq.offer(new Node(sx, sy, 0));

    while (!pq.isEmpty()) {
      Node cur = pq.poll();

      if (min_dis[cur.x][cur.y] < cur.cost)
        continue;

      for (int i = 0; i < 4; i++) {
        int nx = cur.x + dx[i];
        int ny = cur.y + dy[i];

        if (check(nx, ny)) {
          if (arr[nx][ny] != '#') {
            int w = (nextWall[cur.x][cur.y] == 1 && nextWall[nx][ny] == 1) ? 0 : 1;
            if (min_dis[nx][ny] > cur.cost + w) {
              min_dis[nx][ny] = cur.cost + w;
              pq.offer(new Node(nx, ny, cur.cost + w));
            }
          }
        }
      }
    }
  }

  public static boolean check(int x, int y) {
    return (0 <= x && x < H && 0 <= y && y < W);
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