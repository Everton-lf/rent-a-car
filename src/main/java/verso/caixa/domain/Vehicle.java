package com.example.vehicles.domain;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import verso.caixa.VehicleStatus;

@Entity
@Table(name = "vehicles")
public class Vehicle extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @NotBlank
    public String brand;

    @NotBlank
    public String model;

    @NotBlank
    public String engine;

    @NotNull
    public Integer year;

    @Enumerated(EnumType.STRING)
    @NotNull
    public VehicleStatus status = VehicleStatus.AVAILABLE;

    @Transient
    public String getCarTitle() {
        return String.format("%s %s %s", brand, model, engine);
    }
}
