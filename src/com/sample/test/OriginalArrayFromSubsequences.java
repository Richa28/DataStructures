package com.sample.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class OriginalArrayFromSubsequences {

	private List<Integer> adjacencyList[];
	
	@SuppressWarnings("unchecked")
	public OriginalArrayFromSubsequences(int numOfVertices) {
		adjacencyList = new LinkedList[numOfVertices];
		for(int i=0; i<numOfVertices; i++) {
			adjacencyList[i] = new LinkedList<>();
		}
	}
	
	public static void main(String[] args) {
		OriginalArrayFromSubsequences obj = new OriginalArrayFromSubsequences(5);
		List<List<Character>> subsequences = new ArrayList<>();
		List<Character> innerList = new ArrayList<>();
		innerList.add('1');
		innerList.add('3');
		innerList.add('2');
		subsequences.add(innerList);
		
		innerList = new ArrayList<>();
		innerList.add('1');
		innerList.add('3');
		innerList.add('4');
		subsequences.add(innerList);
		
		innerList = new ArrayList<>();
		innerList.add('2');
		innerList.add('4');
		subsequences.add(innerList);
		
		List<Character> output = obj.getOriginalArrayFromSubsequences(subsequences);
		for(Character x : output) {
			System.out.print(x + "  ");
		}
	}
	
	private void addEdge (int u, int v) {
		adjacencyList[u].add(v);
	}
	
	private void addDataToDAG(List<List<Character>> subsequences) {
		int n = subsequences.size();
		for(int i=0; i< n-1; i++) {
			List<Character> sequence1 = subsequences.get(i);
			List<Character> sequence2 = subsequences.get(i+1);
			
			for(int j=0; j<Math.min(sequence1.size(), sequence2.size()); j++) {
				if(sequence1.get(j) != sequence2.get(j)) {
					addEdge(sequence1.get(j)-'0', sequence2.get(j)-'0');
				}
			}
		}
	}
	
	private List<Character> topologicalSort(){
		List<Character> list = new ArrayList<>();
		Stack<Integer> stack = new Stack<>();
		boolean[] visited = new boolean[adjacencyList.length];
		Arrays.fill(visited, false);
		
		for(int i=0; i<adjacencyList.length; i++) {
			if(!visited[i]) {
				topologicalSortUtil(i, visited, stack);
			}
		}
		
		while(!stack.isEmpty()) {
			list.add((char) (stack.pop() + '0'));
		}
		
		return list;
	}
	
	private void topologicalSortUtil(int u, boolean[] visited, Stack<Integer> stack) {
		visited[u] = true;
		
		for(Integer v : adjacencyList[u]) {
			if(!visited[v]) {
				topologicalSortUtil(v, visited, stack);
			}
		}
		stack.push(u);
	}
	
	public List<Character> getOriginalArrayFromSubsequences(List<List<Character>> subsequences) {
		int n = subsequences.size();
		if(n == 0) {
			return Collections.emptyList();
		}
		if(n == 1) {
			return subsequences.get(0);
		}
		
		addDataToDAG(subsequences);
		return topologicalSort();
	}

}
