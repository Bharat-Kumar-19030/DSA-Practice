class Solution {
    int check(int pos,String str,int idx,int memo[][]){
        if(idx==str.length()){
            return Math.abs(pos);
        }
        if(memo[idx][pos+str.length()]!=-1)return memo[idx][pos+str.length()];
        int ans=0;
        if(str.charAt(idx)=='L'){
            ans=check(pos-1,str,idx+1,memo);
        }
        else if(str.charAt(idx)=='R'){
            ans=check(pos+1,str,idx+1,memo);
        }
        else{
            ans=Math.max(check(pos-1,str,idx+1,memo),check(pos+1,str,idx+1,memo));
        }
        return memo[idx][pos+str.length()]=ans;
    }
    public int furthestDistanceFromOrigin(String moves) {
        int memo[][]= new int[moves.length()][moves.length()*2+1];
        for(int i[]:memo){
            Arrays.fill(i,-1);
        }
        return check(0,moves,0,memo);
    }
}