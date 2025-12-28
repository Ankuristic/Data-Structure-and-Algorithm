class Solution {
    public int removeDuplicates(int[] nums) {

        if (nums.length == 0) return 0;

        int slow = 0;
        int fast = 1;

        while (fast < nums.length) {
            if (nums[fast] != nums[slow]) {
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }

        return slow + 1;
    }
}


// nums[fast] == nums[slow]	fast++
// nums[fast] != nums[slow]	slow++, copy value


// nums = [1,1,2,2,3]
// fast	slow	Action
// 1	0	duplicate → fast++
// 2	0	new → slow++, copy
// 3	1	duplicate → fast++
// 4	1	new → slow++, copy