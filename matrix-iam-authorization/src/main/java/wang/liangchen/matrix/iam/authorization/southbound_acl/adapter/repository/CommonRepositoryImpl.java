package wang.liangchen.matrix.iam.authorization.southbound_acl.adapter.repository;

import wang.liangchen.matrix.framework.data.dao.StandaloneDao;
import wang.liangchen.matrix.framework.data.dao.criteria.Criteria;
import wang.liangchen.matrix.framework.data.dao.criteria.SubCriteria;
import wang.liangchen.matrix.framework.data.dao.criteria.UpdateCriteria;
import wang.liangchen.matrix.framework.data.dao.entity.RootEntity;
import wang.liangchen.matrix.framework.data.pagination.PaginationResult;
import wang.liangchen.matrix.iam.authorization.southbound_acl.port.repository.CommonRepository;

import javax.inject.Inject;
import java.util.List;

/**
 * @author Liangchen.Wang 2022-08-17 10:28
 */
public class CommonRepositoryImpl implements CommonRepository {
    @Inject
    private StandaloneDao standaloneDao;

    @Override
    public <E extends RootEntity> void add(E entity) {
        standaloneDao.insert(entity);
    }

    @Override
    public <E extends RootEntity> int delete(E entity) {
        return standaloneDao.delete(entity);
    }

    @Override
    public <E extends RootEntity> int delete(SubCriteria<E> criteria) {
        return standaloneDao.delete(criteria);
    }

    @Override
    public <E extends RootEntity> int update(E entity) {
        return standaloneDao.update(entity);
    }

    @Override
    public <E extends RootEntity> int update(UpdateCriteria<E> criteria) {
        return standaloneDao.update(criteria);
    }

    @Override
    public <E extends RootEntity> PaginationResult<E> pagination(Criteria<E> criteria) {
        return standaloneDao.pagination(criteria);
    }

    @Override
    public <E extends RootEntity> List<E> list(Criteria<E> criteria) {
        return standaloneDao.list(criteria);
    }

    @Override
    public <E extends RootEntity> E select(Criteria<E> criteria) {
        return standaloneDao.select(criteria);
    }

    @Override
    public <E extends RootEntity> int count(Criteria<E> criteria) {
        return standaloneDao.count(criteria);
    }

    @Override
    public <E extends RootEntity> boolean exist(Criteria<E> criteria) {
        return standaloneDao.count(criteria) > 0;
    }

}
