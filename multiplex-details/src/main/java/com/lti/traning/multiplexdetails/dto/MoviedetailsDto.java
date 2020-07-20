/**
 * @author: RaviSoni
 * 20-Jul-2020
 */
package com.lti.traning.multiplexdetails.dto;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MoviedetailsDto {
	
	private String	name;
	private String category;
	private String producer;
	private String director;
	private Date releaseDate=new Date();


}
