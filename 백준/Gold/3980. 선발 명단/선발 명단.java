import java.util.*;
import java.io.*;

public class Main {
  public static int[] selected;
  public static int[][] arr;
  public static ArrayList<ArrayList<Integer>> players;
  public static boolean[] visited;
  public static int N, ans;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    int t = Integer.parseInt(br.readLine());

    while (t-- > 0) {
      players = new ArrayList<ArrayList<Integer>>();

      for (int i = 0; i < 11; i++) {
        players.add(new ArrayList<>());
      }
      visited = new boolean[11];
      arr = new int[11][11];
      selected = new int[11];
      ans = 0;

      for (int i = 0; i < 11; i++) {
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < 11; j++) {
          int tmp = Integer.parseInt(st.nextToken());
          if (tmp != 0) {
            players.get(i).add(j);
          }
          arr[i][j] = tmp;
        }
      }

      perm(0, 0);
      sb.append(ans).append("\n");
    }
    System.out.println(sb);
  }

  public static void perm(int cnt, int sum) {
    if (cnt == 11) {
      ans = Math.max(ans, sum);
      return;
    }

    for (int i = 0; i < 11; i++) {
      if (visited[i])
        continue;

      if (players.get(cnt).contains(i)) {
        selected[cnt] = i;
        visited[i] = true;
        perm(cnt + 1, sum + arr[cnt][i]);
        visited[i] = false;
      }
    }
  }

}
