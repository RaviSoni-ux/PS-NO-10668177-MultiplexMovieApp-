/**
 * @author: RaviSoni
 * 18-Jul-2020
 */
package com.lti.traning.multiplexdetails.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.lti.traning.multiplexdetails.dao.MultiplexDetailsRepository;
import com.lti.traning.multiplexdetails.document.MultiplexDetails;
import com.lti.traning.multiplexdetails.dto.MultiplexdetailDto;

@Service
public class MultiplexdetailServiceImp implements Multiplexdetailservice {
	
	
	@Autowired
	private MultiplexDetailsRepository multiplexDetailsRepository;
	
	@Autowired
	private MongoTemplate mongoTemplate;


	@Override
	public MultiplexdetailDto addMultiplex(MultiplexdetailDto multiplexdetailDto) {
		MultiplexDetails multiplexDetails= this.convertToDocument(multiplexdetailDto);
		multiplexDetails=multiplexDetailsRepository.save(multiplexDetails);
	    
		MultiplexdetailDto addmultiplex=this.convertDto(multiplexDetails);
		return addmultiplex;
	
	}

	
	@Override
	public List<MultiplexdetailDto> getAllMultiplexDetails() {
		List<MultiplexDetails>	getmovie=multiplexDetailsRepository.findAll();
		
		  List<MultiplexdetailDto> multiplexdetailsdto=
				  getmovie.stream().map(this::convertDto).collect(Collectors.toList());

			return multiplexdetailsdto ;
	}

	
	@Override
	public MultiplexdetailDto getMultiplexByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public MultiplexdetailDto getMultiplexById(String id) {
		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(id));
		MultiplexDetails multiplexDetails =mongoTemplate.findOne(query, MultiplexDetails.class);
		MultiplexdetailDto getmovie=this.convertDto(multiplexDetails);
		return getmovie;
	}

	
	public MultiplexdetailDto updateMultiplexById(MultiplexdetailDto multiplexdetailDto) {
		 String id=multiplexdetailDto.getId();
		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(id));
		MultiplexDetails multiplexDetails =mongoTemplate.findOne(query, MultiplexDetails.class);
		if(multiplexDetails !=null){
			multiplexDetails.setNumberofscreens(multiplexdetailDto.getNumberofscreens());
			multiplexDetails.setMultiplexname(multiplexdetailDto.getMultiplexname());
			multiplexDetails.setAddress(multiplexdetailDto.getAddress());
			
			multiplexDetails=multiplexDetailsRepository.save(multiplexDetails);
	       return multiplexdetailDto=this.convertDto(multiplexDetails);
	       
		}else{
			return null;
		}
	}

	/* (non-Javadoc)
	 * @see com.lti.traning.multiplexdetails.service.Multiplexdetailservice#deleteMultiplexById(java.lang.String)
	 */
	@Override
	public String deleteMultiplexById(String id) {
		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(id));
		MultiplexDetails multiplexDetails =mongoTemplate.findOne(query, MultiplexDetails.class);
		if (multiplexDetails != null) {
			multiplexDetailsRepository.delete(multiplexDetails);
			return  id +"movie delete .";
		} else {
			return "movie not found !.";
		}
	}
	
//   convert document to DTO
	private MultiplexdetailDto convertDto(MultiplexDetails multiplexdetails){
		ModelMapper modelMapper =new ModelMapper();
		MultiplexdetailDto multiplexdetailDto=modelMapper.map(multiplexdetails,MultiplexdetailDto.class);
		return multiplexdetailDto;
	}
// convert DTO Object to Document Object.	
	private MultiplexDetails convertToDocument(MultiplexdetailDto multiplexdetailDto){
		ModelMapper modelMapper =new ModelMapper();
		MultiplexDetails multiplexDetails=modelMapper.map(multiplexdetailDto, MultiplexDetails.class);
		return multiplexDetails;
	}
}
