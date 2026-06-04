class Solution {
    public int firstUniqChar(String s) {
        int ans[]= new int[26];
        Arrays.fill(ans,-1);
        LinkedHashMap<Integer,Integer> map= new LinkedHashMap<>();
        int ret=-1;
        for(int i=0;i<s.length();i++){
            ans[s.charAt(i)-'a']=i;
            map.put(s.charAt(i)-'a',map.getOrDefault(s.charAt(i)-'a',0)+1);
        }
        for(Map.Entry<Integer,Integer> ent:map.entrySet()){
            if(ent.getValue()==1){
                return ans[ent.getKey()];
            }
        }
        return -1;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna