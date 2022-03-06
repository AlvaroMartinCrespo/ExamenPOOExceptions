package ejercicio1;

public class Parking {

	private static final int LONGITUD_MINIMA_NOMBRE = 3;
	private String nombre;
	private Categoria categoria;
	private int numeroPlazas;
	private int numeroPlazasOcupadas;
	private static double totalRecaudado=0;
	
	
	
	
	public Parking(String nombre, Categoria categoria, int numeroPlazas) throws ParkingException {
		setNombre(nombre);
		this.categoria = categoria;
		if ( numeroPlazas <=0)
			throw new ParkingException("Número de plazas incorrecto " + numeroPlazas);
		
		this.numeroPlazas = numeroPlazas;
		this.numeroPlazasOcupadas = 0;
	}
	
	public double cobrarYSalirDelParking ( int minutos) throws ParkingException {
		double precio;
		if ( minutos <=0) {
			throw new ParkingException("Minutos incorrectos " + minutos);
		}
		if ( numeroPlazasOcupadas==0) {
			throw new ParkingException ("No hay nadie en el parking, no puede salir");
		}
		
		precio= minutos* categoria.getPrecioPorMinuto();
		
		totalRecaudado+= precio;
		
		numeroPlazasOcupadas--;
		
		return precio;
		
	}
	
	
	public static double getTotalRecaudado() {
		return totalRecaudado;
	}

	
	public Parking clonarParking (String nuevoNombre) throws ParkingException {
		
		Parking nuevo=new Parking(nuevoNombre, categoria, numeroPlazas);
		return nuevo;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) throws ParkingException {
		if ( nombre.length() < LONGITUD_MINIMA_NOMBRE) {
			throw new ParkingException("Nombre incorrecto, no cumple la longitud mínima");
		}
		this.nombre = nombre;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	
	public int getNumeroPlazas() {
		return numeroPlazas;
	}
	
	public int getNumeroPlazasOcupadas() {
		return numeroPlazasOcupadas;
	}
	
	public void cocheEntraEnParking() throws ParkingException {
		if (numeroPlazas==numeroPlazasOcupadas) {
			throw new ParkingException("No puede entrar, parking completo");
		}
		numeroPlazasOcupadas++;
	}
	@Override
	public String toString() {
		return "Parking " + nombre + ", Categoria " + categoria + ", Numero de plazas: " + numeroPlazas
				+ ", Ocupadadas: " + numeroPlazasOcupadas ;
	}
	
	
	
	
	
	
	
}
