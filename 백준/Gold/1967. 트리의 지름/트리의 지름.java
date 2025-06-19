import java.util.*;
import java.io.*;

public class Main {
  public static int n;
  public static ArrayList<ArrayList<Node>> arr = new ArrayList<ArrayList<Node>>();
  public static boolean[] visited;
  public static int[] distance;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    n = Integer.parseInt(br.readLine());

    for (int i = 0; i <= n; i++) {
      arr.add(new ArrayList<>());
    }

    for (int i = 0; i < n - 1; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      arr.get(a).add(new Node(b, c));
      arr.get(b).add(new Node(a, c));
    }

    Node first = bfs(1);
    Node second = bfs(first.node);

    System.out.println(second.cost);

  }

  public static Node bfs(int start) {
    Queue<Node> q = new ArrayDeque<>();
    visited = new boolean[n + 1];
    distance = new int[n + 1];
    visited[start] = true;
    distance[start] = 0;
    q.offer(new Node(start, 0));

    while (!q.isEmpty()) {
      Node cur = q.poll();

      for (Node next : arr.get(cur.node)) {
        if (!visited[next.node]) {
          distance[next.node] = cur.cost + next.cost;
          visited[next.node] = true;
          q.offer(new Node(next.node, cur.cost + next.cost));
        }
      }
    }

    int max_v = Integer.MIN_VALUE;
    int ans = 0;
    for (int i = 1; i <= n; i++) {
      if (distance[i] > max_v) {
        ans = i;
        max_v = distance[i];
      }
    }
    return new Node(ans, max_v);
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