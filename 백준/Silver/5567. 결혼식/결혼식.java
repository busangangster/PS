import java.util.*;
import java.io.*;

public class Main {
  public static int n, m;
  public static int[] min_dis;
  public static ArrayList<ArrayList<Node>> arr = new ArrayList<ArrayList<Node>>();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    n = Integer.parseInt(br.readLine());
    m = Integer.parseInt(br.readLine());

    for (int i = 0; i <= n; i++) {
      arr.add(new ArrayList<>());
    }

    min_dis = new int[n + 1];
    Arrays.fill(min_dis, 500 * 10000 + 1);

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      arr.get(a).add(new Node(b, 1));
      arr.get(b).add(new Node(a, 1));
    }

    dijkstra();

    int cnt = 0;
    for (int i = 2; i <= n; i++) {
      if (min_dis[i] < 3)
        cnt++;
    }

    System.out.println(cnt);

  }

  public static void dijkstra() {
    PriorityQueue<Node> pq = new PriorityQueue<Node>((o1, o2) -> o1.cost - o2.cost);
    min_dis[1] = 0;
    pq.offer(new Node(1, 0));

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