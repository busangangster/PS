import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    PriorityQueue<Node> pq = new PriorityQueue<>();
    int n = Integer.parseInt(br.readLine());
    for (int i = 0; i < n; i++) {
      int tmp = Integer.parseInt(br.readLine());
      if (tmp == 0) {
        if (pq.isEmpty())
          sb.append(0);
        else
          sb.append(pq.poll().node);
        sb.append("\n");
      } else {
        pq.offer(new Node(tmp));
      }
    }
    System.out.println(sb);
  }
}

class Node implements Comparable<Node> {
  int node;

  public Node(int node) {
    this.node = node;
  }

  @Override
  public int compareTo(Node o) {
    if (Math.abs(this.node) == Math.abs(o.node)) {
      return this.node - o.node;
    }
    return Math.abs(this.node) - Math.abs(o.node);
  }

}