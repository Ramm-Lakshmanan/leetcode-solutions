class ProductOfNumbers {
    List<Integer> pre;
    int size;
    public ProductOfNumbers() {
        pre=new ArrayList<>();
        size=0;
    }
    
    public void add(int num) {
        pre.add(num);
        size++;
    }
    
    public int getProduct(int k) {
        int ans=1;
        for(int i=size-1;i>size-k-1;i--){
            ans*=pre.get(i);
        }
        return ans;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */