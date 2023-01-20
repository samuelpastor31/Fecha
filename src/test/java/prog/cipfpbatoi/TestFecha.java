package prog.cipfpbatoi;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class TestFecha {

    private PrintStream oldOut;
    private ByteArrayOutputStream baos;
    @BeforeEach
    public void before() {
        // Redirigir salida estándar
        baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        oldOut = System.out;
        System.out.flush();
        System.setOut(ps);
    }

    @AfterEach
    public void after() {
        // Reestablecer salida estándar
        System.setOut(oldOut);
    }

    @Test
    public void testConstructorPorDefecto() {

        Fecha fecha = new Fecha();
        assertTrue(fecha.getDia() == 1 && fecha.getMes() == 1 && fecha.getAnyo() == 1970, "El constructor por defecto inicializa los valores de dia, mes y año a los valores indicados en el enunciado");
    }

    @Test
    public void testConstructorParametrizado3Parametros() {
        int dia = 3;
        int mes = 4;
        int anyo = 2015;
        Fecha fecha = new Fecha(dia, mes, anyo);
        assertTrue(fecha.getDia() == dia && fecha.getMes() == mes && fecha.getAnyo() == anyo, "El constructor parametrizado con 3 parámetros no inicializa correctamente los valores");
    }

    @Test
    public void testConstructorParametrizado1ParametroString() {
        int dia = 3;
        int mes = 4;
        int anyo = 2015;
        Fecha fecha = new Fecha(dia + "/" + mes + "/" + anyo);
        assertTrue(fecha.getDia() == dia && fecha.getMes() == mes && fecha.getAnyo() == anyo, "El constructor parametrizado con 1 parámetro String no está inicializando correctamente los valores del objeto");
    }

    @Test
    public void testSet() {
        Fecha fecha = new Fecha(3, 5, 2014);
        int diaFinal = 4;
        int mesFinal = 9;
        int anyoFinal = 2020;
        fecha.set(diaFinal, mesFinal, anyoFinal);
        assertTrue(fecha.getDia() == diaFinal && fecha.getMes() == mesFinal && fecha.getAnyo() == anyoFinal, "El método set no asigna correctamente todos los datos de la fecha");
    }

    @Test
    public void testClone() {
        int dia = 4; int mes = 9; int anyo = 2020;
        Fecha fecha = new Fecha(dia, mes, anyo);
        Fecha fechaClon = fecha.clone();

        assertTrue(fechaClon.getDia() == dia && fechaClon.getMes() == mes && fechaClon.getAnyo() == anyo, "La fecha clonada y la fecha original no contienen la misma información");
    }

    @Test
    public void testIsEqual() {
        Fecha fecha1 = new Fecha(3, 6, 298);
        Fecha fecha2 = new Fecha(3, 6, 298);
        Fecha fecha3 = new Fecha("03/06/298");
        Fecha fecha4 = new Fecha();

        assertTrue(fecha1.isEqual(fecha2), "La fechas creadas con un mismo constructor no coinciden conteniendo la misma información");
        assertTrue(fecha2.isEqual(fecha3), "Las fechas creadas con diferentes constructores no coinciden conteniendo la misma información");
        assertTrue(fecha3.isEqual(fecha2), "Las fechas creadas con diferentes constructores no coinciden conteniendo la misma información");
        assertFalse(fecha1.isEqual(fecha4), "Las fechas son diferentes y se están dando como iguales");
    }

    @Test
    public void testGetDiaSemana() {
        Fecha fecha = new Fecha(12, 12, 2023);
        String diaSemanaObtenido = fecha.getDiaSemana();
        String diaSemanaEsperado = "martes";
        assertTrue(diaSemanaObtenido.equalsIgnoreCase(diaSemanaEsperado), "Esperaba que fuera "+ diaSemanaEsperado +" y el 12/12/2023 se ha determinado que es " + diaSemanaObtenido);

        Fecha fecha2 = new Fecha(1, 1, 2012);
        diaSemanaObtenido = fecha2.getDiaSemana();
        diaSemanaEsperado = "domingo";
        assertTrue(fecha2.getDiaSemana().equalsIgnoreCase("domingo"), "Esperaba que fuera "+ diaSemanaEsperado +" y el 01/01/2012 se ha determinado que es " + diaSemanaObtenido);
    }

    @Test
    public void testIsFestivo() {
        Fecha fecha = new Fecha(12, 12, 2023);
        assertFalse(fecha.isFestivo(), "El día se marca como no festivo cuando realmente no lo es (sábado o domingo)");

        Fecha fecha2 = new Fecha(1, 1, 2012);
        assertTrue(fecha2.isFestivo(), "El día no se marca como no festivo cuando realmente lo es (sábado o domingo)");
    }

    @Test
    public void testGetNumeroSemana() {
        Fecha fecha1 = new Fecha(15, 1, 2018);
        int numeroSemanaEsperado = 3;
        assertTrue(fecha1.getNumeroSemana()== 3, "No se está determinando que la fecha 15/1/2018 sea un día de la semana " + numeroSemanaEsperado);

        Fecha fecha2 = new Fecha(2,1,2017);
        numeroSemanaEsperado = 2;
        assertTrue(fecha2.getNumeroSemana() == 2,  "No se está determinando que la fecha 02/01/2017 sea un día de la semana " + numeroSemanaEsperado);

        Fecha fecha3 = new Fecha(6,3,2021);
        numeroSemanaEsperado = 10;
        assertTrue(fecha3.getNumeroSemana() == 10,  "No se está determinando que la fecha 06/03/2021 sea un día de la semana " + numeroSemanaEsperado);

        Fecha fecha4 = new Fecha(31, 12, 1996);
        numeroSemanaEsperado = 53;
        assertTrue(fecha4.getNumeroSemana() == 53,  "No se está determinando que la fecha 31/12/1996 sea un día de la semana " + numeroSemanaEsperado);
    }

    @Test
    public void testAnyadir() {

        Fecha fechaInicial = new Fecha(15, 1, 2022);
        Fecha fechaDiaSiguienteAFechaInicial = new Fecha(16, 1, 2022);
        assertTrue(fechaInicial.anyadir(1).isEqual(fechaDiaSiguienteAFechaInicial), "No se está añadiendo correctamente un día a la fecha 15/1/2022");


        Fecha fechaInicial2 = new Fecha(30, 12, 2021);
        Fecha fechaDosDiasSiguientesAFechaInicial = new Fecha(1, 1, 2022);
        assertTrue(fechaInicial2.anyadir(2).isEqual(fechaDosDiasSiguientesAFechaInicial), "No se está añadiendo correctamente dos días a la fecha 30/12/2021");

        Fecha ultimoDiaEnero = new Fecha(31, 1, 2022);
        Fecha treintaDiasDespues = new Fecha(2, 3, 2022);
        assertTrue(ultimoDiaEnero.anyadir(30).isEqual(treintaDiasDespues), "No se está sumando correctamente treinta días a la fecha 31/1/2022");
    }

    @Test
    public void testRestar() {
        Fecha fechaInicio = new Fecha(15, 1, 2022);
        Fecha fechaFinalEsperada = new Fecha(14, 1, 2022);
        assertTrue(fechaInicio.restar(1).isEqual(fechaFinalEsperada), "No se está restando correctamente un día al 15/1/2022");

        fechaInicio = new Fecha(1, 1, 2022);
        fechaFinalEsperada = new Fecha(30, 12, 2021);
        assertTrue(fechaInicio.restar(2).isEqual(fechaFinalEsperada), "No se está restando correctamente dos días al 1/1/2022");

        fechaInicio = new Fecha(2, 3, 2022);
        fechaFinalEsperada = new Fecha(31, 1, 2022);
        assertTrue(fechaInicio.restar(30).isEqual(fechaFinalEsperada), "No se está restando correctamente dos días al 2/3/2022");
    }

    @Test
    public void testMostrarFechaDia1Mes1FormatoES() {

        String textoFechaPorDefectoFormatoES = "01-01-1970";
        Fecha fechaPorDefecto = new Fecha();
        fechaPorDefecto.mostrarFormatoES();
        String salida = baos.toString();
        assertTrue(salida.contains(textoFechaPorDefectoFormatoES), "No se está formateando correctamente la fecha por defecto en formato Español. Debería mostrarse como " + textoFechaPorDefectoFormatoES);
    }

    @Test
    public void testMostrarFechaDia1Mes1FormatoGB() {

        String textoFechaPorDefectoFormatoGB = "1970-01-01";
        Fecha fechaPorDefecto = new Fecha();
        fechaPorDefecto.mostrarFormatoGB();
        String salida = baos.toString();
        assertTrue(salida.contains(textoFechaPorDefectoFormatoGB), "No se está formateando correctamente la fecha por defecto en formato Británico. Debería mostrarse como " + textoFechaPorDefectoFormatoGB);
    }

    @Test
    public void testMostrarFechaDia21Mes3FormatoTexto() {

        String textoFechaFormatoGB = "21-marzo-1998";
        Fecha fecha = new Fecha(21,3,1998);
        fecha.mostrarFormatoTexto();
        String salida = baos.toString();
        assertTrue(salida.contains(textoFechaFormatoGB), "No se está formateando correctamente la fecha 21/03/1998 en formato Texto. Debería mostrarse como " + textoFechaFormatoGB);
    }

    @Test
    public void testMostrarFechaDia1Mes3FormatoTexto() {

        String textoFechaFormatoTexto = "01-marzo-1998";
        Fecha fecha = new Fecha(1,3,1998);
        fecha.mostrarFormatoTexto();
        String salida = baos.toString();
        assertTrue(salida.contains(textoFechaFormatoTexto), "No se está formateando correctamente la fecha 01/03/1998 en formato Texto. Debería mostrarse como " + textoFechaFormatoTexto);
    }

    @Test
    public void testMostrarFechaDia20Mes10FormatoES() {

        String textoFechaPorDefectoFormatoES = "01-01-1970";
        Fecha fechaPorDefecto = new Fecha();
        fechaPorDefecto.mostrarFormatoES();
        String salida = baos.toString();
        assertTrue(salida.contains(textoFechaPorDefectoFormatoES), "No se está formateando correctamente la fecha por defecto en formato Español. Debería mostrarse como " + textoFechaPorDefectoFormatoES);
    }

    @Test
    public void testMostrarFechaDia20Mes10FormatoGB() {

        String textoFechaFormatoGB = "1970-10-20";
        Fecha fecha = new Fecha(20,10,1970);
        fecha.mostrarFormatoGB();
        String salida = baos.toString();
        assertTrue(salida.contains(textoFechaFormatoGB), "No se está formateando correctamente la fecha 20/10/1970 en formato Británico. Debería mostrarse como " + textoFechaFormatoGB);
    }

    @Test
    public void testIsCorrecta() {
        Fecha fecha = new Fecha(29, 2, 1987);
        assertFalse(fecha.isCorrecta(), "La fecha no se determina como incorrecta");

        Fecha fecha2 = new Fecha(29, 2, 1992);
        assertTrue(fecha2.isCorrecta(), "La fecha no se determina como correcta");
    }

    @Test
    public void testIsBisiesto() {
        assertFalse(Fecha.isBisiesto(1986), "El año 1986 no es bisiesto");
        assertTrue(Fecha.isBisiesto(1992), "El año 1992 sí es bisiesto");
    }

    @Test
    public void testGetDiasAnyo() {
        assertEquals(365, Fecha.getDiasAnyo(1986), "El año 1986 tiene 365 días");
        assertEquals(366, Fecha.getDiasAnyo(1992), "El año 1992 tiene 366 días");
    }

    @Test
    public void testGetDiasMes() {
        assertEquals(28, Fecha.getDiasMes(2, 1986), "El més de febrero del año 1986 tiene 28 días");
        assertEquals(29, Fecha.getDiasMes(2, 1992), "El més de febrero del año 1992 tiene 29 días");
    }



}
