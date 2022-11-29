package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Polkaman;
import com.revature.service.PolkamanService;

/*A rest controller is a specialized controller class - All the methods in this class write the response body
 * 
 * Spring Boot has a built-in servelt called the DispatchServlet
 * 
 * The spring framework uses an interace called the HandlerMapping interface which is reposible for 
 * helping the dispatchservlet figure out which controller should be use to handle an incoming
 * HTTP request.
 * 
 *  
 *  The RequestMapping annotation specifes a portion of the URL that this entire controller will be mapped to.
 *  That is to say, if someone wants to access the resources exposed by this controller, they should use the
 *  following URL: /polkaman
 * */

@RestController
@RequestMapping(path = "/polkaman")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials="true")
public class PolkamanController {
	@Autowired
	private PolkamanService polkamanService;
	
	
	@RequestMapping(value="/all", method = RequestMethod.GET)
	@CrossOrigin
	public List<Polkaman> findAll(){
		return this.polkamanService.sortPolkamanByName();
	}
	
	
	/*This method allows us to find the polkaaman by id
	 * 
	 * Using the PathVariable, we can tell spring to parse the request URL for us, thus isolating the id
	 * parameter and passing it to our method for us
	 * 
	 * the ResponseEntity allow us a bit more control over the HTTP resposne status code
	 * */
	
	@GetMapping(path="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin
	public ResponseEntity<Polkaman> findById(@PathVariable int id){
		return new ResponseEntity<Polkaman>(this.polkamanService.findById(id), HttpStatus.OK);
	}
	
	
	@GetMapping(path = "/id", produces = MediaType.APPLICATION_JSON_VALUE)
	public Polkaman findByIdRequestParam(@RequestParam int id) {
		return this.polkamanService.findById(id);
	}
	
	@PostMapping(path = "/new", consumes = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin
	public void save(@RequestBody Polkaman polkaman) {
		this.polkamanService.save(polkaman);
	}
	
}
