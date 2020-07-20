/**
 * @author: RaviSoni
 * 16-Jul-2020
 */
package com.lti.training.moviedetails.utility;

import org.modelmapper.ModelMapper;

import com.lti.training.moviedetails.document.MovieDetails;
import com.lti.training.moviedetails.dto.MoviedetailDto;

public class ConvertDocument {
	
	
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
