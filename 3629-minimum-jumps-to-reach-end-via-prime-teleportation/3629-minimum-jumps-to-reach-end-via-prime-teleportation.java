class Solution {
    public int minJumps(int[] nums) {
        int max=nums[0];
        Queue<Integer> q= new LinkedList<>();
        HashMap<Integer,HashSet<Integer>> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],new HashSet<>());
            }
            map.get(nums[i]).add(i);
            max=Math.max(max,nums[i]);
        }
        boolean seive[]= new boolean[max+1];
        if(max >= 0)seive[0]=true;
        if(max >= 1)seive[1]=true;
        for(int i=2;i*i<seive.length;i++){
            for(long j=(long)i*i;j<seive.length;j+=i){
                seive[(int)j]=true;
            }
        }
        // System.out.println(Arrays.toString(seive));
        q.offer(0);
        boolean visited[]= new boolean[nums.length];
        visited[0]=true;
        int steps=0,ret=Integer.MAX_VALUE;
        HashSet<Integer> alreadyseenprimes= new HashSet<>();
        while(!q.isEmpty()){
            int s=q.size();
            for(int i=0;i<s;i++){
                int curr=q.poll();
                // if(!visited[curr]){

                    // System.out.println("checking for: "+curr);     
                    if(curr==nums.length-1){
                        return steps;
                    }
                    if(curr>0&&!visited[curr-1]){
                        // System.out.println("added:"+(curr-1)+" due to "+curr);
                        q.offer(curr-1);
                        visited[curr-1]=true;
                    }
                    if(curr+1<nums.length&&!visited[curr+1]){
                        // System.out.println("added:"+(curr+1)+" due to "+curr);
                        q.offer(curr+1);
                        visited[curr+1]=true;
                    }
                    if(seive[nums[curr]]==false&&!alreadyseenprimes.contains(nums[curr])){
                        // System.out.println("prime: "+nums[curr]);
                        int temp=nums[curr];
                        while(temp<=max){
                            if(map.containsKey(temp)){
                                // System.out.println("mul of"+nums[curr]+" "+ map.get(temp));
                                for(int j:map.get(temp)){
                                    if(!visited[j]){
                                        q.offer(j);
                                        visited[j]=true;
                                    }
                                }
                            }
                            temp+=nums[curr];
                        }
                        // visited[nums[curr]]=true;
                        alreadyseenprimes.add(nums[curr]);
                    }  
                    // visited[curr]=true;                      
                // }                
            }
            steps++;
        }
        return ret;
    }
}