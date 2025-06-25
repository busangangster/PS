import java.util.*;
import java.io.*;

public class Main {
  public static int N, M, ans;
  public static ArrayList<Node> chicken = new ArrayList<>();
  public static ArrayList<Node> house = new ArrayList<>();
  public static ArrayList<Node> selected = new ArrayList<>();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        int tmp = Integer.parseInt(st.nextToken());
        if (tmp == 1) {
          house.add(new Node(i, j));
        } else if (tmp == 2) {
          chicken.add(new Node(i, j));
        }
      }
    }

    ans = Integer.MAX_VALUE;
    dfs(0, 0);

    System.out.println(ans);

  }

  public static void dfs(int start, int cnt) {
    if (cnt == M) {
      int res = checkDistance();
      ans = Math.min(ans, res);
      return;
    }

    for (int i = start; i < chicken.size(); i++) {
      selected.add(chicken.get(i));
      dfs(i + 1, cnt + 1);
      selected.remove(selected.size() - 1);
    }
  }

  public static int checkDistance() {
    int sum = 0;
    for (Node h : house) {
      int min_v = Integer.MAX_VALUE;
      for (Node c : selected) {
        int dis = Math.abs(c.x - h.x) + Math.abs(c.y - h.y);
        min_v = Math.min(min_v, dis);
      }
      sum += min_v;
    }
    return sum;
  }
}

class Node {
  int x;
  int y;

  public Node(int x, int y) {
    this.x = x;
    this.y = y;
  }
}