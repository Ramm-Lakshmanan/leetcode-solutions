class Solution {
    public int totalFruit(int[] fruits) {
        int max=0;
        int f1=-1,c1=-1;
        int f2=-1,c2=-1;

        int right=0,left=0,n=fruits.length;

        while(right<n){
            if(f1==-1){
                f1=fruits[right];
                c1=1;
            }
            else if(fruits[right]==f1){
                c1++;
            }
            else if(f2==-1){
                f2=fruits[right];
                c2=1;
            }
            else if(fruits[right]==f2){
                c2++;
            }
            else{
                while(left<right && c1>0 && c2>0){
                    if(fruits[left]==f1) c1--;
                    else c2--;
                    left++;
                }

                if(c1==0){
                    f1=fruits[right];c1=1;
                }
                else{
                    f2=fruits[right];c2=1;
                }
            }

            max=Math.max(max,right-left+1);
            right++;
        }

        return max;
    }
}