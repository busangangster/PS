import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static ArrayList<ArrayList<Node>> arr = new ArrayList<ArrayList<Node>>();
    static int[] min_dis;
    static int INF = 50000 * 1000 + 1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            arr.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr.get(u).add(new Node(v, c));
            arr.get(v).add(new Node(u, c));
        }

        dijkstra(1);
        int ans = min_dis[N];
        System.out.println(ans);
    }
    
    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<Node>((o1, o2) -> o1.cost - o2.cost);
        min_dis = new int[N + 1];
        Arrays.fill(min_dis, INF);

        min_dis[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (min_dis[cur.idx] < cur.cost)
                continue;

            for (int i = 0; i < arr.get(cur.idx).size(); i++) {
                Node next = arr.get(cur.idx).get(i);

                if (min_dis[next.idx] > cur.cost + next.cost) {
                    min_dis[next.idx] = cur.cost + next.cost;
                    pq.offer(new Node(next.idx, min_dis[next.idx]));
                }
            }
        }
    }
}

class Node {
    int idx;
    int cost;

    public Node(int idx, int cost) {
        this.idx = idx;
        this.cost = cost;
    }
}