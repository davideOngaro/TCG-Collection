package com.personal.tcgcollector.controller;

import com.personal.tcgcollector.service.OnePieceInputService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class ManualUpdateController {

    private final OnePieceInputService opInputService;

    @GetMapping("/")
    public void updateDatasOP(){

        opInputService.updateOnePieceDatas();
    }
}
