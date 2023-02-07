package com.bootcamp.requestbootcoin.service;

import com.bootcamp.bootcoin.utils.Constants;
import com.bootcamp.requestbootcoin.entity.RequestBootcoin;
import com.bootcamp.requestbootcoin.repository.RequestBootcoinRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class RequestBootcoinServiceImpl implements  RequestBootcoinService{

    @Autowired
    private RequestBootcoinRepository requestBootcoinRepository;

    @Override
    public Flux<RequestBootcoin> getAll() {
        return requestBootcoinRepository.findAll();
    }

    @Override
    public Mono<RequestBootcoin> getMonederoById(String id) {
        return requestBootcoinRepository.findById(id);
    }

    @Override
    public Mono<RequestBootcoin> createMonedero(RequestBootcoin request) {
    	request.setAmount(request.getNumBootcoin()*Constants.PURCHASE_PRICE);
        return requestBootcoinRepository.save(request);
    }

    @Override
    public Mono<RequestBootcoin> updateMonedero(RequestBootcoin request) {
        return requestBootcoinRepository.findById(request.getId())
                .flatMap(newMonedero -> {
                	newMonedero.setId(request.getId());
                    newMonedero.setBootcoinId(request.getBootcoinId());
                    newMonedero.setAmount(request.getNumBootcoin()*Constants.PURCHASE_PRICE);
                    newMonedero.setPayType(request.getPayType());
                    newMonedero.setPhone(request.getPhone());
                    newMonedero.setUser(request.getUser());
                    newMonedero.setNumBootcoin(request.getNumBootcoin());
                    return requestBootcoinRepository.save(newMonedero);
                });
    }

    @Override
    public Mono<RequestBootcoin> deleteMonedero(String id) {
        return requestBootcoinRepository.findById(id)
                .flatMap(request -> requestBootcoinRepository.delete(request)
                        .then(Mono.just(request)));
    }
    
}
