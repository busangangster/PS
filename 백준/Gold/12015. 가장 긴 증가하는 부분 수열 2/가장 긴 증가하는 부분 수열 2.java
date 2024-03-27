import java.io.*;
import java.util.*;

class Main {
	static int[] arr,lis;
	static int N,len;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        
        arr = new int[N];
        lis = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        len = 1;
        lis[0] = arr[0];
        for (int i=1; i<N; i++) {
        	if (lis[len-1] < arr[i]) {
        		lis[len++] = arr[i];
        	}
        	else if (lis[len-1] > arr[i]) {
        		int tmp = bs(arr[i]);
        		lis[tmp] = arr[i];
        	}
        }
        System.out.println(len);
    }
    
    public static int bs(int target) {
    	int lt = 0;
    	int rt = len-1;
    	
    	
    	while (lt < rt) {
    		int mid = (lt+rt) / 2;
    		
    		if (lis[mid] < target) {
    			lt = mid+1;
    		}
    		else {
    			rt = mid;
    		}
    	}
    	return rt;
    }
}