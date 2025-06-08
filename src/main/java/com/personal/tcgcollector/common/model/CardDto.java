package com.personal.tcgcollector.common.model;

import lombok.Data;

import java.util.List;

@Data
public class CardDto {

    private String id;
    private String code;
    private String rarity;
    private String type;
    private String name;
    private ImageDto images;
    private Integer cost;
    private AttributeDto attribute;
    private Integer power;
    private String counter;
    private String color;
    private String family;
    private String ability;
    private String trigger;
    private SetDto set;
    private List<String> notes;
}