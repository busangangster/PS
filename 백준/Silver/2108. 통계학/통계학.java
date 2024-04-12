import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		HashMap<Integer,Integer> hm = new HashMap<>();
		ArrayList<Integer> findFre = new ArrayList<>();
		
		for (int i=0; i<n;i ++) {
			int k = Integer.parseInt(br.readLine());
			arr[i] = k;
			hm.put(k, hm.getOrDefault(k, 0)+1);
		}
		
		int first = (int) Math.round((double)((double) Arrays.stream(arr).sum() / n)) ;
		Arrays.sort(arr);

		int second = 0;
		if (n != 1) second = n/2; 
		
		int fre = Integer.MIN_VALUE;
		for (Integer key:  hm.keySet()) {
			fre = Math.max(fre, hm.get(key));
		}
		
		for (Integer key: hm.keySet()) {
			if (hm.get(key) == fre) findFre.add(key);
		}
		
		Collections.sort(findFre);
		
		int fourth = Arrays.stream(arr).max().getAsInt() - Arrays.stream(arr).min().getAsInt();
		
		sb.append(first).append("\n").append(arr[second]).append("\n").append(findFre.size()==1 ? findFre.get(0) : findFre.get(1)).append("\n").append(fourth);
		System.out.println(sb);
	}
	
}