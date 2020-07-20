/**
 * @author: RaviSoni
 * 16-Jul-2020
 */
package com.lti.training.moviedetails.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.lti.training.moviedetails.dao.MovieDetailsRepository;
import com.lti.training.moviedetails.document.MovieDetails;
import com.lti.training.moviedetails.dto.MoviedetailDto;

@Service
public class MoviedetailServiceImpl implements MoviedetailService{
	
	@Autowired
    private MovieDetailsRepository movieDetailsRepository;
	
	@Autowired
	private MongoTemplate mongoTemplate;

	
	
   @Override
	public MoviedetailDto addMovie(MoviedetailDto moviedetailsDto) {
		
	
		MovieDetails moviedetails= this.convertToDocument(moviedetailsDto);
	     moviedetails=movieDetailsRepository.save(moviedetails);
	    
	     MoviedetailDto addmovie=this.convertDto(moviedetails);
		return addmovie;
	}

	@Override
	public List<MoviedetailDto> getAllMovieDetails() {
	
	List<MovieDetails>	getmovie=movieDetailsRepository.findAll();
	
	  List<MoviedetailDto> moviedetailsdto=
			  getmovie.stream().map(this::convertDto).collect(Collectors.toList());

		return moviedetailsdto ;
	}
	
	@Override
	public MoviedetailDto getMovieById(String id) {
		      // TODO Auto-generated method stub
				Query query = new Query();
				query.addCriteria(Criteria.where("id").is(id));
				MovieDetails movieDetails =mongoTemplate.findOne(query, MovieDetails.class);
				MoviedetailDto getmovie=this.convertDto(movieDetails);
				return getmovie;
	}
	
	@Override
	public MoviedetailDto getMovieByName(String name) {
		// TODO Auto-generated method stub
		Query query = new Query();
		query.addCriteria(Criteria.where("name").is(name));
		MovieDetails movieDetails =mongoTemplate.findOne(query, MovieDetails.class);
		MoviedetailDto getmovie=this.convertDto(movieDetails);
		return getmovie;
	}
	
	@Override
	public MoviedetailDto updateMovieById(MoviedetailDto moviedetailDto,String id) {
		// TODO Auto-generated method stub
		
		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(id));
		MovieDetails movieDetails =mongoTemplate.findOne(query, MovieDetails.class);
		if(movieDetails !=null){
			movieDetails.setName(moviedetailDto.getName());
			movieDetails.setDirector(moviedetailDto.getDirector());
			movieDetails.setProducer(moviedetailDto.getProducer());
			movieDetails.setCategory(moviedetailDto.getCategory());
			movieDetails.setReleaseDate(moviedetailDto.getReleaseDate());
			movieDetails=movieDetailsRepository.save(movieDetails);
	       return moviedetailDto=this.convertDto(movieDetails);
	       
		}else{
			return null;
		}
	}


	public String deleteMovieById(String id) {
		// TODO Auto-generated method stub
		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(id));
		MovieDetails movieDetails =mongoTemplate.findOne(query, MovieDetails.class);
		if (movieDetails != null) {
			movieDetailsRepository.delete(movieDetails);
			return  id +"movie delete .";
		} else {
			return "movie not found !.";
		}
	}	
	

	
//convert document to DTO
	private MoviedetailDto convertDto(MovieDetails moviedetails){
		ModelMapper modelMapper =new ModelMapper();
		MoviedetailDto moviedetailsDto=modelMapper.map(moviedetails,MoviedetailDto.class);
		return moviedetailsDto;
	}
// convert DTO Object to Document Object.	
	private MovieDetails convertToDocument(MoviedetailDto moviedetailsDto){
		ModelMapper modelMapper =new ModelMapper();
		MovieDetails moviedetails=modelMapper.map(moviedetailsDto, MovieDetails.class);
		return moviedetails;
	}

	

	
	

	
	
}
