//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ret = new int[nums.length], tmp = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            ret[i] = i == 0 ? 1 : ret[i - 1] * nums[i - 1];
        }
        for(int i = nums.length - 1; i >= 0; i--){
            tmp[i] = i == nums.length - 1 ? 1 : tmp[i + 1] * nums[i + 1];
        }
        for(int i = 0; i < nums.length; i++){
            ret[i] *= tmp[i];
        }
        return ret;
    }
}