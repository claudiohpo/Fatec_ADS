public class Distancias {
	
	public static void main(String[] args) {
		
		double km=20,milhas,milhasnau,leguas,pes;
		
		milhas = km / 1.609;
		milhasnau = km / 1.852;
		pes = km * 3281;
		leguas = km / 4.828;
		
		System.out.println("20 km são " + milhas + " milhas");
		System.out.println("20 km são " + milhasnau + " milhas nauticas");
		System.out.println("20 km são " + leguas + " léguas");
		System.out.println("20 km são " + pes + " pés");
		
	
	}
}