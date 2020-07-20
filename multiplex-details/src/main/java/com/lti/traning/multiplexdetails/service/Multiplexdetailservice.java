/**
 * @author: RaviSoni
 * 18-Jul-2020
 */
package com.lti.traning.multiplexdetails.service;

import java.util.List;

import com.lti.traning.multiplexdetails.dto.MultiplexdetailDto;

public interface Multiplexdetailservice {

	public MultiplexdetailDto addMultiplex(MultiplexdetailDto multiplexdetailDto);
	public List<MultiplexdetailDto> getAllMultiplexDetails();
	//Serach..
	public MultiplexdetailDto getMultiplexByName(String name);
	public MultiplexdetailDto getMultiplexById(String id);
	
	public MultiplexdetailDto updateMultiplexById(MultiplexdetailDto multiplexdetailDto);
	public String deleteMultiplexById(String id);

}
