package com.app.handcraft.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="POLL")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Poll implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="POLL_ID")
    private Long id;
    @Column(name="QUESTION")
    @NotEmpty
    private String question;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="POLL_ID")
    @OrderBy
    @Size(min=2, max=6)
    private List<Opt> opts;

    public List<Opt> getDefaultOptions() {
        if (this.opts == null) {
            this.opts = new ArrayList<Opt>();
        }
        return this.opts;
    }
}
