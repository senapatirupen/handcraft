package com.app.handcraft.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "FEEDBACK")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Feedback extends AuditLog {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FE_ID", insertable = false, updatable = false, nullable = false)
    private Long feId;
    @Column(name="OR_IDS")
    private String orIds;
    @Column(name="PR_ID", unique = false, nullable = true)
    private Long prId;
    @Column(name="RATING", unique = false, nullable = false)
    private String rating;
    @Column(name="REVIEW", unique = false, nullable = false)
    private String review;
    @Column(name="FEEDBACK", unique = false, nullable = false)
    private String feedback;
}
