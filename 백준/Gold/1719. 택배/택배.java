import java.util.*;
import java.io.*;

public class Main {
  public static int N, M, INF;
  public static ArrayList<ArrayList<Node>> arr = new ArrayList<ArrayList<Node>>();
  public static int[] min_dis;
  public static int[] prev;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    for (int i = 0; i <= N; i++) {
      arr.add(new ArrayList<>());
    }

    INF = 10000 * 1000 + 1;

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      arr.get(a).add(new Node(b, c));
      arr.get(b).add(new Node(a, c));
    }

    for (int i = 1; i <= N; i++) {
      prev = new int[N + 1];
      dijkstra(i);
      for (int j = 1; j <= N; j++) {
        if (i == j) {
          sb.append("-");
        } else {
          sb.append(prev[j]);
        }
        sb.append(" ");
      }
      sb.append("\n");
    }
    System.out.println(sb);
  }

  public static void dijkstra(int start) {
    PriorityQueue<Node> pq = new PriorityQueue<Node>((o1, o2) -> o1.cost - o2.cost);
    pq.offer(new Node(start, 0));
    min_dis = new int[N + 1];
    Arrays.fill(min_dis, INF);
    min_dis[start] = 0;
    prev[start] = 0;

    while (!pq.isEmpty()) {
      Node cur = pq.poll();

      if (min_dis[cur.node] < cur.cost)
        continue;

      for (Node next : arr.get(cur.node)) {
        if (min_dis[next.node] > cur.cost + next.cost) {
          min_dis[next.node] = cur.cost + next.cost;
          pq.offer(new Node(next.node, cur.cost + next.cost));
          if (start == cur.node) {
            prev[next.node] = next.node;
          } else {
            prev[next.node] = prev[cur.node];
          }
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