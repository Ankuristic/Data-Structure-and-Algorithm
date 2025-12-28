import java.util.HashMap;

public class DuplicateKeys {

     public boolean containsDuplicate(int[] nums) {

        HashMap<Integer, Integer> s = new HashMap<>();

        for (int n : nums) {
            if (s.containsKey(n)) {   // ✅ fix here
                return true;
            }
            s.put(n, 1); // mark as seen
        }

        return false;
    }
}

    



class Solution {
    public boolean containsDuplicate(int[] nums) {

        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] == nums[j]) {
                    return true; // duplicate found
                }
            }
        }

        return false; // all elements are distinct
    }
}
