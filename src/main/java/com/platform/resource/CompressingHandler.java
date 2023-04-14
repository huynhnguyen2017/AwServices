package com.platform.resource;


import com.platform.service.CompressingService;
import org.jboss.resteasy.reactive.RestForm;
import org.jboss.resteasy.reactive.multipart.FileUpload;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/api/v1/compressing")
public class CompressingHandler {

    @Inject
    private CompressingService compressingService;

    @POST
    public Response compress(@RestForm("media") FileUpload media) {
//        byte[] compressedMedia = compressingService.compress((media);
        FileUpload test = media;
        return Response.ok("compressed").build();
    }
}
