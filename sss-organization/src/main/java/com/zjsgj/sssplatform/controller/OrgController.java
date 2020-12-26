package com.zjsgj.sssplatform.controller;

import com.zjsgj.sssplatform.DataObject.OrgOrganization;
import com.zjsgj.sssplatform.common.PageResult;
import com.zjsgj.sssplatform.common.Result;
import com.zjsgj.sssplatform.common.ResultCode;
import com.zjsgj.sssplatform.service.OrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/org")
public class OrgController {
    @Autowired
    private OrgService orgService;

    @GetMapping
    public Result findAll(int page, int pageSize, @RequestParam Map map){
        Page<OrgOrganization> pageUser = orgService.findAll(map,page,pageSize);
        //3.构造返回结果
        PageResult pageResult = new PageResult(pageUser.getTotalElements(),pageUser.getContent());
        return new Result(ResultCode.SUCCESS, pageResult);
    }
}
