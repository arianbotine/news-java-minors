package br.com.alura;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.SubmissionPublisher;

import br.com.alura.model.NotaFiscal;
import br.com.alura.wsclient.NotaFiscalWSClient;

public class TesteEnvioNaoBloqueante {

	public static void main(String[] args) {
		List<NotaFiscal> notasFiscais = List.of(new NotaFiscal("Jo�o", 39.99, LocalDate.now()),
				new NotaFiscal("Renata", 41.20, LocalDate.now()), new NotaFiscal("Paulo", 32.10, LocalDate.now()),
				new NotaFiscal("Fernanda", 15.00, LocalDate.now()));
		NotaFiscalWSClient nfwsc = new NotaFiscalWSClient();
		SubmissionPublisher<NotaFiscal> publisher = new SubmissionPublisher<>();
		publisher.consume(nfwsc::enviar);
		notasFiscais.forEach(nf -> {
			publisher.submit(nf);
		});
		publisher.close();
		System.out.println("Voc� ir� receber a nota fiscal no seu e-mail");
		Scanner scan = new Scanner(System.in);
		scan.nextLine();
		scan.close();
		System.out.println("Parab�ns pela compra!!");
		 
	}
}
