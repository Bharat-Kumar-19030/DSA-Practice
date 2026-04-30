class Solution {
    boolean contain(HashMap<Character,Integer> set,HashMap<Character,Integer> map){
        for(Map.Entry<Character,Integer> entry:set.entrySet()){
            if(!map.containsKey(entry.getKey())){
                return false;
            }else if(map.containsKey(entry.getKey())&&map.get(entry.getKey())<entry.getValue()){
                return false;
            }
        }
        return true;
    }
    public String minWindow(String s, String t) {
        int ptr1 = 0, ptr2 = 0;
        HashMap<Character,Integer> set = new HashMap<>();
        int setlen=0,maplen=0;
        for (int i = 0; i < t.length(); i++) {
            set.put(t.charAt(i),set.getOrDefault(t.charAt(i), 0) + 1);
            setlen++;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        String ret = "";
        while (ptr2 < s.length()) {
            char curr = s.charAt(ptr2);
            ptr2++;
            if (set.containsKey(curr)) {
                map.put(curr, map.getOrDefault(curr, 0) + 1);
                maplen++;
            }
            if(map.size()>0){
                while (!map.containsKey(s.charAt(ptr1))
                        || (map.containsKey(s.charAt(ptr1)) && map.get(s.charAt(ptr1)) > set.get(s.charAt(ptr1)))) {
                    
                    if (map.containsKey(s.charAt(ptr1))) {
                        map.put(s.charAt(ptr1), (map.get(s.charAt(ptr1))) - 1);
                        maplen--;
                    }
                    ptr1++;
                }
            }
            
            if (contain(set,map) && (ret.equals("") || ret.length() > ptr2 - ptr1)) {
                ret = s.substring(ptr1, ptr2);
            }


        }
        return ret;
    }
}