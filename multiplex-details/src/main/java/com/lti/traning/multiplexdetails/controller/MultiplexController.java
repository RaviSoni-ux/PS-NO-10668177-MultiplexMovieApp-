/**
 * @author: RaviSoni
 * 18-Jul-2020
 */
package com.lti.traning.multiplexdetails.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.traning.multiplexdetails.dto.MultiplexdetailDto;
import com.lti.traning.multiplexdetails.service.Multiplexdetailservice;

@RestController
@RequestMapping(value = "/")
public class MultiplexController {

	
	private final Logger LOG = LoggerFactory.getLogger(getClass());
	private Multiplexdetailservice multiplexdetailservice;
	
	@Autowired
	public MultiplexController(Multiplexdetailservice multiplexdetailservice) {
		this.multiplexdetailservice = multiplexdetailservice;
	}
	
	
	@PostMapping("/addMultiplex")
	public ResponseEntity<MultiplexdetailDto> register(@RequestBody MultiplexdetailDto multiplexdetailDto) {
		MultiplexdetailDto multiplexdetail = this.multiplexdetailservice.addMultiplex(multiplexdetailDto);
		ResponseEntity<MultiplexdetailDto> response = 
				new ResponseEntity<MultiplexdetailDto>(multiplexdetail,HttpStatus.OK);
		LOG.info("Add new Movie.");
		return response;
	}
	
	
	@GetMapping("/getMultiplexDetails")
	public ResponseEntity<List<MultiplexdetailDto>> getAllMovies() {
		List<MultiplexdetailDto> multiplexdetailDto = this.multiplexdetailservice.getAllMultiplexDetails();
		ResponseEntity<List<MultiplexdetailDto>> response = 
				new ResponseEntity<List<MultiplexdetailDto>>(multiplexdetailDto,HttpStatus.OK);
		LOG.info("Get All Movie Details.");
		return response;	
		}
	
	@GetMapping("/getMultiplexDetails/{id}")
	public ResponseEntity<MultiplexdetailDto> getMoviebById(@PathVariable("id") String id) {
		MultiplexdetailDto multiplexdetail = this.multiplexdetailservice.getMultiplexById(id);
		LOG.info("Getting user with Movie Name: {}.", multiplexdetail.getMultiplexname());
		ResponseEntity<MultiplexdetailDto> response = 
				new ResponseEntity<MultiplexdetailDto>(multiplexdetail,HttpStatus.OK);
		return response;
	}
	
	@PutMapping("/updateMultipex")
	public ResponseEntity<MultiplexdetailDto> updateMultiplexById(@RequestBody MultiplexdetailDto multiplexdetailDto){
		
		MultiplexdetailDto moviedetail = this.multiplexdetailservice.updateMultiplexById(multiplexdetailDto);
		LOG.info("Up date Movie details: {}." + moviedetail.getId());
		
		ResponseEntity<MultiplexdetailDto> response = 
				new ResponseEntity<MultiplexdetailDto>(moviedetail,HttpStatus.OK);
		return response;
		
	}
	@DeleteMapping("delete/{id}")
	public void deleteMovieById(@PathVariable("id") String id){
		if(id !=null){
			this.multiplexdetailservice.deleteMultiplexById(id);
			LOG.info("Movie details delete !" );
		}else{
			LOG.info("NOT Valid Id.." );
		}
	}
	
}
