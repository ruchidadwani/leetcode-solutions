//Moore's Voting Algorith
class Solution {
    public int majorityElement(int[] nums) {
        int count=0;
        int el=0;
        for(int i=0; i<nums.length; i++){
            if(count==0){
                count=1;
                el=nums[i];
            }
            else if(nums[i]==el){
                count++;
            }
            else{
                count--;
            }
        }
        int cnt=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]==el){
                cnt++;
            }
        }
        if(cnt>nums.length/2){
            return el;
        }
        return -1;
    }
}