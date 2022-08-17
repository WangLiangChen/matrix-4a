package wang.liangchen.matrix.iam.authorization.southbound_acl.port.repository;

import wang.liangchen.matrix.framework.data.dao.criteria.Criteria;
import wang.liangchen.matrix.framework.data.dao.criteria.SubCriteria;
import wang.liangchen.matrix.framework.data.dao.criteria.UpdateCriteria;
import wang.liangchen.matrix.framework.data.dao.entity.RootEntity;
import wang.liangchen.matrix.framework.data.pagination.PaginationResult;

import java.util.List;

/**
 * @author Liangchen.Wang 2022-08-17 10:28
 */
public interface CommonRepository {
    <E extends RootEntity> void add(E entity);

    <E extends RootEntity> int delete(E entity);

    <E extends RootEntity> int delete(SubCriteria<E> criteria);

    <E extends RootEntity> int update(E entity);

    <E extends RootEntity> int update(UpdateCriteria<E> criteria);

    <E extends RootEntity> PaginationResult<E> pagination(Criteria<E> criteria);

    <E extends RootEntity> List<E> list(Criteria<E> criteria);

    <E extends RootEntity> E select(Criteria<E> criteria);

    <E extends RootEntity> int count(Criteria<E> criteria);

    <E extends RootEntity> boolean exist(Criteria<E> criteria);
}
