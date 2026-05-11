class SummaryRanges {

    private TreeMap<Integer, int[]> map;

    public SummaryRanges() {
        map = new TreeMap<>();
    }

    public void addNum(int value) {

        // Find neighboring intervals
        Map.Entry<Integer, int[]> lower = map.floorEntry(value);
        Map.Entry<Integer, int[]> higher = map.ceilingEntry(value);

        // Case 1: already covered
        if (lower != null && lower.getValue()[1] >= value) {
            return;
        }

        boolean mergeLeft =
                lower != null && lower.getValue()[1] + 1 == value;

        boolean mergeRight =
                higher != null && higher.getKey() - 1 == value;

        // Case 2: connect left and right intervals
        if (mergeLeft && mergeRight) {

            lower.getValue()[1] = higher.getValue()[1];
            map.remove(higher.getKey());

        }
        // Case 3: extend left interval
        else if (mergeLeft) {

            lower.getValue()[1]++;

        }
        // Case 4: extend right interval
        else if (mergeRight) {

            int end = higher.getValue()[1];
            map.remove(higher.getKey());

            map.put(value, new int[]{value, end});

        }
        // Case 5: new standalone interval
        else {

            map.put(value, new int[]{value, value});

        }
    }

    public int[][] getIntervals() {

        return map.values().toArray(new int[map.size()][]);
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */
 