package com.security.spring_security.configurations.exceptions;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.lang.Nullable;
import org.springframework.security.authorization.AuthorizationResult;
import org.springframework.security.authorization.method.MethodAuthorizationDeniedHandler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import lombok.extern.slf4j.Slf4j;

@Slf4j // Logs of lombok
@Component
public class SecurityErrorHandler implements MethodAuthorizationDeniedHandler {

    @Override
    @Nullable
    public Object handleDeniedInvocation(MethodInvocation methodInvocation, AuthorizationResult authorizationResult) {
        log.info("\n\n\n");
        log.info(String.format("Method info -> %s", methodInvocation.toString()));
        log.info(String.format("Is Authorized? -> %s", authorizationResult.isGranted()));

        ObjectMapper mapper = new ObjectMapper();

        ObjectNode jsonNode = mapper.createObjectNode();
        jsonNode.put("code", 401);
        jsonNode.put("message", "Not authorized");

        try {
            return mapper.writeValueAsString(jsonNode);

        } catch (JsonProcessingException ex) {
            throw new RuntimeException("JsonProcessingException", ex);
        }
    }

}
