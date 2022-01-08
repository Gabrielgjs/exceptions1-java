package Application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner scan = new Scanner(System.in);
		SimpleDateFormat  sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Romm number: ");
		int number = scan.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(scan.next());
		System.out.println("Check-out date (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(scan.next());
		
		if (!checkOut.after(checkIn) ) {
			System.out.print("Error in reservation: Reservation dates for update must be future dates");
		}
		else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.print("Reservation: "+ reservation);
			
			System.out.println();
			System.out.print("Enter data to update the reservation: ");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(scan.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(scan.next());
			
			System.out.println();
			
			Date now = new Date();
			if(checkIn.before(now) || checkOut.before(now)) {
				System.out.println("Error in reservation: Reservation dates for update must be future dates");
			}
			else if(!checkOut.after(checkIn)) {
				System.out.print("Error in reservation: Reservation dates for update must be future dates");
			}
			else {
				reservation.updateDates(checkIn, checkOut);
				System.out.print("Reservation: "+ reservation);
			}
			
		}
		
		
		
		
		scan.close();
	}

}
