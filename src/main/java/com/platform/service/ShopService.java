package com.platform.service;

import com.platform.entity.Shop;
import com.platform.utils.ExecutorProvider;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

import static java.util.stream.Collectors.toList;

@ApplicationScoped
public class ShopService {

    public ShopService() {
    }

    private final List<Shop> shops = Arrays.asList(new Shop("BestPrice"),
            new Shop("LetsSaveBig"),
            new Shop("LetsSaveBig"),
            new Shop("LetsSaveBig"),
            new Shop("LetsSaveBig"),
            new Shop("LetsSaveBig"),
            new Shop("LetsSaveBig"),
            new Shop("LetsSaveBig"),
            new Shop("LetsSaveBig"),
            new Shop("LetsSaveBig"),
            new Shop("LetsSaveBig"),
            new Shop("LetsSaveBig"),
            new Shop("LetsSaveBig"),
            new Shop("LetsSaveBig"),
            new Shop("LetsSaveBig"),
            new Shop("LetsSaveBig"),
            new Shop("LetsSaveBig"),
            new Shop("LetsSaveBig"),
            new Shop("LetsSaveBig"),
            new Shop("LetsSaveBig"),
            new Shop("LetsSaveBig"),
            new Shop("LetsSaveBig"),
            new Shop("LetsSaveBig"),
            new Shop("LetsSaveBig"),
            new Shop("LetsSaveBig"),
            new Shop("LetsSaveBig"),
            new Shop("LetsSaveBig"),
            new Shop("LetsSaveBig"),
            new Shop("LetsSaveBig"),
            new Shop("LetsSaveBig"),
            new Shop("LetsSaveBig"),
            new Shop("LetsSaveBig"),
            new Shop("LetsSaveBig"),
            new Shop("LetsSaveBig"),
            new Shop("LetsSaveBig"),
            new Shop("LetsSaveBig"),
            new Shop("LetsSaveBig"),
            new Shop("LetsSaveBig"),
            new Shop("LetsSaveBig"),
            new Shop("LetsSaveBig"),
            new Shop("LetsSaveBig"),
            new Shop("LetsSaveBig"),
            new Shop("LetsSaveBig"),
            new Shop("LetsSaveBig"),
            new Shop("LetsSaveBig"),
            new Shop("LetsSaveBig"),
            new Shop("LetsSaveBig"),
            new Shop("LetsSaveBig"),
            new Shop("LetsSaveBig"),
            new Shop("LetsSaveBig"),
            new Shop("LetsSaveBig"),
            new Shop("LetsSaveBig"),
            new Shop("LetsSaveBig"),
            new Shop("LetsSaveBig"),
            new Shop("LetsSaveBig"),
            new Shop("LetsSaveBig"),
            new Shop("LetsSaveBig"),
            new Shop("LetsSaveBig"),
            new Shop("LetsSaveBig"),
            new Shop("LetsSaveBig"),
            new Shop("MyFavoriteShop"),
            new Shop("BuyItAll"));

    public List<String> findPrices(String product) {
        return shops.stream()
                .map(shop -> String.format("%s price is %.2f", shop.getName(), shop.getPrice(product)))
                .collect(toList());
    }

    public List<String> findAsyncPrices(String product) {

        Executor executor = ExecutorProvider.getExecutor(shops.size());

        List<CompletableFuture<String>> priceFutures = shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(
                        () -> String.format("%s price is %.2f",
                                shop.getName(), shop.getPrice(product)), executor))
                .collect(toList());

        return priceFutures.stream()
                .map(CompletableFuture::join)
                .collect(toList());
    }
}
