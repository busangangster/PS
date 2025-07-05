import java.util.*;
import java.io.*;

public class Main {
  public static int N, s, e, M;
  public static ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
  public static boolean[] visited;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    N = Integer.parseInt(br.readLine());

    st = new StringTokenizer(br.readLine());
    s = Integer.parseInt(st.nextToken());
    e = Integer.parseInt(st.nextToken());

    for (int i = 0; i <= N; i++) {
      arr.add(new ArrayList<>());
    }
    visited = new boolean[N + 1];

    M = Integer.parseInt(br.readLine());
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      arr.get(a).add(b);
      arr.get(b).add(a);
    }

    int res = bfs();
    System.out.println(res);
  }

  public static int bfs() {
    Queue<Node> q = new ArrayDeque<>();
    visited[s] = true;
    q.offer(new Node(s, 0));

    while (!q.isEmpty()) {
      Node cur = q.poll();

      if (cur.node == e) {
        return cur.cnt;
      }

      for (int next : arr.get(cur.node)) {
        if (!visited[next]) {
          visited[next] = true;
          q.offer(new Node(next, cur.cnt + 1));
        }
      }
    }
    return -1;
  }
}

class Node {
  int node;
  int cnt;

  public Node(int node, int cnt) {
    this.node = node;
    this.cnt = cnt;
  }
}