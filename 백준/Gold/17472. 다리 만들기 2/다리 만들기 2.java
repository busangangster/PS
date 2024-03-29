import java.io.*;
import java.util.*;

class Main {
	static int N,M,INF,num,answer;
	static int[][] graph,island;
	static boolean[][] visited;
	static boolean[] visited2;
	static ArrayList<ArrayList<Pos>> arr;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int[][] cost;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        graph = new int[N][M];
        island = new int[N][M];
        visited = new boolean[N][M];
        arr = new ArrayList<ArrayList<Pos>>();  

        INF = Integer.MAX_VALUE;
        answer= Integer.MIN_VALUE;

        

        for (int i=0; i<N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for (int j=0; j<M; j++) {
        		graph[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        num = 1;
        for (int i=0; i<N; i++) {
        	for (int j=0; j<M; j++) {
        		if (graph[i][j] == 1 && !visited[i][j]) {
        			island[i][j] = num;
        			bfs(i,j,num);
        			num++;
        		}
        		
        	}
        }

        
        for (int i=0; i<=num; i++) {
        	arr.add(new ArrayList<>());
        }
        
        cost = new int[num][num];
        
        for (int[] x: cost) {
        	Arrays.fill(x,INF);
        }
        
        for (int i=0; i<N; i++) {
        	for (int j=0; j<M; j++) {
        		if (island[i][j] == 1) {
        			findCost(i, j, 1);
        		}else if (island[i][j] == 2) {
        			findCost(i, j, 2);
        		}else if (island[i][j] == 3) {
        			findCost(i, j, 3);
        		}else if (island[i][j] == 4) {
        			findCost(i, j, 4);
        		}else if (island[i][j] == 5) {
        			findCost(i, j, 5);
        		}else if (island[i][j] == 6) {
        			findCost(i, j, 6);
        		}
        	}
        }
        
        for (int i=0; i<cost.length; i++) {
        	for (int j=0; j<cost.length; j++) {
        		if (cost[i][j] != INF) {
        			arr.get(i).add(new Pos(j,cost[i][j]));
        		}
        	}
        }
        for (int i = 1; i < num; i++) {
            boolean flag = true;
            int res = prim(i);
//            System.out.println(res);
            for (int j = 1; j < num; j++) {
               if (visited2[j] == false) {
                  flag = false;
                  break;
               }
            }

            if (flag == true) {
               if (res != 0) {
                  answer = Math.max(res, answer);
               }
            } else {
            	answer = -1;
               break;
            }
         }
//        System.out.println(arr);
//        for (int[] x: island) {
//        	System.out.println(Arrays.toString(x));
//        }
        System.out.println(answer == Integer.MIN_VALUE ? -1 : answer);

        
    }
    
    public static boolean check(int x, int y) {
    	if (0 <= x && x < N && 0 <= y && y < M) return true;
    	else return false;
    }
    
    public static void bfs(int x, int y,int num) {
    	Queue<Node> q = new ArrayDeque<>();
    	q.offer(new Node(x,y));
    	visited[x][y] = true;
    	
    	while (!q.isEmpty()) {
    		Node cur = q.poll();
    		
    		for (int i=0; i<4; i++) {
    			int nx = cur.x + dx[i];
    			int ny = cur.y + dy[i];
    			
    			if (check(nx,ny) && !visited[nx][ny] && graph[nx][ny] == 1) {
    				visited[nx][ny] = true;
    				island[nx][ny] = num;
    				q.offer(new Node(nx,ny));
    			}
    		}
    	}
    }
    
    public static void findCost(int i, int j, int current) {
    	for (int d=0; d<4; d++) {
        	int x = i;
        	int y = j;
        	int dis = 0;
        	int another = 0;
        	
        	while (true) {
        		x += dx[d];
        		y += dy[d];
        		
        		if (!check(x,y)) break;
        		
        		if (island[x][y] != 0 && island[x][y] != current) {
        			another = island[x][y];
        			if (dis >= 2)  {
        				cost[current][another] = Math.min(cost[current][another], dis);
        			}
        			break;
        		}
        		else if (island[x][y] == 0) {
        			dis++;
        		}
        	}
    	}
	
    }
    
    public static int prim(int start) {
    	PriorityQueue<Pos> pq = new PriorityQueue<>();
        visited2 = new boolean[num+1];
    	pq.offer(new Pos(start,0));
    	int ans = 0;
    	
    	while (!pq.isEmpty()) {
    		Pos cur = pq.poll();
    		
    		if (visited2[cur.node]) continue;
    		
    		ans += cur.cost;
    		visited2[cur.node]= true;
    		
    		for (Pos next: arr.get(cur.node)) {
    			if (!visited2[next.node]) {
    				pq.offer(new Pos(next.node,next.cost));
    			}
    		}
    	}
    	return ans;
    }
}

class Node{
	int x,y;
	public Node(int x, int y) {
		this.x = x;
		this.y = y;
		
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