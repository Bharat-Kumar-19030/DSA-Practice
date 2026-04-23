class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        ArrayList<double[]> list= new ArrayList<>();
        for(int i=0;i<wage.length;i++){
            list.add(new double[]{(double)wage[i]/quality[i],quality[i]});
        }
        Collections.sort(list,(a,b)->Double.compare(a[0],b[0]));
        // for(double i[]:list){
        //     System.out.println(Arrays.toString(i)+" "+(double)i[1]/i[0]*1.0);
        // }
        int totalqual=0;
        double wag=Integer.MAX_VALUE;
        PriorityQueue<Double> pq=new PriorityQueue<>(Collections.reverseOrder());
        // System.out.println(wag);
        for(int i=0;i<list.size();i++){            
            totalqual+=list.get(i)[1];
            pq.offer(list.get(i)[1]);
            if(pq.size()>k){
                totalqual-=pq.poll();
            }
            if(pq.size()==k){
                wag=Math.min(wag,totalqual*list.get(i)[0]);
            }
        }
        return wag;
    }
}