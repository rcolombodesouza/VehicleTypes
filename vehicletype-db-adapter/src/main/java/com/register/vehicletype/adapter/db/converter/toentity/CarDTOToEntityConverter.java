package com.register.vehicletype.adapter.db.converter.toentity;

import com.register.vehicletype.adapter.db.entity.CarEntity;
import com.register.vehicletype.domain.dto.CarDTO;
import org.springframework.core.convert.converter.Converter;

/**
 * The CarDTOToEntityConverter class is responsible for converting instances of CarDTO to CarEntity.
 * The converted CarEntity can then be used for persistence operations or other business logic.
 */
public class CarDTOToEntityConverter implements Converter<CarDTO, CarEntity> {

    /**
     * Converts a CarDTO object to a CarEntity object.
     *
     * @param source the CarDTO to be converted
     * @return the converted CarEntity
     */
    @Override
    public CarEntity convert(CarDTO source) {
        return new CarEntity(source.id(), source.make(), source.model(), source.year(), source.numberOfDoors());
    }
}
