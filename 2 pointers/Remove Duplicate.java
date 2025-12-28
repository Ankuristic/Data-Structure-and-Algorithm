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


// Approach: Two Pointer Technique
// Key Insight:

// Since array is sorted, duplicates are adjacent
// Use two pointers:

// i = slow pointer (position for next unique element)
// j = fast pointer (scanning through array)



// Algorithm:
// 1. Start with i = 0 (first element is always unique)
// 2. Iterate j from 1 to end
// 3. If nums[j] != nums[i]:
//    - Found a new unique element
//    - Increment i
//    - Place nums[j] at position i
// 4. Return i + 1 (number of unique elements)

// 🔍 Visual Dry Run
// Initial Array:
// nums = [1, 1, 2, 2, 2, 3, 4, 4]
//         ↑
//         i, j

// i = 0 (position for next unique)
// j = 0 (current scanning position)
// count = 0 unique elements so far


// Step 1: j = 1
// nums = [1, 1, 2, 2, 2, 3, 4, 4]
//         ↑  ↑
//         i  j

// Compare: nums[j] (1) == nums[i] (1) ❌ Same! Skip
// Action: Just move j forward
// Result: i stays at 0
// State:

// i = 0
// j moves to 2


// Step 2: j = 2
// nums = [1, 1, 2, 2, 2, 3, 4, 4]
//         ↑     ↑
//         i     j

// Compare: nums[j] (2) != nums[i] (1) ✅ Different! New unique element
// Action: 
//   1. i++ (i becomes 1)
//   2. nums[i] = nums[j]
//   3. nums[1] = 2
// After Update:
// nums = [1, 2, 2, 2, 2, 3, 4, 4]
//            ↑  ↑
//            i  j
// State:

// i = 1
// j moves to 3
// Unique elements so far: [1, 2]


// Step 3: j = 3
// nums = [1, 2, 2, 2, 2, 3, 4, 4]
//            ↑     ↑
//            i     j

// Compare: nums[j] (2) == nums[i] (2) ❌ Same! Skip
// Action: Just move j forward
// Result: i stays at 1
// State:

// i = 1
// j moves to 4


// Step 4: j = 4
// nums = [1, 2, 2, 2, 2, 3, 4, 4]
//            ↑        ↑
//            i        j

// Compare: nums[j] (2) == nums[i] (2) ❌ Same! Skip
// Action: Just move j forward
// Result: i stays at 1
// State:

// i = 1
// j moves to 5


// Step 5: j = 5
// nums = [1, 2, 2, 2, 2, 3, 4, 4]
//            ↑           ↑
//            i           j

// Compare: nums[j] (3) != nums[i] (2) ✅ Different! New unique element
// Action: 
//   1. i++ (i becomes 2)
//   2. nums[i] = nums[j]
//   3. nums[2] = 3
// After Update:
// nums = [1, 2, 3, 2, 2, 3, 4, 4]
//               ↑     ↑
//               i     j
// State:

// i = 2
// j moves to 6
// Unique elements so far: [1, 2, 3]


// Step 6: j = 6
// nums = [1, 2, 3, 2, 2, 3, 4, 4]
//               ↑           ↑
//               i           j

// Compare: nums[j] (4) != nums[i] (3) ✅ Different! New unique element
// Action: 
//   1. i++ (i becomes 3)
//   2. nums[i] = nums[j]
//   3. nums[3] = 4
// After Update:
// nums = [1, 2, 3, 4, 2, 3, 4, 4]
//                  ↑     ↑
//                  i     j
// State:

// i = 3
// j moves to 7
// Unique elements so far: [1, 2, 3, 4]


// Step 7: j = 7 (Last Element)
// nums = [1, 2, 3, 4, 2, 3, 4, 4]
//                  ↑           ↑
//                  i           j

// Compare: nums[j] (4) == nums[i] (4) ❌ Same! Skip
// Action: Just move j forward
// Result: i stays at 3
// State:

// i = 3
// j = 8 (loop ends)


// Final Result:
// nums = [1, 2, 3, 4, 2, 3, 4, 4]
//         └──────┬──────┘
//         Unique elements (k=4)

// Return: i + 1 = 3 + 1 = 4
// First k elements: [1, 2, 3, 4] ✅

// 💻 Code Implementation
// Solution 1: Two Pointer (Optimal)
// javascriptfunction removeDuplicates(nums) {
//     // Edge case: empty array
//     if (nums.length === 0) return 0;
    
