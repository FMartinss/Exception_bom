package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation {

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private Integer roomNumber;
	Date checkin;
	Date checkout;

	// Construtores / Sobrecarga

	public Reservation() {

	}

	public Reservation(Integer roomNumber, Date checkin, Date checkout) throws DomainException { //Propagando o erro para ser tratado no main
		if(!checkout.after(checkin)){
			throw new DomainException("Date error");
		}
		this.roomNumber = roomNumber;
		this.checkin = checkin;
		this.checkout = checkout;
	}

	// Getters Setters

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckin() {
		return checkin;
	}

	public Date getCheckout() {
		return checkout;
	}

	// METODOS

	public long duration() {
		long diff = checkout.getTime() - checkin.getTime();
		// return (((diff/1000)/60)/60)/24;
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS); // CONVERTE PARA DIAS A VARIAVEL DIFF QUE ESTÁ EM
																	// MILISEGUNDOS

	}

	public void updateDates(Date checkin, Date checkout) throws DomainException {
		Date now = new Date();
		if (((checkin.before(now)) || (checkout.before(now))) || (!checkout.after(checkin))) {
			throw new DomainException("Date error"); //SOMENTE VOU LANCAR A MENSAGEM DE EXCEPTION, MAS QUE IRÁ TRATAR SERÁ O 
			//PROGRAMA PRINCIPAL
		}
		
		this.checkin = checkin;
		this.checkout = checkout;
		
	}

	@Override
	public String toString() {
		return "Reservation: Room " + roomNumber + " ," + "Check-in: " + sdf.format(checkin) + " ," + "Check-out: "
				+ sdf.format(checkout) + ", " + duration() + " nights";
	}

}
