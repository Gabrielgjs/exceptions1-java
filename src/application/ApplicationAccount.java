package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.BusinessException;

public class ApplicationAccount {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US );
		Scanner scan = new Scanner(System.in);
		
		//Account acc = new Account();
		
		System.out.print("Informe os dados da conta: ");
		System.out.print("Número: ");
		int numero = scan.nextInt(); 
		System.out.print("Titular: ");
		scan.nextLine();
		String titluar = scan.nextLine();
		System.out.print("Saldo inicial: ");
		double saldo = scan.nextDouble();
		System.out.print("Limite de saque: ");
		double limiteSaque = scan.nextDouble();
		
		Account acc = new Account(numero, titluar, saldo, limiteSaque);
		
		System.out.println();
		System.out.print("Informe a quantia pra sacar: ");
		double quantia = scan.nextDouble();
		 
		try {
			acc.saque(quantia);
			System.out.println("Novo saldo : " + String.format("%.2f", acc.getSaldo()));
		}
		catch (BusinessException e) {
			System.out.println(e.getMessage());
		}
		
		scan.close();
	}
}
