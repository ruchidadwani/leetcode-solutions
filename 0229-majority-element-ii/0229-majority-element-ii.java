class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ls = new ArrayList<>();
        Map<Integer, Integer> mpp = new HashMap<>();

        int n = nums.length;

        for (int i = 0; i < n; i++) {
            mpp.put(nums[i], mpp.getOrDefault(nums[i], 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : mpp.entrySet()) {
            if (entry.getValue() > n / 3) {
                ls.add(entry.getKey());
            }
        }

        return ls;
    }
}