package com.zjsgj.sssplatform.DataObject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrgOrganization {
    @Id
    @GeneratedValue
    private Integer orgid;
    private String orgcode;
    private String orgname;
    private Integer orglevel;
    private String orgdegree;
    private String orgseq;
    private String orgtype;
    private String orgaddr;
    private String zipcode;
    private Integer manaposition;
    private Integer managerid;
    private String orgmanager;
    private String linkman;
    private String linktel;
    private String email;
    private String weburl;
    private Date startdate;
    private Date enddate;
    private String status;
    private String area;
    private Date createtime;
    private Date lastupdate;
    private Integer updator;
    private Integer sortno;
    private String isleaf;
    private Integer subcount;
    private String remark;
    private String tenantId;
    private String appId;
    private Integer parentorgid;
}
