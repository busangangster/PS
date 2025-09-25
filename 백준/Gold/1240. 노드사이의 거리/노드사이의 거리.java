import java.util.*;
import java.io.*;

public class Main {
  public static int N, M;
  public static ArrayList<ArrayList<Node>> arr = new ArrayList<ArrayList<Node>>();
  public static boolean[] visited;

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

    for (int i = 0; i < N - 1; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      arr.get(a).add(new Node(b, c));
      arr.get(b).add(new Node(a, c));
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int first = Integer.parseInt(st.nextToken());
      int second = Integer.parseInt(st.nextToken());
      int res = bfs(first, second);
      sb.append(res).append("\n");
    }
    System.out.println(sb);
  }

  public static int bfs(int start, int end) {
    Queue<Node> q = new ArrayDeque<>();
    visited = new boolean[N + 1];
    visited[start] = true;
    q.offer(new Node(start, 0));

    while (!q.isEmpty()) {
      Node cur = q.poll();

      if (cur.node == end) {
        return cur.cost;
      }

      for (Node next : arr.get(cur.node)) {
        if (!visited[next.node]) {
          visited[next.node] = true;
          q.offer(new Node(next.node, cur.cost + next.cost));
        }
      }
    }
    return -1;
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