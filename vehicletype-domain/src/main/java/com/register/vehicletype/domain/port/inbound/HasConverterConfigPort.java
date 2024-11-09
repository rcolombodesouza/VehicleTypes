package com.register.vehicletype.domain.port.inbound;

import org.springframework.core.convert.converter.ConverterRegistry;

/**
 * Interface for classes that can register their converters with a given
 * {@link ConverterRegistry}.
 */
public interface HasConverterConfigPort {

    /**
     * Registers custom converters with the specified {@link ConverterRegistry}.
     *
     * @param converterRegistry the registry where converters will be registered
     */
    void registerConverters(ConverterRegistry converterRegistry);
}
