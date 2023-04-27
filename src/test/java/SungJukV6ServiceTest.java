import catgirl.spring4.sungjukv6.model.SungJukVO;
import catgirl.spring4.sungjukv6.service.SungJukV6Service;
import catgirl.spring4.sungjukv6.service.SungJukV6ServiceImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SungJukV6ServiceTest {
    SungJukV6Service sjsrv;
    @Before
    public void setup(){
        sjsrv = new SungJukV6ServiceImpl(null);
    }

    @Test
    public void test1(){
        SungJukVO sj = new SungJukVO("test1", 99, 99, 99);
        sjsrv.computeSungJuk(sj);
        assertEquals(297, sj.getTot());
        assertEquals(99, sj.getAvg(), 0.0);
        assertEquals('수', sj.getGrd());

    }
}

//        sj.setTot(sj.getKor() + sj.getEng() + sj.getMat());
//        sj.setAvg((double) sj.getTot() / 3);
//        switch ((int) (sj.getAvg() / 10)) {
//            case 10:
//            case 9: sj.setGrd('수');break;
//            case 8: sj.setGrd('우');break;
//            case 7: sj.setGrd('미');break;
//            case 6: sj.setGrd('양');break;
//            default: sj.setGrd('가');break;
//        }
//        SungJukVO sj2 = new SungJukVO("이름", 99, 88, 77, sj.getTot(), sj.getAvg(), sj.getGrd());
//        System.out.println(sj);
//        int cnt = sjdao.insertSungJuk(sj2);
//        if(sjdao.insertSungJuk(sj2) > 0)
//            System.out.println("insert 성공");
//System.out.println(cnt);