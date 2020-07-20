/**
 * @author: RaviSoni
 * 16-Jul-2020
 */
package com.lti.training.moviedetails.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.training.moviedetails.dto.MovieExceptionDto;
import com.lti.training.moviedetails.dto.MoviedetailDto;
import com.lti.training.moviedetails.service.MoviedetailService;
import com.lti.training.moviedetails.utility.MovieExceptionUtility;

@RestController
@RequestMapping(value = "/")
public class MovieController {

	
	private final Logger LOG = LoggerFactory.getLogger(getClass());


    private MoviedetailService moviedetailService;
	
	@Autowired
	public MovieController(MoviedetailService moviedetailService) {
		// TODO Auto-generated constructor stub
		this.moviedetailService = moviedetailService;
	}
			//Add Movie Details..
	@PostMapping("/addMovie")
	public ResponseEntity<MoviedetailDto> register(@RequestBody MoviedetailDto moviedetailDto) {
		MoviedetailDto moviedetail = this.moviedetailService.addMovie(moviedetailDto);
		ResponseEntity<MoviedetailDto> response = 
				new ResponseEntity<MoviedetailDto>(moviedetail,HttpStatus.OK);
		LOG.info("Add new Movie.");
		return response;
	}
	
	// Get All Movie details
	@GetMapping("/getMovieDetails")
	public ResponseEntity<List<MoviedetailDto>> getAllMovies() {
		List<MoviedetailDto> moviedetail = this.moviedetailService.getAllMovieDetails();
		ResponseEntity<List<MoviedetailDto>> response = 
				new ResponseEntity<List<MoviedetailDto>>(moviedetail,HttpStatus.OK);
		LOG.info("Get All Movie Details.");
		return response;	
		}
	
	 // get /Search Movie by ID ..
	@GetMapping("/getMovieDetails/{id}")
	public ResponseEntity<MoviedetailDto> getMoviebById(@PathVariable("id") String id) {
		MoviedetailDto moviedetail = this.moviedetailService.getMovieById(id);
		LOG.info("Getting user with Movie Name: {}.", moviedetail.getName());
		ResponseEntity<MoviedetailDto> response = 
				new ResponseEntity<MoviedetailDto>(moviedetail,HttpStatus.OK);
		return response;
	}
	
	@PutMapping("/updateMovie/{id}")
	public ResponseEntity<MoviedetailDto> upadteMovieDetails(@RequestBody MoviedetailDto moviedto ,@PathVariable("id") String id){
		MoviedetailDto moviedetail = this.moviedetailService.updateMovieById(moviedto ,id);
		if(moviedetail !=null)
		LOG.info("Update Movie details: {}.", moviedetail);
		ResponseEntity<MoviedetailDto> response = 
				new ResponseEntity<MoviedetailDto>(moviedetail,HttpStatus.OK);
		return response;
		}
	
	//delete movie By Id ..
	@DeleteMapping("delete/{id}")
	public void deleteMovieById(@PathVariable("id") String id){
		if(id !=null){
			this.moviedetailService.deleteMovieById(id);
			LOG.info("Movie details delete !" );
		}else{
			LOG.info("NOT Valid Id.." );
		}
	}
	
	// update /Edit Movie Details By ID..
		/*@PutMapping("/updateMovieDetails/{name})")
		public ResponseEntity<MoviedetailDto> upadteMovieDetails(@PathVariable("name") String name){
			MoviedetailDto moviedetail = this.moviedetailService.updateMovieById(id);
			LOG.info("Getting user with Movie Name: {}.", moviedetail.getName());
			ResponseEntity<MoviedetailDto> response = 
					new ResponseEntity<MoviedetailDto>(moviedetail,HttpStatus.OK);
			return response;
		}*/
	

	@ExceptionHandler(MovieExceptionUtility.class)
	public ResponseEntity<MovieExceptionDto> boundaryExceptionHanler(MovieExceptionUtility ex) {
		MovieExceptionDto movieExceptiondto = 
				new MovieExceptionDto(ex.getMessage(), 
									HttpStatus.BAD_REQUEST.value(), 
									System.currentTimeMillis());
		ResponseEntity<MovieExceptionDto> response = 
				new ResponseEntity<MovieExceptionDto>(movieExceptiondto, HttpStatus.BAD_REQUEST);
		return response;
	}
	
}
