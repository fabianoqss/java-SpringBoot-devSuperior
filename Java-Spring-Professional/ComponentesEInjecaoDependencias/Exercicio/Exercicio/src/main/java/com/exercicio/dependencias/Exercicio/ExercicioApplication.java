package com.exercicio.dependencias.Exercicio;

import com.exercicio.dependencias.Exercicio.entities.Order;
import com.exercicio.dependencias.Exercicio.services.OrderService;
import com.exercicio.dependencias.Exercicio.services.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class ExercicioApplication implements CommandLineRunner {

	@Autowired
	private OrderService orderService;

	public static void main(String[] args) {
		SpringApplication.run(ExercicioApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
		Scanner sc = new Scanner(System.in);

		System.out.println("Digite o código do produto:");
		int code = sc.nextInt();

		System.out.println("Digite o valor do produto:");
		double basic = sc.nextDouble();

		System.out.println("Digite o desconto do produto:");
		double discount = sc.nextDouble();

		Order order = new Order(code, basic, discount);

		System.out.println("Código do pedido: " + order.getCode());
		System.out.printf("Valor total: %.2f%n", orderService.total(order));

	}

}
