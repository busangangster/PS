import java.io.*;
import java.util.*;
 
class Main {
	static int N,M,K,X,INF;
	static ArrayList<ArrayList<Node>> arr;
	static int[] min_dis;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());

		arr = new ArrayList<ArrayList<Node>>();
		INF = 1000001;

		for (int i=0; i<=N; i++) {
			arr.add(new ArrayList<>());
		}

		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr.get(a).add(new Node(b,1));
		}

		int[] tmp = dijkstra(X);
		for (int i=0; i<=N; i++) {
			if (tmp[i] == K) {
				sb.append(i).append("\n");
			}
		}
		System.out.println(sb.length() == 0 ? -1 : sb);
	}

	static int[] dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		min_dis = new int[N+1];
		Arrays.fill(min_dis,INF);
		min_dis[start] = 0;
		pq.offer(new Node(start,0));

		while(!pq.isEmpty()){
			Node cur = pq.poll();

			if (min_dis[cur.node] < cur.cost) continue;

			for (Node next: arr.get(cur.node)){
				if (min_dis[next.node] > cur.cost + next.cost) {
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