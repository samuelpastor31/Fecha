package prog.cipfpbatoi;

import java.util.StringTokenizer;

class Fecha {

	private int dia;

	private int mes;

	private int anyo;

	private static final String[] DIAS_TEXTO = new String[] { "domingo", "lunes", "martes", "miercoles", "jueves", "viernes",
			"sábado"};

	private static final String[] MESES_TEXTO = new String[] { "enero", "febrero", "marzo", "abril", "mayo", "junio",
			"julio", "agosto", "septiembre", "octubre", "noviembre", "diciembre" };

	/**
	 *  Constructor por defecto
	 *  Inicializa una fecha a dia 1-1-1970
	 */
	public Fecha() {
		this.dia = 1;
		this.mes = 1;
		this.anyo = 1970;
	}

	/**
	 *  Inicializa la fecha
	 *  @param dia de la semana
	 *  @param mes del año
	 *  @param anyo
	 */
	public Fecha(int dia, int mes, int anyo) {
		this.dia = dia;
		this.mes = mes;
		this.anyo = anyo;
	}

	/**
	 * Inicializa la fecha a partir de otra pasada en formato String dd/mm/yyyy
	 *
	 * Deberemos trocearlas de forma que asignemos el día més y año a cada uno de los atributoe
	 * @param fecha
	 */
	public Fecha(String fecha) {
		StringTokenizer st = new StringTokenizer(fecha);
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
	 * @return
	 */
	public Fecha clone() {
		Fecha clon = new Fecha(this.dia,this.mes,this.anyo);
		return clon;
	}

	/**
	 * Devuelve el día de la semana que representa por la Fecha actual
	 * @return @dia
	 */
	public int getDia() {
		return dia;
	}

	/**
	 * Devuelve el mes que representa la Fecha actual
	 * @return @mes
	 */
	public int getMes(){
		return mes;
	}

	/**
	 * Devuelve el año que representa la Fecha actual
	 * @return @mes
	 */
	public int getAnyo(){
		return anyo;
	}

	/**
	 * Muestra por pantalla la fecha en formato español dd-mm-yyyy
	 */
	public void mostrarFormatoES()  {
		System.out.println(this.dia+"-"+this.mes+"-"+this.anyo);
	}

	/**
	 * Muestra por pantalla la fecha en formato inglés yyyy-mm-dd
	 */
	public void mostrarFormatoGB() {
		System.out.println(this.anyo+"-"+this.mes+"-"+this.dia);
	}

	/**
	 * Muestra por pantalla la fecha en formato texto dd-mmmm-yyyy
	 * Ej. 1 enero de 1970
	 */
	public void mostrarFormatoTexto() {
		String mesActual ="a";
		String[] mes = {"enero", "febrero", "marzo", "abril", "mayo", "junio", "julio", "agosto", "setiembre", "octubre", "noviembre", "diciembre"};
		for (int i = 0; i <mes.length ; i++) {
			if (i==this.mes){
				mesActual = mes[i];
			}
		}
		System.out.println(this.dia+"-"+mesActual+"-"+this.anyo);
	}

	/**
	 * Retorna un booleano indicando si la fecha del objeto es igual a la fecha pasada como
	 * argumento
	 *
	 * @return boolean
	 */
	public boolean isEqual(Fecha otraFecha) {
		if (otraFecha.getDia()==this.dia){
		}else if (otraFecha.getMes()==this.mes){
		}else if (otraFecha.getAnyo()==this.anyo){
			return true;
		}
		return false;
	}

	/**
	 * Devuelve el número de la semana dentro del año actual.
	 *
	 * @return int dia semana
	 */
	public int getNumeroSemana() {
		return 0;
	}

	/**
	 * Retorna el dia correspondiente de la semana en formato String
	 * @return String
	 */
	public String getDiaSemana() {
		return null;
	}

	/**
	 * Solo Festivo sábado o domingo
	 * @return boolean
	 */
	public boolean isFestivo() {
		return false;
	}

	/**
	 * Devuelve un objeto de tipo fecha que representa una fecha añadiendo @numDias
	 * A la fecha Actual. El número máximo de dias a restar es 30
	 *
	 * @return boolean
	 */
	public Fecha anyadir(int numDias){
		return null;
	}

	/**
	 * Devuelve un objeto de tipo fecha que representa una fecha restando @numDias
	 * A la fecha Actual. El número máximo de dias a restar es 30
	 *
	 * @return boolean
	 */
	public Fecha restar(int numDias){
		return null;
	}

	public boolean isCorrecta(){
		return false;
	}

	/**
	 * Retorna el mes del año en formato text (enero, febrero, marzo,...)
	 * @return char
	 */
	private String getMesTexto() {
		return null;
	}

	/**
	 * Devuelve el número de dias transcurridos desde el 1-1-1
	 *
	 * @return int
	 */
	private int getDiasTranscurridosOrigen() {
		return 0;
	}

	/**
	 * Devuelve el número de dias transcurridos en el anyo que representa el objeto
	 *
	 * @return int
	 */
	private int getDiasTranscurridosAnyo() {
		return 0;
	}

	/**
	 * Indica si el año pasado como argumento es bisiesto. Un año es bisiesto si es divisible por 4
	 * pero no es divisible entre 100 o es divisible entre 4 entre 100 y entre 400
	 *
	 * @return boolean
	 */
	public static boolean isBisiesto(int anyo){
		return false;
	}

	/**
	 *  Calcula el número de días que tiene el @mes en el @año pasado como argumento
	 *  Deberás hacer uso del métodos isBisiesto
	 *
	 *  @return int total dias mes en curso
	 */
	public static int getDiasMes(int mes, int anyo) {
		return 0;
	}

	/**
	 * Calcula el número total de dias que tiene el año pasado como argumento
	 *
	 * @return int total dias anyo en curso
	 */
	public static int getDiasAnyo(int anyo){
		return 0;
	}
}

