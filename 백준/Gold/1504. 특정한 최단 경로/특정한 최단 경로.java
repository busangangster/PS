import java.util.*;
import java.io.*;

public class Main {
  public static int N, E, v1, v2, INF;
  public static ArrayList<ArrayList<Node>> arr = new ArrayList<ArrayList<Node>>();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    E = Integer.parseInt(st.nextToken());

    for (int i = 0; i <= N; i++) {
      arr.add(new ArrayList<>());
    }
    INF = 200000 * 1000 + 1;

    for (int i = 0; i < E; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      arr.get(a).add(new Node(b, c));
      arr.get(b).add(new Node(a, c));
    }

    st = new StringTokenizer(br.readLine());
    v1 = Integer.parseInt(st.nextToken());
    v2 = Integer.parseInt(st.nextToken());

    int[] fromStart = dijkstra(1);
    int[] fromV1 = dijkstra(v1);
    int[] fromV2 = dijkstra(v2);

    int firstDistance = 0;
    int secondDistance = 0;

    firstDistance += fromStart[v1];
    firstDistance += fromV1[v2];
    firstDistance += fromV2[N];

    secondDistance += fromStart[v2];
    secondDistance += fromV2[v1];
    secondDistance += fromV1[N];

    if (firstDistance >= INF && secondDistance >= INF) {
      System.out.println(-1);
    } else {
      System.out.println(Math.min(firstDistance, secondDistance));
    }

  }

  public static int[] dijkstra(int start) {
    PriorityQueue<Node> pq = new PriorityQueue<Node>((o1, o2) -> o1.cost - o2.cost);
    int[] min_dis = new int[N + 1];
    Arrays.fill(min_dis, INF);
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
    return min_dis;
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
