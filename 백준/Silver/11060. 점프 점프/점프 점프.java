import java.util.*;
import java.io.*;

public class Main {
  public static int N, INF;
  public static int[] arr, min_dis;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    N = Integer.parseInt(br.readLine());
    arr = new int[N];
    min_dis = new int[N];

    INF = 1000 * 100 + 1;
    Arrays.fill(min_dis, INF);

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    move();
    System.out.println(min_dis[N - 1] == INF ? -1 : min_dis[N - 1]);

  }

  public static void move() {
    PriorityQueue<Node> pq = new PriorityQueue<Node>((o1, o2) -> o1.cost - o2.cost);
    min_dis[0] = 0;
    pq.offer(new Node(0, 0));

    while (!pq.isEmpty()) {
      Node cur = pq.poll();

      if (min_dis[cur.node] < cur.cost)
        continue;

      for (int i = 1; i <= arr[cur.node]; i++) {
        int next = cur.node + i;
        if (check(next)) {
          if (min_dis[next] > cur.cost + 1) {
            min_dis[next] = cur.cost + 1;
            pq.offer(new Node(next, cur.cost + 1));
          }
        }
      }
    }
  }

  public static boolean check(int x) {
    return (0 <= x && x < N);
  }
}

class Node {
  int node;
  int cost;

  public Node(int node, int cost) {
    this.node = node;
    this.cost = cost;
  }
}