import java.util.*;
import java.io.*;

public class Main {
  public static int n, d, c, INF;
  public static ArrayList<ArrayList<Node>> arr;
  public static int[] min_dis;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    int t = Integer.parseInt(br.readLine());
    INF = 100000 * 1000 + 1;

    while (t-- > 0) {
      st = new StringTokenizer(br.readLine());
      n = Integer.parseInt(st.nextToken());
      d = Integer.parseInt(st.nextToken());
      c = Integer.parseInt(st.nextToken());
      arr = new ArrayList<ArrayList<Node>>();
      min_dis = new int[n + 1];
      Arrays.fill(min_dis, INF);
      for (int i = 0; i <= n; i++) {
        arr.add(new ArrayList<>());
      }

      for (int i = 0; i < d; i++) {
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        arr.get(b).add(new Node(a, s));
      }

      dijkstra(c);
      int cnt = 0;
      int time = Integer.MIN_VALUE;

      for (int i = 1; i <= n; i++) {
        if (min_dis[i] != INF) {
          cnt++;
          time = Math.max(time, min_dis[i]);
        }
      }

      sb.append(cnt + " " + time).append("\n");

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