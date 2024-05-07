import java.io.*;
import java.util.*;

public class Main {
	static int N,min_v;
	static int[] population;
	static boolean[] isSelected,visited;
	static ArrayList<Integer> districtA, districtB;
	static ArrayList<ArrayList<Integer>> graph;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		population = new int[N+1];
		graph = new ArrayList<ArrayList<Integer>>();
		isSelected = new boolean[N+1];
		min_v = Integer.MAX_VALUE;
		
		st = new StringTokenizer(br.readLine());
		for (int i=1; i<=N; i++) {
			population[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i=0; i<=N; i++) {
			graph.add(new ArrayList<>());
		}
		
		for (int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			for (int j=0; j<n; j++) {
				int a = Integer.parseInt(st.nextToken());
				graph.get(i).add(a);
				graph.get(a).add(i);
			}
			
		}
		subset(0);
		System.out.println(min_v == Integer.MAX_VALUE ? -1 : min_v);
	}
	
	static void subset(int cnt) {
		if (cnt == N) {
			districtA = new ArrayList<>();
			districtB = new ArrayList<>();
			
			for (int i=1; i<=N; i++) {
				if (isSelected[i] == true) {
					districtA.add(i);
				}
				else {
					districtB.add(i);
				}
			}
			
			if (districtA.size() == 0 || districtB.size() == 0) {
				return;
			}
			
			if (bfs(districtA) && bfs(districtB)) {
				min_v = Math.min(min_v, calculateGap());
			}
			
			return;
		}
		
		isSelected[cnt] = true;
		subset(cnt+1);
		isSelected[cnt] = false;
		subset(cnt+1);
		
	}
	
	static boolean bfs(ArrayList<Integer> arr) {
		Queue<Integer> q = new ArrayDeque<Integer>();
		visited = new boolean[N+1];
		q.offer(arr.get(0));
		visited[arr.get(0)] = true;
		int cnt = 1;
		
		while (!q.isEmpty()) {
			int cur = q.poll();
			
			for (int i=0; i<graph.get(cur).size(); i++) {
				int x = graph.get(cur).get(i);
				if (arr.contains(x) && !visited[x]) {
					q.offer(x);
					visited[x] = true;
					cnt++;
				}
			}
		}
		if (cnt == arr.size()) {
			return true;
		}
		return false;
	}
	
	static int calculateGap() {
		int populA = 0;
		int populB = 0;
		
		for (int x : districtA) {
			populA += population[x];
		}
		for (int x: districtB) {
			populB += population[x];
		}
		return Math.abs(populA - populB);
	}
}