package com.example.consumerApi2.entity;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(NON_NULL)
@Getter
@Setter
public class StatisticsApi{
	private int totalRequests;
	private String responseCode;
	private Long minResponseTime;
	private Long maxResponseTime;
	private Long avgResponseTime;
	private Long startTime;
	private Long stopTime;
	private Long totalTime;
	

}
