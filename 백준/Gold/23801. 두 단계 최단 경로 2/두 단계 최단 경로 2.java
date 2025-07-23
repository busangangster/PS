import java.util.*;
import java.io.*;

public class Main {
  public static int N, M, X, Z;
  public static long INF;
  public static int[] dots;
  public static long[] min_dis1;
  public static long[] min_dis2;
  public static ArrayList<ArrayList<Node>> arr = new ArrayList<ArrayList<Node>>();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    for (int i = 0; i <= N; i++) {
      arr.add(new ArrayList<>());
    }
    INF = 300000L * 1000000L + 1L;
    min_dis1 = new long[N + 1];
    min_dis2 = new long[N + 1];

    Arrays.fill(min_dis1, INF);
    Arrays.fill(min_dis2, INF);

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      arr.get(a).add(new Node(b, c));
      arr.get(b).add(new Node(a, c));
    }

    st = new StringTokenizer(br.readLine());
    X = Integer.parseInt(st.nextToken());
    Z = Integer.parseInt(st.nextToken());

    int P = Integer.parseInt(br.readLine());
    dots = new int[P];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < P; i++) {
      dots[i] = Integer.parseInt(st.nextToken());
    }

    dijkstra(X, min_dis1);
    dijkstra(Z, min_dis2);

    long ans = INF;

    for (int i = 0; i < P; i++) {
      int tmp = dots[i];
      if (min_dis1[tmp] == INF || min_dis2[tmp] == INF)
        continue;

      long res = min_dis1[tmp] + min_dis2[tmp];
      ans = Math.min(ans, res);
    }

    System.out.println(ans == INF ? -1 : ans);

  }

  public static void dijkstra(int start, long[] min_dis) {
    PriorityQueue<Node> pq = new PriorityQueue<Node>((o1, o2) -> (int) o1.cost - (int) o2.cost);
    min_dis[start] = 0;
    pq.offer(new Node(start, 0));

    while (!pq.isEmpty()) {
      Node cur = pq.poll();

      if (min_dis[cur.node] < cur.cost)
        continue;

      for (Node next : arr.get(cur.node)) {
        if (min_dis[next.node] > cur.cost + next.cost) {
          min_dis[next.node] = cur.cost + next.cost;
          pq.offer(new Node(next.node, cur.cost + next.cost));
        }
      }

    }
  }
}

class Node {
  int node;
  long cost;

  public Node(int node, long cost) {
    this.node = node;
    this.cost = cost;
  }
}