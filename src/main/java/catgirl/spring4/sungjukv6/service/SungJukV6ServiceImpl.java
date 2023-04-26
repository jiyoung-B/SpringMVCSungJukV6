package catgirl.spring4.sungjukv6.service;




import catgirl.spring4.sungjukv6.dao.SungJukV4DAO;
import catgirl.spring4.sungjukv6.dao.SungJukV6DAOImpl;
import catgirl.spring4.sungjukv6.model.SungJukVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("sjsrv")
public class SungJukV6ServiceImpl implements SungJukV6Service {

    private List<SungJukVO> sjs = null;
    private SungJukV4DAO sjdao = null;


    @Autowired
    public SungJukV6ServiceImpl(SungJukV4DAO sjdao) {
        this.sjdao = sjdao;
    }

    public SungJukVO readOneSungJuk(int sjno) {return null;}
    public boolean modifySungJuk(SungJukVO sj) {return false;}
    public boolean removeSungJuk(int sjno) {return false;}

    // 성적리스트 받아옴
    public List<SungJukVO> readSungJuk() {
        return sjdao.selectSungJuk();
    }
    // 성적 데이터 저장
    public boolean newSungJuk(SungJukVO sj) {
        boolean result = false;

        this.computeSungJuk(sj);
        if (sjdao.insertSungJuk(sj) > 0) result = true;
        System.out.println("리저트"+result);

        return result;

    }
    // 성적 데이터 처리
    public void computeSungJuk(SungJukVO sj) {
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
    }


}
