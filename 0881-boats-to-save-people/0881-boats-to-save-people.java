class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i=0,j=people.length-1;
        // System.out.println(Arrays.toString(people));
        int ans=0;
        while(i<=j){
            int toadd=people[j];
            j--;
            // while(i<=j){
                if(toadd+people[i]<=limit){
                    toadd+=people[i];
                    i++;
                }
                // else break;
            // }
            ans++;            
        }
        return ans;
    }
}