//     // i = position for next unique element
//     let i = 0;
    
//     // j = scanning pointer
//     for (let j = 1; j < nums.length; j++) {
//         // If current element is different from last unique
//         if (nums[j] !== nums[i]) {
//             i++;              // Move to next position
//             nums[i] = nums[j]; // Place unique element
//         }
//     }
    
//     // Return count of unique elements
//     return i + 1;
// }

// // Test
// const nums = [1, 1, 2, 2, 2, 3, 4, 4];
// const k = removeDuplicates(nums);
// console.log("k =", k);                    // Output: 4
// console.log("nums =", nums.slice(0, k));  // Output: [1, 2, 3, 4]

// Solution 2: With Detailed Logging (For Understanding)
// javascriptfunction removeDuplicatesDetailed(nums) {
//     if (nums.length === 0) return 0;
    
//     let i = 0;
//     console.log(`Initial: i=${i}, nums=[${nums}]\n`);
    
//     for (let j = 1; j < nums.length; j++) {
//         console.log(`Step ${j}:`);
//         console.log(`  Comparing nums[${j}]=${nums[j]} with nums[${i}]=${nums[i]}`);
        
//         if (nums[j] !== nums[i]) {
//             i++;
//             nums[i] = nums[j];
//             console.log(`  ✅ Different! i=${i}, nums[${i}]=${nums[i]}`);
//             console.log(`  Array: [${nums}]`);
//         } else {
//             console.log(`  ❌ Same! Skip`);
//         }
//         console.log();
//     }
    
//     console.log(`Final: k=${i + 1}, First ${i + 1} elements: [${nums.slice(0, i + 1)}]`);
//     return i + 1;
// }

// // Test with logging
// const test = [1, 1, 2, 2, 2, 3, 4, 4];
// removeDuplicatesDetailed(test);

// 📊 Complete Trace Table
// Stepjinums[j]nums[i]CompareActionArray StateUnique CountInit0011-Start[1,1,2,2,2,3,4,4]111011SameSkip[1,1,2,2,2,3,4,4]122021Diffi++, copy[1,2,2,2,2,3,4,4]233122SameSkip[1,2,2,2,2,3,4,4]244122SameSkip[1,2,2,2,2,3,4,4]255132Diffi++, copy[1,2,3,2,2,3,4,4]366243Diffi++, copy[1,2,3,4,2,3,4,4]477344SameSkip[1,2,3,4,2,3,4,4]4End-3---Return 4[1,2,3,4,,,,]4

// 🎨 Visual Animation
// Animation Frames:
// Frame 1: Initial State
// [1, 1, 2, 2, 2, 3, 4, 4]
//  ↑
//  i,j
// Frame 2: j=1, Same element
// [1, 1, 2, 2, 2, 3, 4, 4]
//  ↑  ↑
//  i  j   ❌ Skip (both are 1)
// Frame 3: j=2, New element found!
// [1, 2, 2, 2, 2, 3, 4, 4]
//     ↑  ↑
//     i  j   ✅ Copy 2 to position 1
// Frame 4: j=3, j=4, Same element
// [1, 2, 2, 2, 2, 3, 4, 4]
//     ↑        ↑
//     i        j   ❌ Skip (both are 2)
// Frame 5: j=5, New element found!
// [1, 2, 3, 2, 2, 3, 4, 4]
//        ↑     ↑
//        i     j   ✅ Copy 3 to position 2
// Frame 6: j=6, New element found!
// [1, 2, 3, 4, 2, 3, 4, 4]
//           ↑     ↑
//           i     j   ✅ Copy 4 to position 3
// Frame 7: j=7, Same element
// [1, 2, 3, 4, 2, 3, 4, 4]
//           ↑           ↑
//           i           j   ❌ Skip (both are 4)
// Final: Return 4
// [1, 2, 3, 4, _, _, _, _]
//  └────┬────┘
//    k=4 unique elements

// 🧮 Complexity Analysis
// Time Complexity: O(n)

// Single pass through the array
// Visit each element exactly once
// n = length of array

// Space Complexity: O(1)

// Only use two pointers (i and j)
// Modify array in-place
// No extra data structures


// 🔄 More Examples
// Example 1: No Duplicates
// javascriptInput:  [1, 2, 3, 4, 5]
// Output: k = 5, nums = [1, 2, 3, 4, 5]

// Explanation: All elements are unique, no changes needed
// Example 2: All Same
// javascriptInput:  [2, 2, 2, 2, 2]
// Output: k = 1, nums = [2, _, _, _, _]

