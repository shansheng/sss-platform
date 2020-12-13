package com.zjsgj.sssplatform.service.impl;

import com.zjsgj.sssplatform.DataObject.OrgOrganization;
import com.zjsgj.sssplatform.repository.OrgOrganizationRepository;
import com.zjsgj.sssplatform.service.OrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class OrgServiceImpl implements OrgService {

    @Autowired
    private OrgOrganizationRepository repository;

    @Override
    public OrgOrganization findById(Integer id) {
        return repository.getOne(id);
    }

    @Override
    public Page<OrgOrganization> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public OrgOrganization save(OrgOrganization org) {
        return repository.save(org);
    }

    @Override
    public void delete(OrgOrganization organization) {
        repository.delete(organization);
    }
}
