package com.dat3.webclient.entity;

import com.dat3.webclient.dto.AgeResponse;
import com.dat3.webclient.dto.GenderResponse;
import com.dat3.webclient.dto.NationalityResponse;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class CombinedInfo {

  @Id
  private String name;
  private String gender;
  private double genderProbability;
  private int age;
  private int ageCount;
  private String country;
  private double countryProbability;


  public CombinedInfo(GenderResponse gender, AgeResponse age, NationalityResponse nationality) {
    this.name = gender.name;
    this.gender = gender.gender;
    this.genderProbability = gender.probability;
    this.age = age.age;
    this.ageCount = age.count;
    this.country = nationality.getCountry().get(0).country_id;
    this.countryProbability = nationality.getCountry().get(0).probability;
  }
}
