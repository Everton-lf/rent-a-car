package verso.caixa.dto;
import verso.caixa.domain.Vehicle;
import verso.caixa.domain.VehicleStatus;

public record VehicleResponse(
        Long id,
        String brand,
        String model,
        String engine,
        Integer anoFabricacao,
        VehicleStatus status,
        String carTitle
) {
    public static VehicleResponse from(Vehicle vehicle) {
        return new VehicleResponse(
                vehicle.id, vehicle.brand, vehicle.model, vehicle.engine, vehicle.anoFabricacao, vehicle.status, vehicle.getCarTitle());
    }
}