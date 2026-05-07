class Solution {
    public int[] maxValue(int[] nums) {
        int maxprev[]= new int[nums.length];
        maxprev[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            maxprev[i]=Math.max(maxprev[i-1],nums[i]);
        }
        int minsuf[]= new int[nums.length];
        minsuf[nums.length-1]=nums[nums.length-1];
        for(int i=nums.length-2;i>=0;i--){
            minsuf[i]=Math.min(nums[i],minsuf[i+1]);
        }
        // System.out.println(Arrays.toString(maxprev));
        // System.out.println(Arrays.toString(minsuf));
        int ret[]= new int[nums.length];
        ret[ret.length-1]=maxprev[nums.length-1];
        for(int i=nums.length-2;i>=0;i--){
            ret[i]=maxprev[i];
            if(minsuf[i+1]<maxprev[i]){
                ret[i]=ret[i+1];
            }
        }
        return ret;
    }
}