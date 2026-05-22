package com.project.DepartmentService.Config;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;

import com.project.DepartmentService.Client.EmployeeClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.reactive.LoadBalancedExchangeFilterFunction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class WebClientConfig {
    @Autowired
    LoadBalancedExchangeFilterFunction loadBalancedExchangeFilterFunction;

    @Bean
    public WebClient EmployeeWebClient() {//LOAD BALANCER FILTER
        return WebClient.builder().baseUrl("http://EmployeeService").filter(loadBalancedExchangeFilterFunction).build();
    }

    @Bean
    public EmployeeClient employeeClient() {

        WebClientAdapter adapter =
                WebClientAdapter.create(EmployeeWebClient());

        HttpServiceProxyFactory factory =
                HttpServiceProxyFactory.builderFor(adapter).build();

        return factory.createClient(EmployeeClient.class);
    }
}
