import java.util.*;
import java.io.*;

public class Main {
  public static int N, M;
  public static long INF;
  public static long[] min_dis;
  public static ArrayList<ArrayList<Node>> arr = new ArrayList<ArrayList<Node>>();
  public static PriorityQueue<Node> pq = new PriorityQueue<Node>((o1, o2) -> (int) o1.cost - (int) o2.cost);

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    N = Integer.parseInt(br.readLine());

    INF = 10000L * 500000L + 1L;
    min_dis = new long[N + 1];
    Arrays.fill(min_dis, INF);

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < 3; i++) {
      int tmp = Integer.parseInt(st.nextToken());
      pq.offer(new Node(tmp, 0));
      min_dis[tmp] = 0;
    }

    for (int i = 0; i <= N; i++) {
      arr.add(new ArrayList<>());
    }

    M = Integer.parseInt(br.readLine());

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      arr.get(a).add(new Node(b, c));
      arr.get(b).add(new Node(a, c));
    }

    long distance = Long.MIN_VALUE;
    int ans = 0;
    dijkstra();
    for (int i = 1; i <= N; i++) {
      if (i == 0)
        continue;

      if (min_dis[i] == INF)
        continue;

      if (min_dis[i] > distance) {
        distance = min_dis[i];
        ans = i;
      }
    }
    System.out.println(ans);
  }

  public static void dijkstra() {

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