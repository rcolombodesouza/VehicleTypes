package com.register.vehicletype.adapter.db.converter.toentity;

import com.register.vehicletype.adapter.db.entity.TruckEntity;
import com.register.vehicletype.domain.dto.TruckDTO;
import org.springframework.core.convert.converter.Converter;

/**
 * The TruckDTOToEntityConverter class is responsible for converting TruckDTO objects to TruckEntity objects.
 * It implements the Converter interface with TruckDTO as the source type and TruckEntity as the target type.
 */
public class TruckDTOToEntityConverter implements Converter<TruckDTO, TruckEntity> {

    /**
     * Converts a TruckDTO object to a TruckEntity object.
     *
     * @param source the TruckDTO object to be converted
     * @return the resulting TruckEntity object
     */
    @Override
    public TruckEntity convert(TruckDTO source) {
        return new TruckEntity(source.id(), source.make(), source.model(), source.year(), source.payloadCapacity());
    }
}
