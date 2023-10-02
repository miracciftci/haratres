public class AlışerişSepeti {
	// List turunu ve List turuyle gelen bir cok ozelligide kullanabilirdim ama kullanmadım 
	// cunku algoritmalar kucuk ve List bellekte cok yer kaplar performans duser. 
	
	public static void main(String[] args){
		int[] A = {5, 6, 4, 3, 4 };

		try {
			System.out.println("Toplam tutar: " + totalBasketAmount(A));
		
			System.out.print("Indrirm yapilmayan kalemler: ");
			for(int i : nonDiscountableItems(A)) {
				System.out.print(i +" ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	static int[] discountBasket(int[] array) throws Exception {
		checkArray(array);
		int [] arrayclone = array.clone();
		for(int i = 0 ; i<arrayclone.length-1 ; i++) {
			if(arrayclone[i] > arrayclone[i+1]) {
				arrayclone[i] -= arrayclone[i+1];
			}
		}
		return arrayclone;
	}
	
	static int totalBasketAmount(int[] array) throws Exception {
		int total = 0;
		for(int i : discountBasket(array).clone()) {
			total += i;
		}
		return total;
	}
	
	static int[] nonDiscountableItems(int[] basket) throws Exception {
		int count = 0;
		int i = 0;
		int[] arraydiscount = discountBasket(basket).clone();
		int[] basketclone = basket.clone();
	
		for(i = 0 ; i< basket.length ; i++) {
			if(basket[i] == arraydiscount[i]) {
				basketclone[count] = basket[i];
				count++;
			}
		}
		int[] result = new int[count];
		for(i = 0 ; i<count ; i++) {
			result[i] = basketclone[i];
		}
		
		int num = 0;
		for(i = 0 ; i<result.length-1 ; i++) {
			for(int j = i+1 ; j<result.length ; j++) {
				if(result[j] < result[i]) {
					num = result[j];
					result[j] = result[i];
					result[i] = num;
				}
			}
		}
		return result;
	}
	
	static void checkArray(int[] array) throws Exception {
		if(!(1<array.length && array.length<100)) {
			throw new Exception("The size of the list must be between 1 and 100");
		}
		
		for(int i : array) {
			if(i>2000 || i<0) {
				throw new Exception("The value of list elements must be between 0 and 2.000");
			}
		}	
	}
	
	
	
	
}
