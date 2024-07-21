package com.register.vehicletype.aop.aspect;

import com.register.vehicletype.domain.dto.MotorcycleDTO;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * The MotorcycleServiceAdapterAspect class is an aspect class that provides AOP (Aspect-Oriented Programming) functionality
 * for the MotorcycleServiceAdapter class. It contains advice methods that are executed before and after specific methods
 * in the MotorcycleServiceAdapter class, allowing additional behavior to be applied.
 */
@Aspect
public class MotorcycleServiceAdapterAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(MotorcycleServiceAdapterAspect.class);

    /**
     * This method is a before advice that is executed before the execution of the findById() method in the MotorcycleServiceAdapter class.
     * It logs an informative message with the details of the motorcycle ID being searched.
     *
     * @param joinPoint The JoinPoint object representing the method call.
     */
    @Before("execution(* com.register.vehicletype.domain.service.MotorcycleServiceAdapter.findById(..))")
    public void beforeFindById(JoinPoint joinPoint) {
        LOGGER.info("Searching motorcycle with id {}.", joinPoint.getArgs()[0]);
    }

    /**
     * This method is called after the successful execution of the findById() method in the MotorcycleServiceAdapter class.
     * It logs an informative message with the details of the motorcycle found.
     *
     * @param motorcycleDTO The MotorcycleDTO object that was returned by the findById() method.
     */
    @AfterReturning(pointcut = "execution(*..MotorcycleDTO *..service..findById(*))", returning = "motorcycleDTO")
    public void afterFindById(MotorcycleDTO motorcycleDTO) {
        LOGGER.info("Motorcycle found {}.", motorcycleDTO);
    }

    /**
     * This method is called after an exception is thrown during the execution of the findById() method
     * in the MotorcycleServiceAdapter class. It logs an error message with the details of the exception.
     *
     * @param joinPoint  the JoinPoint object representing the method call
     * @param exception  the Exception object that was thrown during the execution of the findById() method
     */
    @AfterThrowing(pointcut = "execution(*..MotorcycleDTO *..service..findById(*))", throwing = "exception")
    public void afterFindByIdException(JoinPoint joinPoint, Exception exception) {
        LOGGER.error("Error finding motorcycle with id {}.", joinPoint.getArgs()[0], exception);
    }

    /**
     * This method is a before advice that is executed before the execution of the {@code findAllByOrderByMakeAsc()}
     * method in the {@code MotorcycleServiceAdapter} class. It logs an informative message indicating that the query to find all
     * motorcycles ordered by make in ascending order is being initiated.
     */
    @Before("execution(* com.register.vehicletype.domain.service.MotorcycleServiceAdapter.findAllByOrderByMakeAsc(..))")
    public void beforeFindAllByOrderByMakeAsc() {
        LOGGER.info("Initiating query to find all motorcycles ordered by make in ascending order.");
    }

    /**
     * This method is called after the successful execution of the findAllByOrderByMakeAsc() method in the MotorcycleServiceAdapter class.
     * It logs an informative message with the number of motorcycles found.
     *
     * @param motorcycleDTOList The list of MotorcycleDTO objects that were returned by the findAllByOrderByMakeAsc() method.
     */
    @AfterReturning(pointcut =
            "execution(* com.register.vehicletype.domain.service.MotorcycleServiceAdapter.findAllByOrderByMakeAsc(..))",
            returning = "motorcycleDTOList")
    public void afterFindAllByOrderByMakeAsc(List<MotorcycleDTO> motorcycleDTOList) {
        LOGGER.info("Found {} motorcycles ordered by make in ascending order.", motorcycleDTOList.size());
    }

    /**
     * This method is called after an exception is thrown during the execution of the findAllByOrderByMakeAsc() method
     * in the MotorcycleServiceAdapter class. It logs an error message with the details of the exception.
     *
     * @param exception The Exception object that was thrown during the execution of the findAllByOrderByMakeAsc() method.
     */
    @AfterThrowing(pointcut =
            "execution(* com.register.vehicletype.domain.service.MotorcycleServiceAdapter.findAllByOrderByMakeAsc(..))",
            throwing = "exception")
    public void afterFindAllByOrderByMakeAscException(Exception exception) {
        LOGGER.error("Error finding motorcycles ordered by make in ascending order.", exception);
    }

    /**
     * This method is called before the execution of the delete() method in the MotorcycleServiceAdapter class.
     * It logs an informative message with the details of the motorcycle being deleted.
     *
     * @param joinPoint the JoinPoint object representing the method call
     */
    @Before("execution(* com.register.vehicletype.domain.service.MotorcycleServiceAdapter.delete(..))")
    public void beforeDelete(JoinPoint joinPoint) {
        LOGGER.info("Deleting motorcycle with id {}.", joinPoint.getArgs()[0]);
    }

    /**
     * This method is called after the successful execution of the delete() method in the MotorcycleServiceAdapter class.
     * It logs an informative message with the details of the motorcycle being deleted.
     *
     * @param joinPoint the JoinPoint object representing the method call
     */
    @AfterReturning(pointcut = "execution(* com.register.vehicletype.domain.service.MotorcycleServiceAdapter.delete(..))")
    public void afterDelete(JoinPoint joinPoint) {
        LOGGER.info("Motorcycle deleted with id {}.", joinPoint.getArgs()[0]);
    }

    /**
     * This method is called after an exception is thrown during the execution of the delete() method in the MotorcycleServiceAdapter class.
     * It logs an error message with the details of the motorcycle being deleted and the exception.
     *
     * @param joinPoint  the JoinPoint object representing the method call
     * @param exception  the Exception object that was thrown during the execution of the delete() method
     */
    @AfterThrowing(pointcut = "execution(* com.register.vehicletype.domain.service.MotorcycleServiceAdapter.delete(..))",
            throwing = "exception")
    public void afterDeleteException(JoinPoint joinPoint, Exception exception) {
        LOGGER.error("Error deleting motorcycle with id {}.", joinPoint.getArgs()[0], exception);
    }

    /**
     * This method is called before the execution of the save() method in the MotorcycleServiceAdapter class.
     * It logs an informative message with the details of the motorcycle being saved.
     *
     * @param joinPoint  the JoinPoint object representing the method call
     */
    @Before("execution(* com.register.vehicletype.domain.service.MotorcycleServiceAdapter.save(..))")
    public void beforeSave(JoinPoint joinPoint) {
        LOGGER.info("Saving motorcycle {}.", joinPoint.getArgs()[0]);
    }

    /**
     * This method is called after the successful execution of the save() method in the MotorcycleDTO service.
     * It logs an informative message with the details of the saved motorcycle.
     *
     * @param motorcycleDTO    the MotorcycleDTO object that was saved
     */
    @AfterReturning(pointcut = "execution(*..MotorcycleDTO *..service..save(*))", returning = "motorcycleDTO")
    public void afterSave(MotorcycleDTO motorcycleDTO) {
        LOGGER.info("Motorcycle saved {}.", motorcycleDTO);
    }

    /**
     * This method is called after an exception is thrown during the execution of the save() method in the MotorcycleDTO service.
     * It logs an error message with the details of the motorcycle and the exception.
     *
     * @param joinPoint  the JoinPoint object representing the method call
     * @param exception  the Exception object that was thrown during the execution of the save() method
     */
    @AfterThrowing(pointcut = "execution(*..MotorcycleDTO *..service..save(*))", throwing = "exception")
    public void afterSaveException(JoinPoint joinPoint, Exception exception) {
        LOGGER.error("Error saving motorcycle {}.", joinPoint.getArgs()[0], exception);
    }
}

