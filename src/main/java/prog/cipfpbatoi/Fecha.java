package prog.cipfpbatoi;

import java.util.Calendar;
import java.util.StringTokenizer;

class Fecha {

	private int dia;

	private int mes;

	private int anyo;

	private static final String[] DIAS_TEXTO = new String[]{"domingo","lunes", "martes", "miercoles", "jueves", "viernes",
			"sábado"};

	private static final String[] MESES_TEXTO = new String[]{"enero", "febrero", "marzo", "abril", "mayo", "junio",
			"julio", "agosto", "septiembre", "octubre", "noviembre", "diciembre"};

	/**
	 * Constructor por defecto
	 * Inicializa una fecha a dia 1-1-1970
	 */
	public Fecha() {
		this.dia = 1;
		this.mes = 1;
		this.anyo = 1970;
	}

	/**
	 * Inicializa la fecha
	 *
	 * @param dia  de la semana
	 * @param mes  del año
	 * @param anyo
	 */
	public Fecha(int dia, int mes, int anyo) {
		this.dia = dia;
		this.mes = mes;
		this.anyo = anyo;
	}

	/**
	 * Inicializa la fecha a partir de otra pasada en formato String dd/mm/yyyy
	 * <p>
	 * Deberemos trocearlas de forma que asignemos el día més y año a cada uno de los atributoe
	 *
	 * @param fecha
	 */
	public Fecha(String fecha) {
		StringTokenizer st = new StringTokenizer(fecha, "/");
		this.dia = Integer.valueOf(st.nextToken());
		this.mes = Integer.valueOf(st.nextToken());
		this.anyo = Integer.valueOf(st.nextToken());
	}

	/**
	 * Modifica la fecha actual a partir de los datos pasados como argumento
	 */
	public void set(int dia, int mes, int anyo) {
		this.dia = dia;
		this.mes = mes;
		this.anyo = anyo;
	}

	/**
	 * Obtiene una fecha con los mismos atributos que la fecha actual
	 *
	 * @return
	 */
	public Fecha clone() {
		Fecha clon = new Fecha(this.dia, this.mes, this.anyo);
		return clon;
	}

	/**
	 * Devuelve el día de la semana que representa por la Fecha actual
	 *
	 * @return @dia
	 */
	public int getDia() {
		return dia;
	}

	/**
	 * Devuelve el mes que representa la Fecha actual
	 *
	 * @return @mes
	 */
	public int getMes() {
		return mes;
	}

	/**
	 * Devuelve el año que representa la Fecha actual
	 *
	 * @return @mes
	 */
	public int getAnyo() {
		return anyo;
	}

	/**
	 * Muestra por pantalla la fecha en formato español dd-mm-yyyy
	 */
	public void mostrarFormatoES() {
		System.out.printf("%02d-%02d-%d",this.dia, this.mes, this.anyo);
	}

	/**
	 * Muestra por pantalla la fecha en formato inglés yyyy-mm-dd
	 */
	public void mostrarFormatoGB() {
		System.out.printf("%d-%02d-%02d",this.anyo, this.mes, this.dia);
	}

	/**
	 * Muestra por pantalla la fecha en formato texto dd-mmmm-yyyy
	 * Ej. 1 enero de 1970
	 */
	public void mostrarFormatoTexto() {
		String mesActual = " ";
		String[] meses = {"enero", "febrero", "marzo", "abril", "mayo", "junio", "julio", "agosto", "setiembre", "octubre", "noviembre", "diciembre"};
		for (int i = 0; i < MESES_TEXTO.length; i++) {
			if (i == mes-1) {
				mesActual = meses[i];
			}
		}
		System.out.printf("%02d-"+mesActual+"-%d",this.dia, this.anyo);
	}

