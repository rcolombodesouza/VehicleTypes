package com.register.vehicletype.adapter.db.converter.todto;

import com.register.vehicletype.adapter.db.entity.MotorcycleEntity;
import com.register.vehicletype.domain.dto.MotorcycleDTO;
import org.springframework.core.convert.converter.Converter;

/**
 * The MotorcycleEntityToDTOConverter class is responsible for converting MotorcycleEntity objects
 * to MotorcycleDTO objects. This conversion facilitates the transfer of data from the persistence
 * layer to the presentation layer.
 */
public class MotorcycleEntityToDTOConverter implements Converter<MotorcycleEntity, MotorcycleDTO> {

    /**
     * Converts a MotorcycleEntity object to a MotorcycleDTO object.
     *
     * @param source the MotorcycleEntity object to convert
     * @return a new MotorcycleDTO object containing the data from the source MotorcycleEntity
     */
    @Override
    public MotorcycleDTO convert(MotorcycleEntity source) {
        return new MotorcycleDTO(source.getId(), source.getMake(), source.getModel(), source.getYear(), source.isHasSidecar());
    }
}
