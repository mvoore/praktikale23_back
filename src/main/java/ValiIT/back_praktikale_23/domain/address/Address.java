package ValiIT.back_praktikale_23.domain.address;

import ValiIT.back_praktikale_23.domain.address.city.City;
import ValiIT.back_praktikale_23.domain.address.region.Region;
import ValiIT.back_praktikale_23.domain.internship.company.Company;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    @Size(max = 255)
    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

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

    @Column(name = "longitude", precision = 6, scale = 4)
    private BigDecimal longitude;

    @Column(name = "latitude", precision = 6, scale = 4)
    private BigDecimal latitude;




}