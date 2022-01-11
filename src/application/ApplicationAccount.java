package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;

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
		if (quantia > acc.getLimiteSaque()) {
			System.out.println("Erro de saque:  A quantia excede o limite de saque ");
		} 
		else if (quantia > acc.getSaldo()) {
			System.out.println("Erro de saque: Saldo insulficiente");
		}else {
			acc.saque(quantia);
			System.out.println("Novo saldo : " + String.format("%.2f", acc.getSaldo()));
		}
		
		
		scan.close();
	}
}
