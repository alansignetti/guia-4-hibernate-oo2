package negocio;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;



//import test.al;
//import test.mayor;
//import test.tercer;

public class Funciones {
	public static boolean esBisiesto (int anio){
		boolean resultado=false;
		if ((anio % 4 == 0) && ((anio % 100 != 0) || (anio % 400 == 0))) {

			resultado=true;
		}

		return resultado;
	}

	//	Serán bisiestos los años divisibles por 4, exceptuando los que son divisibles por 100 y no
	//	divisibles por 400. Ejemplos: son bisiestos 1996, 2004, 2000, 1600; No son bisiestos 1700,
	//	1800, 1900, 2100


	public static boolean esFechaValida (LocalDate fecha){
		boolean resultado =false;
		//		En el caso de ser bisiesto es válido el día 29/02
		int anio=fecha.getYear();
		if ((anio % 4 == 0) && ((anio % 100 != 0) || (anio % 400 == 0))) {
			if(fecha.getMonthValue()==02&& fecha.getDayOfMonth()==29) {
				//System.out.println("Es valido");
				resultado=true;
			}

		}
		else
			System.out.println("No es valido");

		return resultado;
	}

	public static String traerFechaCorta (LocalDate fecha) {
		//		Retorna “dd/mm/aaaa”		
		int dd=fecha.getDayOfMonth();		
		int mm=fecha.getMonthValue();		
		int aaaa=fecha.getYear();

		return dd+"/"+mm+"/"+aaaa;		
	}

	public static String traerHoraCorta (LocalTime hora) {
		//		Retorna “hh:mm”

		int hh=hora.getHour();
		int mm=hora.getMinute();
		return hh+":"+mm;
	}

	public static boolean esDiaHabil (LocalDate fecha) {
		//		Consideramos hábil de lunes a viernes.
		boolean resultado=false;
		if(fecha.getDayOfWeek()!=DayOfWeek.SUNDAY&&fecha.getDayOfWeek()!=DayOfWeek.SATURDAY) {
			//			System.out.println("Es dia habil");
			resultado=true;
		}
		else {

			//			System.out.println("No es dia habil");


		}
		return resultado;

	}

	public static String traerDiaDeLaSemana (LocalDate fecha) {

		String diaEsp = null;
		DayOfWeek dia=fecha.getDayOfWeek();
		switch (dia) {
		case MONDAY:

			diaEsp="Lunes";
			break;
		case TUESDAY:

			diaEsp="Martes";
			break;
		case WEDNESDAY:

			diaEsp="Miercoles";
			break;
		case THURSDAY:

			diaEsp="Jueves";
			break;
		case FRIDAY:

			diaEsp="Viernes";
			break;
		case SATURDAY:

			diaEsp="Sabado";
			break;
		case SUNDAY:

			diaEsp="Domingo";
			break;

		}
		return diaEsp;		
	}
	public static String traerMesEnLetras (LocalDate fecha) {
		String mesEnLetras=null;
		switch (fecha.getMonthValue()) {
		case 1:
			mesEnLetras="Enero";
			break;
		case 2:
			mesEnLetras="Febrero";
			break;
		case 3:
			mesEnLetras="Marzo";
			break;
		case 4:
			mesEnLetras="Abril";
			break;
		case 5:
			mesEnLetras="Mayo";
			break;
		case 6:
			mesEnLetras="Junio";
			break;
		case 7:
			mesEnLetras="Julio";
			break;
		case 8:
			mesEnLetras="Agosto";
			break;
		case 9:
			mesEnLetras="Septiembre";
			break;
		case 10:
			mesEnLetras="Octubre";
			break;
		case 11:
			mesEnLetras="Noviembre";
			break;
		case 12:
			mesEnLetras="Diciembre";
			break;
		}
		return mesEnLetras;

	}

