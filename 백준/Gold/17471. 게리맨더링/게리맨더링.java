import java.util.*;
import java.io.*;

public class Main {
  public static int N, ans;
  public static int[] population;
  public static boolean[] selected, visited;
  public static ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    N = Integer.parseInt(br.readLine());
    population = new int[N + 1];
    selected = new boolean[N + 1];
    ans = Integer.MAX_VALUE;

    st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= N; i++) {
      population[i] = Integer.parseInt(st.nextToken());
    }

    for (int i = 0; i <= N; i++) {
      arr.add(new ArrayList<>());
    }

    for (int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine());
      int tmp = Integer.parseInt(st.nextToken());
      for (int j = 0; j < tmp; j++) {
        int k = Integer.parseInt(st.nextToken());
        arr.get(i).add(k);
      }
    }

    subset(1);
    System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
  }

  public static void subset(int cnt) {
    if (cnt == N + 1) {
      visited = new boolean[N + 1];
      int res = 0;
      int firstSection = 0;
      int secondSection = 0;
      for (int i = 1; i <= N; i++) {
        if (!visited[i]) {
          bfs(i, selected[i]);
          res++;
        }
      }
      if (res == 2) {
        for (int i = 1; i <= N; i++) {
          if (selected[i]) {
            firstSection += population[i];
          } else {
            secondSection += population[i];
          }
        }
        ans = Math.min(ans, Math.abs(firstSection - secondSection));
      }
      return;
    }

    selected[cnt] = true;
    subset(cnt + 1);
    selected[cnt] = false;
    subset(cnt + 1);

  }

  public static void bfs(int start, boolean flag) {
    Queue<Integer> q = new ArrayDeque<Integer>();
    visited[start] = true;
    q.offer(start);

    while (!q.isEmpty()) {
      int cur = q.poll();

      for (int next : arr.get(cur)) {
        if (!visited[next] && selected[next] == flag) {
          visited[next] = true;
          q.offer(next);
        }
      }
    }
  }
}