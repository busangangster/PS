import java.io.*;
import java.util.*;
 
class Solution {
	static int D,W,K,ans;
	static int[][] graph,copy;
	static boolean[] isSelected;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for (int tc=1; tc<=t; tc++) {
			st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			graph = new int[D][W];
			copy = new int[D][W];
			isSelected = new boolean[D];
			ans = Integer.MAX_VALUE;

			for (int i=0; i<D; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j=0; j<W; j++) {
					graph[i][j] = Integer.parseInt(st.nextToken());
					copy[i][j] = graph[i][j];
				}
			}

			if (check()) { // 약품을 투입하지 않고도, 성능검사를 통과하는 경우
				sb.append("#").append(tc).append(" ").append(0);
			}
			else {
				subset(0); // 부분집합 start
				sb.append("#").append(tc).append(" ").append(ans);
			}
			sb.append("\n");
		}
		System.out.println(sb);

	}
	
	// 부분집합으로 어디에 약물을 투입할지 결정
	static void subset(int cnt) { 
		if (cnt == D) { // cnt가 D일 때
			dfs(isSelected,0,0); // 약품 투입해주고
			renew(); // 맵 초기화 
			return;
		}

		isSelected[cnt] = true;
		subset(cnt+1);
		isSelected[cnt] = false;
		subset(cnt+1);
		
	}

	static void dfs(boolean[] checked,int cnt, int idx) {
		if (cnt >= ans) return; // 약품 투입횟수가 기존 ans보다 더 커지면 어차피 답이 되지 않기 때문에 바로 return. 

		if (idx == D) {
			if (check()) { // 유효성 검사가 true인 경우, ans값 갱신. 
				ans = Math.min(cnt,ans);
			}
			return;
		}

		if (checked[idx]) { // 약물을 투입하기로 선택한 행일 경우, 
			Arrays.fill(graph[idx],0); // A로 다 투입해보고
			dfs(checked,cnt+1,idx+1);

			Arrays.fill(graph[idx],1); // B로도 다 투입해봄. 
			dfs(checked,cnt+1,idx+1);
		}

		else { // 약물을 투입하지 않기로 한 행이면, idx만 1 증가. 
			dfs(checked,cnt,idx+1);
		}
	}

	static boolean check() {  // K만큼의 구역이 있는지 확인. 
		for (int i=0; i<W; i++) {
			int cnt = 1; // K구간 확인하는 변수 
			int start = graph[0][i]; // 초기값
			boolean flag = false; 

			for (int j=1; j<D; j++) {

				if (start == graph[j][i]) { // 같은 값이면 cnt++;
					cnt++;
				}
				else { // 아니면 초기값 변경. 
					start = graph[j][i];
					cnt = 1;
				}

				if (cnt == K) { // 구간이 존재하면 더 이상 볼 필요 X
					flag = true;
					break;
				}
			}
			if (!flag) {
				return false;
			}
		}
		return true;
	}

	static void renew() {
		for (int i=0; i<D; i++) {
			for (int j=0; j<W; j++) {
				graph[i][j] = copy[i][j];
			}
		}
	}
}
