import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = " ";
        String[] arr = s.split(" ");
        ArrayList<Integer> arr2 = new ArrayList<Integer>();
        for (String val : arr) {
            arr2.add(Integer.parseInt(val));
        }
        Collections.sort(arr2);
        // System.out.println(arr2.toString());
        return arr2.get(0) + " " + arr2.get(arr2.size() -1 );
    }
}