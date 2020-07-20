/**
 * @author: RaviSoni
 * 16-Jul-2020
 */
package com.lti.training.moviedetails.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MovieExceptionDto {

	private String message;
	private Integer errorCode;
	private Long timeStamp;
}
