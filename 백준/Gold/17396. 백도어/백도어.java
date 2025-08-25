import java.util.*;
import java.io.*;

public class Main {
  public static int N, M;
  public static long INF;
  public static long[] min_dis;
  public static int[] ward;
  public static ArrayList<ArrayList<Node>> arr = new ArrayList<ArrayList<Node>>();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    ward = new int[N];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      ward[i] = Integer.parseInt(st.nextToken());
    }

    INF = 100000L * 300000L + 1L;
    min_dis = new long[N];
    Arrays.fill(min_dis, INF);

    for (int i = 0; i < N; i++) {
      arr.add(new ArrayList<>());
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      arr.get(a).add(new Node(b, c));
      arr.get(b).add(new Node(a, c));
    }

    dijkstra();
    System.out.println(min_dis[N - 1] == INF ? -1 : min_dis[N - 1]);

  }

  public static void dijkstra() {
    PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> (int) (o1.cost - o2.cost));
    min_dis[0] = 0;
    pq.offer(new Node(0, 0));

    while (!pq.isEmpty()) {
      Node cur = pq.poll();

      if (min_dis[cur.node] < cur.cost)
        continue;

      for (Node next : arr.get(cur.node)) {
        if (ward[next.node] == 0 || next.node == N - 1) {
          if (min_dis[next.node] > cur.cost + next.cost) {
            min_dis[next.node] = cur.cost + next.cost;
            pq.offer(new Node(next.node, cur.cost + next.cost));
          }
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