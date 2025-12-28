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


// 1️⃣ Opposite Direction (Left–Right Pointers)
// Pointers start from both ends and move toward each other
// 👉 When to use


// Array is sorted


// Finding pairs / minimizing difference


// Palindrome checks


// 👉 Pattern
// int left = 0, right = n - 1;
// while (left < right) {
//     if (condition) left++;
//     else right--;
// }

// 👉 Examples


// Two Sum (sorted array)


// Check palindrome string


// Container With Most Water


// Remove duplicates from sorted array



// 2️⃣ Same Direction (Fast–Slow Pointers)
// Both pointers move forward but at different speeds
// 👉 When to use


// Removing duplicates


// In-place array modifications


// Linked list cycle detection


// 👉 Pattern
// int slow = 0;
// for (int fast = 0; fast < n; fast++) {
//     if (condition) {
//         slow++;
//     }
// }

// 👉 Examples


// Remove duplicates from sorted array


// Move zeros to end


// Linked List Cycle Detection (Floyd’s Algorithm)



// 3️⃣ Sliding Window (Dynamic Two Pointers)
// Window expands and shrinks dynamically
// 👉 When to use


// Subarray / substring problems


// Sum, length, or count constraints


// 👉 Pattern
// int left = 0;
// for (int right = 0; right < n; right++) {
//     // expand window

//     while (condition violated) {
//         left++; // shrink window
//     }
// }

// 👉 Examples


// Longest Substring Without Repeating Characters


// Maximum sum subarray of size K


// Minimum window substring



// 4️⃣ Fixed Window Two Pointers
// Window size remains constant
// 👉 When to use


// Fixed-length subarray problems


// 👉 Pattern
// int left = 0, sum = 0;
// for (int right = 0; right < n; right++) {
//     sum += arr[right];

//     if (right - left + 1 > k) {
//         sum -= arr[left++];
//     }
// }

// 👉 Examples


// Maximum average subarray


// Count subarrays of size K



// 5️⃣ Three Pointers (Extension of Two Pointer)
// Used when 2 pointers aren’t enough
// 👉 When to use


// 3Sum, 4Sum


// Merging sorted arrays


// 👉 Examples


// 3Sum problem


// Merge 3 sorted arrays



// 6️⃣ Partition-Based Two Pointer
// Rearranging elements based on condition
// 👉 When to use


// Segregation problems


// 👉 Pattern
// int left = 0, right = n - 1;
// while (left < right) {
//     if (arr[left] is valid) left++;
//     else swap(left, right);
// }

// 👉 Examples


// Sort 0s and 1s


// Dutch National Flag problem


// Separate even and odd numbers



// 7️⃣ Linked List Two Pointer
// Pointers move at different speeds
// 👉 Examples


// Find middle of linked list


// Detect cycle


// Find nth node from end



// 🔥 Summary Table
// TypePointersCommon UseOpposite DirectionStart & EndPair problemsFast–SlowSame directionIn-place operationsSliding WindowExpand & ShrinkSubarray problemsFixed WindowConstant sizeSubarray sumPartitionRearrangementSorting / SegregationLinked ListDifferent speedsCycle / middle

// If you want, I can also:
// ✔️ Map LeetCode problems to each type
// ✔️ Explain when NOT to use two pointers
// ✔️ Give Java templates for each type
// Just tell me 👍ss