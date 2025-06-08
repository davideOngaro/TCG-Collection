package com.personal.tcgcollector.common.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TcgApiResponse {

    private int page;
    private int limit;
    private int total;
    private int totalPages;
    private List<CardDto> data;
}