package com.app.handcraft.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VoteTransformer {

    @Autowired
    OptionTransformer optionTransformer;

    public com.app.handcraft.web.model.Vote transfer(com.app.handcraft.entity.Vote fromVote){
        com.app.handcraft.web.model.Vote toVote = new com.app.handcraft.web.model.Vote();
        toVote.setId(fromVote.getId());
        toVote.setOption(optionTransformer.transfer(fromVote.getOpt()));
        return toVote;
    }
    public com.app.handcraft.entity.Vote transfer(com.app.handcraft.web.model.Vote fromVote){
        com.app.handcraft.entity.Vote toVote = new com.app.handcraft.entity.Vote();
        toVote.setId(fromVote.getId());
        toVote.setOpt(optionTransformer.transfer(fromVote.getOption()));
        return toVote;
    }

}
