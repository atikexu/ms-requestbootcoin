package com.bootcamp.requestbootcoin.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "requestbootcoin")
@Data
@Generated
@AllArgsConstructor
@NoArgsConstructor
public class RequestBootcoin {

    @Id
    private String id;
    private Integer bootcoinId;
    private String phone;
    private Float amount;
    private String payType;
    private String user;
    private Integer numBootcoin;
}
