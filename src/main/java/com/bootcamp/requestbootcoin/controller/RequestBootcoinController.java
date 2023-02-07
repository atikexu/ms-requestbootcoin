package com.bootcamp.requestbootcoin.controller;

import com.bootcamp.requestbootcoin.entity.RequestBootcoin;
import com.bootcamp.requestbootcoin.service.RequestBootcoinService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
@RequestMapping("/requestbootcoin")
public class RequestBootcoinController {

    @Autowired
    private RequestBootcoinService requestBootcoinService;

    @GetMapping
    public Flux<RequestBootcoin> getAll(){
      return requestBootcoinService.getAll();
    }

    @GetMapping("/{id}")
    public Mono<RequestBootcoin> getMonederoById(@PathVariable String id){
        return requestBootcoinService.getMonederoById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Mono<RequestBootcoin> createMonedero(@RequestBody RequestBootcoin monederoDto){
        return requestBootcoinService.createMonedero(monederoDto);
    }

    @PutMapping
    public Mono<RequestBootcoin> updateMonedero(@RequestBody RequestBootcoin monederoDto) {
        return requestBootcoinService.updateMonedero(monederoDto);
    }

    @DeleteMapping("/{id}")
    public Mono<RequestBootcoin> deleteMonedero(@PathVariable String id){
        return requestBootcoinService.deleteMonedero(id);
    }
}
