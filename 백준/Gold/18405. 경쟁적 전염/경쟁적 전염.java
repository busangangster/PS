import java.util.*;
import java.io.*;

public class Main {
  public static int N, K, S, X, Y;
  public static int[][] arr;
  public static Node[][] copyArr;
  public static int[] dx = { 0, 1, 0, -1 };
  public static int[] dy = { 1, 0, -1, 0 };
  public static PriorityQueue<Node> pq = new PriorityQueue<>(((o1, o2) -> o1.num - o2.num));

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    arr = new int[N][N];
    copyArr = new Node[N][N];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        int tmp = Integer.parseInt(st.nextToken());
        if (tmp != 0) {
          pq.offer(new Node(i, j, tmp, 0));
        }
        arr[i][j] = tmp;
        copyArr[i][j] = new Node(i, j, tmp, 0);
      }
    }

    st = new StringTokenizer(br.readLine());
    S = Integer.parseInt(st.nextToken());
    X = Integer.parseInt(st.nextToken());
    Y = Integer.parseInt(st.nextToken());

    bfs();
    System.out.println(copyArr[X - 1][Y - 1].num);
  }

  public static void bfs() {
    while (!pq.isEmpty()) {
      Node cur = pq.poll();

      for (int i = 0; i < 4; i++) {
        int nx = cur.x + dx[i];
        int ny = cur.y + dy[i];

        if (check(nx, ny)) {
          if (arr[nx][ny] == 0) {
            if (copyArr[nx][ny].time == 0 || copyArr[nx][ny].time > cur.time + 1) {
              if (cur.time < S) {
                copyArr[nx][ny] = new Node(nx, ny, cur.num, cur.time + 1);
                pq.offer(new Node(nx, ny, cur.num, cur.time + 1));
              }
            }
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
  int num;
  int time;

  public Node(int x, int y, int num, int time) {
    this.x = x;
    this.y = y;
    this.num = num;
    this.time = time;
  }
}