package com.app.handcraft.dto;


import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@Getter
public class PollTransformer {

    @Autowired
    OptionTransformer optionTransformer;

    public com.app.handcraft.web.model.Poll transfer(com.app.handcraft.entity.Poll fromPoll){
        com.app.handcraft.web.model.Poll toPoll = new com.app.handcraft.web.model.Poll();
        toPoll.setId(fromPoll.getId());
        toPoll.setQuestion(fromPoll.getQuestion());
        toPoll.getDefaultOptions().addAll(fromPoll.getOpts().stream().map(fromOption ->
                optionTransformer.transfer(fromOption)).collect(Collectors.toList()));
        return toPoll;
    }

    public com.app.handcraft.entity.Poll transfer(com.app.handcraft.web.model.Poll fromPoll){
        com.app.handcraft.entity.Poll toPoll = new com.app.handcraft.entity.Poll();
        toPoll.setId(fromPoll.getId());
        toPoll.setQuestion(fromPoll.getQuestion());
        toPoll.getDefaultOptions().addAll(fromPoll.getOptions().stream().map(fromOption ->
                optionTransformer.transfer(fromOption)).collect(Collectors.toSet()));
        return toPoll;
    }

}
