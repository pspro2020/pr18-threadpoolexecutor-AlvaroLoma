package potencias;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Server {
	private ThreadPoolExecutor piscina;

	public Server(ThreadPoolExecutor piscina) {
		this.piscina = piscina;
	}

	void execute(Potencia potencia) {
		try {
			piscina.execute(potencia);
			System.out.printf("Server -> numero de tareas %d\n", piscina.getPoolSize());
			System.out.printf("Server -> Hilos activos: %d\n", piscina.getActiveCount());
		} catch (Exception e) {
			System.out.printf("Server ->Potencia cancelada: %s\n", potencia.getClass().getSimpleName());
		}
	}

	void shutdown() throws InterruptedException {
		piscina.shutdown();
		if (piscina.awaitTermination(20, TimeUnit.DAYS)) {
			System.out.printf("Server -> Trabajo terminado. Han completado la terea: %d veces\n",
					piscina.getCompletedTaskCount());
		} else {
			System.out.printf("Server -> Alcanzado el tiempo maximo de espera. Completado: %d\n",
					piscina.getCompletedTaskCount());
		}
	}

}
