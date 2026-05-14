class Solution {
    public boolean isGood(int[] nums) {
        HashMap<Integer,Integer> map= new HashMap<>();
        // int maxi=0;
        int max=nums[0];
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
            if(i>max)max=i;
            if(map.get(i)>2||i==0){
                // System.out.println(1);
                return false;
            }
        }
        int st=1;
        // System.out.println("max: "+max);
        if(map.get(max)!=2){
            //  System.out.println(2);;
             return false;
        }
        map.put(max,map.getOrDefault(max,0)-1);
        while(map.containsKey(st)){
            map.put(st,map.getOrDefault(st,0)-1);
            if(map.get(st)<=0)map.remove(st);
            st++;
        }
        if(map.size()>0){
            //  System.out.println(3);;
             return false;
        }
        return true;

    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna