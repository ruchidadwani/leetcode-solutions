class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = findFirst(nums, target, 0, nums.length-1);
        int last = findLast(nums, target, 0, nums.length-1);
        return new int[]{first, last};
    }

    int findFirst(int[] nums, int target, int low, int high) {
        int first = -1;
        while(low<=high) {
            int mid = (low+high)/2;
            if(nums[mid]==target) {
                first=mid;
                high=mid-1;
            }
            else if(target > nums[mid]) {
                low = mid+1;
            }
            else {
                high = mid-1;
            }
        }
        return first;
    }

    int findLast(int[] nums, int target, int low, int high) {
        int last = -1;
        while(low<=high) {
            int mid = (low+high)/2;
            if(nums[mid]==target) {
                last=mid;
                low=mid+1;
            }
            else if(target > nums[mid]) {
                low = mid+1;
            }
            else {
                high = mid-1;
            }
        }
        return last;
    }
}

/*
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = -1, end = -1;
        int low = 0, high = nums.length-1;
        while(low<=high) {
            int mid = (low+high)/2;
            if(nums[mid] == target) {
                start = mid;
                end = mid;
                while(start>0 && nums[start-1] == target) {
                    start = start-1;
                }
                while(end<nums.length-1 && nums[end+1] == target) {
                    end = end+1;
                }
                break;
            }
            else if(target > nums[mid]) {
                low = mid+1;
            }
            else {
                high = mid-1;
            }
        }
        return new int[]{start,end};
    }
}
*/