import java.util.*;
class Solution {
    public ArrayList<Integer> solution(int[] arr) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        
        if (arr.length == 1) {
            ans.add(-1);
            return ans;
        }
        else {
            int k = Arrays.stream(arr).min().getAsInt();
            System.out.println(k);

            for (int i=0; i<arr.length; i++) {
                if (arr[i] == k) continue;
                else {
                    ans.add(arr[i]);
                }
            }
        }
        return ans;
    }
}