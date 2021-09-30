package com.apress.prospringmvc.bookstore.formatter;

import org.springframework.format.AnnotationFormatterFactory;
import org.springframework.format.Parser;
import org.springframework.format.Printer;

import java.util.Date;
import java.util.Set;

public class DateFormatAnnotationFormatterFactory implements AnnotationFormatterFactory<DateFormat> {

    @Override
    public Set<Class<?>> getFieldTypes() {
        return Set.of(Date.class);
    }

    @Override
    public Printer<?> getPrinter(DateFormat annotation, Class<?> fieldType) {
        return createFormatter(annotation);
    }

    @Override
    public Parser<?> getParser(DateFormat annotation, Class<?> fieldType) {
        return createFormatter(annotation);
    }

    private DateFormatter createFormatter(DateFormat annotation) {
        var formatter = new DateFormatter();
        formatter.setFormat(annotation.format());
        return formatter;
    }

}
