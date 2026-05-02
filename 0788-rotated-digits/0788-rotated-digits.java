class Solution {
    public int rotatedDigits(int n) {
        int ans=0;
        for(int i=1;i<=n;i++){
            int temp=i;
            boolean found=false;
            while(temp>0){
                int l=temp%10;
                temp/=10;
                if(l==0||l==1||l==8){
                    continue;
                }
                else if(l==5||l==9||l==2||l==6){
                    found=true;
                }
                // else if(l==2){
                //     // if(temp*10+5<=n){
                //         found=true;
                //     // }
                // }else if(l==6){
                //     // if(temp*10+9<=n){
                //         found=true;
                //     // }
                // }
            }
            if(found){
                // System.out.println("true for :"+i);
                ans++;
            }
        }
        return ans;
    }
}