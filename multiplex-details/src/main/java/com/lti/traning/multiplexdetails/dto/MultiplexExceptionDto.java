/**
 * @author: RaviSoni
 * 18-Jul-2020
 */
package com.lti.traning.multiplexdetails.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MultiplexExceptionDto {
	
	private String message;
	private Integer errorCode;
	private Long timeStamp;

}
