package com.register.vehicletype.adapter.db.converter.todto;

import com.register.vehicletype.adapter.db.entity.TruckEntity;
import com.register.vehicletype.domain.dto.TruckDTO;
import org.springframework.core.convert.converter.Converter;


/**
 * TruckEntityToDTOConverter is responsible for converting TruckEntity objects to TruckDTO objects.
 * This class implements the Converter interface and provides the conversion logic in the convert method.
 */
public class TruckEntityToDTOConverter implements Converter<TruckEntity, TruckDTO> {

    /**
     * Converts a TruckEntity object to a TruckDTO object.
     *
     * @param source the TruckEntity object to be converted
     * @return a TruckDTO object containing the converted data from the source TruckEntity
     */
    @Override
    public TruckDTO convert(TruckEntity source) {
        return new TruckDTO(source.getId(), source.getMake(), source.getModel(), source.getYear(), source.getPayloadCapacity());
    }
}
