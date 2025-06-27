import java.util.*;
import java.io.*;

public class Main {
  public static int N, M;
  public static ArrayList<ArrayList<Integer>> arr1 = new ArrayList<ArrayList<Integer>>();
  public static ArrayList<ArrayList<Integer>> arr2 = new ArrayList<ArrayList<Integer>>();
  public static boolean[] visited;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    for (int i = 0; i <= N; i++) {
      arr1.add(new ArrayList<>());
      arr2.add(new ArrayList<>());
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      arr1.get(a).add(b);
      arr2.get(b).add(a);
    }

    int cnt = 0;

    for (int i = 1; i <= N; i++) {
      int first = BFS(i, arr1);
      int second = BFS(i, arr2);
      if (first + second > N - 2)
        cnt++;
    }

    System.out.println(cnt);
  }

  public static int BFS(int start, ArrayList<ArrayList<Integer>> arr) {
    Queue<Integer> q = new ArrayDeque<>();
    visited = new boolean[N + 1];
    q.offer(start);
    visited[start] = true;
    int ans = 0;

    while (!q.isEmpty()) {
      int cur = q.poll();

      for (int next : arr.get(cur)) {
        if (!visited[next]) {
          ans++;
          visited[next] = true;
          q.offer(next);
        }
      }
    }
    return ans;
  }
}