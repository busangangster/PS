import java.io.*;
import java.util.*;

/*
CheckPoints !!

- 이분탐색문제인 건 빠르게 알았지만, 자료형을 잘 체크했어야 함.
lt가 1이고, rt는 최댓값인 2^31-1이 들어가는데, 이 둘을 더할 경우 int의 범위를 벗어나게 됨.
떄문에 long형으로 선언해줬어야 함 !! 
*/

public class Main {
	static int K,N,max_v;
	static int[] arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		arr = new int[K];
		for (int i=0; i<K; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		max_v = Arrays.stream(arr).max().getAsInt();
		
		long lt = 1;
		long rt = max_v;
		long ans = 0;
		
		while (lt <= rt) {
			long mid = (lt+rt) /2 ;
			if (checkCnt(mid) >= N) {
				ans = mid;
				lt = mid+1 ;
			}
			else {
				rt = mid-1;
			}
		}
		System.out.println(ans);
	
	}
	
	static long checkCnt(long target) {
		long cnt = 0;
		for (int i=0; i<K;i++) {
			cnt += (arr[i] / target);
		}
		return cnt;
	}
}
