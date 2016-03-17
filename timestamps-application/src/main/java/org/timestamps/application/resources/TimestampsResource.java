package org.timestamps.application.resources;

import com.codahale.metrics.annotation.Timed;
import com.google.inject.Inject;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;
import org.timestamps.application.api.TimestampDto;
import org.timestamps.application.domain.TimestampService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Api("/")
public class TimestampsResource {

    private static final String DEFAULT_PARAM_N = "100";
    private static final String LIMIT_KEY = "limit";

    private final TimestampService timestampService;
    private final DtoConverter dtoConverter;

    @Inject
    public TimestampsResource(TimestampService timestampService, DtoConverter dtoConverter) {
        this.timestampService = timestampService;
        this.dtoConverter = dtoConverter;
    }

    @GET
    @Timed
    @ApiOperation(value = "Get a timestamp")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful retrieval of a timestamp", response = TimestampDto.class),
            @ApiResponse(code = 404, message = "No poll exists with the provided id"),
            @ApiResponse(code = 500, message = "Internal server error")}
    )
    public TimestampDto get() {
        return dtoConverter.toDto(timestampService.get());
    }

}
