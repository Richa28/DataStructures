package com.sample.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FindMedianInStream {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
	/*	BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < arrCount; i++) {
            int arrItem = Integer.parseInt(bufferedReader.readLine().trim());
            arr.add(arrItem);
        }

        findMedians(arr);

        bufferedReader.close();*/
		
		List<Integer> arr = new ArrayList<>();
		arr.add(5);
		arr.add(15);
		arr.add(1);
		arr.add(3);
		arr.add(2);
		arr.add(8);
		arr.add(7);
		arr.add(9);
		arr.add(10);
		arr.add(6);
		arr.add(11);
		arr.add(4);
		
		
		
		findMedians(arr);
	}
	
	public static void findMedians(List<Integer> arr) {
		int m = 0; // effective median 
		MaxHeap left  = new MaxHeap(); 
		MinHeap right = new MinHeap(); 
	  
	    for(int i = 0; i < arr.size(); i++) 
	    { 
	        m = getMedian(arr.get(i), m, left, right); 
	        System.out.println(m);
	    } 
	}
	
	static int getMedian(int e, int m, MaxHeap l, MinHeap r) 
	{ 
	    int sig = Signum(l.GetCount(), r.GetCount()); 
	    switch(sig) 
	    { 
	    case 1: 
	  
	        if( e < m ) 
	        { 
	            r.Insert(l.ExtractTop()); 
	  
	            l.Insert(e); 
	        } 
	        else
	        { 
	            r.Insert(e); 
	        } 
	  
	        m = Average(l.top(), r.top()); 
	  
	        break; 
	  
	    case 0: 
	  
	        if( e < m )
	        { 
	            l.Insert(e);
	            m = l.GetTop();
	        } 
	        else
	        { 
	            r.Insert(e);
	            m = r.GetTop();
	        } 
	  
	        break; 
	  
	    case -1:
	  
	        if( e < m )
	        { 
	            l.Insert(e);
	        } 
	        else
	        { 
	            l.Insert(r.ExtractTop()); 
	            r.Insert(e);
	        } 
	  
	        m = Average(l.GetTop(), r.GetTop()); 
	  
	        break; 
	    } 
	  
	    return m; 
	} 

	static int Average(int a, int b) 
	{ 
	    return (a + b) / 2; 
	} 
	
	public static int Signum(int a, int b) 
	{ 
	    if( a == b ) 
	        return 0; 
	  
	    return a < b ? -1 : 1; 
	}

}

class Heap{
	
	protected int heapSize;
	protected int[]  heapArray;
	
	public Heap()
    { 
        heapSize = -1; 
        heapArray = new int[128];
    } 
	
	public void Exch(int a, int b) 
	{ 
	    int aux = a; 
	    a = b; 
	    b = aux; 
	} 
  
	public int left(int i) 
    { 
        return 2 * i + 1; 
    } 
  
	public int right(int i) 
    { 
        return 2 * (i + 1); 
    } 
  
	public int parent(int i) 
    { 
        if( i <= 0 ) 
        { 
            return -1; 
        } 
  
        return (i - 1)/2; 
    } 
  
     
    
	public int top() 
    { 
        int max = -1; 
  
        if( heapSize >= 0 ) 
        { 
            max = heapArray[0]; 
        } 
  
        return max; 
    } 
  
    // Returns number of elements in heap 
	public int count() 
    { 
        return heapSize + 1; 
    } 
  
    public void heapify(int i) 
    { 
        int p = parent(i); 
  
        if( p >= 0 && heapArray[i] > heapArray[p] ) 
        { 
            Exch(heapArray[i], heapArray[p]); 
            heapify(p); 
        } 
    } 
  
    // Deletes root of heap 
	public int deleteTop() 
    { 
        int del = -1; 
  
        if( heapSize > -1) 
        { 
            del = heapArray[0]; 
  
            Exch(heapArray[0], heapArray[heapSize]); 
            heapSize--; 
            heapify(parent(heapSize+1)); 
        } 
  
        return del; 
    } 
  
    // Helper to insert key into Heap 
	public boolean insertHelper(int key) 
    { 
        boolean ret = false; 
  
        if( heapSize < 128 ) 
        { 
            ret = true; 
            heapSize++; 
            heapArray[heapSize] = key; 
            heapify(heapSize); 
        } 
  
        return ret; 
    } 
}

class MaxHeap extends Heap 
{ 
	int GetTop() 
    { 
        return top(); 
    } 
  
    int ExtractTop() 
    { 
        return deleteTop(); 
    } 
  
    int  GetCount() 
    { 
        return count(); 
    } 
  
    boolean Insert(int key) 
    { 
        return insertHelper(key); 
    }
    
    public void heapify(int i) 
    { 
        int p = parent(i); 
  
        if( p >= 0 && heapArray[i] < heapArray[p] ) 
        { 
            Exch(heapArray[i], heapArray[p]); 
            heapify(p); 
        } 
    } 
}

class MinHeap extends Heap 
{ 
    int GetTop() 
    { 
        return top(); 
    } 
  
    int ExtractTop() 
    { 
        return deleteTop(); 
    } 
  
    int  GetCount() 
    { 
        return count(); 
    } 
  
    boolean Insert(int key) 
    { 
        return insertHelper(key); 
    }
    
    public void heapify(int i) 
    { 
        int p = parent(i); 
  
        if( p >= 0 && heapArray[i] > heapArray[p] ) 
        { 
            Exch(heapArray[i], heapArray[p]); 
            heapify(p); 
        } 
    } 
};
