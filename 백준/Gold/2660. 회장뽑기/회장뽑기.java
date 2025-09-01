import java.util.*;
import java.io.*;

public class Main {
  public static int N;
  public static ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
  public static ArrayList<Integer> candidate = new ArrayList<>();
  public static boolean[] visited;
  public static int[] score;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    N = Integer.parseInt(br.readLine());

    for (int i = 0; i <= N; i++) {
      arr.add(new ArrayList<>());
    }
    score = new int[N + 1];

    while (true) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      if (a == -1 && b == -1)
        break;
      arr.get(a).add(b);
      arr.get(b).add(a);
    }

    int king = Integer.MAX_VALUE;

    for (int i = 1; i <= N; i++) {
      visited = new boolean[N + 1];
      int res = bfs(i);
      score[i] = res;
      king = Math.min(res, king);
    }

    int cnt = 0;
    for (int i = 1; i <= N; i++) {
      if (score[i] == king) {
        sb.append(i).append(" ");
        cnt++;
      }
    }
    System.out.println(king + " " + cnt);
    System.out.println(sb);
  }

  public static int bfs(int start) {
    Queue<Node> q = new ArrayDeque<>();
    q.offer(new Node(start, 0));
    visited[start] = true;
    int range = Integer.MIN_VALUE;

    while (!q.isEmpty()) {
      Node cur = q.poll();

      range = Math.max(range, cur.cnt);

      for (int next : arr.get(cur.node)) {
        if (!visited[next]) {
          visited[next] = true;
          q.offer(new Node(next, cur.cnt + 1));

        }
      }
    }
    return range;
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