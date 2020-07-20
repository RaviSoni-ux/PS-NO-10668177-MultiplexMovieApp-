/**
 * @author: RaviSoni
 * 19-Jul-2020
 */
package com.lti.traning.multiplexdetails.document;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.lti.traning.multiplexdetails.dto.MoviedetailsDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Document
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MultiplexAllotMovie {
	
	@Id
	private String id;
	private String screenNo;
	private LocalDateTime alltOndate;
	private MultiplexDetails multiplexdetails;
	private List<MoviedetailsDto> moviedetails;

}
