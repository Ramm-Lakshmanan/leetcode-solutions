class Solution {
    public int findKthLargest(int[] nums, int k) {
        // PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // for (int num: nums) {
        //     minHeap.offer(num);

        //     if (minHeap.size() > k) 
        //         minHeap.poll();
        // }

        // return minHeap.peek();

        int left = 0, right = nums.length - 1;
        while (true) {
            int pivot = partition(nums, left, right);
            if (pivot == k-1) {
                return nums[pivot];
            }
            else if (pivot > k-1) {
                right = pivot - 1;
            }
            else {
                left = pivot + 1;
            }
        }
    }

    public int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int i = left + 1;
        int j = right;
        while (i <= j) {
            if (nums[i] < pivot && nums[j] > pivot) {
                swap(nums, i, j);
                i++;
                j--;
            }

            if (nums[i] >= pivot)
                i++;

            if (nums[j] <= pivot)
                j--;
        }
        swap(nums, left, j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}