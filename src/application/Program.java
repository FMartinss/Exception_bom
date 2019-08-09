package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		
		try {
			
			Scanner sc = new Scanner(System.in);
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Reservation reservation;
			System.out.print("Room number: ");
			int roomNumber = sc.nextInt();
			System.out.print("Check-in date (dd/MM/yyyy): ");
			Date checkin = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			Date checkout = sdf.parse(sc.next());

			reservation = new Reservation(roomNumber, checkin, checkout);
			System.out.println("Reservation: " + reservation);
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date: ");
			checkin = sdf.parse(sc.next());
			System.out.print("Check-out date: ");
			checkout = sdf.parse(sc.next());
			
			reservation.updateDates(checkin, checkout);
			System.out.println("Updated reservation!!");
			System.out.println("Reservation: " + reservation);

			sc.close();
		}catch (ParseException pe) {
			System.out.println("Invalid date format.");
		}catch (DomainException dm) {
			System.out.println("Error in Reservation: " + dm.getMessage());
		}catch (RuntimeException rte) {
			System.out.println("Erro inesperado.");
		}
		

	}

}
