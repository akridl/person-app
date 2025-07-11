package com.example;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;
import jakarta.ws.rs.ext.Provider;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Provider
@Slf4j
public class LoggingFilter implements ContainerRequestFilter, ContainerResponseFilter {

    private static final String REQUEST_EXECUTION_START = "request-execution-start";

    @Override
    public void filter(ContainerRequestContext containerRequestContext) throws IOException {
        containerRequestContext.setProperty(REQUEST_EXECUTION_START, System.currentTimeMillis());

        log.info("Requested {} {}", containerRequestContext.getRequest().getMethod(), containerRequestContext.getUriInfo().getPath());
    }

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
       Long requestStart = (Long) requestContext.getProperty(REQUEST_EXECUTION_START);
       final long took = (requestStart == null) ? -1 : System.currentTimeMillis() - requestStart;

       log.debug("Completed {} {}, took: {}ms.", requestContext.getRequest().getMethod(), requestContext.getUriInfo().getPath(), took);
    }
}
