import java.util.*;
import java.io.*;
	
public class Main {
	static int N,M,P,start,end;
	static long INF,min_v;
	static ArrayList<ArrayList<Node>> graph;
	static int[] nums,nodes;
	static long[] min_dis;
	static boolean[] visited;
	static HashMap<Integer,long[]> hm;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		hm = new HashMap<>();
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList<ArrayList<Node>>();
		nums = new int[3];
		INF = 999876454321L;
		min_v = 999876454321L;
		
		
		for (int i=0; i<=N; i++) {
			graph.add(new ArrayList<>());
		}
		
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph.get(u).add(new Node(v,w));
			graph.get(v).add(new Node(u,w));
		}
		
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		P = Integer.parseInt(br.readLine());
		nodes = new int[P];
		visited = new boolean[P];
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<P; i++) {
			nodes[i] = Integer.parseInt(st.nextToken());
		}
		
		hm.put(start, dijkstra(start));
		for (int i=0; i<P; i++) {
			hm.put(nodes[i],dijkstra(nodes[i]));
		}
				
		perm(0);
		System.out.println(min_v == 999876454321L ? -1 : min_v);
	}
	
	static void perm(int cnt) {
		if (cnt == 3) {
			long tmp = 0;
		
			tmp += hm.get(start)[nums[0]];
			tmp += hm.get(nums[0])[nums[1]];
			tmp += hm.get(nums[1])[nums[2]];
			tmp += hm.get(nums[2])[end];

			min_v = Math.min(min_v, tmp);
			return;
		}

		
		for (int i=0; i<P; i++) {
			
			if (visited[i]) continue;
			
			nums[cnt] = nodes[i];
			visited[i] = true;
			perm(cnt+1);
			visited[i] = false;
			
		}
	}
	
	static long[] dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		min_dis = new long[N+1];
		Arrays.fill(min_dis,INF);
		min_dis[start] = 0;
		pq.offer(new Node(start,0));
		
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if (min_dis[cur.node] < cur.cost) continue;
			
			for (Node next: graph.get(cur.node)) {
				if (min_dis[next.node] > next.cost + cur.cost) {
					min_dis[next.node] = next.cost + cur.cost;
					pq.offer(new Node(next.node, next.cost+cur.cost));
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
//				return (int) ((int) this.cost - o.cost);
			return Long.compare(this.cost, o.cost);
		}
	}
}