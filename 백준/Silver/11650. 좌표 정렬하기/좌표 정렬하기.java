import java.util.*;
import java.io.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PriorityQueue<Node> pq = new PriorityQueue<Node>();
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    int n = Integer.parseInt(br.readLine());
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      pq.offer(new Node(a, b));
    }

    while (!pq.isEmpty()) {
      Node tmp = pq.poll();
      sb.append(tmp.x + " " + tmp.y).append("\n");
    }

    System.out.println(sb);

  }
}

class Node implements Comparable<Node> {
  int x;
  int y;

  public Node(int x, int y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public int compareTo(Node o) {
    if (this.x == o.x) {
      return this.y - o.y;
    }
    return this.x - o.x;
  }
}