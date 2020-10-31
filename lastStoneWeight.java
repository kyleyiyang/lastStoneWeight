class Solution {
    public int lastStoneWeight(int[] stones) {
        if (stones.length==1) {
            return stones[0];
        } else if (stones.length==2) {
            return Math.abs(stones[0]-stones[1]);
        } else {
            ArrayList<Integer> s = new ArrayList<>();
            int max=0;
            for (int i=0;i<stones.length;i++) {
                if (stones[i]>max) {
                    max=stones[i];
                }
                s.add(stones[i]);
            }
            s.remove(s.indexOf(max));
            int max2=0;
            while(s.size()>0) {
                max2=getMax(s);
                if (s.size()==1) {
                    return Math.abs(max-max2);
                }
                //s.remove(s.indexOf(max2));
                //s.add(Math.abs(max-max2));
                s.set(s.indexOf(max2),Math.abs(max-max2));
                max=getMax(s);
                s.remove(s.indexOf(max));
            }
            return s.get(0);
        }
    }
    public static int getMax(ArrayList<Integer> arr) {
        int m = 0;
        for (int i:arr) {
            if (i>m) {
                m=i;
            }
        }
        return m;
    }
}
