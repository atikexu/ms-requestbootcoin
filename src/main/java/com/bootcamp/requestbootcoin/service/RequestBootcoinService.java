package com.bootcamp.requestbootcoin.service;

import com.bootcamp.requestbootcoin.entity.RequestBootcoin;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface RequestBootcoinService {

    Flux<RequestBootcoin> getAll();
    Mono<RequestBootcoin> getMonederoById(String id);
    Mono<RequestBootcoin> createMonedero(RequestBootcoin monederoDto);
    Mono<RequestBootcoin> updateMonedero(RequestBootcoin monederoDto);
    Mono<RequestBootcoin> deleteMonedero(String id);
}
