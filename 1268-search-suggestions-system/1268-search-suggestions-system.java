class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        int n=products.length;
        List<List<String>> ans=new ArrayList<>();
        for(int i=0;i<searchWord.length();i++){
            List<String> curr=new ArrayList<>();
            int cnt=0,j=0;
            while(cnt<3 && j<n){
                if(products[j].length()>=i+1 && searchWord.substring(0,i+1).equals(products[j].substring(0,i+1))){
                    curr.add(products[j]);
                    cnt++;
                }
                j++;
            }
            ans.add(curr);
        }
        return ans;
    }
}