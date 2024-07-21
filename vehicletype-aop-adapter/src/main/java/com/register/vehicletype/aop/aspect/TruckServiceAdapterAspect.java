package com.register.vehicletype.aop.aspect;

import com.register.vehicletype.domain.dto.TruckDTO;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * The TruckServiceAdapterAspect class is an aspect that provides logging functionality for the TruckServiceAdapter class.
 * It logs informative messages before and after method executions, as well as error messages in case of exceptions.
 */
@Aspect
public class TruckServiceAdapterAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(TruckServiceAdapterAspect.class);

    /**
     * This method is a before advice that is executed before the execution of the findById() method in the truckServiceAdapter class.
     * It logs an informative message with the details of the truck ID being searched.
     *
     * @param joinPoint The JoinPoint object representing the method call.
     */
    @Before("execution(* com.register.vehicletype.domain.service.TruckServiceAdapter.findById(..))")
    public void beforeFindById(JoinPoint joinPoint) {
        LOGGER.info("Searching truck with id {}.", joinPoint.getArgs()[0]);
    }

    /**
     * This method is called after the successful execution of the findById() method in the truckServiceAdapter class.
     * It logs an informative message with the details of the truck found.
     *
     * @param truckDTO The TruckDTO object that was returned by the findById() method.
     */
    @AfterReturning(pointcut = "execution(*..TruckDTO *..service..findById(*))", returning = "truckDTO")
    public void afterFindById(TruckDTO truckDTO) {
        LOGGER.info("Truck found {}.", truckDTO);
    }

    /**
     * This method is called after an exception is thrown during the execution of the findById() method
     * in the TruckServiceAdapter class. It logs an error message with the details of the exception.
     *
     * @param joinPoint  the JoinPoint object representing the method call
     * @param exception  the Exception object that was thrown during the execution of the findById() method
     */
    @AfterThrowing(pointcut = "execution(*..TruckDTO *..service..findById(*))", throwing = "exception")
    public void afterFindByIdException(JoinPoint joinPoint, Exception exception) {
        LOGGER.error("Error finding truck with id {}.", joinPoint.getArgs()[0], exception);
    }

    /**
     * This method is a before advice that is executed before the execution of the {@code findAllByOrderByMakeAsc()}
     * method in the {@code TruckServiceAdapter} class. It logs an informative message indicating that the query to find all
     * trucks ordered by make in ascending order is being initiated.
     */
    @Before("execution(* com.register.vehicletype.domain.service.TruckServiceAdapter.findAllByOrderByMakeAsc(..))")
    public void beforeFindAllByOrderByMakeAsc() {
        LOGGER.info("Initiating query to find all trucks ordered by make in ascending order.");
    }

    /**
     * This method is called after the successful execution of the findAllByOrderByMakeAsc() method in the TruckServiceAdapter class.
     * It logs an informative message with the number of trucks found.
     *
     * @param truckDTOList The list of TruckDTO objects that were returned by the findAllByOrderByMakeAsc() method.
     */
    @AfterReturning(pointcut =
            "execution(* com.register.vehicletype.domain.service.TruckServiceAdapter.findAllByOrderByMakeAsc(..))",
            returning = "truckDTOList")
    public void afterFindAllByOrderByMakeAsc(List<TruckDTO> truckDTOList) {
        LOGGER.info("Found {} trucks ordered by make in ascending order.", truckDTOList.size());
    }

    /**
     * This method is called after an exception is thrown during the execution of the findAllByOrderByMakeAsc() method
     * in the TruckServiceAdapter class. It logs an error message with the details of the exception.
     *
     * @param exception The Exception object that was thrown during the execution of the findAllByOrderByMakeAsc() method.
     */
    @AfterThrowing(pointcut =
            "execution(* com.register.vehicletype.domain.service.TruckServiceAdapter.findAllByOrderByMakeAsc(..))",
            throwing = "exception")
    public void afterFindAllByOrderByMakeAscException(Exception exception) {
        LOGGER.error("Error finding trucks ordered by make in ascending order.", exception);
    }

    /**
     * This method is called before the execution of the delete() method in the TruckServiceAdapter class.
     * It logs an informative message with the details of the truck being deleted.
     *
     * @param joinPoint the JoinPoint object representing the method call
     */
    @Before("execution(* com.register.vehicletype.domain.service.TruckServiceAdapter.delete(..))")
    public void beforeDelete(JoinPoint joinPoint) {
        LOGGER.info("Deleting truck with id {}.", joinPoint.getArgs()[0]);
    }

    /**
     * This method is called after the successful execution of the delete() method in the TruckServiceAdapter class.
     * It logs an informative message with the details of the truck being deleted.
     *
     * @param joinPoint the JoinPoint object representing the method call
     */
    @AfterReturning(pointcut = "execution(* com.register.vehicletype.domain.service.TruckServiceAdapter.delete(..))")
    public void afterDelete(JoinPoint joinPoint) {
        LOGGER.info("truck deleted with id {}.", joinPoint.getArgs()[0]);
    }

    /**
     * This method is called after an exception is thrown during the execution of the delete() method in the TruckServiceAdapter class.
     * It logs an error message with the details of the truck being deleted and the exception.
     *
     * @param joinPoint  the JoinPoint object representing the method call
     * @param exception  the Exception object that was thrown during the execution of the delete() method
     */
    @AfterThrowing(pointcut = "execution(* com.register.vehicletype.domain.service.TruckServiceAdapter.delete(..))",
            throwing = "exception")
    public void afterDeleteException(JoinPoint joinPoint, Exception exception) {
        LOGGER.error("Error deleting truck with id {}.", joinPoint.getArgs()[0], exception);
    }

    /**
     * This method is called before the execution of the save() method in the TruckServiceAdapter class.
     * It logs an informative message with the details of the truck being saved.
     *
     * @param joinPoint  the JoinPoint object representing the method call
     */
    @Before("execution(* com.register.vehicletype.domain.service.TruckServiceAdapter.save(..))")
    public void beforeSave(JoinPoint joinPoint) {
        LOGGER.info("Saving truck {}.", joinPoint.getArgs()[0]);
    }

    /**
     * This method is called after the successful execution of the save() method in the TruckDTO service.
     * It logs an informative message with the details of the saved truck.
     *
     * @param truckDTO    the truckDTO object that was saved
     */
    @AfterReturning(pointcut = "execution(*..TruckDTO *..service..save(*))", returning = "truckDTO")
    public void afterSave(TruckDTO truckDTO) {
        LOGGER.info("Truck saved {}.", truckDTO);
    }

    /**
     * This method is called after an exception is thrown during the execution of the save() method in the TruckDTO service.
     * It logs an error message with the details of the truck and the exception.
     *
     * @param joinPoint  the JoinPoint object representing the method call
     * @param exception  the Exception object that was thrown during the execution of the save() method
     */
    @AfterThrowing(pointcut = "execution(*..TruckDTO *..service..save(*))", throwing = "exception")
    public void afterSaveException(JoinPoint joinPoint, Exception exception) {
        LOGGER.error("Error saving truck {}.", joinPoint.getArgs()[0], exception);
    }
}

