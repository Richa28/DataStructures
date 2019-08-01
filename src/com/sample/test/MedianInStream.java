package com.sample.test;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianInStream {

	public static void main(String[] args) {

		int arr[] = { 5, 20, 13, 12, 1, 6, 3, 8 };

		PriorityQueue<Double> minHeap = new PriorityQueue<Double>();
		PriorityQueue<Double> maxHeap = new PriorityQueue<Double>(arr.length, new Comparator<Double>() {
			@Override
			public int compare(Double o1, Double o2) {
				return (int) (o2 - o1);
			}
		});

		MedianInStream obj = new MedianInStream();
		double med = 0;
		for (int i = 0; i < arr.length; i++) {
			med = obj.getMedian(minHeap, maxHeap, (double)arr[i], med);
			System.out.println("median = " + med);
		}
	}

	double getMedian(PriorityQueue<Double> minHeap, PriorityQueue<Double> maxHeap, double data, double median) {
		int minHeapCount = minHeap.size();
		int maxHeapCount = maxHeap.size();
		double currentMedian = 0;
		
		if(minHeapCount > maxHeapCount) {
			if(data < median) {
				// Add to max heap
				maxHeap.add(data);
			}else {
				maxHeap.add(minHeap.poll());
				minHeap.add(data);
			}
			currentMedian = (maxHeap.peek() + minHeap.peek())/2;
		}else if(minHeapCount < maxHeapCount) {
			if(data < median) {
				// Add to max heap
				minHeap.add(maxHeap.poll());
				maxHeap.add(data);
			}else {
				minHeap.add(data);
			}
			currentMedian = (maxHeap.peek() + minHeap.peek())/2;
		}else {
			if(data < median) {
				maxHeap.add(data);
				currentMedian = maxHeap.peek();
			}else {
				minHeap.add(data);
				currentMedian = minHeap.peek();
			}
		}
		return currentMedian;
	}

}
