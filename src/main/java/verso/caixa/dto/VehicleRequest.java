package verso.caixa.dto;

import verso.caixa.domain.VehicleStatus;

public class VehicleRequest {
    private String brand;
    private String model;
    private String engine;
    private int anoFabricacao;
    public VehicleStatus status;

    public String getBrand() {
        return brand;
    }

    public VehicleRequest() {
    }

    public VehicleRequest(String model, String brand, String engine, int anoFabricacao) {
        this.model = model;
        this.brand = brand;
        this.engine = engine;
        this.anoFabricacao = anoFabricacao;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(int anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }
}