	public static String traerFechaLarga (LocalDate fecha) {
		String diaLetra=traerDiaDeLaSemana(fecha);
		int dia=fecha.getDayOfMonth();
		String mes=traerMesEnLetras(fecha);
		int anio=fecha.getYear();
		return diaLetra+" "+dia+" de "+mes+" del "+anio;
	}

	public static int traerCantDiasDeUnMes (int anio, int mes) {
		int numDias=0;
		switch (mes) {
		case 1: case 3: case 5: case 7: case 8: case 10: case 12:
			numDias = 31;
			break;
		case 4: case 6: case 9: case 11:
			numDias = 30;
			break;
		case 2:

			if (esBisiesto(anio)) {
				numDias = 29;

			}
			else
				numDias = 28;
		}
		return numDias;

	}

	public  static double aproximar2Decimal (double valor) {
		//		Si el tercer decimal es mayor o igual 5, suma 1 al segundo decimal		
		double v=Math.round(valor * 100d) / 100d;
		return v;
	}
	public static boolean esNumero(char c) {
		boolean resultado=false;
		if (Character.isDigit(c)) {
			resultado= true;
		}
		return resultado;

	}

	public static boolean esLetra(char c) {
		boolean resultado=false;
		if (Character.isLetter(c)) {
			resultado= true;
		}
		return resultado;
	}

	public static boolean esCadenaNros(String cadena) {
		boolean resultado=false;
		boolean numeric = true;
		numeric = cadena.matches("-?\\d+(\\.\\d+)?");//para float etc
		if(numeric) {
			resultado=true;
		}   	      	        	
		return resultado;
	}


	public static boolean esCandenaLetras(String cadena) {
		boolean resultado=true;
		if (cadena == null) {
			// checks if the String is null 
			resultado= false;
		}      
		int len = cadena.length();
		for (int i = 0; i < len; i++) {
			if ((Character.isLetter(cadena.charAt(i)) == false)) {
				resultado=false;
			}
		}	      
		return resultado;
	}

}


















































































