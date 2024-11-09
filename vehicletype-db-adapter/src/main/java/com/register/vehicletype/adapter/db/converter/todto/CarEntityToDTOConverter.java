package com.register.vehicletype.adapter.db.converter.todto;

import com.register.vehicletype.adapter.db.entity.CarEntity;
import com.register.vehicletype.domain.dto.CarDTO;
import org.springframework.core.convert.converter.Converter;

/**
 * The CarEntityToDTOConverter is responsible for converting instances of CarEntity to CarDTO.
 */
public class CarEntityToDTOConverter implements Converter<CarEntity, CarDTO> {

    /**
     * Converts a CarEntity object to a CarDTO object.
     *
     * @param source the CarEntity object to be converted
     * @return the converted CarDTO object
     */
    @Override
    public CarDTO convert(CarEntity source) {
        return new CarDTO(source.getId(), source.getMake(), source.getModel(), source.getYear(), source.getNumberOfDoors());
    }
}
