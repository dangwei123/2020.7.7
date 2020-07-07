给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

说明：解集不能包含重复的子集。
class Solution {
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        back(nums,new ArrayList<>(),0);
        return res;
    }
    private void back(int[] nums,List<Integer> row,int index){
        res.add(new ArrayList(row));
        if(index==nums.length){
            return;
        }
        
        for(int i=index;i<nums.length;i++){
            row.add(nums[i]);
            back(nums,row,i+1);
            row.remove(row.size()-1);
        }
    }
}

给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

说明：解集不能包含重复的子集。

class Solution {
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        back(nums,new ArrayList<>(),0,new boolean[nums.length]);
        return res;
    }
    private void back(int[] nums,List<Integer> row,int index,boolean[] v){
        res.add(new ArrayList(row));
        if(index==nums.length){
            return;
        }
        for(int i=index;i<nums.length;i++){
            if(v[i]){
                continue;
            }
            if(i!=0&&nums[i]==nums[i-1]&&!v[i-1]){
                continue;
            }
            row.add(nums[i]);
            v[i]=true;
            back(nums,row,i+1,v);
            row.remove(row.size()-1);
            v[i]=false;
        }
    }
}

