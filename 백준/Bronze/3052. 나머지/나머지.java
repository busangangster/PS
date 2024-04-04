import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		
		HashMap<Integer,Integer> hm = new HashMap<>();

		
		for (int i=0; i<10; i++) {
			int k = Integer.parseInt(br.readLine());
			hm.put(k%42,hm.getOrDefault(k%42, 0)+1);
		}
		
		System.out.println(hm.size());
		
		
	}
}