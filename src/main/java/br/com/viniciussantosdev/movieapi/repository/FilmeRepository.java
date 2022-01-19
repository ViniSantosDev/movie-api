package br.com.viniciussantosdev.movieapi.repository;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.viniciussantosdev.movieapi.entity.Filme;

@Repository
public interface FilmeRepository extends PagingAndSortingRepository<Filme, Long> {

	public Page<Filme> findByDataLancamento(Date date, Pageable page);

	@Query(value = "select f from filme f where f.lancamento >= :date", nativeQuery = true)
	public Page<Filme> findAllByLancamento(@Param("date") Date date, Pageable page);

}
