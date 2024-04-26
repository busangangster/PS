import java.io.*;
import java.util.*;
 
class Main {
	static int N,M,R,INF;
	static int[] items;
	static ArrayList<ArrayList<Node>> arr;
	static int[] min_dis;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		items = new int[N+1];
		INF = 100*15+1;
		arr = new ArrayList<ArrayList<Node>>();

		for (int i=1; i<=N; i++) {
			items[i] = Integer.parseInt(st.nextToken());
		}

		for (int i=0; i<=N; i++) {
			arr.add(new ArrayList<>());
		}

		for (int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			arr.get(a).add(new Node(b,c));
			arr.get(b).add(new Node(a,c));
		}
		int max_v = Integer.MIN_VALUE;
		
		for (int i=1; i<=N; i++) {
			int[] ans = dijkstra(i);
			int tmp = 0;
			for (int j=1; j<=N; j++) {
				if (ans[j] <= M) {
					tmp += items[j];
				}
			}
			max_v = Math.max(max_v,tmp);
		}
		System.out.println(max_v);

	}

	 static int[] dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		min_dis = new int[N+1];
		Arrays.fill(min_dis,INF);
		min_dis[start] = 0;
		pq.offer(new Node(start,0));

		while (!pq.isEmpty()) {
			Node cur = pq.poll();

			if (min_dis[cur.node] < cur.cost) continue;

			for (Node next: arr.get(cur.node)) {
				if (min_dis[next.node] > cur.cost + next.cost){
					min_dis[next.node] = cur.cost + next.cost;
					pq.offer(new Node(next.node, cur.cost + next.cost));
				}
			}
		}
		return min_dis;
	}

	static class Node implements Comparable<Node>{
		int node,cost;
		public Node(int node, int cost) {
			this.node = node;
			this.cost = cost;
		}
		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}
}