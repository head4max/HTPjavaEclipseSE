package task15executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ShopMain {

	public static void main(String[] args) {
		
		int countCashBox = 3;
		
		ExecutorService pool = Executors.newFixedThreadPool(countCashBox);
		
		pool.execute(new Shopper("Хлеб", "Молоко"));
		pool.execute(new Shopper("Ромовая баба", "Печенье"));
		pool.execute(new Shopper("Мука", "Гречка"));
		pool.execute(new Shopper("Мокароны", "Сарделки"));
		pool.execute(new Shopper("Картошка", "Помидоры"));
		pool.execute(new Shopper("Сок Яблочный", "Сыр"));
		pool.execute(new Shopper("Газировка", "Вафли"));
		pool.execute(new Shopper("Клубника", "Мандарины"));
		pool.execute(new Shopper("Кетчуп", "Пельмени"));
	}

}
