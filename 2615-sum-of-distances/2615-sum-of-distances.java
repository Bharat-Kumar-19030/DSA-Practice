class pair{
    int val;
    ArrayList<Integer> list;
    pair(int v){
        val=v;
        list= new ArrayList<>();
    }
}
class Solution {
    public long[] distance(int[] nums) {
        long ret[]= new long[nums.length];
        HashMap<Integer,pair> map= new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],new pair(0));
                map.get(nums[i]).list.add(i);
            }else{
                map.get(nums[i]).val+=Math.abs(map.get(nums[i]).list.get(0)-i);
                map.get(nums[i]).list.add(i);
            }
        }
        // for(Map.Entry<Integer,pair> ent:map.entrySet()){
        //     System.out.println(ent.getKey()+" "+ent.getValue().val+" "+ent.getValue().list);
        // }
        for(Map.Entry<Integer,pair> ent:map.entrySet()){
            if(ent.getValue().list.size()>1){
                ret[ent.getValue().list.get(0)]=ent.getValue().val;
                long prev=ent.getValue().val;
                for(int i=1;i<ent.getValue().list.size();i++){
                    int curridx=ent.getValue().list.get(i);
                    int previdx=ent.getValue().list.get(i-1);
                    ret[curridx]=prev-(curridx-previdx)*(ent.getValue().list.size()-i)+(curridx-previdx)*i;
                    prev=ret[curridx];
                }
            }
        }
        return ret;
    }
}