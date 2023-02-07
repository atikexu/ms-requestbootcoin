package com.bootcamp.requestbootcoin.repository;

import com.bootcamp.requestbootcoin.entity.RequestBootcoin;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestBootcoinRepository extends ReactiveMongoRepository<RequestBootcoin, String>{

}
