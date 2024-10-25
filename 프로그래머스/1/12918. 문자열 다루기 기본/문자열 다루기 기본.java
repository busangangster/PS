class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        
        if ((s.length() == 4 || s.length() == 6 ) && check(s)) {
            return true;
        }
        else {
            return false;
        }
    }
            public static boolean check(String x) {
            try {
                Integer.parseInt(x);
                return true;
            }
            catch (NumberFormatException e) {
                return false;
            }
        }
}