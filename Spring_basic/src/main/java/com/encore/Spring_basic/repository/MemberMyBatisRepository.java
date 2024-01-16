package com.encore.Spring_basic.repository;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/*
MyBatis 쓰겠다는 어노테이션
 */
@Mapper
@Repository
public interface MemberMyBatisRepository extends MemberRepository{
    /*
    본문에 MyBatisRepository 에서 사용할 메서드 형시을 정의해야 하나,
    MemberRepository에서 상속 받고 있으므로, 생략 가능
    실질적인 쿼리등 구현은 resources/mapper/MemberMapper.xml 파일에 수행
     */

}
