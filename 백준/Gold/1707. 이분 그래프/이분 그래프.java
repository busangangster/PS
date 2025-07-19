import java.util.*;
import java.io.*;

public class Main {
  public static int V, E;
  public static ArrayList<ArrayList<Integer>> arr;
  public static int[] visited;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    int k = Integer.parseInt(br.readLine());

    while (k-- > 0) {
      st = new StringTokenizer(br.readLine());
      V = Integer.parseInt(st.nextToken());
      E = Integer.parseInt(st.nextToken());

      arr = new ArrayList<ArrayList<Integer>>();

      for (int i = 0; i <= V; i++) {
        arr.add(new ArrayList<>());
      }

      for (int i = 0; i < E; i++) {
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        arr.get(a).add(b);
        arr.get(b).add(a);
      }

      boolean flag = true;
      visited = new int[V + 1];

      for (int i = 1; i <= V; i++) {
        if (visited[i] == 0) {
          int res = bfs(i);
          if (res == -1) {
            flag = false;
            break;
          }
        }
      }

      if (flag)
        sb.append("YES");
      else
        sb.append("NO");
      sb.append("\n");

    }

    System.out.println(sb);
  }

  public static int bfs(int start) {
    Queue<Node> q = new ArrayDeque<>();
    visited[start] = 1;
    q.offer(new Node(start, 1));

    while (!q.isEmpty()) {
      Node cur = q.poll();

      for (int next : arr.get(cur.node)) {
        int color = cur.color == 1 ? 2 : 1;
        if (visited[next] == 0) {
          visited[next] = color;
          q.offer(new Node(next, color));
        } else {
          if (visited[next] != color) {
            return -1;
          }
        }
      }
    }
    return 1;
  }
}

class Node {
  int node;
  int color;

  public Node(int node, int color) {
    this.node = node;
    this.color = color;
  }
}