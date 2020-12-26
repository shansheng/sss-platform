package com.zjsgj.sssplatform.repository;

import com.zjsgj.sssplatform.DataObject.OrgOrganization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface OrgOrganizationRepository extends JpaRepository<OrgOrganization,Integer>, JpaSpecificationExecutor<OrgOrganization> {

}
