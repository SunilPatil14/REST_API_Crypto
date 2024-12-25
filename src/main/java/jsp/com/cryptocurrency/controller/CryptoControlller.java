package jsp.com.cryptocurrency.controller;


import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import jsp.com.cryptocurrency.dto.Crypto;
import jsp.com.cryptocurrency.service.CryptoService;


@RestController
public class CryptoControlller {
	
	@Autowired
	CryptoService service;
	
	@PostMapping("/cryptos")
	public ResponseEntity<Object> savecrypto(@RequestBody Crypto crypto) {
		return service.save(crypto);
	}
	
	@PostMapping("/cryptos/many")
	public ResponseEntity<Object> crypto(@RequestBody List<Crypto> crypto) {
		return service.saveAll(crypto);
	}
	
	@GetMapping("/cryptos")
		public ResponseEntity<Object> FetchAllcrypto() {
			return service.FetchAllcrypto();
	}
	
	@GetMapping("/cryptos/{id}")
	public ResponseEntity<Object> Fetchcryptobyid(@PathVariable int id) {
		return service.Fetchcryptobyid(id);
	}
	
	@GetMapping("/cryptos/name/{name}")
	public ResponseEntity<Object> Fetchcryptobyname(@PathVariable String name) {
		return service.Fetchcryptobyname(name);
	}
	
	@GetMapping("/cryptos/price/{price}")
	public ResponseEntity<Object> FetchcryptobyPriceGreater(@PathVariable double price) {
		return service.FetchcryptobyPriceGreater(price);
	}
	
	@GetMapping("cryptos/range/{min}/{max}")
	public ResponseEntity<Object> fetchCryptorBetween(@PathVariable double min ,@PathVariable double max ){
		return service.fetchCryptorBetween(min,max);
		
	}
	
	
	@DeleteMapping("/cryptos/{id}")
	public ResponseEntity<Object> deleteById(@PathVariable int id){
	return service.deleteById(id);
	}
	
	
	@PutMapping("/cryptos")
	public ResponseEntity<Object> updateRecord(@RequestBody Crypto crypto){
		return service.updateCrypto(crypto);
	}
		
		
	@PatchMapping("/cryptos/{id}")
	public ResponseEntity<Object> updateRecord(@PathVariable int id,@RequestBody Crypto crypto){
		return service.updateCryptobyId(id,crypto);
	}
	
	 

}
