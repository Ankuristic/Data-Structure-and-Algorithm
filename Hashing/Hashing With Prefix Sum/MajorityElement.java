package DSA.Hashing.Hashing With Prefix Sum;

public class MajorityElement {

        public int majorityElement(int[] nums) {


    for(int  i  =0 ;  i<nums.length  ; i++){
        int count =0; 

        for(int j =0 j <nums.length; j++){
            if(nums[[i]== nums[j]]){
                count++;
            }
        }

            // check majority condition
            if (count > n / 2) {
                return nums[i];
            }
        }

        return -1; // majority always exists as per problem

    }

    }
    
}


// using Hashing

class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);

            if (map.get(num) > n / 2) {
                return num;
            }
        }
        return -1;
    }
}


//Moore's algorithm 


class Solution {
    public int majorityElement(int[] nums) {
        int candidate = 0;
        int count = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }

            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }
}

