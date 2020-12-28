package com.zjsgj.sssplatform.service.impl;

import com.zjsgj.sssplatform.DataObject.OrgOrganization;
import com.zjsgj.sssplatform.repository.OrgOrganizationRepository;
import com.zjsgj.sssplatform.service.OrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class OrgServiceImpl implements OrgService {

    @Autowired
    private OrgOrganizationRepository repository;

    @Override
    public OrgOrganization findById(Integer id) {
        return repository.getOne(id);
    }

    @Override
    public Page<OrgOrganization> findAll(Map<String,Object> map, int page, int size) {
        //1.需要查询条件
        Specification<OrgOrganization> spec = new Specification<OrgOrganization>() {
            /**
             * 动态拼接查询条件
             * @return
             */
            public Predicate toPredicate(Root<OrgOrganization> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> list = new ArrayList<>();
                //根据请求的companyId是否为空构造查询条件
                if(!StringUtils.isEmpty(map.get("pid"))) {
                    list.add(criteriaBuilder.equal(root.get("parentorgid").as(String.class),(String)map.get("pid")));
                }

                if(!StringUtils.isEmpty(map.get("orgname"))) {
                    list.add(criteriaBuilder.like(root.get("orgname").as(String.class),"%" +(String)map.get("orgname")+"%"));
                }

                if(!StringUtils.isEmpty(map.get("status"))) {
                    //根据请求的hasDept判断  是否分配部门 0未分配（departmentId = null），1 已分配 （departmentId ！= null）
                    if("running".equals((String) map.get("status"))) {
                        list.add(criteriaBuilder.equal(root.get("status").as(String.class),(String)map.get("status")));
                    }
                }
                return criteriaBuilder.and(list.toArray(new Predicate[list.size()]));
            }
        };


        if (!StringUtils.isEmpty(map.get("field"))){

            return repository.findAll(spec,PageRequest.of(page-1, size,Sort.by(!StringUtils.isEmpty(map.get("order"))&&"descend".equals(map.get("order").toString())? Sort.Direction.DESC: Sort.Direction.ASC ,map.get("field").toString())));
        }

        return repository.findAll(spec,PageRequest.of(page-1, size));
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
