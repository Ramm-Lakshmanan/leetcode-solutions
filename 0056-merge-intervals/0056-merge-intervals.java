class Solution {
    public int[][] merge(int[][] arr) {
        Arrays.sort(arr,(a,b)->{
            if(a[0]!=b[0]) return Integer.compare(a[0],b[0]);
            return Integer.compare(b[1],a[1]);
        });
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        temp.add(arr[0][0]);temp.add(arr[0][1]);
        ans.add(temp);
        int len=0;
        for(int i=1;i<arr.length;i++){
            if(ans.get(len).get(1)>=arr[i][0]){
                ans.get(len).set(1,Math.max(arr[i][1],ans.get(len).get(1)));
            }
            else{
                List<Integer> summa=new ArrayList<>();
                summa.add(arr[i][0]);summa.add(arr[i][1]);
                ans.add(summa);
                len++;
            }
        }
        int[][] res=new int[len+1][2];
        for(int i=0;i<len+1;i++){
            res[i][0]=ans.get(i).get(0);
            res[i][1]=ans.get(i).get(1);
        }
        return res;
    }
}