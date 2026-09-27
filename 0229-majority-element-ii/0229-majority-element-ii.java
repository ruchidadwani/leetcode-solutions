class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ls = new ArrayList<>();
        Map<Integer, Integer> mpp = new HashMap<>();
        int n = nums.length;
        int min = (n/3)+1;

        for(int i=0; i<n; i++) {
            mpp.put(nums[i], mpp.getOrDefault(nums[i], 0) + 1);
            if(mpp.get(nums[i]) == min)
                ls.add(nums[i]);

        }
        return ls;
    }
}