package com.personal.tcgcollector.client;

import com.personal.tcgcollector.common.model.TcgApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@FeignClient(name = "tcg-api", url = "${feign.client.config.tcg-api.url}")
public interface ImportClientAPI {

    @GetMapping("one-piece/cards")
    TcgApiResponse getAllOPCards(@RequestParam("limit") int limit, @RequestParam("page") int page); // Usa una classe CardDto adeguata
}

