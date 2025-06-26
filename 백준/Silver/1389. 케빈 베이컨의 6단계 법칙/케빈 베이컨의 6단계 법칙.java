import java.util.*;
import java.io.*;

public class Main {
  public static int N, M, INF;
  public static ArrayList<ArrayList<Node>> arr = new ArrayList<ArrayList<Node>>();
  public static int[] min_dis;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    for (int i = 0; i <= N; i++) {
      arr.add(new ArrayList<>());
    }
    INF = 5000 * 100 + 1;

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      arr.get(a).add(new Node(b, 1));
      arr.get(b).add(new Node(a, 1));
    }

    int min_v = Integer.MAX_VALUE;
    int ans = 0;

    for (int i = 1; i <= N; i++) {
      int res = dijkstra(i);
      if (min_v > res) {
        ans = i;
        min_v = res;
      }
    }

    System.out.println(ans);
  }

  public static int dijkstra(int start) {
    PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
    min_dis = new int[N + 1];
    int tmp = 0;
    Arrays.fill(min_dis, INF);
    pq.offer(new Node(start, 0));
    min_dis[start] = 0;

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
    for (int i = 1; i <= N; i++) {
      tmp += min_dis[i];
    }
    return tmp;
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