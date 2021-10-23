package ExceptionHandlingg;

public class ExceptionHierarchy {

	public static void employees(int linesOfCode) throws Exception  {
		// TODO Auto-generated method stub

		if (linesOfCode > 2500) {
			throw new Exception("Humm na karte!");
		}
//		try {
//			if (linesOfCode > 2500) {
//				throw new Exception("Humm na karte!");
//			}
//		} catch (Exception e) {
//			System.out.println("hum milkr hi bana lenge yr!");
//		}

		System.out.println("hum bana lenge!");
	}

	public static void assistant(int linesOfCode) throws Exception  {
		// TODO Auto-generated method stub

		System.out.println("Sunno employees tumhe ek project banana hai!");
		employees(linesOfCode);
//		try {
//			employees(linesOfCode);
//		} catch (Exception e) { //Exception e = new Exception()
//			// TODO Auto-generated catch block
//			System.out.println(e.getMessage());
//			System.out.println("Chalo main hi bana leta hun, warna naukri gyi!");
//		}
	}

	public static void main(String[] args)   { // main -> superviosr
		// TODO Auto-generated method stub

//		System.out.println("Sun assitant!");
//		assistant(3000);
//		System.out.println("Tera promotion");
		try {
			assistant(3000);
			System.out.println("Beta tera promotion");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("In main");
			System.out.println(e.getMessage());
			System.out.println("Gyi teri naukri!");
		}

	}

}
