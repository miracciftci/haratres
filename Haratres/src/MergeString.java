
public class MergeString {
	
	public static void main(String[] args){
		String a = "hrte";
		String b = "aars";
		
		try {
			String result = fonk(a,b);
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	static String fonk(String a,String b) throws Exception {
		checkParameter(a, b);
		int size = Math.min(a.length(), b.length());
		StringBuilder result = new StringBuilder();
		
		for(int i = 0 ; i<size ; i++) {
			result.append(a.charAt(i)).append(b.charAt(i));
		}
		
		if(a.length() - b.length() > 0) 
			result.append(a.substring(size, a.length()));
		else 
			result.append(b.substring(size, b.length()));
		
		
		return result.toString();
	}
	
	static void checkParameter(String a, String b) throws Exception {
		if(!(1<a.length() && 1<b.length() && a.length()<2500 && b.length()<2500))
			throw new Exception("The size of the function parameters must be between 1 and 2500");	
	}
	
	
	
}
