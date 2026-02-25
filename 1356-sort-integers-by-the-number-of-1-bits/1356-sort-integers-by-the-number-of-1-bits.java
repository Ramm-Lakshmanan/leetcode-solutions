class Solution {
    public int[] sortByBits(int[] arr) {
        int n=arr.length;
        Integer[] temp=new Integer[n];
        for(int i=0;i<n;i++){
            temp[i]=arr[i];
        }
        Arrays.sort(temp,(a,b)->{
            if(Integer.bitCount(a)==Integer.bitCount(b)) return (a-b);
            return Integer.bitCount(a)-Integer.bitCount(b);
        });

        for(int i=0;i<n;i++) arr[i]=temp[i];
        return arr;
    }
}