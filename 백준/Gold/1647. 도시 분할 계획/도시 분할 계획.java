import java.util.*;
import java.io.*;

public class Main {
  public static int N, M;
  public static boolean[] visited;
  public static ArrayList<ArrayList<Node>> arr = new ArrayList<ArrayList<Node>>();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    for (int i = 0; i <= N; i++) {
      arr.add(new ArrayList<>());
    }
    visited = new boolean[N + 1];

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      arr.get(a).add(new Node(b, c));
      arr.get(b).add(new Node(a, c));
    }

    int res = prim(1);
    System.out.println(res);

  }

  public static int prim(int start) {
    PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
    int max_v = Integer.MIN_VALUE;
    int ans = 0;
    pq.offer(new Node(start, 0));

    while (!pq.isEmpty()) {
      Node cur = pq.poll();

      if (visited[cur.node])
        continue;

      visited[cur.node] = true;
      max_v = Math.max(max_v, cur.cost);
      ans += cur.cost;

      for (Node next : arr.get(cur.node)) {
        if (!visited[next.node]) {
          pq.offer(next);
        }
      }
    }
    return ans - max_v;
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