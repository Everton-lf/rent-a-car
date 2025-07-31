package verso.caixa.dto;



import jakarta.validation.constraints.NotNull;
import verso.caixa.domain.VehicleStatus;
public record UpdateStatusRequest(@NotNull VehicleStatus status) {}