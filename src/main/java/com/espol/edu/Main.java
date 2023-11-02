package com.espol.edu;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("PMD.UseUtilityClass")
public class Main {

	public static void main(String[] args) {
		Meal carneAsada = new Meal("Carne Asada", 10,20);
		Meal polloAsado = new Meal("Pollo Asado", 6,20);
		Meal chuletaAsada = new Meal("Chuleta Asada", 12,10);
		Meal churrasco = new Meal("Currasco", 9,10);
		Meal sopaGallina = new Meal("Sopa de Gallina", 5,25);
		
		List<Meal> menuHoy = new ArrayList<Meal>();
		menuHoy.add(carneAsada);
		menuHoy.add(polloAsado);
		menuHoy.add(chuletaAsada);
		menuHoy.add(churrasco);
		menuHoy.add(sopaGallina);
		
		
		Menu app = new Menu(menuHoy);
		app.runDinningManager();

	}

}
