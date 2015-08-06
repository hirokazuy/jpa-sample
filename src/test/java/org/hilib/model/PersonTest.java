// -*- mode: java; coding: utf-8; tab-width: 4; -*-
package org.hilib.model;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.mysema.query.jpa.JPQLQuery;
import com.mysema.query.jpa.impl.JPAQuery;

import com.mysema.query.jpa.hibernate.HibernateQuery;

import org.hilib.model.UserInfo;
import org.hilib.model.QUserInfo;

public class PersonTest {
	private static EntityManagerFactory emf;
	private static EntityManager entityManager;

	@BeforeClass
	public static void beforeClass() {
		emf = Persistence.createEntityManagerFactory("test");
	}
	@AfterClass
	public static void AfterClass() {
		emf.close();
	}
	
	@Before
	public void before() {
		entityManager = emf.createEntityManager();
	}

	@After
	public void after() {
		if (entityManager != null) {
			entityManager.close();
		}
		entityManager = null;
	}

	public void insertItem() {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		UserInfo info = new UserInfo();
		info.setId(1);
		info.setUserId("TestUser");
		info.setUserPassword("TestPassword");
		entityManager.persist(info);
		tx.commit();
	}

	@Test
	public void inserTest() {
	}
	
	@Test
	public void queryTest() {
		insertItem();
		UserInfo info = entityManager.find(UserInfo.class, new Integer(1));
		assertThat(info.getId(), is(1));
		QUserInfo userinfo = QUserInfo.userInfo;
		JPQLQuery query = new JPAQuery(entityManager);
		List<UserInfo> infos = query.from(userinfo)
			.list(userinfo);
		assertThat(infos.size(), is(1));
	}
}
