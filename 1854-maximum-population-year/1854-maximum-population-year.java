class Solution {
    public int maximumPopulation(int[][] logs) {
        int[] arr=new int[101];

        for(int[] log:logs){
            arr[log[0]-1950]+=1;
            arr[log[1]-1950]-=1;
        }

        int max_year=1950,max=arr[0];

        for(int i=1951;i<=2050;i++){
            arr[i-1950]+=arr[i-1950-1];
            if(arr[i-1950]>max){
                max=arr[i-1950];
                max_year=i;
            }
        }
        return max_year;
    }
}