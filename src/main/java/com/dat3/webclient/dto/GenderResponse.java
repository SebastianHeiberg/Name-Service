package com.dat3.webclient.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class GenderResponse {

    public int count;
    public String gender;
    public String name;
    public double probability;
}
