package potencias;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class FixedThreadPoolMain {

	public static void main(String[] args) {

		Server server = new Server((ThreadPoolExecutor) Executors.newFixedThreadPool(4));
		for (int i = 0; i < 10; i++) {
			Potencia task = new Potencia(i + 1);
			server.execute(task);

		}
		try {
			server.shutdown();

		} catch (InterruptedException exception) {
			return;
		}

	}

}
