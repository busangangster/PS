import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    ArrayList<Node> jewels = new ArrayList<Node>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int m = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      jewels.add(new Node(m, v));
    }

    ArrayList<Integer> bags = new ArrayList<>();
    for (int i = 0; i < K; i++) {
      bags.add(Integer.parseInt(br.readLine()));
    }

    Collections.sort(bags);
    Collections.sort(jewels);

    long ans = 0;
    int idx = 0;

    for (int bag : bags) {
      while (idx < N && jewels.get(idx).weight <= bag) {
        maxHeap.offer(jewels.get(idx).price);
        idx++;
      }
      if (!maxHeap.isEmpty()) {
        ans += maxHeap.poll();

      }
    }
    System.out.println(ans);

  }
}

class Node implements Comparable<Node> {
  int weight;
  int price;

  public Node(int weight, int price) {
    this.weight = weight;
    this.price = price;
  }

  @Override
  public int compareTo(Node o) {
    return this.weight - o.weight;
  }
}