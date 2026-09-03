class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n=nums.length;
        int[][] arr=new int[n][2];

        for(int i=0;i<n;i++){
            arr[i][0]=nums[i];
            arr[i][1]=i;
        }

        Arrays.sort(arr,(a,b)->Integer.compare(a[0],b[0]));

        int[] a1=new int[n];int[] a2=new int[n];

        for(int i=0;i<n;i++){
            a1[i]=arr[i][0];
            a2[i]=arr[i][1];
        }

        int l=0,r=1;

        while(r<n){
            if(a1[r]-a1[r-1]>limit){
                Arrays.sort(a2,l,r);

                for(int i=l;i<r;i++){
                    nums[a2[i]]=a1[i];
                }

                l=r;
            }
            r++;
        }       
        Arrays.sort(a2,l,r);

        for(int i=l;i<r;i++){
            nums[a2[i]]=a1[i];
        }

        return nums;
    }
}