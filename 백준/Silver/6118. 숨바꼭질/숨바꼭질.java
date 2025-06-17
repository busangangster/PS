import java.util.*;
import java.io.*;

public class Main {
  public static int N, M;
  public static int[] dis;
  public static ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    dis = new int[N + 1];
    Arrays.fill(dis, -1);
    for (int i = 0; i <= N; i++) {
      arr.add(new ArrayList<>());
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      arr.get(a).add(b);
      arr.get(b).add(a);
    }

    bfs();

    int max_dis = Integer.MIN_VALUE;
    int ans = 0;

    for (int i = 1; i <= N; i++) {
      if (max_dis < dis[i]) {
        max_dis = dis[i];
        ans = i;
      }
    }

    int cnt = 0;
    for (int i = 1; i <= N; i++) {
      if (dis[i] == max_dis) {
        cnt++;
      }
    }

    System.out.println(ans + " " + max_dis + " " + cnt);
  }

  public static void bfs() {
    Queue<Integer> q = new ArrayDeque<Integer>();
    dis[1] = 0;
    q.offer(1);

    while (!q.isEmpty()) {
      int cur = q.poll();

      for (int next : arr.get(cur)) {
        if (dis[next] == -1) {
          dis[next] = dis[cur] + 1;
          q.offer(next);
        }
      }
    }
  }
}