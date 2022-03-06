package ejercicio1;

import java.util.Scanner;

public class PrincipalEjercicio1 {
	
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		Categoria categoria = crearCategoria();
		
		try {
			Parking parking1=crearParking(categoria, 1);
		} catch (ParkingException e) {
			System.out.println(e.getMessage());
		}
		try {
			Parking parking2=crearParking(categoria, 2);
			Parking parking3=crearParking(categoria, 3);
			
			parking3.cocheEntraEnParking();
			
			System.out.println("¿Cuántos minutos ha estado estacionado en el Parking " + parking3.getNombre() + "?");
			int minutos = sc.nextInt();
			
			double precio=parking3.cobrarYSalirDelParking(minutos);
			System.out.println("Ha pagado " + precio + "€.");
			
		}catch ( ParkingException e) {
			System.out.println(e.getMessage());
		}
		
		

	}

	private static Categoria crearCategoria() {

		Categoria categoria = null;
		String nombre;
		double precioPorMinuto;

		boolean error;
		
		do {
			System.out.println("Introduce el nombre de la categoria");
			nombre = sc.nextLine();

			System.out.println("Introduce el precio por minuto:");
			precioPorMinuto = sc.nextDouble();

			try {
				categoria = new Categoria(nombre, precioPorMinuto);
				error=false;
			} catch (ParkingException e) {
				System.out.println(e.getMessage());
				error=true;
			}

		} while (error);
		return categoria;
	}
	
	private static Parking crearParking (Categoria categoria, int numero) throws ParkingException {
		
		Parking parkingNuevo;
		int numPlazas;
		String nombre;
		
		System.out.println("Introduzca el nombre del Parking " + numero + ": ");
		nombre = sc.next();
		System.out.println("Introduzca el número de plazas que tendrá: ");
		numPlazas = sc.nextInt();
		
		parkingNuevo = new Parking (nombre, categoria, numPlazas);
		
		return parkingNuevo;
		
	}

}
