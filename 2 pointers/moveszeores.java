class Solution {
    public void moveZeroes(int[] nums) {
        int nz = 0;   // current index
        int z = 0;  // position for next non-zero

        while (nz < nums.length) {
            if (nums[nz] != 0) {
                int temp = nums[nz];
                nums[nz] = nums[z];
                nums[z] = temp;
                z++;
            }
            nz++;
        }
    }
}


// same pointer 