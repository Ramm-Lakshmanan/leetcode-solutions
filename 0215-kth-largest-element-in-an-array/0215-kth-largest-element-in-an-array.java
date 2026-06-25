import java.util.Random;

class Solution {
    private final Random rand = new Random(); // Reuse Random instance

    public int partition(int l, int r, int[] nums) {
        // 1. Pick a random index between l and r
        int randomIndex = l + rand.nextInt(r - l + 1);
        
        // 2. Swap it to the end so your existing logic works perfectly
        int pTemp = nums[randomIndex];
        nums[randomIndex] = nums[r];
        nums[r] = pTemp;

        int i = l - 1;
        int pivot = nums[r];

        for (int j = l; j < r; j++) {
            if (nums[j] > pivot) { // Descending order
                i++;
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
            }
        }
        i++;
        int temp = nums[i];
        nums[i] = nums[r];
        nums[r] = temp;

        return i;
    }

    public int qsort(int l, int r, int[] nums, int k) {
        while (l <= r) {
            int q = partition(l, r, nums);

            if (q + 1 == k) {
                return nums[q];
            }
            else if (q + 1 < k) {
                l = q + 1;
            }
            else {
                r = q - 1;
            }
        }
        return nums[k - 1];
    }

    public int findKthLargest(int[] nums, int k) {
        return qsort(0, nums.length - 1, nums, k);
    }
}
