//Better  TC-> O(n^3)*O(no. of elements in set)  SC-> O(n)(for internal hashset) + O(quads)*2
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Set<List<Integer>> st = new HashSet<>();
        int n = nums.length;

        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                Set<Long> hashset = new HashSet<>();
                for(int k=j+1; k<n; k++) {
                    long sum = (long) nums[i] + nums[j] + nums[k];
                    long fourth = (long) target - sum;
                    if(hashset.contains(fourth)) {
                        List<Integer> temp = new ArrayList<>();
                            temp.add(nums[i]);
                            temp.add(nums[j]);
                            temp.add(nums[k]);
                            temp.add((int)fourth);
                            Collections.sort(temp);
                            st.add(temp);
                    }
                    hashset.add((long)nums[k]);

                    
                }
            }

        }
        ans.addAll(st);
        return ans;
    }
}
/*
//Brute Force TC-> O(n^4) SC-> O(no. of quads)*2
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Set<List<Integer>> st = new HashSet<>();
        int n = nums.length;

        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                for(int k=j+1; k<n; k++) {
                    for(int l=k+1; l<n; l++) {
                        int sum = nums[i] + nums[j] + nums[k] + nums[l];
                        if(sum == target) {
                            List<Integer> temp = new ArrayList<>();
                            temp.add(nums[i]);
                            temp.add(nums[j]);
                            temp.add(nums[k]);
                            temp.add(nums[l]);

                            Collections.sort(temp);
                            st.add(temp);
                        }
                    }
                }
            }

        }
        ans.addAll(st);
        return ans;
    }
}
*/