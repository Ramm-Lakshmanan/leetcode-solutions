class ProductOfNumbers {
    List<Integer> pre;
    int size;
    public ProductOfNumbers() {
        pre=new ArrayList<>();
        pre.add(1);
        size=0;
    }
    
    public void add(int num) {
        if(num==0){
            pre=new ArrayList<>();
            pre.add(1);
            size=0;
        }        
        else{
            pre.add(pre.get(size)*num);
            size++;
        }
    }
    
    public int getProduct(int k) {
        if(k>size) return 0;
        else return pre.get(size)/pre.get(size-k);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */