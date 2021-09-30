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
public class WishList extends AuditLog {
    private static final long serialVersionUID=1L;
    private Long wiId;
    private String wishListStatus;
    private Collection<Product> products;
}
