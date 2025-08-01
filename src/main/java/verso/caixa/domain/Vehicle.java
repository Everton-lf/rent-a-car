package verso.caixa.domain;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

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
    public Integer anoFabricacao;

    @Enumerated(EnumType.STRING)
    @NotNull
    public VehicleStatus status = VehicleStatus.AVAILABLE;

    @Transient
    public String getCarTitle() {
        return String.format("%s %s %s", brand, model, engine);
    }
}
