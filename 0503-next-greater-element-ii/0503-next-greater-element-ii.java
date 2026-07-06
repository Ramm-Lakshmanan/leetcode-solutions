class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        Deque<Integer> stk=new ArrayDeque<>();
        int[] nge=new int[n];
        boolean[] mark=new boolean[n];
        
        for(int i=n-1;i>=0;i--){
            while(!stk.isEmpty() && stk.peek()<=nums[i]) stk.pop();

            if(stk.isEmpty()) nge[i]=-1;
            else {
                nge[i]=stk.peek();
                mark[i]=true;
            }

            stk.push(nums[i]);
        }

        for(int i=n-1;i>=0;i--){
            if(!mark[i]){
                while(!stk.isEmpty() && nums[i]>=stk.peek()) stk.pop();
                if(stk.isEmpty()) return nge;
                nge[i]=stk.peek();
                mark[i]=true;
            }
        }
        return nge;
    }
}