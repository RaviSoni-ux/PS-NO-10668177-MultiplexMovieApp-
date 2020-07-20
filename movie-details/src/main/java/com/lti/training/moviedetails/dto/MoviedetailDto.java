/**
 * @author: RaviSoni
 * 16-Jul-2020
 */
package com.lti.training.moviedetails.dto;

import java.util.Date;

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
public class MoviedetailDto {
	
	
	private String id;
	private String	name;
	private String category;
	private String producer;
	private String director;
	private Date releaseDate=new Date();


}
