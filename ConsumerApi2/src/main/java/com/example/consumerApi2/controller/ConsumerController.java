package com.example.consumerApi2.controller;

import com.example.consumerApi2.entity.Location;
import com.example.consumerApi2.entity.StatisticsApi;
import com.example.consumerApi2.service.ConsumerService;
import com.example.consumerApi2.service.MetricService;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@Secured("USER")
@RestController

@RequestMapping(("/consume"))
public class ConsumerController {

    @Autowired
    private ConsumerService service;
    
    @Autowired
    private MetricService metricService;

    @GetMapping("/fares/{origin}/{destination}")
    public String getFares(@PathVariable("origin") String origin,
			@PathVariable("destination") String destination) throws JsonProcessingException {
        return service.getFare(origin,destination);
    }

    @GetMapping("/airports")
    public String getAirports() throws JsonProcessingException {
        return service.getAirport();
    }

    /* find an origin or destination by providing a few characters that would match either an airport code, name or description*/
    @GetMapping("/{searchTerm}")
    public String getOriginDestination(@PathVariable(value= "searchTerm") String searchTerm) throws JsonProcessingException {
        //return service.getOriginDestination(searchTerm);
    	return null;
    }
    
    @GetMapping("/metrics")
	public List<StatisticsApi> getMetricsData(){
		return metricService.data();
	}

}
