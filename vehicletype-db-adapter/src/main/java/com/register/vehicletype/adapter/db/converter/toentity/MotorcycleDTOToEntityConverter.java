package com.register.vehicletype.adapter.db.converter.toentity;

import com.register.vehicletype.adapter.db.entity.MotorcycleEntity;
import com.register.vehicletype.domain.dto.MotorcycleDTO;
import org.springframework.core.convert.converter.Converter;

/**
 * The MotorcycleDTOToEntityConverter class implements the Converter interface
 * to convert a MotorcycleDTO object to a MotorcycleEntity object.
 */
public class MotorcycleDTOToEntityConverter implements Converter<MotorcycleDTO, MotorcycleEntity> {

    /**
     * Converts a MotorcycleDTO object to a MotorcycleEntity object.
     *
     * @param source the MotorcycleDTO object to convert
     * @return the converted MotorcycleEntity object
     */
    @Override
    public MotorcycleEntity convert(MotorcycleDTO source) {
        return new MotorcycleEntity(source.id(), source.make(), source.model(), source.year(), source.hasSidecar());
    }
}
