package com.encore.Spring_basic.repository;

import com.encore.Spring_basic.domain.Member;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
public class MemberJpaRepository implements MemberRepository {

    /*
    EntityManager 는 JPA 의 핵심 클래스(객체)
    Entity 의 생명주기를 관리. DB 와의 모든 상호작용을 책임.
    Entity 를 대상으로  CRUD 하는 기능을 제공
     */
    private EntityManager entityManager;
    public MemberJpaRepository(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public List<Member> findAll() {
        /*
        jpql : jpa 의 쿼리문법
        장점 : DB에 따라 문법이 달라지지 않는 객체지향 언어, 컴파일타임에서 확인 (Spring data jpa 의 기능)
        단점 : DB 고유의 기능과 서능을 극대화하기 어려움
         */
        List<Member> members = entityManager
                .createQuery("select m from Member m", Member.class)
                .getResultList();
        return members;
    }

    @Override
    public Member save(Member member) {
        /*
        persist 전달된 Entity 가 EntityManager 의 관리 상태가
        되도록 만들어주고, 트랜잭션이 커밋될 때 DB 에 저장.
        insert 포함.
         */
        entityManager.persist(member);
        return member;
    }

    @Override
    public Optional<Member> findById(long id) {
        // find 메서드는 pk를 매개변수로 준다.
        Member member =  entityManager.find(Member.class, id);

        return Optional.ofNullable(member);
    }

    @Override
    public void delete(Member member) {
        /*
        remove 메서드 사용
        update 의 경우 merge 메서드 사용
         */
    }

    @Override
    public void deleteById(long id) {

    }

//    @Override
//    public Optional<Member> delete(long id) {
//        return Optional.empty();
//    }

    public List<Member> findByName(String name) {
        // 그외 컬럼으로 조회할 때는 select m from Member where m.name = :mame
        List<Member> members =  entityManager.createQuery(
                "select m from Member m where m.name = :name" , Member.class
        )
                .setParameter("name", name)
                .getResultList();

        return members;
    }
}
