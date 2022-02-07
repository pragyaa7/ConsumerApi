package statistics;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.consumerApi2.entity.StatisticsApi;
import com.example.consumerApi2.service.MetricService;

@Component
public class MetricFilter implements Filter {

    @Autowired
    private MetricService metricService;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		long startTime = System.currentTimeMillis();
		chain.doFilter(request, response);
        int status = ((HttpServletResponse) response).getStatus();
        System.out.println("status-----------------"+status);
        //metricService.increaseCount(status);
        long endTime = System.currentTimeMillis();
        long totaltime = endTime - startTime;
        System.out.println("Total max time taken to get the Fare " +totaltime +"ms");
        metricService.create(request,response,startTime,endTime,totaltime,status);
		
	}
	
	
}
