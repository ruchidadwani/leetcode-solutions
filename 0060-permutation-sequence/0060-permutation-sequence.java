class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> nums = new ArrayList<>();
        int fact = 1;
        
        for(int i = 1; i < n; i++){
            fact *= i;
        }
        
        for(int i = 1; i <= n; i++){
            nums.add(i);
        }
        
        k = k - 1; // convert to 0 index
        StringBuilder ans = new StringBuilder();
        
        while(true){
            ans.append(nums.get(k / fact));
            nums.remove(k / fact);
            
            if(nums.size() == 0) break;
            
            k = k % fact;
            fact = fact / nums.size();
        }
        
        return ans.toString();
    }
}