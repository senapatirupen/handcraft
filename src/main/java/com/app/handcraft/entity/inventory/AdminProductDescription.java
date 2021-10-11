package com.app.handcraft.entity.inventory;

import com.app.handcraft.entity.AuditLog;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="ADMIN_PRODUCT_DESCRIPTION")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdminProductDescription extends AuditLog {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ADPRDE_ID", insertable = false, updatable = false, nullable = false)
    private Long adprdeId;

    @Column(name="NAME", unique = false, nullable = true)
    private String name;//Bandhans Kraft Patachitra Palm Leaf Painting, Framed with Cane Stick, Used Natural Colors On Talapatra, Wall Hanging, Home Décor, Wall Painting, Maa Laxmi Talapatra Painting
    @Column(name="MODEL", unique = false, nullable = true)
    private String model;//b-P1079
    @Column(name="FRAME_INCLUDED", unique = false, nullable = true)
    private String frameIncluded;//Yes
    @Column(name="WALL_MOUNT", unique = false, nullable = true)
    private String wallMount;//Yes
    @Column(name="PACK_OF", unique = false, nullable = true)
    private String packOf;//1
    @Column(name="TYPE", unique = false, nullable = true)
    private String type;//Pattachitra
    @Column(name="LOCATION", unique = false, nullable = true)
    private String location;//India, Orissa, Raghurajpur
    @Column(name="MATERIAL", unique = false, nullable = true)
    private String MATERIAL;//Cane Stick
    @Column(name="THEME", unique = false, nullable = true)
    private String theme;//Religious
    @Column(name="COLOR", unique = false, nullable = true)
    private String color;//Natural

    @Column(name="HEIGHT", unique = false, nullable = true)
    private String height;//7 inch
    @Column(name="WIDTH", unique = false, nullable = true)
    private String width;//2 inch
    @Column(name="WEIGHT", unique = false, nullable = true)
    private String weight;//0.155 kg
    @Column(name="DIMENSIONS", unique = false, nullable = true)
    private String dimensions;//6x4(inch)

    @Column(name="SHORT_DESC", unique = false, nullable = true)
    @Lob
    private byte[] shortDesc;
    @Column(name="LONG_DESC", unique = false, nullable = true)
    @Lob
    private byte[] longDesc;//Material: Talapatra, Cane Stick Frame Size : 6x6 (inch) Talapatra Painting Size: 3.5x3.5 (inch) Weight: 155 (g) ?Unique art made up on delicate Talapatra paintings are made by fine line drawings etched with a steel stylus on rectangular strips of palm leaves that are delicately strung together. ... The great epics Ramayana and Mahabharata are favourite subjects of illustration in many art forms, as they are with palm leaf paintings.

    @Column(name="SELLER", unique = false, nullable = true)
    private String seller;//HarmonyArts
    @Column(name="IMG_NAME", unique = false, nullable = true)
    private String imgName;//HarmonyArts
}
