package com.project.dugeun.repository;

import com.project.dugeun.entity.QUser;
import com.project.dugeun.entity.User;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.test.context.TestPropertySource;
import org.springframework.web.bind.annotation.DeleteMapping;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;

    // EntityManager 빈을 주입.
    @PersistenceContext
    EntityManager em;

    @Test
    @DisplayName("유저 저장 테스트")
    public void createUserTest(){
        User user = new User();

        user.setUserName("seol");
        user.setAge(26);
        user.setDepartment("computer science");
        user.setDescription("i am seol");

        User savedUser = userRepository.save(user);
        System.out.println(savedUser.toString());
    }

    public void createUserList(){
        for(int i=0; i<10; i++){
            User user = new User();
            user.setUserName("테스트 유저"+i);
            user.setDepartment("computer science"+ i);
            user.setAge(23 + i);
            user.setDescription("유저 상세 설명");
            User savedUser = userRepository.save(user);

            }
    }


    public void createUserList2(){
        for(int i=1; i<=5; i++){
            User user = new User();
            user.setUserName("테스트 유저"+i);
            user.setAge(50+i);
            user.setDepartment("자율전공학부");
            user.setDescription("유저 상세 설명");
            userRepository.save(user);

        }
        for(int i=6; i<=10; i++){
            User user = new User();
            user.setUserName("테스트 유저"+i);
            user.setAge(100+i);
            user.setDepartment("자율전공학부");
            user.setDescription("유저 상세 설명");
            userRepository.save(user);
        }
    }

    @Test
    @DisplayName("유저명 조회 테스트")
    public void findByUserNameTest(){
        this.createUserList();
        List<User> userList = userRepository.findByUserName("테스트 유저1");
        for(User user: userList){
            System.out.println(user.toString());
        }
    }

    @Test
    @DisplayName("유저명, 유저상세설명 or 테스트")
    public void findByUserNameOrDescription(){
        this.createUserList();
        List<User> userList =
                userRepository.findByUserNameOrDescription("테스트 유저1","유저 상세 설명5");
        for(User user : userList){
            System.out.println(user.toString());
        }
    }

    @Test
    @DisplayName("유저 나이 내림차순 조회 테스트")
    public void findByAgeLessThanTest(){
       this.createUserList();
       List<User> userList = userRepository.findByAgeLessThan(25);
       for(User user: userList){
           System.out.println(user.toString());
       }
    }

    @Test
    @DisplayName("@Query를 이용한 상품 조회 테스트")
    public void findByItemDescriptionTest(){
        this.createUserList();
        List<User> userList = userRepository.findByDescription("유저 상세 설명");
        for(User user: userList){
            System.out.println(user.toString());
        }

    }

    @Test
    @DisplayName("Querydsl 조회 테스트1")
    public void queryDslTest(){
        this.createUserList();
        // JPAQueryFactory를 이용하여 쿼리를 동적으로 생성.
        // 생성자의 파라미터로는 Entity Manger객체를
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        QUser qUser = QUser.user;
        JPAQuery<User> query = queryFactory.selectFrom(qUser)
                .where(qUser.description.like("%"+"유저 상세 설명"+ "%"))
                .orderBy(qUser.age.desc());

        // JPAQuery메소드 중 한개인 fetch를 이용해서 쿼리 결과를 리스트로 반환한다.
        // fetch() 메소드 실행 시점에 쿼리문이 실행된다.
        List<User> userList = query.fetch();

        for(User user : userList){
            System.out.println(user.toString());
        }
    }

    @Test
    @DisplayName("상품 Querydsl 조회 테스트2")
    public void queryDslTest2(){

        this.createUserList2();
        // BooleanBuilder는 쿼리에 드어갈 조건으 만들어주는 조건을 만들어주는 빌더
        // Predicate를 구현하고 있으며 메소드 체인 형식으로 사용 가능
        BooleanBuilder booleanBuilder = new BooleanBuilder();
        QUser user = QUser.user;
        String description = "유저 상세 설명";
        int age = 52;

        booleanBuilder.and(user.description.like("%"+description+"%"));
        booleanBuilder.and(user.age.gt(age));

        // 데이터를 페이징해 조회하도록 PageRequest.of() 메소드를 이용해 Pageble 객체를 생성
        // 첫번째 인자는 조회할 페이지의 번호, 두 번째 인자는 한 페이지당 조회할 데이터의 개수
        Pageable pageable = PageRequest.of(0,5);
        Page<User> userPagingResult =
                userRepository.findAll(booleanBuilder, pageable);
        System.out.println("total elements : "+
        userPagingResult. getTotalElements());

        List<User> resultUserList = userPagingResult.getContent();
        for(User resultUser: resultUserList){
            System.out.println(resultUser.toString());
        }


    }




}
