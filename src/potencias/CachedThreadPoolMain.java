package potencias;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class CachedThreadPoolMain {

	public static void main(String[] args) {
		Server server = new Server((ThreadPoolExecutor) Executors.newCachedThreadPool());
		for (int i = 0; i < 10; i++) {
			Potencia potencia = new Potencia(i + 1);
			server.execute(potencia);

		}
		try {
			server.shutdown();
		} catch (InterruptedException e) {
			return;
		}

	}

}
