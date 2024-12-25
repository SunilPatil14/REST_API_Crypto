package jsp.com.cryptocurrency.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import jsp.com.cryptocurrency.dto.Crypto;

public interface CryptoRepository extends JpaRepository<Crypto, Integer>{

	Optional<Crypto> findByName(String name);

	List<Crypto> findByPriceGreaterThan(double price);

	List<Crypto> findByPriceBetween(double min, double max);

}
