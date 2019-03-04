package com.vn.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.vn.dao.Dao;

@Repository
public abstract class AbstractDao<T, ID> implements Dao<T, ID> {

	@Autowired
	protected JdbcTemplate jdbcTemplate;
	
	@Autowired
	protected NamedParameterJdbcTemplate namedParameterjdbcTemplate;
	
}
