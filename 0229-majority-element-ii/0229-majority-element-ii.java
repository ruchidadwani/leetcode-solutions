class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ls = new ArrayList<>();

        int el1=Integer.MIN_VALUE;
        int el2=Integer.MIN_VALUE;
        int cnt1=0, cnt2=0;

        for(int i=0; i<nums.length; i++) {

            if (cnt1 == 0 && nums[i] != el2) {
                cnt1 =1;
                el1 = nums[i];
            }
            else if (cnt2 == 0 && nums[i] != el1) {
                cnt2 = 1;
                el2 = nums[i];
            }
            else if (el1 == nums[i]) {
                cnt1++;
            }
            else if (el2 == nums[i]) {
                cnt2++;
            }
            else {
                cnt1--; 
                cnt2--;
            }
        }
        cnt1 = 0;
        cnt2 = 0;

        for(int i=0; i<nums.length; i++) {
            if (nums[i] == el1)
                cnt1++;
            else if (nums[i] == el2)
                cnt2++;
        }
        if(cnt1 > (nums.length/3) )
            ls.add(el1);

        if(cnt2 > (nums.length/3) )
            ls.add(el2);

        return ls;
    }
}

/*
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
*/