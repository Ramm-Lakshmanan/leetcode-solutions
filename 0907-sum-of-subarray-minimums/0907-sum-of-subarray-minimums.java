class Solution {
    public int sumSubarrayMins(int[] arr) {
        int[] nse=new int[arr.length];
        int[] pse=new int[arr.length];
        Stack<Integer> stk1=new Stack<>();
        Stack<Integer> stk2=new Stack<>();
        for(int i=arr.length-1;i>=0;i--){
            while(!stk1.isEmpty() && arr[i]<=arr[stk1.peek()]){
                stk1.pop();
            }
            if(stk1.isEmpty()) nse[i]=arr.length;
            else nse[i]=stk1.peek();
            stk1.push(i);
        }
        for(int i=0;i<arr.length;i++){
            while(!stk2.isEmpty() && arr[i] < arr[stk2.peek()]){  
                stk2.pop();
            }
            if(stk2.isEmpty()) pse[i] = -1;
            else pse[i] = stk2.peek();
            stk2.push(i);
        }

        long mod = 1000000007;
        long res = 0;

        for (int i = 0; i < arr.length; i++) {
            long left = i - pse[i];
            long right = nse[i] - i;
            res = (res + (left * right % mod) * arr[i] % mod) % mod;
        }
        return (int) res;
    }
}