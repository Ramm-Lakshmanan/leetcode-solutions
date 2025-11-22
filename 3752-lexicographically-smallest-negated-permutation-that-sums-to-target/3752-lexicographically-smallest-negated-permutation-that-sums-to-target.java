class Solution {
    public int[] lexSmallestNegatedPerm(int n, long target) {
        long max=(((long)n*((long)n+1L))/2L);
        if(max<Math.abs(target)) return new int[]{};
        else{
            int[] ans=new int[n];
            if(max==target){
                for(int i=1;i<=n;i++){
                    ans[i-1]=i;
                }
                return ans;
            }
            else if(target==-max){
                for(int i=n;i>=1;i--){
                    ans[(n-i)]=-i;
                }
                return ans;
            }
            else{
                
                int[] mark=new int[n];

                if(target>=0){
                    int left=0;
                    int right=n-1;
                    long curr=0;
                    int j=-1;
                    for(int i=n;i>=1;i--){
                        curr+=(long)i;
                        long rem=(max-curr);
                        if(rem-curr<target){
                            mark[i-1]=1;
                            ans[right--]=i;
                            curr-=(long)i;
                        }
                        else if(rem-curr>target){
                            ans[left++]=-i;
                        }
                        else{
                            mark[i-1]=1;
                            ans[left++]=-i;
                            j=i-1;
                            break;
                        }
                    }
                    if(j==-1) return new int[]{};
                    for(int k=j;k>=1;k--){
                        ans[right--]=k;
                    }
                    
                    return ans;
                }
                else{
                    int left=0;
                    int right=n-1;
                    long curr=0;
                    int j=-1;
                    for(int i=n;i>=1;i--){
                        curr-=(long)i;
                        long rem=(max+curr);
                        if(rem+curr<target){
                            mark[i-1]=1;
                            ans[right--]=i;
                            curr+=(long)i;
                        }
                        else if(rem+curr>target){
                            ans[left++]=-i;
                        }
                        else{
                            mark[i-1]=1;
                            ans[left++]=-i;
                            j=i-1;
                            break;
                        }
                    }
                    if(j==-1) return new int[]{};
                    for(int k=j;k>=1;k--){
                        ans[right--]=k;
                    }
                    
                    return ans;
                }
            }
        }
    }
}