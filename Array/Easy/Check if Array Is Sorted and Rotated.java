class Solution {
    public boolean check(int[] nums) {
        int count = 0;  // yeh count karega ki kitni baar order break ho raha hai
        int n = nums.length;

        // Array ke saare elements ko pair-wise check karenge
        for (int i = 0; i < n; i++) {
            // Agar koi element agle element se bada hai, toh order break ho raha hai
            if (nums[i] > nums[(i + 1) % n]) {
                count++;
            }
            // Agar ek se zyada baar order break ho gaya, toh yeh sorted rotated array nahi hai
            if (count > 1) {
                return false;
            }
        }

        // Agar maximum ek hi break point mila, toh yeh sorted and rotated array hai
        return true;
    }
}
