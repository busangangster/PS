import java.util.*;
import java.io.*;

public class Main {
  public static int F, S, G, U, D;
  public static int[] move;
  public static boolean[] visited;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    F = Integer.parseInt(st.nextToken());
    S = Integer.parseInt(st.nextToken());
    G = Integer.parseInt(st.nextToken());
    U = Integer.parseInt(st.nextToken());
    D = Integer.parseInt(st.nextToken());

    visited = new boolean[F + 1];

    move = new int[] { U, -D };

    int res = bfs();

    System.out.println(res == -1 ? "use the stairs" : res);
  }

  public static int bfs() {
    Queue<Node> q = new ArrayDeque<>();
    q.offer(new Node(S, 0));
    visited[S] = true;

    while (!q.isEmpty()) {
      Node cur = q.poll();

      if (cur.x == G) {
        return cur.cnt;
      }

      for (int i = 0; i < 2; i++) {
        int nx = cur.x + move[i];

        if (!check(nx))
          continue;
        if (visited[nx])
          continue;

        visited[nx] = true;
        q.offer(new Node(nx, cur.cnt + 1));
      }
    }
    return -1;
  }

  public static boolean check(int x) {
    return (1 <= x && x <= F);
  }
}

class Node {
  int x;
  int cnt;

  public Node(int x, int cnt) {
    this.x = x;
    this.cnt = cnt;
  }
}