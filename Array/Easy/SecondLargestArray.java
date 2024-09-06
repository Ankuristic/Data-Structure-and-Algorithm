public class SecondLargestArray {
    
    int max = Integer.MIN_VALUE; // initially set to smallest possible value
    int secondLargest = Integer.MIN_VALUE; // initially set to smallest possible value
    int N = arr.length;
    
    // First find the largest element
    for (int i = 0; i < N; i++) {
        if (arr[i] > max) {
            max = arr[i];  // update largest element
        }
    }
    
    // Now find the second largest element
    for (int i = 0; i < N; i++) {
        if (arr[i] > secondLargest && arr[i] < max) {
            secondLargest = arr[i];  // update second largest
        }
    }
    
    // If secondLargest is still smallest value, return -1
    return (secondLargest == Integer.MIN_VALUE) ? -1 : secondLargest;
}
}
