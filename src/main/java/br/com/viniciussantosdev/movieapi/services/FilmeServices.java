package br.com.viniciussantosdev.movieapi.services;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import br.com.viniciussantosdev.movieapi.dto.*;
import br.com.viniciussantosdev.movieapi.entity.Filme;
import br.com.viniciussantosdev.movieapi.repository.FilmeRepository;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;

@Service
public class FilmeServices {

    @Autowired
    private FilmeRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    public Page<FilmeDTO> findAllFilme() {
        try {
            Pageable pageable = PageRequest.of(0, 100);
            Page<Filme> filme = repository.findAll(pageable);
            return convertToDTO(filme);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

    }

    public FilmeDTO findOneFilme(long id) throws Exception {
        try {
            Optional<Filme> filme = repository.findById(id);
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

    public FilmeDTO postFilmes(FilmeDTO body) throws Exception {
        Filme filme = modelMapper.map(body, Filme.class);
        Filme filmeRegistrado = repository.save(filme);
        return modelMapper.map(filmeRegistrado, FilmeDTO.class);

    }

    public FilmeDTO putFilme(FilmeDTO body) throws Exception {
        try {
            if (!this.repository.existsById(body.getId())) {
                throw new NotFoundException("Filme não existe");
            }
            Filme filme = modelMapper.map(body, Filme.class);
            Filme filmeAtualizado = repository.save(filme);
            return modelMapper.map(filmeAtualizado, FilmeDTO.class);
        } catch (Exception e) {
            throw e;
        }
    }

    public FilmeDTO deleteFilme(long body) throws Exception {
        try {
            repository.deleteById(body);
            return modelMapper.map(body, FilmeDTO.class);
        } catch (IllegalArgumentException e) {
            throw e;
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
        return filmeDto;
    }

}
