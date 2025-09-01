package verso.caixa.dto;
import verso.caixa.domain.Vehicle;
import verso.caixa.domain.VehicleStatus;

public class VehicleResponse {
    public Long id;
    public String brand;
    public String model;
    public String engine;
    public int anoFabricacao;
    public VehicleStatus status;

    public static VehicleResponse from(Vehicle v) {
        var r = new VehicleResponse();
        r.id = v.id;
        r.brand = v.brand;
        r.model = v.model;
        r.engine = v.engine;
        r.anoFabricacao = v.anoFabricacao;
        r.status = v.status;
        return r;
    }
}
