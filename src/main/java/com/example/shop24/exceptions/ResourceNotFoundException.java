package com.example.shop24.exceptions;

import javax.management.relation.RelationException;
import java.io.Serial;

public class ResourceNotFoundException extends RelationException {
    @Serial
    private static final long serialVersionUID = -29864061;

    public ResourceNotFoundException() {
        super();
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }

}
