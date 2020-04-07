package com.ssm.mapper;

import com.ssm.entity.Admin;

public interface AdminMapper {
   public Admin findAdminByName(String adminname);

   boolean registAdmin(Admin admin);
}
