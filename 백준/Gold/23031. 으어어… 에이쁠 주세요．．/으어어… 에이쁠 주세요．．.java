import java.io.*;
import java.util.*;

public class Main {
	static int N,cur_x,cur_y,cur_d;
	static char[][] graph;
	static boolean[][] light;
	static char[] cmd;
	static boolean flag = true;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int[] lx = {-1,0,1,0,-1,-1,1,1};
	static int[] ly = {0,1,0,-1,-1,1,1,-1};
	static ArrayList<Zombie> zombies;
	static ArrayList<Zombie> current;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		String s = br.readLine();
		
		cmd = new char[s.length()];
		graph = new char[N][N];
		light = new boolean[N][N];
		zombies = new ArrayList<Zombie>();
		current = new ArrayList<Zombie>();
		
		for (int i=0; i<N; i++) {
			String k = br.readLine();
			for (int j=0; j<N; j++) {
				graph[i][j] = k.charAt(j);
				if (graph[i][j] == 'Z') {
					zombies.add(new Zombie(i,j,2));
				}
			}
		}
		
		for (int i=0; i<s.length(); i++) {
			cmd[i] = s.charAt(i);
		}
		
		cur_x = 0;
		cur_y = 0;
		cur_d = 2;
		
		int idx = 0;
		while (true) {
			if (idx == s.length()) break;
			
			if (cmd[idx] == 'F') {
				move();
			}
			
			else {
				changeDirection(cmd[idx]);
			}
			
			if (findSwitch()) { // 스위치가 있으면
				turnOn(); // 블 키자
			}
			
			if(!meetZombie()) {
				flag = false;
				break;
			}
			
			if(!zombiePattern()) {
				flag = false;
				break;
			}
			
			idx++;
		}
		System.out.println(flag ? "Phew..." : "Aaaaaah!");
	}
	
	static void changeDirection(char c) { // 아리 방향전환
		if (c == 'R') {
			cur_d = (cur_d+1) % 4;
		}
		else if (c == 'L') {
			if (cur_d == 0) {
				cur_d = 3;
			}
			else if (cur_d == 1) {
				cur_d = 0;
			}
			else if (cur_d == 2) {
				cur_d = 1;
			}
			else if (cur_d == 3) {
				cur_d = 2;
			}
		}
	}
	
	static void turnOn() { // 맵에서 불키기
		light[cur_x][cur_y] = true;
		for (int i=0; i<8; i++) {
			int nx = cur_x + lx[i];
			int ny = cur_y + ly[i];
			
			if (!check(nx,ny)) continue;
			
			light[nx][ny] = true;
		
		}
	}
	
	static void move() { // 아리가 움직이는데 범위를 벗어나지 않는경우에만 움직임. 
		int nx = cur_x + dx[cur_d];
		int ny = cur_y + dy[cur_d];
		
		if (check(nx,ny)) {
			cur_x = nx;
			cur_y = ny;
		}
	}
	
	static boolean findSwitch() { // 아리가 이동한 칸에 스위치가 있는지 확인
		if(graph[cur_x][cur_y] == 'S') return true;
		else return false;
	}
	
	static boolean meetZombie() {
		if (graph[cur_x][cur_y] == 'Z') {
			if (!light[cur_x][cur_y]) {
				return false;
			}
		}
		return true;
	}
	
	static boolean zombiePattern() {
		for (int i=0; i<zombies.size(); i++) {
			Zombie cur = zombies.get(i);
			int nx = cur.x + dx[cur.d];
			int ny = cur.y + dy[cur.d];
			
			if (!check(nx,ny)) {
				cur.d = (cur.d+2)%4;
				current.add(new Zombie(cur.x,cur.y,cur.d));
			}
			else {
				if (nx == cur_x && ny == cur_y) {
					if (!light[nx][ny]) {
						return false;
					}
				}
				if (graph[nx][ny] == 'S') {
					graph[cur.x][cur.y]= 'O' ;
				}
				else {
					if (graph[cur.x][cur.y]== 'S') {
						graph[nx][ny] = 'Z';
					}
					else {
						graph[cur.x][cur.y] = 'O';
						graph[nx][ny] = 'Z';		
					}
					
				}

				current.add(new Zombie(nx,ny,cur.d));
			}
		}
		zombies.clear();
		for (Zombie z: current) {
			zombies.add(new Zombie(z.x,z.y,z.d));
		}
		current.clear();
		return true;
		
	}
	
	static boolean check(int x, int y) {
		if (0 <= x && x < N && 0 <= y && y < N) return true;
		else return false;
	}
	
	static class Zombie{
		int x, y,d;
		public Zombie(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}
}