package com.encore.Spring_basic.repository;

import com.encore.Spring_basic.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
/*
spring data jpa 의 기본 기능을 쓰기 위해서는 JpaRepository를 상송해야함
상속시에 entity 명과 해당 pk 타입 명시
실질적인 구현클래스와 스팩은 SimpleJpaRepository 클래스에 있고
실직적인 구동상황에서 hibernate 구현체에 동작위임.

SimpleJpaRepository: 기본 구현체로서 가장 일반적으로 사용됩니다. CRUD 메서드를 구현하고 Spring Data JPA 의 특징을 지원.
QuerydslJpaRepository: Querydsl 을 사용하여 동적 쿼리를 작성할 수 있도록 지원하는 구현체. Querydsl 은 타입 안전한 쿼리를 작성하는 데 도움을 주는 라이브러리.
SimpleJpaBatchRepository: 대량 데이터 처리에 최적화된 구현체, 배치 작업에 사용될 수 있다.
QueryByExampleExecutor: 예제 객체를 사용하여 동적 쿼리를 수행하는 데 사용되는 구현체.
JdbcRepository: JDB C를 직접 사용하는 구현체로, JPA 를 사용하지 않고 직접 SQL 쿼리를 작성하는 경우에 유용할 수 있다.
 */
public interface MemberSpringDataJpaRepository extends MemberRepository, JpaRepository<Member, Long> {


}
