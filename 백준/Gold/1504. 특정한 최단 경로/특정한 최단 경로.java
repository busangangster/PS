import java.io.*;
import java.util.*;

public class Main {

    static int N, E, INF;
    static ArrayList<ArrayList<Node>> arr = new ArrayList<ArrayList<Node>>();
    static int[] min_dis;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        INF = 800 * 200000 + 1;

        for (int i = 0; i < N + 1; i++) {
            arr.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            arr.get(u).add(new Node(v, c));
            arr.get(v).add(new Node(u, c));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());
        
        int[] start = dijkstra(1);
        int[] d1 = dijkstra(v1);
        int[] d2 = dijkstra(v2);

        int first = start[v1] + d1[v2] + d2[N];
        int second = start[v2] + d2[v1] + d1[N];

        if (first >= INF || second >= INF) {
            System.out.println(-1);
        }
        else {
            System.out.println(Integer.min(first, second));
        }
    }

    public static int[] dijkstra(int start) {
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
        return min_dis;
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