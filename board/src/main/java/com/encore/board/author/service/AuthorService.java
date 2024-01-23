package com.encore.board.author.service;

import com.encore.board.author.domain.Author;
import com.encore.board.author.domain.Role;
import com.encore.board.author.dto.AuthorDetailResDto;
import com.encore.board.author.dto.AuthorListResDto;
import com.encore.board.author.dto.AuthorSaveDto;
import com.encore.board.author.dto.AuthorUpdateDto;
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
        Role role = authorSaveDto.getRole() == null || authorSaveDto.getRole().equals("user") ? Role.USER : Role.ADMIN ;
        // 일반 생성자 방식
//        Author author = new Author(
//                authorSaveDto.getName(),
//                authorSaveDto.getEmail(),
//                authorSaveDto.getPassword(),
//                role
//        );

        // @Builder를 이용한 방식
        Author author = Author.builder()
                .name(authorSaveDto.getName())
                .email(authorSaveDto.getEmail())
                .password(authorSaveDto.getPassword())
                .build();
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

    public Author findById(long id) throws EntityNotFoundException {
        return authorRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public AuthorDetailResDto findAuthorDetail(long id) throws EntityNotFoundException {
        Author author =  this.findById(id);
        String role = author.getRole() == null || author.getRole() == Role.USER ? "일반 사용자" : "관리자" ;
        AuthorDetailResDto authorDetailResDto = new AuthorDetailResDto();
        authorDetailResDto.setId(author.getId());
        authorDetailResDto.setName(author.getName());
        authorDetailResDto.setEmail(author.getEmail());
        authorDetailResDto.setPassword(author.getPassword());
        authorDetailResDto.setCreatedTime(author.getCreatedTime());
        authorDetailResDto.setRole(role);
        return authorDetailResDto;
    }

    public void update(AuthorUpdateDto authorUpdateDto ) throws EntityNotFoundException {
        Author author =  this.findById(authorUpdateDto.getId());
        author.AuthorUpdate(authorUpdateDto.getName(), authorUpdateDto.getPassword());
        authorRepository.save(author);
    };

    public void delete(long id) throws EntityNotFoundException {
        authorRepository.deleteById(id);
    }

}
