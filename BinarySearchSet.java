package lab05;

public class BinarySearchSet {

	public double[] storage; //represent the simple array that holds the list values
	private int capacity; //holds the length of the storage array
	private int numItems ; //holds the number of the elements/values in the list
	
	public BinarySearchSet() {
		
		capacity = 6;
		storage = new double[capacity];
		
		
	}
	
	public boolean isEmpty() {
		
		if(numItems == 0) {
			
			return true;
		}
		else {
			return false;
		}
	}
	
	public int size() {
		
		numItems =0;
		
		for(int i = 0 ; i < storage.length; i++) {
			
			if(storage[i] != 0.0) {
				
				numItems ++;
			}
		}
		
		return numItems;
	}
	
	public void grow() {
		
		capacity = capacity*2;
		
		double secondStorage[] = new double [capacity];
		
		for(int i = 0 ; i < storage.length; i++) {
			
			secondStorage[i] = storage[i]; 
			
		}
		
		storage = secondStorage;
		
		
	}
	
	public String toString() {
		
		String answ = "\n";
		
		for(int i=0; i < storage.length; i++) {
			
			
				
				answ += (storage[i]) + " ";
				answ += "\n";
		}
		
		return answ;
	}
	
	public boolean remove(double value) {
		
		int num = size();
		int max= num;
		int min = 0; 
		int mid = 0; 
		boolean find = false;
		
		while(max >= min && find == false) {
			
			mid = (max + min) /2;
			
			if(storage[mid] == value) {
				
				find = true;
			}
			else if(storage[mid] < value) {
				
				min = mid+1;
				
			}
			else {
				
				max = mid-1;
			}
		}
		
		if(find == true) {
			
			for(int i = mid ; i < num -1 ; i ++) {
				
				int j;
				j= i+1;
				storage[i] = storage[j];
				
			}
			
			storage[num - 1] = 0.0 ;
			
			numItems --;
			
			return true;
		}
		else {
			
			return false;
		}
		
	}
	
	public boolean sequential_add(double newVal) {
		
		boolean find = false;
		
		for(int i = 0 ; i < numItems; i ++) {
			
			if( newVal == storage[i]) {
				
				find = true; 
			}
		}
		
		if(find == false && numItems>0) {
			
			int num = 0 ;
			
			if( numItems == storage.length) {
				
				grow();
		
			}
			
			while(newVal > storage[num] && num <= numItems) {
				
				num++;
				
			}
			
			if(num > numItems) {
				
				storage[num-1]= newVal;
				numItems++;
			}
			
			else {
				
				for(int i = numItems ; i > 0 & i >= num ; i --) {
				
					storage[i] = storage[i-1];
					
					
			}
			
			storage[num]= newVal;
			numItems++;
			}
		}
		
		else if(find == false){
			storage[0] = newVal;
			numItems++;
		}
		
		return find;
}
	
	public boolean contains(double value) {
		
		int max= numItems;
		int min = 0; 
		int mid = 0; 
		boolean find = false;
		
		while(max >= min && find == false) {
			
			mid = (max + min) /2;
			
			if(storage[mid] == value) {
				
				find = true;
			}
			else if(storage[mid] < value) {
				
				min = mid+1;
				
			}
			else {
				
				max = mid-1;
			}
		}
		
		
		return find;
		
	}
	
	public boolean containsAll(double[] elements) {
		
		int max= numItems;
		int min = 0; 
		int mid = 0; 	
		boolean find = false;
		int cont = 0;
		
		for(int i= 0 ; i < elements.length; i ++) {
			
			
			
			while(max >= min) {
			
				mid = (max + min) /2;
			
				if(storage[mid] == elements[i]) {
				
					
					cont ++;
					break;
				}
				
				else if(storage[mid] < elements[i]) {
				
					min = mid+1;
				
				}
				
				else {
				
				max = mid-1;
			}
		}
			max = numItems;
			min=0;
		}
		
		if(cont == elements.length) {
			
			return true;
		}
		else {
			
			return false;
			
		}
		
	}
	/*/o this function returns true if all the input values (stored in
	elements) are in the list
	o otherwise, return false
	o this method must take advantage of the list being sorted and use
	a binary search to determine if an item is in the array.
	*/
	public boolean binary_add(double newVal) {
		
		int max= numItems;
		int min = 0; 
		int mid =0;
		boolean find = true;
		
		if(numItems == storage.length) {
			
			grow();
			
		}
		while (min <= max && find == true) {
		    mid = (min + max ) / 2;

		        if(storage[mid] < newVal) {
		        	min = mid +1;
		        }
		           
		        else if(storage[mid] > newVal) {
		        	max = mid -1;
		        }
		        else if (storage[mid] == newVal) {
		        	find =  false;
		        }
		          
		}
		
		if(find == true ) {
			
		
			if( numItems > 0) {
		
			for(int i = numItems; i > mid; i--) {
			
				storage[i]= storage[i-1];
			
			}
			
			if(mid == 0 && storage[mid] < newVal) {
				
			storage[mid +1]= newVal;
			
			numItems ++;
			
			}
			else {
				
				storage[mid]= newVal;
				numItems++;
			}
			
			
			}
			else {
				
				storage[0]= newVal;
				
				numItems ++;
				
				
			}
		}
		
		
		return find;
		
		
	}
	
	public BinarySearchSet(double[] input) {
		
		capacity = input.length;
		storage = new double[capacity];
		
		for(int i = 0 ; i < input.length; i ++) {
			
		binary_add(input[i]);
			
		}
		
	}
	
	public void clear() {
		
		for(int i = 0 ; i < storage.length; i ++) {
			
			storage[i] = 0.0;
			
		}
	}
	
}


