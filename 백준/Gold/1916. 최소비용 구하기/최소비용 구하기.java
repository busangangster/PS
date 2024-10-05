import java.io.*;
import java.util.*;

public class Main {
    static int N, M, S, E,INF;
    static ArrayList<ArrayList<Node>> arr = new ArrayList<ArrayList<Node>>();
    static int[] min_dis;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        INF = 1000 * 100000 + 1;

        for (int i = 0; i < N + 1; i++) {
            arr.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            arr.get(u).add(new Node(v, c));
        }

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        dijkstra(S);
        System.out.println(min_dis[E]);
    }
    
    public static void dijkstra(int start) {
        min_dis = new int[N + 1];
        Arrays.fill(min_dis, INF);

        PriorityQueue<Node> pq = new PriorityQueue<Node>((o1, o2) -> o1.cost - o2.cost);
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