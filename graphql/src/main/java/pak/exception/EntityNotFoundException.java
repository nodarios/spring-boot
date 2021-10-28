package pak.exception;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class EntityNotFoundException extends RuntimeException implements GraphQLError {

    private final Map<String, Object> extensions = new HashMap<>();

    public EntityNotFoundException(String message, UUID id) {
        super(message);
        extensions.put("invalid id", id);
    }

    @Override
    public List<SourceLocation> getLocations() {
        return Collections.emptyList();
    }

    @Override
    public Map<String, Object> getExtensions() {
        return extensions;
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.DataFetchingException;
    }

}
