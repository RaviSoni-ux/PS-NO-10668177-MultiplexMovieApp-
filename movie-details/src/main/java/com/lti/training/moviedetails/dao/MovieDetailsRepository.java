/**
 * @author: RaviSoni
 * 16-Jul-2020
 */
package com.lti.training.moviedetails.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.lti.training.moviedetails.document.MovieDetails;


@EnableMongoRepositories
public interface MovieDetailsRepository extends MongoRepository<MovieDetails, String>{

}
