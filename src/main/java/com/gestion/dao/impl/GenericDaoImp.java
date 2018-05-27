package com.gestion.dao.impl;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.primefaces.model.SortOrder;

import com.gestion.dao.GenericDao;

public class GenericDaoImp<T> implements GenericDao<T> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void saveOrUpdate(T entity) throws Exception {
		entityManager.persist(entity);

	}

	@Override
	public void delete(T entity) throws Exception {
		entityManager.remove(entity);

	}

	@Override
	public List<T> findAll(Class<T> cls, int start, int size, String sortField, SortOrder sortOrder,
			Map<String, Object> filters) throws Exception {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(cls);
		Root<T> root = criteriaQuery.from(cls);
		criteriaQuery.select(root);
		if (sortField != null) {
			if (sortOrder == SortOrder.ASCENDING) {
				criteriaQuery.orderBy(criteriaBuilder.asc(root.get(sortField)));
			}

			if (sortOrder == SortOrder.DESCENDING) {
				criteriaQuery.orderBy(criteriaBuilder.desc(root.get(sortField)));
			}

		}

		TypedQuery<T> query = entityManager.createQuery(criteriaQuery);
		query.setFirstResult(start);
		query.setMaxResults(size);
		return query.getResultList();
	}

	@Override
	public List<T> findAll(Class<T> cls) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> query = builder.createQuery(cls);
		Root<T> root = query.from(cls);
		query.select(root);
		return entityManager.createQuery(query).getResultList();
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
