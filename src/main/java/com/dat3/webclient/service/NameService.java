package com.dat3.webclient.service;

import com.dat3.webclient.dto.AgeResponse;
import com.dat3.webclient.dto.CombinedResponse;
import com.dat3.webclient.dto.GenderResponse;
import com.dat3.webclient.dto.NationalityResponse;
import com.dat3.webclient.entity.CombinedInfo;
import com.dat3.webclient.repository.NameRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class NameService {

NameRepo nameRepo;

  public NameService(NameRepo nameRepo) {
    this.nameRepo = nameRepo;
  }

  public Mono<GenderResponse> findGender(String name){
    Mono<GenderResponse> response = WebClient.create()
        .get()
        .uri("https://api.genderize.io?name="+name)
        .retrieve()
        .bodyToMono(GenderResponse.class)
        .doOnError(e-> System.out.println("UUUPS : "+e.getMessage()));
    return response;
  }

  public Mono<AgeResponse> findAge(String name){
    Mono<AgeResponse> response = WebClient.create()
        .get()
        .uri("https://api.agify.io/?name="+name)
        .retrieve()
        .bodyToMono(AgeResponse.class)
        .doOnError(e-> System.out.println("UUUPS : "+e.getMessage()));
    return response;
  }

  Mono<NationalityResponse> findNationality(String name){
    Mono<NationalityResponse> response = WebClient.create()
        .get()
        .uri("https://api.nationalize.io/?name="+name)
        .retrieve()
        .bodyToMono(NationalityResponse.class)
        .doOnError(e-> System.out.println("UUUPS : "+e.getMessage()));
    return response;
  }

  public CombinedResponse fetchNameDetails(String name) {

    if (nameRepo.findById(name).isPresent()){
      CombinedResponse combinedResponse = new CombinedResponse(nameRepo.findById(name).get());
      return combinedResponse;
    }

    Mono<GenderResponse> gender= findGender(name);
    Mono<AgeResponse> age = findAge(name);
    Mono<NationalityResponse> nationality= findNationality(name);
    CombinedInfo ci = Mono.zip(gender, age,  nationality).map(tuple -> new CombinedInfo(tuple.getT1(),tuple.getT2(),tuple.getT3())).block();
    nameRepo.save(ci);
    CombinedResponse combinedResponse = new CombinedResponse(ci);
    return combinedResponse;
  }

}
