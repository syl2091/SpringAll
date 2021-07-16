package com.wasu.demo5.dao.impl;

import com.wasu.demo5.dao.SysLogDao;
import com.wasu.demo5.domain.SysLog;
import org.springframework.beans.factory.NamedBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @ClassName:SysLogDaoImpl
 * @Description: TODO
 * @Author: Syl
 * @Date: 2021/7/16 13:48
 */
@Repository
public class SysLogDaoImpl implements SysLogDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public void saveLog(SysLog sysLog) {
        StringBuffer sql = new StringBuffer("insert into sys_log");
        sql.append("(id,username,operation,time,method,params,ip,create_time)");
        sql.append("values(uuid(),:username,:operation,:time,:method,");
        sql.append(":params,:ip,:createTime)");

        NamedParameterJdbcTemplate npjt = new NamedParameterJdbcTemplate(this.jdbcTemplate.getDataSource());
        npjt.update(sql.toString(), new BeanPropertySqlParameterSource(sysLog));
    }
}
