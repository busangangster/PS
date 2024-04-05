import java.util.*;
import java.io.*;

public class Main {
	static String parent,pattern;
	static int[] table;
	static StringBuilder sb = new StringBuilder();
	static ArrayList<Integer> arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		parent = br.readLine();
		pattern = br.readLine();
		
		table = new int[pattern.length()];
		
		arr = new ArrayList<Integer>();

		kmp();
		System.out.println(arr.size());
		for (int x: arr) {
			System.out.print(x+" ");
		}
		
	}
	
	static void makeTable() {
		int n = pattern.length();
		
		int idx = 0;
		
		for (int i=1; i<n; i++) {
			while (idx > 0 && pattern.charAt(i) != pattern.charAt(idx)) {
				idx = table[idx-1];
			}
			
			if (pattern.charAt(i) == pattern.charAt(idx)) {
				idx++;
				table[i] = idx;
			}
		}
	}
	
    static void kmp() {
    	makeTable();
    	
    	int parentSize = parent.length();
    	int patternSize = pattern.length();
    	
    	int idx = 0;
    	
    	for (int i=0; i<parentSize; i++) {
    		while (idx >0 && parent.charAt(i) != pattern.charAt(idx)) {
    			idx = table[idx-1];
    		}
    		if (parent.charAt(i) == pattern.charAt(idx)) {
    			if (idx == patternSize - 1) {
    				arr.add(i-idx+1);
    				idx = table[idx];
    			} else {
    				idx += 1;
    			}
    		}
    	}
    }
}