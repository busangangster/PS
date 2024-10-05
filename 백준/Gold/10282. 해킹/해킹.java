import java.io.*;
import java.util.*;

public class Main {

    static int n, d, c;
    static ArrayList<ArrayList<Node>> arr;
    static int INF = 10000 * 100000 + 1;
    static int[] min_dis;
    static int infectedCnt;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());

        for (int t = 0; t < tc; t++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            arr = new ArrayList<ArrayList<Node>>();

            for (int i = 0; i < n + 1; i++) {
                arr.add(new ArrayList<>());
            }

            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                arr.get(b).add(new Node(a, s));
            }

            dijkstra(c);

            int max_v = 0;
            infectedCnt = 0;
            for (int i = 1; i < n + 1; i++) {
                if (min_dis[i] != INF) {
                    infectedCnt++;
                    max_v = Integer.max(max_v, min_dis[i]);
                }
            }
            sb.append(infectedCnt + " " + max_v).append("\n");
        }
        System.out.println(sb);
    }

    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<Node>((o1, o2) -> o1.cost - o2.cost);
        min_dis = new int[n + 1];
        Arrays.fill(min_dis, INF);

        min_dis[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (min_dis[cur.idx] < cur.cost) {
                continue;
            }

            for (int i = 0; i < arr.get(cur.idx).size(); i++) {
                Node next = arr.get(cur.idx).get(i);
                if ( min_dis[next.idx] > cur.cost + next.cost) {
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