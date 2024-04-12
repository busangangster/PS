import java.io.*;
import java.util.*;

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