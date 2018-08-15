package com.eway.demo.controller

import com.eway.common.EwayResponse
import com.eway.common.exception.EwayException
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired

import javax.servlet.http.HttpServletRequest

/**
 *
 * @param < IVK >   stand for invoke service, passing method need to be execute
 * @param < IV >   stand for input_validator, passing method need to be execute
 * @param < SV >   stand for storage_validator, passing method need to be execute
 */
abstract class AbstractController<IVK, IV, SV> {

    protected Logger LOGGER = LoggerFactory.getLogger(AbstractController.class)

    protected @Autowired IVK invokeService
    protected @Autowired IV inputValidator
    protected @Autowired SV storageValidator

    private @Autowired HttpServletRequest httpServletRequest

    protected <O, I, E> EwayResponse<O> perform(I dataRequest, ServiceInvoker<I, O> service, InputValidator<I, E> inputValidator, StorageValidator<I, E> storageValidator)
        throws EwayException {
        LOGGER.info("Request from: {}", httpServletRequest.getRequestURI())
        inputValidator.validate(dataRequest)
        return success(service.invoke(storageValidator.validate(dataRequest)))
    }


    protected <I> EwayResponse<I> success(I data) {
//        LOGGER.info("Success with data: {}", data)
        return new EwayResponse<I>(data)
    }

    static interface ServiceInvoker<I, O> {
        O invoke(I i)
    }

    static interface InputValidator<I, O> {
        O validate(I i) throws EwayException
    }

    static interface StorageValidator<I, E> {
        E validate(I i) throws EwayException
    }
}
