import java.util.*;
import java.io.*;

public class Main {
	public static int[] dx = {-1,0,1,0,-1,-1,1,1};
	public static int[] dy = {0,1,0,-1,-1,1,1,-1};
	public static boolean[][] visited;
	public static int[][] arr;
	public static int w,h;
    public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		while (true) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			if (w == 0 && h == 0) break;
			else {
				arr = new int[h][w];
				visited = new boolean[h][w];
				int cnt = 0;
				for (int i=0; i<h; i++) {
					st = new StringTokenizer(br.readLine());
					for (int j=0; j<w; j++) {
						arr[i][j] = Integer.parseInt(st.nextToken());
					}
				}
				
				for (int i=0; i<h; i++) {
					for (int j=0; j<w; j++) {
						if (!visited[i][j] && arr[i][j] == 1) {
							cnt++;
							BFS(i,j);
						}
					}
				}
				sb.append(cnt).append("\n");
			}
		}
		System.out.println(sb);
	}
    
    public static void BFS(int x, int y) {
    	Queue<Node> q = new ArrayDeque<Node>();
    	q.offer(new Node(x,y));
    	visited[x][y] = true;
    	    	
    	while (!q.isEmpty()) {
    		Node cur = q.poll();
    		
    		for (int i=0; i<8; i++) {
    			int nx = cur.x + dx[i];
    			int ny = cur.y + dy[i];
    			
    			if (check(nx,ny) && !visited[nx][ny] && arr[nx][ny] != 0) {
    				visited[nx][ny] = true;
    				q.add(new Node(nx,ny));
    			}
    		}
    	}
    }
    
    public static boolean check(int x, int y) {
    	if (0 <= x && x < h && 0 <= y && y < w) return true;
    	else return false;
    }
}

class Node{
	int x;
	int y;
	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}