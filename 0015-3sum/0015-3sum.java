class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        for(int i=0; i<nums.length; i++) {
            if(i>0 && nums[i] == nums[i-1]) continue;
            int j=i+1, k=nums.length-1;

            while(j<k) {
                int sum = nums[i] + nums[j] + nums[k];
                if(sum<0) {
                    j++;
                }
                else if (sum>0) {
                    k--;
                }
                else {
    
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    ans.add(temp);
                    j++;
                    k--;
                    while(j<k && nums[j] == nums[j-1]) j++;
                    while(j<k && nums[k] == nums[k+1]) k--;
                }
            }
            
            
        }
        return ans;
    }
}


//Better
/*class Solution {
    public List<List<Integer>> threeSum(int[] num s) {
        List<List<Integer>> ans = new ArrayList<>();
        Set<List<Integer>> st = new HashSet<>();

        int n = nums.length;

        for(int i=0; i<n; i++) {
            Set<Integer> hashset = new HashSet<>();
            for(int j=i+1; j<n; j++) {
                int third = -(nums[i] + nums[j]);
                if (hashset.contains(third)) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(third);

                    Collections.sort(temp);
                    st.add(temp);
                }
                hashset.add(nums[j]);
            }
        }
        ans.addAll(st);
        return ans;
    }
}
*/

//Brute Force
/*
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        Set<List<Integer>> st = new HashSet<>();

        int n = nums.length;
        
        for(int i=0; i<n-2; i++) {
            for(int j=i+1; j<n-1; j++) {
                for(int k=j+1; k<n; k++) {

                    if(nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);

                        Collections.sort(temp);
                        st.add(temp);
                    }
                }
            }
        }
        ans.addAll(st);
        return ans;
    }
}
*/