import java.io.*;
import java.util.*;

class Main { 
	static int V,E,K,INF;
	static int[] min_dis;
	static ArrayList<ArrayList<Pos>> arr;
	public static void main(String[] args)  throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		K = Integer.parseInt(br.readLine());
		INF = Integer.MAX_VALUE;

		arr = new ArrayList<ArrayList<Pos>>();

		for (int i=0; i<=V; i++) {
			arr.add(new ArrayList<>());
		}
		
		for (int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			arr.get(u).add(new Pos(v,w));
		}

		dijkstra(K);
		for (int i=1; i<min_dis.length; i++) {
			if (min_dis[i] == INF) {
				System.out.println("INF");
			}
			else System.out.println(min_dis[i]);
		}
	}

	public static void dijkstra(int start) {
		PriorityQueue<Pos> pq = new PriorityQueue<>();
		min_dis = new int[V+1];
		Arrays.fill(min_dis,INF);
		min_dis[start] = 0;
		pq.offer(new Pos(start,0));

		while (!pq.isEmpty()) {
			Pos cur = pq.poll();

			if (min_dis[cur.node] < cur.cost) continue;

			for (Pos next: arr.get(cur.node)) {
				if (min_dis[next.node] > cur.cost + next.cost) {
					min_dis[next.node] = cur.cost + next.cost;
					pq.offer(new Pos(next.node, cur.cost+next.cost));
				}
			}
		}
	}
	
}

class Pos implements Comparable<Pos>{
	int node,cost;
	public Pos(int node, int cost) {
		this.node = node;
		this.cost = cost;
	}
	@Override
	public int compareTo(Pos o) {
		return this.cost - o.cost;
	}
}