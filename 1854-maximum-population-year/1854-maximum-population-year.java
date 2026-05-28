class Solution {
    public int maximumPopulation(int[][] logs) {
        int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
        for(int[] log:logs){
            min=Math.min(min,log[0]);
            max=Math.max(max,log[1]);
        }
        int[] arr=new int[max-min+1];
        for(int[] log:logs){
            arr[log[0]-min]+=1;
            arr[log[1]-min]-=1;
        }
        int max_pop=0;
        int sum=0;
        int year=-1;
        for(int i=0;i<max-min+1;i++){
            sum+=arr[i];
            if(sum>max_pop){
                max_pop=sum;
                year=i+min;
            }
        }
        return year;
    }
}