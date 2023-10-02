public class YakinNumaralarProblemleri {
	
	public static void main(String[] args) {
		int[] A = { 3, 1, 5, 23, 2, 4, 9, 10, 15, 31 };
		
		try {
			for(String str : fonk(A)) 
				System.out.println(str);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	static String[] fonk(int[] array) throws Exception {
		checkArray(array);
		array = sortingArray(array);
		int difference = smallestDifference(array);
		
		String[] resultArray = new String[array.length];
		int count = 0;
		
		for(int i = 0 ; i<array.length-1 ; i++) {
			if(array[i+1]-array[i] == difference) {
				resultArray[count] = String.valueOf(array[i]) + " " + String.valueOf(array[i+1]);
				count++;
			}
		}
		
		String[] result = new String[count];
		
		for(int i = 0 ; i<count ; i++) {
			result[i] = resultArray[i];
		}
		
		return result;
	}
	
	static int smallestDifference(int[] array) {
		int result = Math.abs(array[1] - array[0]);
		int size = array.length;
		
		for(int i = 0 ; i<size ; i++) {
			for(int j = i+1 ; j<size ; j++) {
				 int diff = Math.abs(array[i] - array[j]);
				 if(diff < result && diff !=0) {
					 result = diff;
				 }
			}
		}
		
		return result;
	}
	
	static int[] sortingArray(int array[]) {
		int num = 0;
		for(int i = 0 ; i<array.length-1 ; i++) {
			for(int j = i+1 ; j<array.length ; j++) {
				if(array[j] < array[i]) {
					num = array[j];
					array[j] = array[i];
					array[i] = num;
				}
			}
		}
		return array;
	}
	
	static void checkArray(int[] array) throws Exception {
		if(!(1<array.length && array.length<1000)) {
			throw new Exception("The size of the list must be between 1 and 1000");
		}
		
		for(int i : array) {
			if(i>20000 || i<-20000) {
				throw new Exception("The value of list elements must be between -20.000 and 20.000");
			}
		}
	}
	
}
