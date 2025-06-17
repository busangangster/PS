import java.util.*;
import java.io.*;

public class Main {
  public static int N, M, distance;
  public static boolean[] visited;
  public static ArrayList<Integer> nodes;
  public static ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    visited = new boolean[N + 1];
    for (int i = 0; i <= N; i++) {
      arr.add(new ArrayList<>());
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      arr.get(a).add(b);
      arr.get(b).add(a);
    }

    bfs();
    Collections.sort(nodes);
    System.out.println(nodes.get(0) + " " + distance + " " + nodes.size());

  }

  public static void bfs() {
    Queue<Node> q = new ArrayDeque<Node>();
    visited[1] = true;
    distance = Integer.MIN_VALUE;
    nodes = new ArrayList<>();
    q.offer(new Node(1, 0));

    while (!q.isEmpty()) {
      Node cur = q.poll();

      for (int next : arr.get(cur.node)) {
        if (!visited[next]) {
          if (distance < cur.dis + 1) {
            nodes.clear();
            distance = cur.dis + 1;
            nodes.add(next);
          } else if (distance == cur.dis + 1) {
            nodes.add(next);
          }
          visited[next] = true;
          q.offer(new Node(next, cur.dis + 1));
        }
      }
    }
  }
}

class Node {
  int node;
  int dis;

  public Node(int node, int dis) {
    this.node = node;
    this.dis = dis;
  }
}