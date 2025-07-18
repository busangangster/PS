import java.util.*;
import java.io.*;

public class Main {
  public static int N, M, ans;
  public static boolean[] visited;
  public static ArrayList<ArrayList<Node>> arr = new ArrayList<ArrayList<Node>>();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    N = Integer.parseInt(br.readLine());
    M = Integer.parseInt(br.readLine());

    visited = new boolean[N + 1];
    ans = 0;

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

    prim();
    System.out.println(ans);

  }

  public static void prim() {
    PriorityQueue<Node> pq = new PriorityQueue<Node>((o1, o2) -> o1.cost - o2.cost);
    pq.offer(new Node(1, 0));

    while (!pq.isEmpty()) {
      Node cur = pq.poll();

      if (visited[cur.node])
        continue;

      visited[cur.node] = true;
      ans += cur.cost;

      for (Node next : arr.get(cur.node)) {
        if (!visited[next.node]) {
          pq.offer(next);
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