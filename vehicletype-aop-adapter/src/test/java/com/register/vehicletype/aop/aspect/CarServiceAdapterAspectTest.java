package com.register.vehicletype.aop.aspect;

import com.register.vehicletype.domain.dto.CarDTO;
import org.aspectj.lang.JoinPoint;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;

import java.util.Collections;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CarServiceAdapterAspectTest {

    @Mock
    private Logger logger;

    @Mock
    private JoinPoint joinPoint;

    private CarServiceAdapterAspect aspect;

    @BeforeEach
    void setUp() {
        aspect = new CarServiceAdapterAspect(logger);
    }

    @Test
    void testBeforeFindById() {
        when(joinPoint.getArgs()).thenReturn(new Object[]{1L});

        aspect.beforeFindById(joinPoint);

        verify(logger).info("Searching car with id {}.", 1L);
    }

    @Test
    void testAfterFindById() {
        CarDTO carDTO = new CarDTO(1L, "Toyota", "Corolla", 2020, 4);

        aspect.afterFindById(carDTO);

        verify(logger).info("Car found {}.", carDTO);
    }

    @Test
    void testAfterFindByIdException() {
        Exception exception = new RuntimeException("Test exception");
        when(joinPoint.getArgs()).thenReturn(new Object[]{1L});

        aspect.afterFindByIdException(joinPoint, exception);

        verify(logger).error("Error finding car with id {}.", 1L, exception);
    }

    @Test
    void testBeforeFindAllByOrderByMakeAsc() {
        aspect.beforeFindAllByOrderByMakeAsc();

        verify(logger).info("Initiating query to find all cars ordered by make in ascending order.");
    }

    @Test
    void testAfterFindAllByOrderByMakeAsc() {
        aspect.afterFindAllByOrderByMakeAsc(Collections.emptyList());

        verify(logger).info("Found {} cars ordered by make in ascending order.", 0);
    }

    @Test
    void testAfterFindAllByOrderByMakeAscException() {
        Exception exception = new RuntimeException("Test exception");

        aspect.afterFindAllByOrderByMakeAscException(exception);

        verify(logger).error("Error finding cars ordered by make in ascending order.", exception);
    }
}