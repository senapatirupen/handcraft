package com.app.handcraft.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Poll implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    @NotEmpty
    private String question;
    @Size(min=2, max = 6)
    private List<Option> options;

    public List<Option> getDefaultOptions() {
        if (this.options == null) {
            this.options = new ArrayList<Option>();
        }
        return this.options;
    }
}
