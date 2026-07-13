class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n=nums.length;
        List<Integer> ans=new ArrayList<>();
        
        int ele1=-1,cnt1=0,ele2=-1,cnt2=0;

        for(int i=0;i<n;i++){
            if(nums[i]==ele1) cnt1++;
            else if(nums[i]==ele2) cnt2++;
            else if(cnt1==0){
                ele1=nums[i];cnt1=1;
            }
            else if(cnt2==0){
                ele2=nums[i];cnt2=1;
            }
            else{
                cnt1--;cnt2--;
            }
        }

        cnt1=0;cnt2=0;

        for(int ele:nums){
            if(ele==ele1) cnt1++;
            else if(ele==ele2) cnt2++;
        }

        if(cnt1>n/3) ans.add(ele1);
        if(cnt2>n/3) ans.add(ele2);

        return ans;
    }
}