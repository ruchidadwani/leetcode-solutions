class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();

        int n = nums.length;

        for(int i=0; i<n-3; i++) {
            if(i>0 && nums[i] ==nums [i-1]) continue;
            for(int j=i+1; j<n-2; j++) {
                if(j>i+1 && nums[j] == nums[j-1]) continue;
                int k = j+1;
                int l = n-1;
                while(k<l) {
                    long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];
                    if(sum < target) k++;
                    else if(sum > target) l--;
                    else {
                        List<Integer> ls = new ArrayList<>();
                        ls.add(nums[i]);
                        ls.add(nums[j]);
                        ls.add(nums[k]);
                        ls.add(nums[l]);
                        ans.add(ls);
                        k++; l--;
                        while(k<l && nums[k] == nums[k-1]) k++;
                        while(k<l && nums[l] == nums[l+1]) l--;
                    }
                }
            }

        }
        return ans;
    }
}
/*
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