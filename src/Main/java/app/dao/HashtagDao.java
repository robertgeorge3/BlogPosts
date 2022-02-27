package app.dao;

import app.dto.Hashtags;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Repository
public class HashtagDao implements HashtagRepository{
    @Override
    public List<Hashtags> findAll() {
        return null;
    }

    @Override
    public List<Hashtags> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Hashtags> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Hashtags> findAllById(Iterable<Integer> integers) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(Hashtags entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Hashtags> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Hashtags> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Hashtags> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Hashtags> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Hashtags> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Hashtags> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Hashtags> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Hashtags getOne(Integer integer) {
        return null;
    }

    @Override
    public Hashtags getById(Integer integer) {
        return null;
    }

    @Override
    public <S extends Hashtags> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Hashtags> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Hashtags> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Hashtags> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Hashtags> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Hashtags> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Hashtags, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}
