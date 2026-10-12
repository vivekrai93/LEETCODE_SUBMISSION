class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> chhotans = new ArrayList<>();

        int i = 0;

        solve(i, ans, chhotans, nums);
        return ans;
    }

    static void solve(int i, List<List<Integer>> ans, List<Integer> chhotans, int[] nums) {

        if (i >= nums.length) {
            ans.add(new ArrayList<>(chhotans));
            return;
        }

        int value = nums[i];
        //include 

        chhotans.add(value);
        solve(i + 1, ans, chhotans, nums);

        // backtrack
        chhotans.remove(chhotans.size() - 1);

        //while excluding, ignore the same elements and move on to the new element
        /// ye exclude wala logic ek assumption pr based hai
        while (i+ 1 < nums.length && nums[i] == nums[i + 1]) {
            i++;
        }

        //exclude 
        solve(i + 1, ans, chhotans, nums);

    }
}