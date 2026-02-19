class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        int n=products.length;
        List<List<String>> ans=new ArrayList<>();
        for(int i=0;i<searchWord.length();i++){
            List<String> curr=new ArrayList<>();
            ans.add(curr);
        }
        for(int i=0;i<n;i++){
            int j=0;
            while(j<searchWord.length() && products[i].length()>=j+1 && products[i].substring(0,j+1).equals(searchWord.substring(0,j+1))){
                List<String> temp=ans.get(j);
                System.out.println(temp);
                if(temp.size()<=2)
                    temp.add(products[i]);
                j++;
            }
        }
        return ans;
    }
}