import java.util.*;
import java.io.*;

public class Main {
  public static int N, M, INF, x, y, z;
  public static ArrayList<ArrayList<Node>> arr;
  public static int[] min_dis1, min_dis2, min_dis3;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    arr = new ArrayList<ArrayList<Node>>();
    for (int i = 0; i <= N; i++) {
      arr.add(new ArrayList<>());
    }

    INF = 10000 * 200000 + 1;
    min_dis1 = new int[N + 1];
    min_dis2 = new int[N + 1];
    min_dis3 = new int[N + 1];

    Arrays.fill(min_dis1, INF);
    Arrays.fill(min_dis2, INF);
    Arrays.fill(min_dis3, INF);

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      arr.get(a).add(new Node(b, c));
    }

    st = new StringTokenizer(br.readLine());
    x = Integer.parseInt(st.nextToken());
    y = Integer.parseInt(st.nextToken());
    z = Integer.parseInt(st.nextToken());

    int[] fromx = dijkstra1(x, min_dis1);
    int[] fromy = dijkstra1(y, min_dis2);
    int[] whole = dijkstra2(x, min_dis3);

    sb.append(fromx[y] == INF || fromy[z] == INF ? -1 : fromx[y] + fromy[z]).append(" ");
    sb.append(whole[z] == INF ? -1 : whole[z]);
    System.out.println(sb);

  }

  public static int[] dijkstra1(int start, int[] min_dis) {
    PriorityQueue<Node> pq = new PriorityQueue<Node>((o1, o2) -> o1.cost - o2.cost);
    min_dis[start] = 0;
    pq.offer(new Node(start, 0));

    while (!pq.isEmpty()) {
      Node cur = pq.poll();

      if (min_dis[cur.node] < cur.cost)
        continue;

      for (Node next : arr.get(cur.node)) {
        if (min_dis[next.node] > cur.cost + next.cost) {
          min_dis[next.node] = cur.cost + next.cost;
          pq.offer(new Node(next.node, cur.cost + next.cost));
        }
      }
    }
    return min_dis;
  }

  public static int[] dijkstra2(int start, int[] min_dis) {
    PriorityQueue<Node> pq = new PriorityQueue<Node>((o1, o2) -> o1.cost - o2.cost);
    min_dis[start] = 0;
    pq.offer(new Node(start, 0));

    while (!pq.isEmpty()) {
      Node cur = pq.poll();

      if (min_dis[cur.node] < cur.cost)
        continue;

      for (Node next : arr.get(cur.node)) {
        if (next.node != y) {
          if (min_dis[next.node] > cur.cost + next.cost) {
            min_dis[next.node] = cur.cost + next.cost;
            pq.offer(new Node(next.node, cur.cost + next.cost));
          }
        }
      }
    }
    return min_dis;
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