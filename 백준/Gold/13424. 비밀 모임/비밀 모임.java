import java.util.*;
import java.io.*;

public class Main {
  public static int N, M, K, INF;
  public static ArrayList<ArrayList<Node>> arr;
  public static int[] min_dis, friends;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    INF = 1000 * 100 + 1;
    int t = Integer.parseInt(br.readLine());

    while (t-- > 0) {
      st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());

      arr = new ArrayList<ArrayList<Node>>();

      for (int i = 0; i <= N; i++) {
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

      K = Integer.parseInt(br.readLine());
      friends = new int[K];
      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < K; i++) {
        friends[i] = Integer.parseInt(st.nextToken());
      }

      int ans = 0;
      int distance = INF;

      for (int i = 1; i <= N; i++) {
        int[] res = dijkstra(i);
        int tmp = 0;
        for (int j = 0; j < K; j++) {
          tmp += res[friends[j]];
        }
        if (tmp < distance) {
          distance = tmp;
          ans = i;
        }
      }
      sb.append(ans).append("\n");
    }
    System.out.println(sb);
  }

  public static int[] dijkstra(int start) {
    min_dis = new int[N + 1];
    Arrays.fill(min_dis, INF);
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