import java.util.*;
public class fourSum {
	 public List<List<Integer>> fourSumMain(int[] nums, int target) {
		 List<List<Integer>> list = new ArrayList<List<Integer>>();
	        Arrays.sort(nums);
	        for(int i=0, L=nums.length; i<L-3; i++) {
	        	if(nums[i]<<2 > target) 
	        		return list;
	        	for(int j=L-1; j>i+2; j--) {
	        		if(nums[j]<<2 < target)
	        			break;
	        		 int rem = target-nums[i]-nums[j];
	                 int lo = i+1, hi=j-1;
	                 while(lo<hi) {
	                	 int sum=nums[lo]+nums[hi];
	                	 if(sum>rem) --hi;
	                     else if(sum<rem) ++lo;
	                     else {
	                         list.add(Arrays.asList(nums[i],nums[lo],nums[hi],nums[j]));
	                         while(++lo<=hi && nums[lo-1]==nums[lo]) continue; // avoid duplicate results
	                         while(--hi>=lo && nums[hi]==nums[hi+1]) continue; // avoid duplicate results
	                     }
	                 }
	                 while(j>=1 && nums[j]==nums[j-1]) --j; 
	        	}
	        	while(i<L-1 && nums[i]==nums[i+1]) ++i;
	        }
	        return list;
	 }
}
