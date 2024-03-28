import java.io.*;
import java.util.*;

class Main {
	static int R,C,target_x,target_y;
	static Queue<Pos> hedgehog,water;
	static boolean[][] visited1, visited2;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static char[][] graph;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        graph = new char[R][C];
        visited1 = new boolean[R][C];
        visited2 = new boolean[R][C];
        hedgehog = new ArrayDeque<>();
        water = new ArrayDeque<>();
        
        for (int i=0; i<R; i++) {
        	String s = br.readLine();
        	for (int j=0; j<C; j++) {
        		if (s.charAt(j) == '*') {
        			water.add(new Pos(i,j));
        			visited1[i][j] = true;
        			
        		}
        		else if (s.charAt(j) == 'S') {
        			hedgehog.add(new Pos(i,j));
        			visited2[i][j] = true;
        			graph[i][j] = '.';
        		}
        		else {
        			if (s.charAt(j) == 'D') {
        				target_x = i;
        				target_y = j;
        			}
        			graph[i][j] = s.charAt(j);
        		}
        	}
        }
        
        int ans = solve();
        
        System.out.println(ans == -1? "KAKTUS" : ans );
    	
    }
    
    public static int solve() {
		int tmp = 0;
		
    	while (!hedgehog.isEmpty()) {
    		

    		
    		int hog = hedgehog.size();
    		int w = water.size();
    		
    		for (int i=0; i<w; i++) {
    			Pos cur = water.poll();
    			
    			for (int j=0; j<4; j++) {
    				int nx = cur.x + dx[j];
    				int ny = cur.y + dy[j];
    				
    				if (!check(nx,ny)) continue;
    				if (visited1[nx][ny]) continue;
    				if (graph[nx][ny] == 'X' || graph[nx][ny] == 'D') continue;
    				
    				graph[nx][ny] = '*';
    				visited1[nx][ny] = true;
    				water.offer(new Pos(nx,ny));
    			}
    		}
    		
    		for (int i=0; i< hog; i++) {
    			Pos cur = hedgehog.poll();
    			
    			for (int j=0; j<4; j++) {
    				int nx = cur.x + dx[j];
    				int ny = cur.y + dy[j];
    				
    				if (nx == target_x && ny == target_y) {
    					return tmp+1;
    				}
    				if (!check(nx,ny)) continue;
    				if (visited2[nx][ny]) continue;
    				if (graph[nx][ny] == 'X' || graph[nx][ny] == '*') continue;
    				
    				visited2[nx][ny] = true;
    				hedgehog.offer(new Pos(nx,ny));

    			}
    		}
    		tmp++;
    	}
    	return -1;
    	
    }
    
    public static boolean check(int x, int y) {
    	if (0 <= x &&  x < R && 0 <= y && y < C ) return true;
    	else return false;
    }
}

class Pos{
	int x,y;
	public Pos(int x, int y) {
		this.x = x;
		this.y = y;
	}
}