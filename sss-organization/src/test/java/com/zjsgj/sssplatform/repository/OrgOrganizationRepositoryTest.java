package com.zjsgj.sssplatform.repository;

import com.zjsgj.sssplatform.DataObject.OrgOrganization;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrgOrganizationRepositoryTest {
    @Autowired
    OrgOrganizationRepository repository;

    @Test
    public void findAllTest(){
        List<OrgOrganization> list = repository.findAll();
        Assert.assertNotEquals(0,list.size());
    }
}