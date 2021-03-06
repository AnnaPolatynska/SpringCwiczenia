package pl.reaktor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import pl.reaktor.model.Car;
import pl.reaktor.repository.CarRepo;

@SpringBootApplication
public class DMvc4DataApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx 
		= SpringApplication.run(DMvc4DataApplication.class, args);
	
		List<Car> cars = new ArrayList<>();
		cars.add(new Car("A6","Audi",200000.0));
		cars.add(new Car("Auris", "Toyota", 120000.0));
		cars.add(new Car("Panda", "Fiat", 30000.0));
		cars.add(new Car("tipo", "Fiat", 120000.0));
		cars.add(new Car("Uno", "Fiat", 30000.0));
		cars.add(new Car("Adam", "Opel", 12000.0));
		cars.add(new Car("Zafira", "Opel", 20000.0));
		cars.add(new Car("Insigna", "Opel", 12300.0));
		cars.add(new Car("Zafira", "Opel", 30000.0));
		cars.add(new Car("Astra", "Opel", 50000.0));
		cars.add(new Car("A3", "Audi", 20000.0));
		cars.add(new Car("AXA","Audi",300000.0));
		cars.add(new Car("A6","Audi",200000.0));
		
		CarRepo cr = ctx.getBean(CarRepo.class);
		//zapis do bazy danych
		cars.forEach(cr::save);
		
		// findOne odnajduje a cr.delete(selectedCar); delete car o id=1
		Car selectedCar = cr.findOne(1L);
		cr.delete(selectedCar);
		
		cr.findAll().forEach(System.out::println);
		cr.count();// zlicza ile jest rekordów w tabeli
		
		//metoda udostępniona przez car repo
		// ! użyj :: // ::save //System.out::println
		// cr.findByBrand("Fiat").forEach(System.out::println); // podaje adres
		
		// musimy dodać metodę to strinfga w car toString
		List<Car> list1 = cr.findByBrand("Fiat");
		System.out.println(list1);
		
		// w interface car repo findByName + findByPrice + findByBrand
	
		List<Car> list2 = cr.findByBrand("Fiat");
		System.out.println(list2);
		List<Car> list3 = cr.findByName("Tipo");
		System.out.println(list3);
		List<Car> list4 = cr.findByBrandAndPrice("Toyota", 120000.0);
		System.out.println(list4);
		// sprawdza czy jest jakś wynik
		System.out.println(list4.isEmpty());
		System.out.println(list4);
		
		List<Car> list5 = cr.findFirstByBrand("Fiat");
		System.out.println(list5);
		List<Car> list6 = cr.findFirst3ByBrand("Opel");
		System.out.println(list6);
		
		List<Car> list7 = cr.findAllByBrandOrBrand("Opel", "Fiat");
		System.out.println(list7);
		
		List<Car> list8 = cr.findAllByNameStartingWith("A");
		System.out.println(list8);
		
		List<Car> list9 = cr.findAllByNameLike("I%");
		System.out.println(list9);
		
			//marka o nazwie zawierająca st
		List<Car> list10=cr.findAllByNameContaining("st");
		System.out.println(list10);
		//marka o nazwie kończąca się na A
		
		List<Car> list11=cr.findAllByNameEndingWith("a");
		//na liście11 wywołuję for each by print wszystkie pod sobą
		list11.forEach(System.out::println);
		
		//"A%" - rozpoczynające się od A i kończące się na 
		List<Car> list12=cr.findAllByNameLike("A%A");
		System.out.println(list12);
		
		//marka zawierająca ... i kończąca się na A
		// findAllByNameContainingAnd Name StartingWith- powtarzamy name może w środku być np. brand
		List<Car> list13=cr.findAllByNameContainingAndNameStartingWith("st", "A");
		System.out.println(list13);
		
		//brand= opel o cenie <50000
		List<Car> list14=cr.findAllByBrandAndPriceLessThanEqual("Opel", 50000.0);
		System.out.println(list14);
		
		//brand zawierające F-ia-t i cena od do
		List<Car> list15=cr.findAllByBrandLikeAndPriceBetween("%ia%", 20000.0, 100000.);
		System.out.println(list15);
		
		List<Car> list16=cr.findAllByBrandOrderByNameAsc("Opel");
		list16.forEach(System.out::println);
		
		List<Car> list17=cr.findAllByPriceNotNullOrderByPriceDesc();
		list17.forEach(System.out::println);
		
		//2 sposób by cena dziwna składnia
		List<Car> list18=cr.findAllByOrderByPriceDesc();
		list18.forEach(System.out::println);
		
		
		ctx.close();
	}
}
