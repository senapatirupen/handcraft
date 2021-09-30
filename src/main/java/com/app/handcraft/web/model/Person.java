package com.app.handcraft.web.model;

import com.app.handcraft.entity.UserDetail;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Person extends AuditLog {
    private static final long serialVersionUID=1L;
    private Long peId;
    private UserDetail userDetail;
    private Cart cart;
    private Collection<Product> products;
    private Collection<Address> addresses;
}
