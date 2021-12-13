class Solution {
    public boolean canBeIncreasing(int nums[]){
		int temp[] = nums;
		int tCnt = 0;
		for (int i=0; i<temp.length; i++){
			int t = temp[i]; // save temp[i] into t
			temp[i] = -1; // let temp[i] be a blank so that we can see if it is increasing
			if (helper(temp))
				tCnt++;
			temp[i] = t;
		}
		
		if (tCnt>0)
			return true;
		else
			return false;
	}

	public int[] reformArray(int nums[]) {
		Stack<Integer>a = new Stack<Integer>();
		for (int i=0; i<nums.length; i++) {
			if (nums[i] != -1)
				a.push(nums[i]);
		}
		int temp[] = new int [nums.length-1];
		for (int i=temp.length-1; i>=0; i--)
			temp[i] = a.pop();
		return temp;
	}
	
	public boolean allSame(int nums[]) {
		int cnt = 0;
		for (int i=0; i<nums.length-1; i++) {
			if (nums[i] == nums[i+1])
				cnt++;
		}
		if (cnt == nums.length-1)
			return true;
		else
			return false;
	}
	
	public boolean helper (int nums[]){
		nums = reformArray(nums);
		if (nums.length <= 1) 
			return true;
		if (allSame(nums))
			return false;
		for (int i=1; i<nums.length; i++){
			if (nums[i-1] >= nums[i])
				return false;
		}        
		return true;
	}

}
