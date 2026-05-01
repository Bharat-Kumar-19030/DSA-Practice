class Solution {
    public int maxRotateFunction(int[] nums) {
        int temp=0;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            temp+=(i*nums[i]);
        }
        // System.out.println(sum+" "+temp);
        int ans=temp;
        for(int i=nums.length-1;i>=0;i--){
            // System.out.println("ding: "+temp+" -"+(nums[i]*nums.length-1)+" + "+(sum-nums[i]));
            temp=temp-(nums[i]*(nums.length-1))+(sum-nums[i]);
            // System.out.println(temp);
            ans=Math.max(ans,temp);

        }
        return ans;
    }
}