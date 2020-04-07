package com.ssm.service.impl;

import com.ssm.entity.Admin;
import com.ssm.mapper.AdminMapper;
import com.ssm.service.AdminService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.UUID;

@Service
@Transactional(rollbackFor = Exception.class)
public class AdminServiceImpl  implements AdminService {
    @Resource
    private AdminMapper am;
    @Override
    public Admin findAdminByName(String adminname) {
        Admin admin =am.findAdminByName(adminname);
        return admin;
    }

    @Override
    public boolean registAdmin(Admin admin) {
        Admin findadmin=am.findAdminByName(admin.getAdminname());
        if(findadmin!=null) {
            return false;
        }else {
            String id = "sc-" + UUID.randomUUID().toString().replace("-", "").toUpperCase().substring(0, 10);
            admin.setAdminId(id);
            return am.registAdmin(admin);
        }

    }

}
