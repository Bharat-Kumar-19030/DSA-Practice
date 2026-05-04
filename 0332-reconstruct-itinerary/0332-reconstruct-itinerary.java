class Solution {    
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String,ArrayList<String>> map= new HashMap<>();       
        List<String> ret= new ArrayList<>();
        for(int i=0;i<tickets.size();i++){
            if(!map.containsKey(tickets.get(i).get(0))){
                map.put(tickets.get(i).get(0),new ArrayList<>());
                // map2.put(k,tickets.get(i).get(0));
                // k++;
            }
            if(!map.containsKey(tickets.get(i).get(1))){
                map.put(tickets.get(i).get(1),new ArrayList<>());
                // map2.put(k,tickets.get(i).get(1));
                // k++;
            }
            map.get(tickets.get(i).get(0)).add(tickets.get(i).get(1));     
        }
        for(Map.Entry<String,ArrayList<String>> ent: map.entrySet()){
            Collections.sort(ent.getValue());
        }
        // System.out.println(map);
        Stack<String> st= new Stack<>();
        st.add("JFK");
        while(!st.isEmpty()){
            ArrayList<String> list= map.get(st.peek());
            if(list.size()==0){
                ret.add(st.pop());
            }
            else{
                String ele=map.get(st.peek()).get(0);
                map.get(st.peek()).remove(0);
                st.push(ele);
            }
        }
        Collections.reverse(ret);
        return ret;
    }
}