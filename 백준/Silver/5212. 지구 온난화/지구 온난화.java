import java.io.*;
import java.util.*;

class Main { 
	static int R,C,minX,maxX,minY,maxY;
	static char[][] graph;
	static char[][] new_graph;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		minX = Integer.MAX_VALUE;
		maxX = Integer.MIN_VALUE;
		minY = Integer.MAX_VALUE;
		maxY = Integer.MIN_VALUE;

		graph = new char[R][C];
		new_graph = new char[R][C];
		for (int i=0; i<R; i++){
			String s = br.readLine();
			for (int j=0; j<C; j++) {
				graph[i][j] = s.charAt(j);
				new_graph[i][j] = '.';
			}
		}
		
		for (int i=0; i<R; i++) {
			for (int j=0; j<C; j++) {
				if (graph[i][j] == 'X') {
					int cnt = 0;
					for (int k=0; k<4; k++) {
						int nx = i+dx[k];
						int ny = j+dy[k];
						if (!check(nx,ny)) {
							cnt++;
						}
						else if (graph[nx][ny] == '.') {
							cnt++;
						}
					}
					if (cnt < 3) {
						new_graph[i][j] = 'X';
						minX = Math.min(minX,i);
						maxX = Math.max(maxX,i);
						minY = Math.min(minY, j);
						maxY = Math.max(maxY,j);
					}
				}
			}
		}

		for (int i=minX; i<=maxX; i++) {
			for (int j=minY; j<=maxY; j++) {
				sb.append(new_graph[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
		
	}
	public static boolean check(int x, int y){
		if (0 <= x && x < R && 0 <= y && y < C) return true;
		else return false;
	}
}