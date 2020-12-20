package com.zjsgj.sssplatform.controller;

import com.zjsgj.sssplatform.result.ResultVO;
import com.zjsgj.sssplatform.service.OrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/org")
public class OrgController {
    @Autowired
    private OrgService orgService;

    @GetMapping("/list")
    public ResultVO findAll(){
        Pageable pageable=PageRequest.of(0,10);
        return new ResultVO(orgService.findAll(pageable));
    }
}
