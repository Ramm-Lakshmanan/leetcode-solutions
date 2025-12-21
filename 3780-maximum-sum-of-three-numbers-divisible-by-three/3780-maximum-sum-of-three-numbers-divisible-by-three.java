class Solution {
    public int maximumSum(int[] nums) {
        List<Integer> mod1=new ArrayList<>();
        List<Integer> mod2=new ArrayList<>();
        List<Integer> mod0=new ArrayList<>();
        Arrays.sort(nums);
        for(int i:nums){
            if(i%3==0) mod0.add(i);
            else if(i%3==2) mod2.add(i);
            else mod1.add(i);
        }
        int pos1=0,pos2=0,pos3=0,pos4=0;
        if(mod0.size()>=3){
            for(int i=0;i<3;i++){
                pos1+=mod0.get(mod0.size()-i-1);
            }
        }
        if(mod1.size()>=3){
            for(int i=0;i<3;i++){
                pos2+=mod1.get(mod1.size()-i-1);
            }
        }
        if(mod2.size()>=3){
            for(int i=0;i<3;i++){
                pos3+=mod2.get(mod2.size()-i-1);
            }
        }
        if(mod0.size()>=1 && mod1.size()>=1 && mod2.size()>=1){
            pos4+=mod0.get(mod0.size()-1)+mod1.get(mod1.size()-1)+mod2.get(mod2.size()-1);
        }
        return Math.max(Math.max(Math.max(pos1,pos2),pos3),pos4);
    }
}