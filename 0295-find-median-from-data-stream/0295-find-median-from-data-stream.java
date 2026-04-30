class MedianFinder {
    private PriorityQueue<Integer> maxHeap; // left (smaller half)
    private PriorityQueue<Integer> minHeap; // right (larger half)

    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // max heap
        minHeap = new PriorityQueue<>(); // min heap
    }

    public void addNum(int num) {
        // Step 1: add to maxHeap
        maxHeap.offer(num);

        // Step 2: balance order
        minHeap.offer(maxHeap.poll());

        // Step 3: balance size
        if (maxHeap.size() < minHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
        return maxHeap.peek();
    }
}
/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
