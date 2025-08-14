import java.util.*;
import java.io.*;

public class Main {
  public static int N, K, S, X, Y;
  public static int[][] arr;
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

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        int tmp = Integer.parseInt(st.nextToken());
        if (tmp != 0) {
          pq.offer(new Node(i, j, tmp));
        }
        arr[i][j] = tmp;
      }
    }

    st = new StringTokenizer(br.readLine());
    S = Integer.parseInt(st.nextToken());
    X = Integer.parseInt(st.nextToken());
    Y = Integer.parseInt(st.nextToken());

    while (S-- > 0) {
      bfs();
    }

    System.out.println(arr[X - 1][Y - 1]);
  }

  public static void bfs() {
    ArrayList<Node> virus = new ArrayList<>();

    while (!pq.isEmpty()) {
      Node cur = pq.poll();

      for (int i = 0; i < 4; i++) {
        int nx = cur.x + dx[i];
        int ny = cur.y + dy[i];

        if (check(nx, ny)) {
          if (arr[nx][ny] == 0) {
            virus.add(new Node(nx, ny, cur.num));
            arr[nx][ny] = cur.num;
          }
        }
      }
    }

    for (Node tmp : virus) {
      pq.offer(tmp);
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

  public Node(int x, int y, int num) {
    this.x = x;
    this.y = y;
    this.num = num;
  }
}