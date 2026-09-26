class Solution {
    public List<Integer> getRow(int rowIndex) {
        long ans = 1;
        List<Integer> list = new ArrayList<>();
        list.add(1);
        for(int i=1; i<=rowIndex; i++) {
            ans = ans * (rowIndex-i+1);
            ans = ans / i;
            list.add((int)ans);
        }
        return list;
    }
}
