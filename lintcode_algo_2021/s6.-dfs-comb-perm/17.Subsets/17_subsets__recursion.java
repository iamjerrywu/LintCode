public class Solution {
    /**
     * @param nums: A set of numbers
     * @return: A list of lists
     */
    public List<List<Integer>> subsets(int[] nums) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null) {
            return res;
        }

        Arrays.sort(nums);
        dfs(nums, 0, new ArrayList<Integer>(), res);
        return res;
    }

    private void dfs(int[] nums, 
                     int index,
                     ArrayList<Integer> subset, 
                     List<List<Integer>> res) {
        if (index == nums.length){
            res.add(new ArrayList<Integer>(subset));
            return;
        }

        subset.add(nums[index]);
        dfs(nums, index + 1, subset, res);

        subset.remove(subset.size() - 1);
        dfs(nums, index + 1, subset, res);
    }
}