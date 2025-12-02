class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n=gas.length;
        int req=0;
        int have=0;
        int test=0;
        int idx=-1;
        int tot=0;
        for(int i=0;i<n;i++){
            if(cost[i]>gas[i]){
                req+=(cost[i]-gas[i]);
                if(have>0){
                    test+=(cost[i]-gas[i]);
                    if(test>have){
                        have=0;
                        test=0;
                        idx=-1;
                    }
                }
            }
            else{
                tot+=(gas[i]-cost[i]);
                if(have==0){
                    idx=i;
                    test=0;
                }
                have+=(gas[i]-cost[i]);
            }
        }
        if(tot<req) return -1;
        else{
            return idx;
        }
    }
}