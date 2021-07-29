package com.init.Markertper.api.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Hora {

	public static void main(String[] args) {
		String fechaYHora = obtenerFechaYHoraActual();
		System.out.println("La fecha y hora es: " + fechaYHora);
	}

	public static String obtenerFechaYHoraActual() {
		String formato = "yyyy-MM-dd HH:mm:ss";
		DateTimeFormatter formateador = DateTimeFormatter.ofPattern(formato);
		LocalDateTime ahora = LocalDateTime.now();
		return formateador.format(ahora);
	} 
}
