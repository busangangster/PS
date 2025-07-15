import java.util.*;
import java.io.*;

public class Main {
  public static int n, m, tx, ty;
  public static long INF;
  public static long[] min_dis;
  public static int[] prev;
  public static ArrayList<ArrayList<Node>> arr = new ArrayList<ArrayList<Node>>();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    n = Integer.parseInt(br.readLine());
    m = Integer.parseInt(br.readLine());

    for (int i = 0; i <= n; i++) {
      arr.add(new ArrayList<>());
    }
    INF = 100000 * 100000 + 1;
    min_dis = new long[n + 1];
    Arrays.fill(min_dis, INF);
    prev = new int[n + 1];

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      arr.get(a).add(new Node(b, c));
    }

    st = new StringTokenizer(br.readLine());
    tx = Integer.parseInt(st.nextToken());
    ty = Integer.parseInt(st.nextToken());

    dijkstra(tx);

    ArrayList<Integer> orders = new ArrayList<>();
    orders.add(ty);
    int cur = ty;

    while (cur != tx) {
      cur = prev[cur];
      orders.add(cur);
    }

    sb.append(min_dis[ty]).append("\n");
    sb.append(orders.size()).append("\n");
    for (int i = orders.size() - 1; i >= 0; i--) {
      sb.append(orders.get(i)).append(" ");
    }

    System.out.println(sb);

  }

  public static void dijkstra(int start) {
    PriorityQueue<Node> pq = new PriorityQueue<Node>((o1, o2) -> (int) o1.cost - (int) o2.cost);
    min_dis[start] = 0;
    pq.offer(new Node(start, 0));

    while (!pq.isEmpty()) {
      Node cur = pq.poll();

      if (min_dis[cur.node] < cur.cost) {
        continue;
      }

      for (Node next : arr.get(cur.node)) {
        if (min_dis[next.node] > cur.cost + next.cost) {
          min_dis[next.node] = cur.cost + next.cost;
          prev[next.node] = cur.node;
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