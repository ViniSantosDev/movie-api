package br.com.viniciussantosdev.movieapi.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.viniciussantosdev.movieapi.entity.Filme;

@Repository
public interface FilmeRepository extends PagingAndSortingRepository<Filme, Long> {
}
