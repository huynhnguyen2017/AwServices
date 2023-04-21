package com.platform.resource;


import com.platform.service.ShopService;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/v1/shop")
public class ShopResource {

    @Inject
    private ShopService shopService;

    @PostConstruct
    private void init() {
        System.out.println("#####################");
        System.out.println(" ##################  ");
        System.out.println("  ################   ");
        System.out.println("     BestPrice       ");
        System.out.println("    LetsSaveBig      ");
        System.out.println("   MyFavoriteShop    ");
        System.out.println("      BuyItAll       ");
        System.out.println("  ################   ");
        System.out.println(" ##################  ");
        System.out.println("#####################");
    }

    @GET
    @Produces("application/json")
    public Response getShops(@QueryParam("product") String product) {
        List<String> asyncPrices = shopService.findAsyncPrices(product);
        return Response.ok(asyncPrices).build();
    }
}
