package com.br.stefanini.pedidos.utils;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public final class Utils {

	public static List<Date> ultimosMeses() {

		Calendar calendar = Calendar.getInstance();

		List<Date> dates = new ArrayList<Date>();

		int RESTA = 5;

		Date date = new Date();

		while (RESTA >= 0) {
			calendar = Calendar.getInstance();
			calendar.add(Calendar.MONTH, -RESTA);
			date = calendar.getTime();
			dates.add(date);
			RESTA--;
		}

		return dates;
	}

	public static Date convertirDateInicio(Date date){
		Calendar calendar =Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_MONTH, 01);
		return calendar.getTime();
		
	}

	public static Date convertirDateFim(Date date) {		

		Calendar calendario = Calendar.getInstance();
		calendario.setTime(date);
		int ultimoDiaMes = calendario.getActualMaximum(Calendar.DAY_OF_MONTH);
		calendario.set(Calendar.DAY_OF_MONTH, ultimoDiaMes);
		return calendario.getTime();
	}
	
	public static String key(Date valor){
		
		String [] order = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L"};
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(valor);
		int annho = calendar.get(Calendar.YEAR);
		int mes = calendar.get(Calendar.MONTH);
		int dia = calendar.get(Calendar.DATE);
		LocalDate date = LocalDate.of(annho, mes+1, dia);
		Month month = date.getMonth();
		String Mes_ = month.getDisplayName(TextStyle.FULL, new Locale("pt", "BR"));
		int annoMes = date.getYear();		
		int yearActual = calendar.get(Calendar.YEAR);
		
		if(annho<yearActual){			
			return "A" + order[mes] + Mes_+"/" + annoMes;
		}
		else{
			return "B" + order[mes] + Mes_+"/" + annoMes;
		}
		
		
		
	}
	
	
	//No voy a usar...
	public static String capitalizeString(String valor){
		if(valor.length()==0){
			return " ";
		}
		else{
			String primeraLetra = valor.substring(0,1);
			String mayuscula = primeraLetra.toUpperCase();
			String demasLetras = valor.substring(1, valor.length());
			String result =  mayuscula + demasLetras;
			return result;
		}
		
	}

}
