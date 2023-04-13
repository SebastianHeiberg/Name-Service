package com.dat3.webclient.api;

import com.dat3.webclient.dto.CombinedResponse;
import com.dat3.webclient.service.NameService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RequestMapping("name")
@RestController
public class NameController {

  NameService nameService;

  public NameController(NameService nameService) {
    this.nameService = nameService;
  }


  @GetMapping(value = "/{name}")
  public CombinedResponse findInfo(@PathVariable String name){
    return nameService.fetchNameDetails(name);

  }
}
