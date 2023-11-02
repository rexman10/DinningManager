package com.espol.edu;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Menu {
	private List<Meal> items;
	private int baseCost = 5;
	private int mealsOrdered;
	private int total = baseCost;
	private final Map<Meal, Integer> ordenados = new HashMap<Meal, Integer>();

	public Menu(List<Meal> items) {
		super();
		this.items = items;
		this.setMealsOrdered(0);
	}

	public List<Meal> getItems() {
		return items;
	}

	public void setItems(List<Meal> items) {
		this.items = items;
	}
	
	public int getBaseCost() {
		return baseCost;
	}

	public void setBaseCost(int baseCost) {
		this.baseCost = baseCost;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getMealsOrdered() {
		return mealsOrdered;
	}

	public void setMealsOrdered(int mealsOrdered) {
		this.mealsOrdered = mealsOrdered;
	}

	public void addMeal(int quantity) {
		this.mealsOrdered += quantity;
	}

	public void displayMenu() {
		System.out.println("////////////////Platillos Disponibles////////////////");
		System.out.println("Meal name \t\tPrice");
		for(int i = 0; i < items.size(); i++) {
			System.out.println(i+1 + ". " + items.get(i).getName() + "\t\t$ " + items.get(i).getPrice());
		}
		
	}

	private void calculateCost() {
		System.out.println("////////////////Factura////////////////");
		System.out.println("Meal name \t\tQuantity\t\tPrice");
		for (Meal key : ordenados.keySet()) {
			this.total += key.getPrice() * ordenados.get(key);
			System.out.println(key.getName() + "\t\t" + ordenados.get(key) + "\t\t" + key.getPrice());
		}

		if(this.mealsOrdered > 5) {
			this.total -= this.total * 0.1;
			System.out.println("Descuento por mas de 5 platillos: 10%");
		}

		if(this.total > 50) {
			this.total -= 10;
			System.out.println("Descuento por mas de $50: -$10");
		}

		else if(this.total > 100) {
			this.total -= 25;
			System.out.println("Descuento por mas de $100: -$25");
		}		

		System.out.println("Total: " + this.getTotal());
	}
	
	public void runDinningManager() {
		Scanner input = new Scanner(System.in);
		displayMenu();
		
		System.out.print("Introduzca el numero del platillo que desea ordenar: ");
		int seleccion = input.nextInt();
		while(seleccion < 0 || seleccion > this.getItems().size()) {
			System.out.println("Platillo no valido porfavor vuelva a intentar");
			System.out.print("Introduzca el numero del platillo que desea ordenar: ");
			seleccion = input.nextInt();			
		}
		Meal platillo = this.getItems().get(seleccion - 1);
		
		System.out.print("Cuantos " + platillo.getName() + " desea ordenar: ");
		int cantidad = input.nextInt();
		boolean isAvailable = (platillo.getMealsRemaining() - cantidad) > 0;
		if(isAvailable) {
			platillo.orderMeal(cantidad);
			addMeal(cantidad);
			if (ordenados.containsKey(platillo.getName()))
				ordenados.put(platillo, ordenados.get(platillo) + cantidad);
			else
				ordenados.put(platillo, cantidad);
		}
		while(cantidad < 0 || cantidad > 100 || !isAvailable){
			System.out.println("Cantidad invalida porfavor vuelva a intentar");
			System.out.print("Cuantos " + platillo.getName() + " desea ordenar: ");
			cantidad = input.nextInt();
			isAvailable = (platillo.getMealsRemaining() - cantidad) > 0;
		}

		String answer = "";
		while (answer == "") {
			System.out.print("Desea ordenar otro platillo? (Si/No): ");
			answer = input.next();
			if("Si".equals(answer)) {
				runDinningManager();
			}
			else if("No".equals(answer)) {
				System.out.println("Gracias por su compra");
				calculateCost();
				break;
			}
			else {
				System.out.println("Respuesta invalida porfavor vuelva a intentar");
			}
			
		}
		
		
		
	}
		
}
