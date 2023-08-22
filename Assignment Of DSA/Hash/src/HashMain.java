public class HashMain {
	public static void main(String[] args) {
		HashArray h1=new HashArray();
		h1.put("rk", "cc");
		h1.put("rk2","aa");
		h1.put("rk3", "bb");
		//System.out.println("value "+h1.get("rk2"));
		//h1.remove("rk3");
		//System.out.println("value "+h1.get("rk3"));
		//System.out.println("size "+h1.size());
		//System.out.println("size "+h1.contains("bb"));
		h1.printElement();
	}
}

