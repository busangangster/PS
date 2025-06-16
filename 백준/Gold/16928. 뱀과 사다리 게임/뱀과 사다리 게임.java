import java.util.*;
import java.io.*;

public class Main {
  public static int N, M;
  public static boolean[] visited;
  public static HashMap<Integer, Integer> hm = new HashMap<>();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    visited = new boolean[101];

    for (int i = 0; i < N + M; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      hm.put(x, y);
    }

    int res = bfs();

    System.out.println(res);

  }

  public static int bfs() {
    Queue<Node> q = new ArrayDeque<>();
    q.offer(new Node(1, 0));
    visited[1] = true;

    while (!q.isEmpty()) {
      Node cur = q.poll();

      if (cur.pos == 100) {
        return cur.cnt;
      }

      for (int i = 1; i <= 6; i++) {
        int next = cur.pos + i;
        if (hm.containsKey(next)) {
          next = hm.get(next);
        }

        if (check(next) && !visited[next]) {
          q.offer(new Node(next, cur.cnt + 1));
          visited[next] = true;
        }
      }
    }
    return -1;
  }

  public static boolean check(int x) {
    return (1 <= x && x <= 100);
  }
}

class Node {
  int pos;
  int cnt;

  public Node(int pos, int cnt) {
    this.pos = pos;
    this.cnt = cnt;
  }
}