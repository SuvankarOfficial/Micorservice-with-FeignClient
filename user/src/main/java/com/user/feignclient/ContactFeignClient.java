package com.user.feignclient;


import com.user.ResponseBean.ResponseBean;
import com.user.dto.request.ContactRequestBean;
import com.user.dto.response.ContactResponseBean;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(value = "CONTACT-SERVICE")
@LoadBalancerClient
public interface ContactFeignClient {

    @PostMapping("/findByIdsF")
    public List<ContactResponseBean> findAllByIds(@RequestBody List<Long> contactIds);

    @PostMapping("/saveContact")
    public List<ContactResponseBean> saveContact(@RequestBody List<ContactRequestBean> contacts);

    @GetMapping("/getAllContacts")
    public List<ContactResponseBean> getAllContacts();
}
