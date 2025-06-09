import java.util.*;
import java.io.*;

public class Main {
  public static int M, N, H, ans, immature;
  public static int[][][] arr;
  public static int[] dx = { 0, 1, 0, -1, 0, 0 };
  public static int[] dy = { 1, 0, -1, 0, 0, 0 };
  public static int[] dh = { 0, 0, 0, 0, 1, -1 };
  public static Queue<Node> q = new ArrayDeque<Node>();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    M = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());
    H = Integer.parseInt(st.nextToken());

    arr = new int[N][M][H];
    ans = 0;
    immature = 0;

    for (int k = 0; k < H; k++) {
      for (int i = 0; i < N; i++) {
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < M; j++) {
          int tmp = Integer.parseInt(st.nextToken());
          if (tmp == 1) {
            q.offer(new Node(i, j, k, 0));
          } else if (tmp == 0) {
            immature++;
          }
          arr[i][j][k] = tmp;
        }
      }
    }

    if (immature == 0) {
      System.out.println(0);
      return;
    }

    bfs();

    if (immature == 0) {
      System.out.println(ans);
    } else {
      System.out.println(-1);
    }

  }

  public static void bfs() {
    while (!q.isEmpty()) {
      Node cur = q.poll();

      ans = cur.cnt;

      for (int i = 0; i < 6; i++) {
        int nx = cur.x + dx[i];
        int ny = cur.y + dy[i];
        int nh = cur.h + dh[i];

        if (check(nx, ny, nh)) {
          if (arr[nx][ny][nh] == 0) {
            arr[nx][ny][nh] = 1;
            q.offer(new Node(nx, ny, nh, cur.cnt + 1));
            immature--;
          }
        }
      }
    }
  }

  public static boolean check(int x, int y, int h) {
    return (0 <= x && x < N && 0 <= y && y < M && 0 <= h && h < H);
  }
}

class Node {
  int x;
  int y;
  int h;
  int cnt;

  public Node(int x, int y, int h, int cnt) {
    this.x = x;
    this.y = y;
    this.h = h;
    this.cnt = cnt;
  }
}