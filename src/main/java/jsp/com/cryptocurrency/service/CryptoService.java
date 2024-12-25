package jsp.com.cryptocurrency.service;

import java.util.HashMap;

import java.util.List;
import java.util.Map;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import jsp.com.cryptocurrency.dto.Crypto;
import jsp.com.cryptocurrency.repository.CryptoRepository;


@Service
public class CryptoService {
	
	@Autowired
	CryptoRepository repository;
	public ResponseEntity<Object> save(Crypto crypto){
		repository.save(crypto);
		Map<String, Object> map=new HashMap<>();
		map.put("message", "added record sucessfully");
		map.put("data",crypto);
		return new ResponseEntity<Object>(map,HttpStatus.OK);
	}
	
	public ResponseEntity<Object> saveAll(List<Crypto> crypto) {
		repository.saveAll(crypto);
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("message", "added record sucessfully");
		map.put("data",crypto);
		return new ResponseEntity<Object>(map,HttpStatus.OK);
	}
	public ResponseEntity<Object> FetchAllcrypto() {
     List<Crypto> list=repository.findAll();
     if(list.isEmpty()) {
    	 Map<String, Object> map=new HashMap<String, Object>();
 		map.put("message", "added record sucessfully");
 		map.put("data","No Crypto found");
 		return new ResponseEntity<Object>(map,HttpStatus.NOT_FOUND);
    	 
     }else
     {
    	 Map<String, Object> map=new HashMap<String, Object>();
  		map.put("message", "added record sucessfully");
  		map.put("data",list);
  		return new ResponseEntity<Object>(map,HttpStatus.OK);
     	 
     }
		
		
	}
	public ResponseEntity<Object> Fetchcryptobyid(int id) {
		
		Optional<Crypto> optional=repository.findById(id);
		if(optional.isEmpty()) {
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("message", "record not found with ID "+id);
			return new ResponseEntity<Object>(map,HttpStatus.NOT_FOUND);
		}else
		{
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("message", "record found with ID"+id);
			map.put("data", optional.get());
			return new ResponseEntity<Object>(map,HttpStatus.OK);
		}
		
	}
	public ResponseEntity<Object> Fetchcryptobyname(String name) {
		 Optional<Crypto> optional = repository.findByName(name);
		 if(optional.isEmpty()) {
	    	 Map<String, Object> map=new HashMap<String, Object>();
	 		
	 		map.put("data","No Crypto found");
	 		return new ResponseEntity<Object>(map,HttpStatus.NOT_FOUND);
	    	 
	     }else
	     {
	    	 Map<String, Object> map=new HashMap<String, Object>();
	  		map.put("message", "Crypto found");
	  		map.put("data",optional);
	  		return new ResponseEntity<Object>(map,HttpStatus.OK);
	     	 
	     }
		
	}
	public ResponseEntity<Object> FetchcryptobyPriceGreater(double price) {
		List<Crypto> list=repository.findByPriceGreaterThan(price);
		 if(list.isEmpty()) {
	    	 Map<String, Object> map=new HashMap<String, Object>();
	 		
	 		map.put("data","No Cryptos found");
	 		return new ResponseEntity<Object>(map,HttpStatus.NOT_FOUND);
	    	 
	     }else
	     {
	    	 Map<String, Object> map=new HashMap<String, Object>();
	  		map.put("message", "Found Cryptos greater than Price "+price);
	  		map.put("data",list);
	  		return new ResponseEntity<Object>(map,HttpStatus.OK);
	     	 
	     }
	}
	public ResponseEntity<Object> fetchCryptorBetween(double min,double max) {
		List<Crypto> list=repository.findByPriceBetween(min,max);
		 if(list.isEmpty()) {
	    	 Map<String, Object> map=new HashMap<String, Object>();
	 		
	 		map.put("data","No Cryptos found");
	 		return new ResponseEntity<Object>(map,HttpStatus.NOT_FOUND); 
	     }else
	     {
	    	 Map<String, Object> map=new HashMap<String, Object>();
	  		map.put("message", "Found Cryptos range between" +min + max);
	  		map.put("data",list);
	  		return new ResponseEntity<Object>(map,HttpStatus.OK);
	     	 
	     }
	}
	public ResponseEntity<Object> deleteById(int id) {
		Optional<Crypto> optional = repository.findById(id);
		 if(optional.isEmpty()) {
	    	 Map<String, Object> map=new HashMap<String, Object>();
	 		
	 		map.put("data","No crypto found");
	 		return new ResponseEntity<Object>(map,HttpStatus.NOT_FOUND);
	    	 
	     }else
	     {
	    	 Map<String, Object> map=new HashMap<String, Object>();
	  		map.put("message", "Crypto deleted success");
	  		repository.deleteById(id);
	  		return new ResponseEntity<Object>(map,HttpStatus.OK);
	     	 
	     }
		
	}
	public ResponseEntity<Object> updateCrypto(Crypto crypto) {
        repository.save(crypto);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("message", "Crypto Updated Success");
		map.put("data", crypto);

		return new ResponseEntity<Object>(map, HttpStatus.OK);
	}
	
	public ResponseEntity<Object> updateCryptobyId(int id, Crypto crypto) {
		Optional<Crypto> optional=repository.findById(id);
		if(optional.isEmpty()) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("error", "No Crypto Found with Id: "+id);

			return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
		}else
		{
            Map<String, Object> map = new HashMap<String, Object>();
			
			Crypto existingCrypto = optional.get();
			if(crypto.getName()!=null)
				existingCrypto.setName(crypto.getName());
			if(crypto.getCoin()!=null)
				existingCrypto.setCoin(crypto.getCoin());
			if(crypto.getBalance()!=0)
				existingCrypto.setBalance(crypto.getBalance());
			if(crypto.getPrice()!=0)
				existingCrypto.setPrice(crypto.getPrice());
                repository.save(existingCrypto);
			
			
			map.put("message", "Crypto Updated Success");

			return new ResponseEntity<Object>(map, HttpStatus.OK);
			
		}
	}
	
	
	
	

}
