package ValiIT.back_praktikale_23.business.address;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "address")
public class Address {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "region_id", nullable = false)
    private Region region;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

    @Size(max = 255)
    @NotNull
    @Column(name = "street", nullable = false)
    private String street;

    @NotNull
    @Column(name = "street_number", nullable = false)
    private Integer streetNumber;

    @NotNull
    @Column(name = "postal_code", nullable = false)
    private Integer postalCode;

    @Column(name = "longitude", precision = 2, scale = 6)
    private BigDecimal longitude;

    @Column(name = "latitude", precision = 2, scale = 6)
    private BigDecimal latitude;

}