package com.agiles.UniChain.config.ai.controller;

import com.agiles.UniChain.config.ai.service.InterestAiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("ai")
public class interestAiController {
    public InterestAiService interestAi;

    public interestAiController(InterestAiService InterestAiService) {
        this.interestAi = InterestAiService;
    }
    @GetMapping("interest/question/{id}/{text}")
    public ResponseEntity<String> interests(@PathVariable Long id,@PathVariable String text) {
        return ResponseEntity.ok(interestAi.interest(id, text));
    }
}