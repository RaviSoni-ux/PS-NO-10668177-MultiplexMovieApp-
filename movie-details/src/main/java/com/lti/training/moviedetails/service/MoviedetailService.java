/**
 * @author: RaviSoni
 * 16-Jul-2020
 */
package com.lti.training.moviedetails.service;

import java.util.List;

import com.lti.training.moviedetails.dto.MoviedetailDto;

public interface MoviedetailService {
	public MoviedetailDto addMovie(MoviedetailDto moviedetailDto);
	public List<MoviedetailDto> getAllMovieDetails();
	//Serach..
	public MoviedetailDto getMovieByName(String name);
	public MoviedetailDto getMovieById(String id);
	
	public MoviedetailDto updateMovieById(MoviedetailDto moviedetailDto,String id);
	public String deleteMovieById(String id);

	

}
