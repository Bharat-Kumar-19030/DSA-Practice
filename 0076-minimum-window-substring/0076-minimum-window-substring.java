class Solution {
    boolean eq(HashMap<Character,Integer> map,HashMap<Character,Integer> map2){
        for(Map.Entry<Character,Integer> ent:map.entrySet()){
            if(!map2.containsKey(ent.getKey())||map2.get(ent.getKey())<ent.getValue())return false;
        }
        return true;
    }
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> map = new HashMap<>();
        HashMap<Character,Integer> map2 = new HashMap<>();
        for(int i=0;i<t.length();i++){
            map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0)+1);
        }
        int st=0;
        String ret="";
        int ans=s.length();
        for(int i=0;i<s.length();i++){            
            // if(map.containsKey(s.charAt(i))){
                map2.put(s.charAt(i),map2.getOrDefault(s.charAt(i),0)+1);
                // System.out.println("At: "+i);
            // }
            // System.out.println(map+" "+map2);
            while(st<=i&&eq(map,map2)){
                
                // System.out.println(st+" "+i);
                if(ans>=i-st+1){
                    ans=i-st+1;
                    ret=s.substring(st,i+1);
                }
                // if(map2.containsKey(s.charAt(st))){
                    map2.put(s.charAt(st),map2.getOrDefault(s.charAt(st),0)-1);
                    if(map2.get(s.charAt(st))<=0){
                        map2.remove(s.charAt(st));
                    }
                // }                
                st++;
            }
            
        }
        // if(eq(map,map2)){
        //     System.out.println(map+" "+map2);
        //     // System.out.println(st+" "+i);
        //     if(ans>=s.length()-st+1){
        //         ans=s.length()-st+1;
        //         ret=s.substring(st);
        //     }
        // }
        return ret;

    }
}