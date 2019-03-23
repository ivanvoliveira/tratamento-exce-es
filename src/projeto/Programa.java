package projeto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reserva;

public class Programa {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Numero do quarto: ");
		int numeroQuarto = sc.nextInt();
		System.out.println("Data do check-in (dd/mm/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.println("Data do check-out (dd/mm/yyyy): ");
		Date checkOut = sdf.parse(sc.next());
		
		if (!checkOut.after(checkIn)) {
			System.out.println("Erro na reserva: Data de check-out tem que ser depois da data de check-in");
		}
		else {
			Reserva reserva = new Reserva(numeroQuarto, checkIn, checkOut);
			System.out.println("Reserva:" + reserva);
			System.out.println();
			System.out.println("Entre com os dados para atualizar a reserva: ");
			System.out.println("Data do check-in (dd/mm/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.println("Data do check-out (dd/mm/yyyy): ");
			checkOut = sdf.parse(sc.next());
			
			Date agora = new Date();
			if (checkIn.before(agora) || checkOut.before(agora)) {
				System.out.println("Erro na reserva: A data de reserva tem que ser datas futuras.");
			}
			else if (!checkOut.after(checkIn)) {
				System.out.println("Erro na reserva: Data de check-out tem que ser depois da data de check-in");
			}
			else {
				reserva.atualizaDatas(checkIn, checkOut);
				System.out.println("Reserva: " + reserva);
			}
			
		}
		sc.close();
	}

}
