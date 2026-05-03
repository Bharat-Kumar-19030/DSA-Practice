class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length()!=goal.length())return false;
        StringBuilder sb= new StringBuilder(s);
        int rotate=0;
        while(rotate<s.length()){
            sb.append(sb.charAt(0));
            sb.deleteCharAt(0);
            rotate++;
            if(goal.equals(sb.toString()))return true;
        }
        return false;

    }
}