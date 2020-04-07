package com.ssm.service;

import com.ssm.entity.Admin;

public interface AdminService {
   Admin findAdminByName(String adminname);

    boolean registAdmin(Admin admin);
}
