package ssm.zview.me.dao;/*
 *   Created by coder-pig@outlook.com on 2017/4/6.
 */

import org.apache.ibatis.annotations.Param;

public interface LoginCheck {

    public int checkLogin(@Param("name") String name, @Param("passwd") String passwd);
}
