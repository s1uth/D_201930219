package com.example.d_201930219.dto.Product;

public class ChangeProductDto {

    private Long number;
    private String name;

    public ChangeProductDto(Long number, String name){
        this.number = number;
        this.name = name;
    }

    public ChangeProductDto(){}

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
