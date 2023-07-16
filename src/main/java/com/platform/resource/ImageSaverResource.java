package com.platform.resource;

import com.platform.entity.ImageSavingRequest;
import com.platform.model.ImageCatcher;
import com.platform.service.ImageService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@ApplicationScoped
@Path("/v1/image")
public class ImageSaverResource {

    @Inject
    private ImageService imageService;

    @POST
    public Response saveImage(ImageSavingRequest imageSavingRequest) {
        ImageCatcher imageCatcher = imageService.saveImage(imageSavingRequest.getEncodedImage());
        return Response.ok(imageCatcher).build();
    }
}
