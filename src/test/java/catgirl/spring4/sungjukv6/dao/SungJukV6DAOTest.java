package catgirl.spring4.sungjukv6.dao;

import catgirl.spring4.sungjukv6.model.SungJukVO;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sun.security.provider.Sun;

import java.util.List;
/*
단위unit 테스트
        하나의 모듈을 기준으로 독립적으로 진행되는 가장 작은 단위의 테스트
        모듈은 애플리케이션에서 작동하는 하나의 기능 또는 메소드를 의미
        애플리케이션을 구성하는 하나의 기능이 올바르게 동작하는지를 독립적으로 테스트하는 것
        "어떤 기능이 실행되면 어떤 결과가 나온다" 수준으로 테스트 함*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:root-context.xml",
                                    "classpath:servlet-context.xml"})
public class SungJukV6DAOTest extends TestCase {
    @Autowired
    SungJukV4DAO sjdao;

    SungJukVO sj;
    @Test // 테스트 슈트
    public void test1(){
        System.out.println(">> Test 1 시작 <<");
        List<SungJukVO> sjs = sjdao.selectSungJuk();
        System.out.println(sjs);
    }

    @Test // 테스트 슈트
    public void test2(){
        System.out.println(">> Test 2 시작 <<");
        SungJukVO sj = sjdao.selectOneSungJuk(5);
        System.out.println(sj);
    }

    @Test // 테스트 슈트
    public void test3(){
        System.out.println(">> Test 3 시작 <<");

        SungJukVO sj = new SungJukVO("이름", 99, 88, 77);
        sj.setTot(sj.getKor() + sj.getEng() + sj.getMat());
        sj.setAvg((double) sj.getTot() / 3);
        switch ((int) (sj.getAvg() / 10)) {
            case 10:
            case 9: sj.setGrd('수');break;
            case 8: sj.setGrd('우');break;
            case 7: sj.setGrd('미');break;
            case 6: sj.setGrd('양');break;
            default: sj.setGrd('가');break;
        }
        SungJukVO sj2 = new SungJukVO("이름", 99, 88, 77, sj.getTot(), sj.getAvg(), sj.getGrd());
        System.out.println(sj);
        int cnt = sjdao.insertSungJuk(sj2);
        if(sjdao.insertSungJuk(sj2) > 0)
            System.out.println("insert 성공");
            System.out.println(cnt);

        System.out.println(sjdao.selectSungJuk());



    }

}