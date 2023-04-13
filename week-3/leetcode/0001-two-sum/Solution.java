import java.util.HashMap;
class Solution {
    public int[] twoSum(int[] nums, int target) {
	//key: remainder, value:index
    	HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
        	int remainder=target-nums[i];
        	if(map.containsKey(nums[i])){
            return new int[] {map.get(nums[i]),i};
          }	
        	else if(!map.containsKey(remainder)){           
        		map.put(remainder, i); 
          }
    	}
    	return new int[2];
    }
}