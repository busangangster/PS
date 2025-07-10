import java.util.*;
import java.io.*;

public class Main {
  public static int N, M, X, INF;
  public static ArrayList<ArrayList<Node>> arr1 = new ArrayList<ArrayList<Node>>();
  public static ArrayList<ArrayList<Node>> arr2 = new ArrayList<ArrayList<Node>>();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    X = Integer.parseInt(st.nextToken());

    for (int i = 0; i <= N; i++) {
      arr1.add(new ArrayList<>());
      arr2.add(new ArrayList<>());
    }
    INF = 10000 * 100 + 1;

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      arr1.get(a).add(new Node(b, c));
      arr2.get(b).add(new Node(a, c));
    }

    int[] goTo = dijkstra(X, arr1);
    int[] comeBack = dijkstra(X, arr2);

    int ans = Integer.MIN_VALUE;

    for (int i = 1; i <= N; i++) {
      if (i == X)
        continue;
      ans = Math.max(goTo[i] + comeBack[i], ans);
    }
    System.out.println(ans);
  }

  public static int[] dijkstra(int start, ArrayList<ArrayList<Node>> arr) {
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