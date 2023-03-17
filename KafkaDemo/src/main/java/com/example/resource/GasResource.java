package com.example.resource;

import com.example.kafka.GasProcessor;
import com.example.model.Gas;
import io.smallrye.reactive.messaging.annotations.Channel;
import io.smallrye.reactive.messaging.annotations.Emitter;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.concurrent.CompletionStage;

@Path("gas")
@ApplicationScoped
public class GasResource {
    @Inject
    GasProcessor gasProcessor;

    @Inject
    @Channel("gas-out")
    Emitter<Gas> gasEmitter;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response increasePrice(Gas gas){
        gas = gasProcessor.process(gas);
        Emitter<Gas> ack = gasEmitter.send(gas);
        return Response.ok().entity(ack).build();
    }
}
