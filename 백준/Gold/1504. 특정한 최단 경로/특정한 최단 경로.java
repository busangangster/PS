import java.io.*;
import java.util.*;
public class Main {
	
	static int N,E,INF,u,v;
	static ArrayList<ArrayList<Node>> graph;
	static long[] min_dis;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList<ArrayList<Node>>();
		INF = 1000 * 200000 + 1;
		
		for (int i=0; i<=N; i++) {
			graph.add(new ArrayList<>());
		}
		
		for (int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Integer.parseInt(st.nextToken());
			graph.get(a).add(new Node(b,c));
			graph.get(b).add(new Node(a,c));
		}
		
		st = new StringTokenizer(br.readLine());
		u = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());
		
		long[] first = dijkstra(1);
		long[] second = dijkstra(u);
		long[] third = dijkstra(v);
		
		if (first[u] == INF || second[v] == INF || third[N] == INF) {
			System.out.println(-1);
		}
		else {
			long ans1 = first[u] + second[v] + third[N];
			long ans2 = first[v] + third[u] + second[N];
			System.out.println(Math.min(ans1, ans2));
		}
	}
	
	public static long[] dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		min_dis = new long[N+1];
		Arrays.fill(min_dis, INF);
		min_dis[start] = 0;
		pq.offer(new Node(start,0));
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if (min_dis[cur.node] < cur.cost) continue;
			
			for (Node next : graph.get(cur.node)) {
				if (min_dis[next.node] > cur.cost + next.cost) {
					min_dis[next.node] = cur.cost + next.cost;
					pq.offer(new Node(next.node, cur.cost+next.cost));
				}
			}
		}
		return min_dis;
	}
	
	static class Node implements Comparable<Node>{
		int node;
		long cost;
		public Node(int node, long cost) {
			this.node = node;
			this.cost = cost;
		}
		@Override
		public int compareTo(Node o) {
			return (int) ((int) this.cost - o.cost);
		}
	}
}