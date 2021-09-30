package com.app.handcraft.dto;

import com.app.handcraft.entity.Opt;
import org.springframework.stereotype.Component;

@Component
public class OptionTransformer {

    public com.app.handcraft.web.model.Option transfer(Opt fromOpt){
        com.app.handcraft.web.model.Option toOption = new com.app.handcraft.web.model.Option();
        toOption.setId(fromOpt.getId());
        toOption.setValue(fromOpt.getValue());
        return toOption;
    }
    public Opt transfer(com.app.handcraft.web.model.Option fromOption){
        Opt toOpt = new Opt();
        toOpt.setId(fromOption.getId());
        toOpt.setValue(fromOption.getValue());
        return toOpt;
    }
}
