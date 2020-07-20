/**
 * @author: RaviSoni
 * 18-Jul-2020
 */
package com.lti.traning.multiplexdetails.document;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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
public class MultiplexDetails {
	@Id
	private String id;
	private String	multiplexname;
	private String	address;
	private List<String> numberofscreens;


}
