package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.ExcecaoDominio;

public class Reserva {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); //estatico para nao instanciar um novo sdf a cada objeto do tipo reserva, tem apenas 1
	
	private Integer numeroQuarto;
	private Date checkIn;
	private Date checkOut;
	
	public Reserva() {
	}

	public Reserva(Integer numeroQuarto, Date checkIn, Date checkOut) {
		if (!checkOut.after(checkIn)) {
			throw new ExcecaoDominio("Data de check-out tem que ser depois da data de check-in");
		}
		this.numeroQuarto = numeroQuarto;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(Integer numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckout() {
		return checkOut;
	}

	public long duracao() {
		long diferenca = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS);
	}
	
	public void atualizaDatas(Date checkIn, Date checkOut) {
		Date agora = new Date();
		if (checkIn.before(agora) || checkOut.before(agora)) {
			throw new ExcecaoDominio("A data de reserva tem que ser datas futuras.");
		}
		if (!checkOut.after(checkIn)) {
			throw new ExcecaoDominio("Data de check-out tem que ser depois da data de check-in");
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	@Override
	public String toString() {
		return "Quarto "
				+ numeroQuarto
				+ ", Check In: "
				+ sdf.format(checkIn)
				+ ", Check Out: "
				+ sdf.format(checkOut)
				+ ", "
				+ duracao()
				+ " nights.";
	}
}
