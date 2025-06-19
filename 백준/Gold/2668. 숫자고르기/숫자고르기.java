import java.io.*;
import java.util.*;

public class Main {
  public static int N;
  public static int[] arr;
  public static boolean[] checked;
  public static ArrayList<Integer> ans = new ArrayList<>();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    N = Integer.parseInt(br.readLine());

    arr = new int[N + 1];
    checked = new boolean[N + 1];

    for (int i = 1; i <= N; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    for (int i = 1; i <= N; i++) {
      checked[i] = true;
      dfs(i, i);
      checked[i] = false;
    }

    Collections.sort(ans);
    System.out.println(ans.size());
    for (int x : ans) {
      sb.append(x).append("\n");
    }
    System.out.println(sb);

  }

  public static void dfs(int start, int target) {
    if (arr[start] == target) {
      ans.add(start);
    }

    if (checked[arr[start]] == false) {
      checked[arr[start]] = true;
      dfs(arr[start], target);
      checked[arr[start]] = false;
    }
  }
}
