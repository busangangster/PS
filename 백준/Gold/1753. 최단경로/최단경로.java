import java.util.*;
import java.io.*;

public class Main {
  public static int V, E, INF;
  public static ArrayList<ArrayList<Node>> arr = new ArrayList<ArrayList<Node>>();
  public static int[] min_dis;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    st = new StringTokenizer(br.readLine());
    V = Integer.parseInt(st.nextToken());
    E = Integer.parseInt(st.nextToken());

    INF = 300000 * 10 + 1;
    min_dis = new int[V + 1];
    Arrays.fill(min_dis, INF);

    int start = Integer.parseInt(br.readLine());

    for (int i = 0; i <= V; i++) {
      arr.add(new ArrayList<>());
    }

    for (int i = 0; i < E; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      arr.get(a).add(new Node(b, c));
    }

    dijkstra(start);
    for (int i = 1; i <= V; i++) {
      if (min_dis[i] == INF) {
        sb.append("INF");
      } else
        sb.append(min_dis[i]);
      sb.append("\n");
    }
    System.out.println(sb);
  }

  public static void dijkstra(int start) {
    PriorityQueue<Node> pq = new PriorityQueue<Node>((o1, o2) -> o1.cost - o2.cost);
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
  int cost;

  public Node(int node, int cost) {
    this.node = node;
    this.cost = cost;
  }
}