	/**
	 * Retorna un booleano indicando si la fecha del objeto es igual a la fecha pasada como
	 * argumento
	 *
	 * @return boolean
	 */
	public boolean isEqual(Fecha otraFecha) {
		if (otraFecha.getDia() == this.dia) {
			if (otraFecha.getMes() == this.mes) {
				if (otraFecha.getAnyo() == this.anyo) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Devuelve el número de la semana dentro del año actual.
	 *
	 * @return int dia semana
	 */
	public int getNumeroSemana() {
		// Inicializar un contador de semanas
		// Recorrer todos los meses del año
		// Para cada mes recorrer todos sus días (utilizar el método getDiasMes)
		// Para cada objeto fecha (nace de el dia, mes y año recorrido) preguntar si esa fecha es "domingo" (utilizar el método getDiaSemana)
		// Si el dia coincide con this --> devolver contador
		// Si es domingo --> incrementar contador de semanas

		int contadorSemanas = 1;

		for (int i = 1; i <=MESES_TEXTO.length ; i++) {
			for (int j = 1; j <=getDiasMes(i,this.anyo); j++) {
				Fecha dias = new Fecha(j,i,anyo);
				if (this.isEqual(dias)){
					return contadorSemanas;
				}

				if (dias.getDiaSemana().equals("domingo")){
					contadorSemanas++;
				}
			}
		}
		return contadorSemanas;
	}

	/**
	 * Retorna el dia correspondiente de la semana en formato String
	 *
	 * @return String
	 */
	public String getDiaSemana() {
		return DIAS_TEXTO[getDiasTranscurridosOrigen()%7];
	}

	/**
	 * Solo Festivo sábado o domingo
	 *
	 * @return boolean
	 */
	public boolean isFestivo() {
		boolean festivo = true;
		if (getDiaSemana()=="sábado"||getDiaSemana()=="domingo"){
			festivo = true;
		}else {
			festivo = false;
		}
		return festivo;
	}

	/**
	 * Devuelve un objeto de tipo fecha que representa una fecha añadiendo @numDias
	 * A la fecha Actual. El número máximo de dias a restar es 30
	 *
	 * @return boolean
	 */
	public Fecha anyadir(int numDias) {
		Fecha fechaConDiasAnyadidos = clone();
		int diasNuevos = fechaConDiasAnyadidos.getDia();
		int mesNuevo = fechaConDiasAnyadidos.getMes();
		int anyoNuevo = fechaConDiasAnyadidos.getAnyo();

		if (numDias <= 30 && numDias >= 0) {
			for (int i = 0; i <numDias ; i++) {
				if (diasNuevos < getDiasMes(mesNuevo,anyoNuevo)) {
					diasNuevos = diasNuevos + 1;
				}else{
					if (mesNuevo==12){
						mesNuevo = 1;
						diasNuevos = 1;
						anyoNuevo = anyoNuevo+1;
					}else{
						mesNuevo = mesNuevo + 1;
						diasNuevos = 1;
					}
					}
				}
			}
		return new Fecha(diasNuevos,mesNuevo,anyoNuevo);
	}

	/**
	 * Devuelve un objeto de tipo fecha que representa una fecha restando @numDias
	 * A la fecha Actual. El número máximo de dias a restar es 30
	 *
	 * @return boolean
	 */
	public Fecha restar(int numDias) {
		Fecha fechaConDiasAnyadidos = clone();
		int diasNuevos = fechaConDiasAnyadidos.getDia();
		int mesNuevo = fechaConDiasAnyadidos.getMes();
		int anyoNuevo = fechaConDiasAnyadidos.getAnyo();

		if (numDias <= 30 && numDias >= 0) {
			for (int i = 0; i <numDias ; i++) {
				if (diasNuevos > 1) {
					diasNuevos = diasNuevos - 1;
				}else {
					if (mesNuevo == 1) {
						mesNuevo = 12;
						diasNuevos = getDiasMes(mesNuevo,anyoNuevo);
						anyoNuevo = anyoNuevo - 1;
					} else {
						mesNuevo = mesNuevo - 1;
						diasNuevos = getDiasMes(mesNuevo,anyoNuevo);
					}
				}
				}
			}
		return new Fecha(diasNuevos,mesNuevo,anyoNuevo);
	}

	public boolean isCorrecta() {
		if (dia <= getDiasMes(mes,anyo)&&dia>=1){
			return true;
		}else{
			return false;
		}
	}

	/**
	 * Retorna el mes del año en formato text (enero, febrero, marzo,...)
	 *
	 * @return char
	 */
	private String getMesTexto() {
		return MESES_TEXTO[mes];
	}

	/**
	 * Devuelve el número de dias transcurridos desde el 1-1-1
	 *
	 * @return int
	 */
	private int getDiasTranscurridosOrigen() {
		int dias=0;
		for (int i = 1; i <= this.anyo-1; i++) {
			dias=getDiasAnyo(i)+dias;
		}
		dias=getDiasTranscurridosAnyo()+dias;
		return dias;
	}

	/**
	 * Devuelve el número de dias transcurridos en el anyo que representa el objeto
	 *
	 * @return int
	 */
	private int getDiasTranscurridosAnyo() {
		int total = 0;

		for (int i = 1; i < mes; i++) {
			total=total+getDiasMes((i),anyo);
		}

		return total + dia;

	}

	/**
	 * Indica si el año pasado como argumento es bisiesto. Un año es bisiesto si es divisible por 4
	 * pero no es divisible entre 100 o es divisible entre 4 entre 100 y entre 400
	 *
	 * @return boolean
	 */
	public static boolean isBisiesto(int anyo) {
		if ((anyo % 4 == 0) && ((anyo % 100 != 0) || (anyo % 400 == 0))) {
			return true;
		}
		return false;
	}

	/**
	 * Calcula el número de días que tiene el @mes en el @año pasado como argumento
	 * Deberás hacer uso del métodos isBisiesto
	 *
	 * @return int total dias mes en curso
	 */
	public static int getDiasMes(int mes, int anyo) {
		int diasMes = 0;
		switch (mes) {
			case 1:
				diasMes = 31;
			break;
			case 2:
				if (isBisiesto(anyo) == true) {
					diasMes = 29;
				} else {
					diasMes = 28;
				}
				break;
			case 3:
				diasMes = 31;
			break;
			case 4:
				diasMes = 30;
			break;
			case 5:
				diasMes = 31;
			break;
			case 6:
				diasMes = 30;
			break;
			case 7:
				diasMes = 31;
			break;
			case 8:
				diasMes = 31;
			break;
			case 9:
				diasMes = 30;
			break;
			case 10:
				diasMes = 31;
			break;
			case 11:
				diasMes = 30;
			break;
			case 12:
				diasMes = 31;
		}
		return diasMes;
	}


	/**
	 * Calcula el número total de dias que tiene el año pasado como argumento
	 *
	 * @return int total dias anyo en curso
	 */
	public static int getDiasAnyo(int anyo){
		if (isBisiesto(anyo)==true){
			return 366;
		}
		return 365;
	}
}

