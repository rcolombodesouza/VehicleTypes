package com.register.vehicletype.aop.aspect;

import com.register.vehicletype.domain.dto.CarDTO;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * The CarServiceAdapterAspect class is an aspect class that provides logging functionality for the CarServiceAdapter class.
 * It is responsible for logging informative messages before and after the execution of specific methods in the CarServiceAdapter class,
 * as well as logging error messages when exceptions are thrown during method execution.
 */
@Aspect
public class CarServiceAdapterAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(CarServiceAdapterAspect.class);

    /**
     * This method is a before advice that is executed before the execution of the findById() method in the CarServiceAdapter class.
     * It logs an informative message with the details of the car ID being searched.
     *
     * @param joinPoint The JoinPoint object representing the method call.
     */
    @Before("execution(*..CarDTO *..service..findById(*))")
    public void beforeFindById(JoinPoint joinPoint) {
        LOGGER.info("Searching car with id {}.", joinPoint.getArgs()[0]);
    }

    /**
     * This method is called after the successful execution of the findById() method in the CarServiceAdapter class.
     * It logs an informative message with the details of the car found.
     *
     * @param carDTO The CarDTO object that was returned by the findById() method.
     */
    @AfterReturning(pointcut = "execution(*..CarDTO *..service..findById(*))", returning = "carDTO")
    public void afterFindById(CarDTO carDTO) {
        LOGGER.info("Car found {}.", carDTO);
    }

    /**
     * This method is called after an exception is thrown during the execution of the findById() method
     * in the CarServiceAdapter class. It logs an error message with the details of the exception.
     *
     * @param joinPoint  the JoinPoint object representing the method call
     * @param exception  the Exception object that was thrown during the execution of the findById() method
     */
    @AfterThrowing(pointcut = "execution(*..CarDTO *..service..findById(*))", throwing = "exception")
    public void afterFindByIdException(JoinPoint joinPoint, Exception exception) {
        LOGGER.error("Error finding car with id {}.", joinPoint.getArgs()[0], exception);
    }

    /**
     * This method is a before advice that is executed before the execution of the {@code findAllByOrderByMakeAsc()}
     * method in the {@code CarServiceAdapter} class. It logs an informative message indicating that the query to find all
     * cars ordered by make in ascending order is being initiated.
     */
    @Before("execution(* com.register.vehicletype.domain.service.CarServiceAdapter.findAllByOrderByMakeAsc(..))")
    public void beforeFindAllByOrderByMakeAsc() {
        LOGGER.info("Initiating query to find all cars ordered by make in ascending order.");
    }

    /**
     * This method is called after the successful execution of the findAllByOrderByMakeAsc() method in the CarServiceAdapter class.
     * It logs an informative message with the number of cars found.
     *
     * @param carDTOList The list of CarDTO objects that were returned by the findAllByOrderByMakeAsc() method.
     */
    @AfterReturning(pointcut =
            "execution(* com.register.vehicletype.domain.service.CarServiceAdapter.findAllByOrderByMakeAsc(..))",
            returning = "carDTOList")
    public void afterFindAllByOrderByMakeAsc(List<CarDTO> carDTOList) {
        LOGGER.info("Found {} cars ordered by make in ascending order.", carDTOList.size());
    }

    /**
     * This method is called after an exception is thrown during the execution of the findAllByOrderByMakeAsc() method
     * in the CarServiceAdapter class. It logs an error message with the details of the exception.
     *
     * @param exception The Exception object that was thrown during the execution of the findAllByOrderByMakeAsc() method.
     */
    @AfterThrowing(pointcut =
            "execution(* com.register.vehicletype.domain.service.CarServiceAdapter.findAllByOrderByMakeAsc(..))",
            throwing = "exception")
    public void afterFindAllByOrderByMakeAscException(Exception exception) {
        LOGGER.error("Error finding cars ordered by make in ascending order.", exception);
    }

    /**
     * This method is called before the execution of the delete() method in the CarServiceAdapter class.
     * It logs an informative message with the details of the car being deleted.
     *
     * @param joinPoint the JoinPoint object representing the method call
     */
    @Before("execution(* com.register.vehicletype.domain.service.CarServiceAdapter.delete(..))")
    public void beforeDelete(JoinPoint joinPoint) {
        LOGGER.info("Deleting car with id {}.", joinPoint.getArgs()[0]);
    }

    /**
     * This method is called after the successful execution of the delete() method in the CarServiceAdapter class.
     * It logs an informative message with the details of the car being deleted.
     *
     * @param joinPoint the JoinPoint object representing the method call
     */
    @AfterReturning(pointcut = "execution(* com.register.vehicletype.domain.service.CarServiceAdapter.delete(..))")
    public void afterDelete(JoinPoint joinPoint) {
        LOGGER.info("Car deleted with id {}.", joinPoint.getArgs()[0]);
    }

    /**
     * This method is called after an exception is thrown during the execution of the delete() method in the CarServiceAdapter class.
     * It logs an error message with the details of the car being deleted and the exception.
     *
     * @param joinPoint  the JoinPoint object representing the method call
     * @param exception  the Exception object that was thrown during the execution of the delete() method
     */
    @AfterThrowing(pointcut = "execution(* com.register.vehicletype.domain.service.CarServiceAdapter.delete(..))",
            throwing = "exception")
    public void afterDeleteException(JoinPoint joinPoint, Exception exception) {
        LOGGER.error("Error deleting car with id {}.", joinPoint.getArgs()[0], exception);
    }

    /**
     * This method is called before the execution of the save() method in the CarServiceAdapter class.
     * It logs an informative message with the details of the car being saved.
     *
     * @param joinPoint  the JoinPoint object representing the method call
     */
    @Before("execution(* com.register.vehicletype.domain.service.CarServiceAdapter.save(..))")
    public void beforeSave(JoinPoint joinPoint) {
        LOGGER.info("Saving car {}.", joinPoint.getArgs()[0]);
    }

    /**
     * This method is called after the successful execution of the save() method in the CarDTO service.
     * It logs an informative message with the details of the saved car.
     *
     * @param carDTO    the CarDTO object that was saved
     */
    @AfterReturning(pointcut = "execution(*..CarDTO *..service..save(*))", returning = "carDTO")
    public void afterSave(CarDTO carDTO) {
        LOGGER.info("Car saved {}.", carDTO);
    }

    /**
     * This method is called after an exception is thrown during the execution of the save() method in the CarDTO service.
     * It logs an error message with the details of the car and the exception.
     *
     * @param joinPoint  the JoinPoint object representing the method call
     * @param exception  the Exception object that was thrown during the execution of the save() method
     */
    @AfterThrowing(pointcut = "execution(*..CarDTO *..service..save(*))", throwing = "exception")
    public void afterSaveException(JoinPoint joinPoint, Exception exception) {
        LOGGER.error("Error saving car {}.", joinPoint.getArgs()[0], exception);
    }
}
