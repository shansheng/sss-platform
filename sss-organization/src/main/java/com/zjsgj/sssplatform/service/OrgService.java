package com.zjsgj.sssplatform.service;

import com.zjsgj.sssplatform.DataObject.OrgOrganization;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface OrgService {
    OrgOrganization findById(Integer id);
    Page<OrgOrganization> findAll(Map<String,Object> map, int page, int size);
    OrgOrganization save(OrgOrganization org);
    void delete(OrgOrganization organization);
}