/*
 * 
public class Congreso {
	private List<Persona> lstPersonas;
	private List<Conferencia> lstConferencias;
	private List<Entrada> lstEntradas;

	public Congreso() {
		super();
		this.lstPersonas = new ArrayList<Persona>();
		this.lstConferencias = new ArrayList<Conferencia>();
		this.lstEntradas = new ArrayList<Entrada>();
	}

	public List<Persona> getLstPersonas() {
		return lstPersonas;
	}
	public void setLstPersonas(List<Persona> lstPersonas) {
		this.lstPersonas = lstPersonas;
	}
	public List<Conferencia> getLstConferencias() {
		return lstConferencias;
	}
	public void setLstConferencias(List<Conferencia> lstConferencias) {
		this.lstConferencias = lstConferencias;
	}
	public List<Entrada> getLstEntradas() {
		return lstEntradas;
	}
	public void setLstEntradas(List<Entrada> lstEntradas) {
		this.lstEntradas = lstEntradas;
	}



	//4
	public List<Espectador> traerEspectador(){

		List<Espectador> ep1 = new ArrayList<>();
		Espectador e1=null;
		Iterator<Persona> it= lstPersonas.iterator();
		while (it.hasNext()) {
			Persona p=it.next();
			if (p instanceof Espectador ){
				e1=(Espectador) p;
				ep1.add(e1);	
			}		
		}
		return ep1;		
	}


	//5
	public Espectador traerEspectador(long nroDocumento){
		List<Espectador> ep1 = this.traerEspectador();
		Iterator<Espectador> it= ep1.iterator();
		Espectador e1=null;
		int valor=0;
		while (it.hasNext() && valor!=1) {
			e1= it.next();			
			if (e1.getNroDocumento()==nroDocumento) {
				valor=1;
			}
		}
		return e1;
	}



	//6
	public boolean agregarEspectador(String movil, String mail, String nombre, String apellido, String tipoDocumento,
			long nroDocumento, String nivelEstudio) {
		boolean devolver=false;
		Espectador e1=this.traerEspectador(nroDocumento);	

		int id=1;
		if (lstPersonas.size() !=0) {
			id=lstPersonas.get(lstPersonas.size()-1).getIdPersona()+1;
		}	

		if (e1!=null) 	
			devolver= false;

		devolver=lstPersonas.add(new Espectador(id, movil, mail, nombre, apellido, tipoDocumento, nroDocumento, nivelEstudio));
		return devolver;

	}

	//8
	public Conferencia traerConferencia(int idConferencia){
		int valor=0;
		Conferencia c1=null;
		Iterator<Conferencia> it= lstConferencias.iterator();
		while (it.hasNext() && valor!=1) {
			c1=it.next();
			if (c1.getIdConferencia()==idConferencia) {			
				valor=1;				
			}				
		}		
		
			return c1;
		
	}
	//7
	public boolean agregarConferencia(String titulo, LocalDate dia, double costo) {

		int valor=0;
		Iterator<Conferencia> it= lstConferencias.iterator();
		Conferencia c1=null;			
		while (it.hasNext() && valor!=1) {
			c1=it.next();
			if (c1.getTitulo().equalsIgnoreCase(titulo)) { //si existe el titulo			
				valor=1;
			}		

		}
		boolean devolver=false;
		if (valor!=1)			
			devolver= lstConferencias.add(new Conferencia(lstConferencias.size()+1, titulo, dia, costo));

		return devolver;
	}


	public List<Auspiciante> traerAuspiciante(){	
		List<Auspiciante> ap1= new ArrayList<Auspiciante>();
		Iterator<Persona> it= lstPersonas.iterator();
		while (it.hasNext()) {
			Persona p= it.next();
			if (p instanceof Auspiciante){
				Auspiciante a1=(Auspiciante) p;
				ap1.add(a1);	
			}		
		}		
		return ap1;
	}

	public Auspiciante traerAuspiciante(String cuit){
		Auspiciante a1=null;
		List<Auspiciante> ap1=this.traerAuspiciante();
		Iterator<Auspiciante> it = ap1.iterator();		
		int stop=0;		
		while(it.hasNext() && stop!=1){			//recorre la lista
			a1=it.next();
			if (a1.getCuit().equalsIgnoreCase(cuit)) {
				stop=1;
			}
		}			
		Auspiciante devolver=null;
		if (stop==1) {
			devolver= a1;
		}
		else {
			devolver= null;
		}
		return devolver;

	}


	public boolean agregarAuspiciante(String movil, String mail, String razonSocial, String cuit,double montoAportado) throws Exception{
		Auspiciante a1=this.traerAuspiciante(cuit);//MODIFICAR REUTILIZAR LISTA TRAERAUSPICIANTE
		if (a1!=null) 
			throw new Exception ( "Ya existe el cuit-->"+cuit );

		int id=1;
		if (lstPersonas.size()!=0) {
			id= lstPersonas.get(lstPersonas.size()-1).getIdPersona();
		}
		return lstPersonas.add(new Auspiciante(id, movil, mail, razonSocial, cuit, montoAportado));
	}
	public List<Entrada> traerEntrada(LocalDate dia){

		Iterator<Entrada> it=lstEntradas.iterator();
		List<Entrada> en1= new ArrayList<Entrada>();

		while (it.hasNext()) {
			Entrada e = it.next();
			if (e.getConferencia().getDia().isEqual(dia)) {
				en1.add(e);
			}
		}
		return en1;
	}

	public boolean agregarEntrada(String codIngreso, double precio,	Espectador espectador, 
			Conferencia conferencia) throws Exception{//duda con el try catch y la excepcion

		boolean devolver=false;
		int stop=0;
		Iterator<Entrada> it= lstEntradas.iterator();
		while (it.hasNext() && stop==0) {
			Entrada e =  it.next();
			if (e.getCodIngreso().equalsIgnoreCase(codIngreso)) {
				stop=1;//lo encuentra				
			}			
		}
		int id=1;
		if(lstEntradas.size()!=0) {//si es 0 ya es 1
			id= lstEntradas.get(lstEntradas.size()-1).getIdEntrada()+1;//porque empieza desde 0 
//			de la ultima posicion  toma el id y le suma uno
		}
		if (stop== 0 ) {//si no existe
			devolver= lstEntradas.add(new Entrada(id, codIngreso, LocalDate.now(), LocalTime.now(), precio, espectador, conferencia));
		}		
		return devolver;

	}

	public List<Conferencia> traerConferencia(LocalDate dia){

		Iterator<Conferencia> it= lstConferencias.iterator();		
		List<Conferencia> cf= new ArrayList<Conferencia>();

		while (it.hasNext()) {
			Conferencia conferencia = it.next();
			if (conferencia.getDia().isEqual(dia)) {
				cf.add(conferencia);
			}			
		}		
		return cf;		
	}
	

	public double calcularBalance(LocalDate dia) {
	
	//		double balance=0;
			double gananciaEntradas=0;
			double gananciaConferencias=0;
	//		
	//		List<Entrada> entradas=this.traerEntrada(dia);
	//		Iterator<Entrada> it = entradas.iterator();
//		while (it.hasNext()) {
//			Entrada e = it.next();
//				gananciaEntradas=gananciaEntradas+e.getPrecio();					
//		}	
//		
//		List<Conferencia> conferencias=this.traerConferencia(dia);
//		Iterator<Conferencia> it1= conferencias.iterator();		
//		while (it1.hasNext()) {
//			Conferencia c=it1.next();
//			gananciaConferencias=gananciaConferencias+c.calcularCostoReal();			
//		}
//		System.out.println(gananciaEntradas+"ent-------conf"+gananciaConferencias);
//		
		for (Conferencia c: this.traerConferencia(dia)) {
			gananciaConferencias=gananciaConferencias+c.calcularCostoReal();				
		}
		for (Entrada e : this.traerEntrada(dia)) {
			gananciaEntradas=gananciaEntradas+e.getPrecio();			
		}
		return gananciaEntradas+gananciaConferencias;		
	}
 
  
  
public class Entrada {
	private int idEntrada;
	private String codIngreso;
	private LocalDate fechaCompra;
	private LocalTime horaCompra;
	private double precio;
	private Espectador espectador;
	private Conferencia conferencia;

	public Entrada(int idEntrada, String codIngreso, LocalDate fechaCompra, LocalTime horaCompra, double precio,
			Espectador espectador, Conferencia conferencia) throws Exception {
		super();
		this.idEntrada = idEntrada;
		this.setCodIngreso(codIngreso);
		this.fechaCompra = fechaCompra;
		this.horaCompra = horaCompra;
		this.precio = precio;
		this.espectador = espectador;
		this.conferencia = conferencia;
	}

	@Override
	public String toString() {
		return "\nidEntrada=" + idEntrada + ", codIngreso=" + codIngreso + ", fechaCompra=" + fechaCompra
				+ ", horaCompra=" + horaCompra + ", precio=" + precio + ", espectador=" + espectador.getNombre()+ espectador.getApellido() + ", conferencia="
				+ conferencia.getTitulo() ;
	}

	public int getIdEntrada() {
		return idEntrada;
	}

	public void setIdEntrada(int idEntrada) {
		this.idEntrada = idEntrada;
	}

	public String getCodIngreso() {
		return codIngreso;
	}

	public void setCodIngreso(String codIngreso)throws Exception {			
		if (!this.esCodIngresoValido(codIngreso)) throw new Exception("El codigo de la entrada " + codIngreso+" es incorrecto ");
			this.codIngreso = codIngreso;
	}

	public LocalDate getFechaCompra() {
		return fechaCompra;
	}

	public void setFechaCompra(LocalDate fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	public LocalTime getHoraCompra() {
		return horaCompra;
	}

	public void setHoraCompra(LocalTime horaCompra) {
		this.horaCompra = horaCompra;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Espectador getEspectador() {
		return espectador;
	}

	public void setEspectador(Espectador espectador) {
		this.espectador = espectador;
	}

	public Conferencia getConferencia() {
		return conferencia;
	}

	public void setConferencia(Conferencia conferencia) {
		this.conferencia = conferencia;
	}

	
	
	public int calcularDigitoVerificador(String codIngreso) {

		int primeros=0;
		int segundos=0;
		for (int i = 0; i < 6; i++) {
			if (i<3) {
				int valor=Character.getNumericValue(codIngreso.charAt(i));
				valor=valor*2;
				primeros=primeros +valor;
			}
			else {
				int valor=Character.getNumericValue(codIngreso.charAt(i));
				valor=valor*5;
				segundos=segundos +valor;
			}							
		}
		int codigo= primeros+segundos;
		int multiplo=codigo;

		while (multiplo%10!=0) {
			multiplo--;
		}
		return codigo - multiplo;

	}


	public boolean esCodIngresoValido(String codIngreso) {

		int codigo=this.calcularDigitoVerificador(codIngreso);
		boolean devolver=false;

		for (int i = 0; i < codIngreso.length(); i++) {
			int ultimoNum=Character.getNumericValue(codIngreso.charAt(i));
			if (i==6 && ultimoNum==codigo) {
				devolver=true;							
			}			
		}
		return devolver;

	}
	
  
  
  
  
  
  
public class Conferencia {
	private int idConferencia;
	private String titulo;
	private LocalDate dia;
	private double costo;
	private List<Auspiciante> lstAuspiciantes=null;

	public Conferencia(int idConferencia, String titulo, LocalDate dia, double costo) {
		super();
		this.idConferencia = idConferencia;
		this.titulo = titulo;
		this.dia = dia;
		this.costo = costo;
		this.lstAuspiciantes = new ArrayList<Auspiciante>();

	}

	@Override
	public String toString() {
		return "[" + idConferencia + "]" + titulo + "--> dia:" + dia + " $"
				+ costo + "\nAuspiciantes:"+lstAuspiciantes;
	}

	public int getIdConferencia() {
		return idConferencia;
	}
	public void setIdConferencia(int idConferencia) {
		this.idConferencia = idConferencia;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public LocalDate getDia() {
		return dia;
	}
	public void setDia(LocalDate dia) {
		this.dia = dia;
	}
	public double getCosto() {
		return costo;
	}
	public void setCosto(double costo) {
		this.costo = costo;
	}
	public List<Auspiciante> getLstAuspiciantes() {
		return lstAuspiciantes;
	}
	public void setLstAuspiciantes(List<Auspiciante> lstAuspiciantes) {
		this.lstAuspiciantes = lstAuspiciantes;
	}

		public boolean agregarAuspiciante(Auspiciante auspiciante){
		
				return lstAuspiciantes.add(new Auspiciante(auspiciante.idPersona, auspiciante.getMovil(), auspiciante.getMail(), auspiciante.getRazonSocial(), auspiciante.getCuit(), auspiciante.getMontoAportado()));
		}

		public double calcularCostoReal() {
//			List<Auspiciante> a1= this.traerAuspiciante();
			Iterator<Auspiciante> it= lstAuspiciantes.iterator();
			double costoReal=0;
			Auspiciante a1=null;
			while (it.hasNext()) {
				a1=it.next();
				costoReal=costoReal + a1.getMontoAportado();
			}			
//			System.out.println("monto aportado"+a1.getCuit()+a1.getMontoAportado());
			double cost=costoReal - costo;
			return cost;			
		}
  
  */
