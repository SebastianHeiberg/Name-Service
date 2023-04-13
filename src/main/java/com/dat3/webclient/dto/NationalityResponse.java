package com.dat3.webclient.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class NationalityResponse{
  public ArrayList<CoutryResponse> country;
  public String name;
}




