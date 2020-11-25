package potencias;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.concurrent.TimeUnit;

public class Potencia implements Runnable {

	int numero;

	public Potencia(int numero) {
		this.numero = numero;
	}

	@Override
	public void run() {
		System.out.printf("%s: Empiezo a realizar mi tarea  las %s\n", Thread.currentThread().getName(),
				DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM).format(LocalTime.now()));

		try {
			for (int i = 0; i <= 10; i++) {
				System.out.printf("%s: %d ^ %d = %.1f las %s\n", Thread.currentThread().getName(), numero, i,
						Math.pow(numero, i),
						DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM).format(LocalTime.now()));

				TimeUnit.MILLISECONDS.sleep(200);
			}

		} catch (InterruptedException e) {
			return;
		}

		System.out.printf("%s: He terminado la tarea las %s\n", Thread.currentThread().getName(),
				DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM).format(LocalTime.now()));

	}

}
