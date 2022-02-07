package com.example.consumerApi2.service;

import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.consumerApi2.entity.StatisticsApi;

@Service
public class MetricService {
	
	  private List<String> statusList;

	/*
	 * public void increaseCount(int status) { counter.increment("status." +
	 * status); if (!statusList.contains("counter.status." + status)) {
	 * statusList.add("counter.status." + status); } }
	 */

	public List<StatisticsApi> data() {
		
		return null;
	}
	
	public void create(ServletRequest request, ServletResponse response,Long startTime,Long endTime,Long totaltime, int status) {
		StatisticsApi obj = new StatisticsApi();
	}

}
