import java.util.*;
import java.io.*;

public class Main {
  public static int t, N, M, INF;
  public static ArrayList<ArrayList<Node>> arr;
  public static int[] min_dis;
  public static int[] prev;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    t = Integer.parseInt(br.readLine());
    INF = 10000;

    for (int tcase = 1; tcase <= t; tcase++) {
      st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());

      arr = new ArrayList<ArrayList<Node>>();

      for (int i = 0; i < M; i++) {
        arr.add(new ArrayList<>());
      }

      for (int i = 0; i < N; i++) {
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        arr.get(a).add(new Node(b, c));
        arr.get(b).add(new Node(a, c));
      }

      min_dis = new int[M];
      Arrays.fill(min_dis, INF);
      prev = new int[M];

      dijkstra();

      sb.append("Case #" + tcase + ": ");
      if (min_dis[M - 1] == INF) {
        sb.append(-1);
      } else {
        int cur = M - 1;
        ArrayList<Integer> order = new ArrayList<>();
        order.add(cur);

        while (cur != 0) {
          cur = prev[cur];
          order.add(cur);
        }
        Collections.reverse(order);
        for (int tmp : order) {
          sb.append(tmp).append(" ");
        }
      }

      sb.append("\n");

    }
    System.out.println(sb);
  }

  public static void dijkstra() {
    PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
    min_dis[0] = 0;
    pq.offer(new Node(0, 0));

    while (!pq.isEmpty()) {
      Node cur = pq.poll();

      if (min_dis[cur.node] < cur.cost)
        continue;

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
  int cost;

  public Node(int node, int cost) {
    this.node = node;
    this.cost = cost;
  }
}