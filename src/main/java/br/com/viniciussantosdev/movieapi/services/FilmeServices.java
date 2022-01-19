package br.com.viniciussantosdev.movieapi.services;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import br.com.viniciussantosdev.movieapi.dto.*;
import br.com.viniciussantosdev.movieapi.entity.Filme;
import br.com.viniciussantosdev.movieapi.repository.FilmeRepository;
import javassist.NotFoundException;

@Component
public class FilmeServices {

	@Autowired
	private FilmeRepository filmeRepository;

	@Autowired
	private ModelMapper modelMapper;

	public Page<FilmeDTO> findAllFilme() throws Exception {
		try {
			Pageable pageable = PageRequest.of(0, 100);
			Page<Filme> filme = filmeRepository.findAll(pageable);
			return convertToDTO(filme);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	public FilmeDTO findOneFilme(long id) throws Exception {
		try {
			Optional<Filme> filme = filmeRepository.findById(id);
			if (filme.isPresent()) {
				return modelMapper.map(filme.get(), FilmeDTO.class);
			} else {
				throw new NotFoundException(null);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	public FilmeDTO postFilmes(FilmeInsertDTO body) throws Exception {
		try {
			Filme filme = modelMapper.map(body, Filme.class);
			Filme filmeRegistrado = filmeRepository.save(filme);
			return modelMapper.map(filmeRegistrado, FilmeDTO.class);
		} catch (Exception e) {
			throw e;
		}

	}

	public FilmeDTO putFilme(FilmeUpdateDTO body) throws Exception {
		try {
			if (!this.filmeRepository.existsById(body.getId())) {
				throw new NotFoundException("Filme não existe");
			}
			Filme filme = modelMapper.map(body, Filme.class);
			Filme filmeAtualizado = filmeRepository.save(filme);
			return modelMapper.map(filmeAtualizado, FilmeDTO.class);
		} catch (Exception e) {
			throw e;
		}
	}

	public FilmeDTO deleteFilme(long body) throws Exception {
		try {
			filmeRepository.deleteById(body);
			return modelMapper.map(body, FilmeDTO.class);
		} catch (IllegalArgumentException e) {
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	public Page<FilmeDTO> findAllFilmeByDate(Date date) throws Exception {
		try {
			Pageable pageable = PageRequest.of(0, 1);
			Page<Filme> filme = filmeRepository.findByDataLancamento(date, pageable);
			return convertToDTO(filme);
		} catch (NullPointerException e) {
			e.printStackTrace();
			throw e;

		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void deleteAllFilmesByDate(LocalDateTime date) {
		try {
			Pageable pageable = PageRequest.of(0, 1);
			filmeRepository.deleteAll();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public Page<FilmeDTO> convertToDTO(Page<Filme> filme) {
		return filme.map(item -> this.convertToFilmeDTO(item));
	}

	public FilmeDTO convertToFilmeDTO(Filme filme) {
		FilmeDTO filmeDto = new FilmeDTO();
		filmeDto.setNome(filme.getNome());
		filmeDto.setCategoria(filme.getCategoria());
		filmeDto.setId(filme.getId());
		filmeDto.setDataLancamento(filme.getDataLancamento());
		return filmeDto;
	}

	public FilmeDTO createNewDTO(Filme filme) {
		FilmeDTO filmeDTO = new FilmeDTO();
		return filmeDTO;
	}

}

