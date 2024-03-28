import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int[] cnt = new int[30];
		
		String s = br.readLine();

		for (int i=0; i<s.length();i++) {
			int tmp = 0;
			if (Character.isUpperCase(s.charAt(i))) {
				tmp = s.charAt(i) - 65;
			}
			else if (Character.isLowerCase(s.charAt(i))) {
				tmp = s.charAt(i) - 97;
			}
			cnt[tmp]++;
		}
		
		int res = Arrays.stream(cnt).max().getAsInt();
		
		ArrayList<Integer> k = new ArrayList<>();
		for (int i=0; i<cnt.length;i++) {
			if (cnt[i] == res) {
				k.add(i);
			}
		}
		if (k.size() > 1) {
			System.out.println('?');
		}
		else {
			char ans = (char) ((char) 65 + k.get(0));
			System.out.println(ans);
		}
	}
}