package com.devchallenge.application;

import java.util.Locale;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.devchallenge.entities.Order;
import com.devchallenge.services.OrderService;

@SpringBootApplication
@ComponentScan({"com.devchallenge"})
public class Program implements CommandLineRunner{
	
	@Autowired
	private OrderService orderService;
		
	public static void main(String[] args) {
		SpringApplication.run(Program.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter order code: ");
		int number = sc.nextInt();
		System.out.print("Enter basic price: ");
		double basic = sc.nextDouble();
		System.out.print("Enter discount percentage: ");
		double discount = sc.nextDouble();
		
		Order order = new Order(number, basic, discount);
		
		System.out.printf("Pedido Código %d%n", order.getCode());
		System.out.printf("Valor total: R$ %.2f", orderService.total(order));
		
		sc.close();
		
	}

}
