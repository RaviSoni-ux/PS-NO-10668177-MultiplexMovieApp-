/**
 * @author: RaviSoni
 * 18-Jul-2020
 */
package com.lti.traning.multiplexdetails.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.lti.traning.multiplexdetails.document.MultiplexDetails;

@EnableMongoRepositories
public interface MultiplexDetailsRepository extends MongoRepository<MultiplexDetails, String> {

}
