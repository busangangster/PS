import java.io.*;
import java.util.*;
 
class Main {
	static int N,M,ans;
	static int[][] graph;
	static ArrayList<Node> chickens;
	static ArrayList<Node> homes;
	static int[] running;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		graph = new int[N][N];
		ans = Integer.MAX_VALUE;
		chickens = new ArrayList<Node>();
		homes = new ArrayList<Node>();

		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
				if (graph[i][j] == 2) {
					chickens.add(new Node(i,j));
				}
				else if (graph[i][j] == 1) {
					homes.add(new Node(i,j));
				}
			}
		}
		running = new int[M];

		comb(0,0);
		System.out.println(ans);
	}

	static void comb(int cnt,int start) {
		if (cnt == M) {
			int dis = 0;
			for (int i=0; i<homes.size(); i++) {
				int res = Integer.MAX_VALUE;
				for (int j: running) {
					int tmp = Math.abs(homes.get(i).x - chickens.get(j).x) + Math.abs(homes.get(i).y - chickens.get(j).y);
					res = Math.min(tmp,res);
				}
				dis += res;
			}

			ans = Math.min(ans,dis);
			return;
		}


		for (int i=start; i<chickens.size(); i++) {
			running[cnt] = i;
			comb(cnt+1,i+1);
		}

	}
	static class Node{
		int x,y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}