// Explanation: Only one unique element
// Example 3: Two Elements
// javascriptInput:  [1, 1, 1, 2, 2, 2]
// Output: k = 2, nums = [1, 2, _, _, _, _]

// Step-by-step:
// [1, 1, 1, 2, 2, 2]  i=0, j=1: Same, skip
// [1, 1, 1, 2, 2, 2]  i=0, j=2: Same, skip
// [1, 2, 1, 2, 2, 2]  i=0, j=3: Diff, i++, copy
// [1, 2, 1, 2, 2, 2]  i=1, j=4: Same, skip
// [1, 2, 1, 2, 2, 2]  i=1, j=5: Same, skip
// Result: k = 2
// Example 4: Empty and Single Element
// javascriptInput:  []
// Output: k = 0

// Input:  [5]
// Output: k = 1, nums = [5]

// 🎯 Key Concepts
// Why Two Pointers Work:

// Sorted array means duplicates are adjacent
// Pointer i tracks where to place next unique element
// Pointer j scans to find next unique element
// When nums[j] != nums[i], we found a new unique element

// In-Place Modification:

// We overwrite duplicate positions with unique elements
// Don't need to shift all elements
// First k positions contain all unique elements in order

// Why Return i + 1:

// i is zero-indexed (starts at 0)
// If i = 3, we have elements at positions 0, 1, 2, 3
// That's 4 elements total, so return i + 1


// 💡 Common Mistakes to Avoid
// ❌ Mistake 1: Starting both pointers at 0
// javascript// Wrong
// let i = 0, j = 0;
// for (let j = 0; j < nums.length; j++) { // Will always be equal!
// Fix: Start j at 1
// javascript// Correct
// let i = 0;
// for (let j = 1; j < nums.length; j++) {
// ❌ Mistake 2: Forgetting to increment i
// javascript// Wrong
// if (nums[j] !== nums[i]) {
//     nums[i] = nums[j]; // Overwrites current unique element!
// }
// Fix: Increment i first
// javascript// Correct
// if (nums[j] !== nums[i]) {
//     i++;
//     nums[i] = nums[j];
// }
// ❌ Mistake 3: Returning i instead of i+1
// javascript// Wrong
// return i; // Off by one!
// Fix: Return i + 1
// javascript// Correct
// return i + 1; // Correct count

// 🧪 Test Cases
// javascript// Test Case 1: Normal case
// console.log(removeDuplicates([1,1,2])); // Output: 2, nums: [1,2,_]

// // Test Case 2: More duplicates
// console.log(removeDuplicates([0,0,1,1,1,2,2,3,3,4])); // Output: 5, nums: [0,1,2,3,4,_,_,_,_,_]

// // Test Case 3: No duplicates
// console.log(removeDuplicates([1,2,3,4,5])); // Output: 5, nums: [1,2,3,4,5]

// // Test Case 4: All same
// console.log(removeDuplicates([1,1,1,1])); // Output: 1, nums: [1,_,_,_]

// // Test Case 5: Two elements
// console.log(removeDuplicates([1,2])); // Output: 2, nums: [1,2]

// // Test Case 6: Empty
// console.log(removeDuplicates([])); // Output: 0

// // Test Case 7: Single element
// console.log(removeDuplicates([1])); // Output: 1

// 🎓 Interview Tips
// What to Say in Interview:
// 1. Clarify Requirements:

// "Should I modify the array in-place? Yes"
// "Do I need to remove elements or just rearrange? Just rearrange"
// "What should be in positions after k? Doesn't matter"

// 2. Explain Approach:

// "Since array is sorted, duplicates are adjacent"
// "I'll use two pointers - one tracks unique position, other scans"
// "Time: O(n), Space: O(1)"

// 3. Walk Through Example:

// Draw the array with pointers
// Show 2-3 iterations
// Explain when pointers move

// 4. Code and Test:

// Write clean, readable code
// Test with edge cases
// Handle empty array

// Follow-up Questions:
// Q: What if array is not sorted?
// A: Would need to use a Set or HashMap, making it O(n) space
// Q: Can you do it without modifying the array?
// A: Would need extra space for unique elements, violating O(1) space constraint
// Q: What if we need to remove elements completely?
// A: Would need to shift elements, making it O(n²) or use array methods like splice()

// This visualization shows exactly how the two-pointer technique works step by step! The key is understanding that i marks where the next unique element should go, while j scans to find it.