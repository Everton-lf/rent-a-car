package verso.caixa.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
public class VehicleRequest {
    private String brand;
    private String model;
    private String engine;
    private int year;

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getEngine() {
        return engine;
    }

    public int getYear() {
        return year;
    }

    // setters (opcional, caso precise)
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
