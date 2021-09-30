package com.app.handcraft.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cart extends AuditLog {
    private static final long serialVersionUID=1L;
    private Long caId;
    private String cartStatus;
    private Long peId;
    private Collection<Product> products;
}
