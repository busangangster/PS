import java.util.*;
import java.io.*;

public class Main {
  public static int N, ans;
  public static int[] cost, copyCost;
  public static boolean[] visited;
  public static int[] order;
  public static ArrayList<ArrayList<Node>> discount = new ArrayList<ArrayList<Node>>();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    N = Integer.parseInt(br.readLine());

    visited = new boolean[N];
    cost = new int[N];
    copyCost = new int[N];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      cost[i] = Integer.parseInt(st.nextToken());
    }

    for (int i = 0; i < N; i++) {
      discount.add(new ArrayList<>());
    }

    for (int i = 0; i < N; i++) {
      int p = Integer.parseInt(br.readLine());
      for (int j = 0; j < p; j++) {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()) - 1;
        int c = Integer.parseInt(st.nextToken());
        discount.get(i).add(new Node(n, c));
      }
    }

    order = new int[N];
    ans = Integer.MAX_VALUE;
    dfs(0);
    System.out.println(ans);

  }

  public static void dfs(int cnt) {
    if (cnt == N) {
      copy();
      calculate();
      return;
    }

    for (int i = 0; i < N; i++) {
      if (visited[i])
        continue;

      visited[i] = true;
      order[cnt] = i;
      dfs(cnt + 1);
      visited[i] = false;
    }
  }

  public static void calculate() {
    int sum = 0;
    for (int i = 0; i < N; i++) {
      if (sum > ans)
        return;
      int tmp = order[i];
      sum += copyCost[tmp];
      for (Node cur : discount.get(tmp)) {
        copyCost[cur.num] = copyCost[cur.num] - cur.price < 1 ? 1 : copyCost[cur.num] - cur.price;
      }
    }
    ans = Math.min(ans, sum);
  }

  public static void copy() {
    for (int i = 0; i < N; i++) {
      copyCost[i] = cost[i];
    }
  }
}

class Node {
  int num;
  int price;

  public Node(int num, int price) {
    this.num = num;
    this.price = price;
  }
}