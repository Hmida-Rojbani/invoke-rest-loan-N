package de.tekup.loan.invoke.ui.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import de.tekup.loan.invoke.ui.types.CustomerRequest;
import de.tekup.loan.invoke.ui.types.WsResponse;

@FeignClient(url = "localhost:8080", value = "localhost:8080")
public interface RestClientFeign {

	@PostMapping(path = "/api/get-status")
	public WsResponse consumeByFeign(@RequestBody CustomerRequest request);
}
