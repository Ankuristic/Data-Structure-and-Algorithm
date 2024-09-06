//Given an array, arr. The task is to find the largest element in it.

// Input: arr = [1, 8, 7, 56, 90]
// Output: 90
// Explanation: The largest element of the given array is 90.

//intution

// arr[0]> arr[1]
// arr[1]> arr[2]
// arr[3]> arr[4]
// arr[4]> arr[5]

//First step: Sabse pehle, socho array ke andar kya hai? Ek array mein numbers hain, aur tumhe unme se sabse bada number dhoondhna hai.

//Simple Approach: Ek beginner ki tarah socho, agar tumhe manually karna hota, toh tum kya karte? Tum shayad array ke har number ko ek-ek karke dekhte, aur current largest number ko track karte.

//Start with the First Element:

//Sabse pehle element ko initially "sabse bada" maan lo.
//Ab array ke baaki elements ko compare karte jao.
//Agar koi element tumhare current "largest" se bada hota hai, toh usse update kar do.
//Loop through the Array: Ek loop chalana padega jo har element ko check kare, aur agar wo element current largest se bada ho, toh largest ko update karte jao.

//Result: Jab loop complete ho jaye, tumhare paas largest element aa jayega


// public class LargestArray {

//     public static int largest(int[] arr) {
//         // code here
//         int max = 0;
//         int N = arr.length;
//         for (int i = 0 ; i<N; i ++){
//             if (arr[i]>max){
//                 max=arr[i];
//             }
//         }
//     return max;
// }

// }

// Step by Step Process:
// Initial assumption: Pehla element ko "largest" maan lo.

// Example: Array hai {12, 34, 10, 6, 40}. Pehle 12 ko max maan lo.
// Compare each element: Loop ke through baaki elements ko check karo.

// Next element 34 hai. Compare karo:
// Kya 34 > 12? Haan, toh max = 34 kar do.
// Update Logic: Agar current element jo check ho raha hai (let's say arr[i]), woh max se bada hai, toh simply max ko update kar do:

// java
// Copy code
// if (arr[i] > max) {
//     max = arr[i];  // max ko update karke current element bana do
// }
// Continue comparing: Loop aage badhata hai aur har element ka comparison karta hai