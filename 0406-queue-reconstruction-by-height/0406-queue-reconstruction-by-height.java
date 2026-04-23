class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,(a,b)->a[0]==b[0]?a[1]-b[1]:a[0]-b[0]);
        // for(int i[]:people){
        // System.out.println(Arrays.toString(i));
        // }
            
        int ret[][]= new int[people.length][2];
        for(int i[]:ret){
            Arrays.fill(i,-1);
        }
        for(int i=0;i<people.length;i++){
            int count=people[i][1];
            // for(int j=0;j<ret.length;j++){
                int j=0;
                while(j<ret.length&&(count>0||ret[j][0]!=-1)){
                    if(ret[j][0]==-1||ret[j][0]>=people[i][0]){
                        // System.out.println("for "+Arrays.toString(people[i])+"at: "+j+" count "+(count-1));
                        count--;
                    }
                    j++;
                }
                ret[j]=people[i];
                // System.out.println("added: "+Arrays.toString(ret[j])+"at: "+j);
                // for(int k[]:ret){
                //     System.out.println(Arrays.toString(k));
                // }
            // }
        }
        return ret;
    }
}