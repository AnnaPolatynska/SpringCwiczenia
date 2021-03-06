package pl.reaktor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.reaktor.model.Car;

@Repository
public interface CarRepo extends JpaRepository<Car,Long> {

	List<Car> findByBrand(String brand);
	
	List<Car> findByPrice(Double price);
	
	List<Car> findByName(String name);
	
	List<Car> findByBrandAndPrice(String brand, Double price);// nazwy z bd rzutowanie na zapytanie sql
	
	List<Car> findFirstByBrand(String brand);
	
	List<Car> findFirst3ByBrand(String brand);
	
	//select* from cars where brand =b1 or brand =b2   brand musi być różnicowane
	List<Car> findAllByBrandOrBrand(String brand1, String brand2);
	
	//marki samochodów zaczynające się na npA startingwith na co ma się zaczynać wpisuje użytkownik
	List<Car> findAllByNameStartingWith(String name);
	
	//marka o nazwie jak A* (znajdzie wszystkie zaczynające się na A)
	List<Car> findAllByNameLike(String pattern);
	
	//marka o nazwie zawierająca st
	List<Car> findAllByNameContaining(String pattern);
	
	//marka o nazwie kończąca się na A
	List<Car> findAllByNameEndingWith(String pattern);
	
	//marka zawierająca ... i kończąca się na A
	// findAllByNameContainingAnd Name StartingWith- powtarzamy name może w środku być np. brand
	List<Car> findAllByNameContainingAndNameStartingWith(String pattern1, String pattern2);
	
	//brand= opel o cenie <50000
	List<Car> findAllByBrandAndPriceLessThanEqual(String brand, Double price);
	
	//brand i cena od do
	List<Car> findAllByBrandLikeAndPriceBetween(String pattern, Double low, Double high);
	
	//posortowane po marce
	List<Car> findAllByBrandOrderByNameAsc(String brand);
	
	//posortowane po cenie
	List<Car> findAllByPriceNotNullOrderByPriceDesc();
	
	List<Car> findAllByOrderByPriceDesc();
	
}
