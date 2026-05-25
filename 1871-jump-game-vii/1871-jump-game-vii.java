class Solution {
    boolean check(String s, int idx,int min,int max,int memo[]){
        if(idx==s.length()-1)return true;
        if(idx>=s.length())return false;
        if(memo[idx]!=-1)return memo[idx]==1?true:false;
        for(int i=Math.min(idx+max,s.length()-1);i>=idx+min;i--){
            if(s.charAt(i)=='0'){
                if(check(s,i,min,max,memo)){
                    return true;
                }
            }
        }
        memo[idx]=0;
        return false;
    }
    public boolean canReach(String s, int minJump, int maxJump) {
        // int memo[]= new int[s.length()];
        // Arrays.fill(memo,-1);
        // System.out.println(s.length());
        if(s.charAt(s.length()-1)=='1')return false;
        boolean visited[]= new boolean[s.length()];
        visited[0]=true;
        Queue<Integer> q= new LinkedList<>();
        int maxVisited=0;
        q.offer(0);
        while(!q.isEmpty()){
            int curr= q.poll();
            // if(curr==s.length()-1)return true
            int start = Math.max(curr + minJump, maxVisited + 1);
            int end = Math.min(curr + maxJump, s.length() - 1);
            for(int i=start;i<=end;i++){
                if(i==s.length()-1)return true;
                if(s.charAt(i)=='0'&&!visited[i]){
                    q.offer(i);
                    visited[i]=true;
                }
            }    
            maxVisited = Math.max(maxVisited, end);        
        }
        return false;
        // return check(s,0,minJump,maxJump,memo);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna