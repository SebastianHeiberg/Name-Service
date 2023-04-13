package com.dat3.webclient.dto;

import com.dat3.webclient.entity.CombinedInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;


@NoArgsConstructor
@Getter
@Setter
public class CombinedResponse {

  private String name;
  private String gender;
  private double genderProbability;
  private int age;
  private int ageCount;
  private String country;
  private double countryProbability;

  public CombinedResponse(CombinedInfo combinedInfo) {
    this.name = combinedInfo.getName();
    this.gender = combinedInfo.getGender();
    this.genderProbability = combinedInfo.getGenderProbability();
    this.age = combinedInfo.getAge();
    this.ageCount = combinedInfo.getAgeCount();
    this.country = combinedInfo.getCountry();
    this.countryProbability = combinedInfo.getCountryProbability();
  }
}
