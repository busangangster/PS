import java.io.*;
import java.util.*;

public class Main {
    
    static int V, E, K;
    static int INF = Integer.MAX_VALUE;
    static int[] min_dis;
    static ArrayList<ArrayList<Node>> arr = new ArrayList<ArrayList<Node>>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        for (int i = 0; i < V + 1; i++) {
            arr.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            arr.get(u).add(new Node(v, w));
        }

        dijkstra(K);

        for (int i = 1; i < V + 1; i++) {
            sb.append(min_dis[i] == INF ? "INF" : min_dis[i]).append("\n");
        }

        System.out.println(sb);

    }
    
    public static void dijkstra(int start) {
        min_dis = new int[V + 1];
        for (int i = 0; i < V + 1; i++) {
            min_dis[i] = INF;
        }
        PriorityQueue<Node> pq = new PriorityQueue<Node>((o1, o2) -> o1.cost - o2.cost);
        min_dis[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {

            Node cur = pq.poll();

            if (min_dis[cur.idx] < cur.cost) {
                continue;
            }

            for (int i = 0; i < arr.get(cur.idx).size(); i++) {
                Node next_node = arr.get(cur.idx).get(i);
                if (min_dis[next_node.idx] > cur.cost + next_node.cost) {
                    min_dis[next_node.idx] = cur.cost + next_node.cost;
                    pq.offer(new Node(next_node.idx, min_dis[next_node.idx]));

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
    @Override
    public String toString() {
        return "(" + idx + ", " + cost + ")";
    }
}