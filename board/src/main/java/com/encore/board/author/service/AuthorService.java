package com.encore.board.author.service;

import com.encore.board.author.domain.Author;
import com.encore.board.author.dto.AuthorDetailResDto;
import com.encore.board.author.dto.AuthorListResDto;
import com.encore.board.author.dto.AuthorSaveDto;
import com.encore.board.author.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;
    @Autowired
    public AuthorService(AuthorRepository authorRepository){
        this.authorRepository = authorRepository;
    }

    public void save(AuthorSaveDto authorSaveDto){
        Author author = new Author(
                authorSaveDto.getName(),
                authorSaveDto.getEmail(),
                authorSaveDto.getPassword()
        );
        authorRepository.save(author);
    }

    public List<AuthorListResDto> findAll(){
        List<Author> authorList = authorRepository.findAll();
        List<AuthorListResDto> listResDtos = new ArrayList<>();
        for(Author author : authorList){
            AuthorListResDto authorListResDto = new AuthorListResDto();
            authorListResDto.setId(author.getId());
            authorListResDto.setName(author.getName());
            authorListResDto.setEmail(author.getEmail());
            listResDtos.add(authorListResDto);
        }
        return listResDtos;
    }

    public AuthorDetailResDto findById(long id) throws EntityNotFoundException {
        Author author =  authorRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        AuthorDetailResDto authorDetailResDto = new AuthorDetailResDto();
        authorDetailResDto.setId(author.getId());
        authorDetailResDto.setName(author.getName());
        authorDetailResDto.setEmail(author.getEmail());
        authorDetailResDto.setPassword(author.getPassword());
        authorDetailResDto.setCreatedTime(author.getCreatedTime());
        return authorDetailResDto;
    }
}
