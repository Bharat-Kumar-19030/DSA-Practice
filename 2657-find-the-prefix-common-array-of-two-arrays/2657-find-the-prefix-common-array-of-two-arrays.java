class Solution {
    int check(HashMap<Integer,Integer> map){
        int count=0;
        for(int i:map.keySet()){
            if(map.get(i)==2){
                count++;
            }
        }
        return count;
    }
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int ret[]= new int[A.length];
        HashMap<Integer,Integer> map= new HashMap<>();
        // HashSet<Integer> set2= new HashSet<>();
        for(int i=0;i<A.length;i++){
            if(!map.containsKey(A[i])){
                map.put(A[i],0);
            }
            if(!map.containsKey(B[i])){
                map.put(B[i],0);
            }
            map.put(A[i],map.get(A[i])+1);
            map.put(B[i],map.get(B[i])+1);
            ret[i]=check(map);
        }
        return ret;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna