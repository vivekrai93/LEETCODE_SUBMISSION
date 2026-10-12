class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> chhotans = new ArrayList<>();

        int i=0;

        solve( i , ans , chhotans , nums);
        return ans;
    }

    static void solve(int i , List<List<Integer>> ans ,List<Integer> chhotans,int [] nums){

        if(i>= nums.length){
            ans.add(new ArrayList<>(chhotans));
            return;
        }

        int value = nums[i];
        //include 

        chhotans.add(value);
        solve(i+1,ans,chhotans,nums);

        // backtrack
        chhotans.remove(chhotans.size()-1);

        //exclude 
        solve(i+1,ans,chhotans,nums);



    }
}