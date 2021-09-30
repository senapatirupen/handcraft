package com.app.handcraft.util;


import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

@Slf4j
@Component
public class DateUtil {

    public Date stringToDate(String date) {
        try{
            Date newDate = !StringUtils.isBlank(date) ? new SimpleDateFormat("yyyy-MM-dd").parse(date) : null;
            return newDate;
        } catch (ParseException e){
            log.error(e.getMessage(), e);
        }
        return null;
    }

    public Date dateToDate(Date date) {
        try{
            String strDate = !Objects.isNull(date) ? new SimpleDateFormat("yyyy-MM-dd").format(date) : null;
            Date newDate = new SimpleDateFormat("yyyy-MM-dd").parse(strDate);
            return newDate;
        } catch (ParseException e){
            log.error(e.getMessage(), e);
        }
        return null;
    }
}
