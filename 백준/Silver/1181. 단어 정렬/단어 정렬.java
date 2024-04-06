import java.io.*;
import java.util.*;
 
class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		HashMap<String,Integer> hm = new HashMap<>();
		ArrayList<Word> arr = new ArrayList<>();

		int n = Integer.parseInt(br.readLine());
		for (int i=0; i<n; i++) {
			String s = br.readLine();
			if (!hm.containsKey(s)) {
				hm.put(s, 1);
				arr.add(new Word(s, s.length()));
			} 
		}
		
		Collections.sort(arr);
		for (Word x : arr) {
			sb.append(x.s).append("\n");
		}
		System.out.println(sb);
	}

	static class Word implements Comparable<Word>{
		String s;
		int len;
		public Word(String s, int len) {
			this.s = s;
			this.len = s.length();
		}
		@Override
		public int compareTo(Word o) {
			if (this.len == o.len) {
				return this.s.compareTo(o.s);
			}
			return this.len - o.len;

			}		 
		}
	}