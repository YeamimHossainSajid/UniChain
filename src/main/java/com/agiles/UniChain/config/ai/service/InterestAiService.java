package com.agiles.UniChain.config.ai.service;

import com.agiles.UniChain.auth.model.User;
import com.agiles.UniChain.auth.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InterestAiService {
    @Autowired
    UserRepo userRepo;
    @Autowired
    CohereService cohereService;
//    @Autowired
//    OpenRouterService openRouterService;


    public String interest(Long id,String question) {
        User user = userRepo.findById(id).get();
        String interest = Optional.ofNullable(user)
                .map(User::getStudent)
                .map(student -> {
                    String interests = student.getInterests() != null ? student.getInterests() : "";
                    String futurePlans = student.getFuturePlans() != null ? student.getFuturePlans() : "";
                    return interests + futurePlans + futurePlans;
                })
                .orElse("");
        String answer = cohereService.interest(interest+"       above are the information of a student.based on that answer the below questions in 2 lines.if question is not related to this future plan and interest then answer accordingly.      question= "+question);
        return answer;
    }

}