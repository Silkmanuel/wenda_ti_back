package kutuStech.wenda.application.usecases;

import java.util.List;

import kutuStech.wenda.application.dtos.subpoint_dtos.SubpointRegisterParams;
import kutuStech.wenda.domain.subpoint.Subpoint;

public interface SubpointUseCases {
    Subpoint createSubpoint(SubpointRegisterParams subpoint);
    Subpoint getById(String subpointId);
    List<Subpoint> getAll();
}
