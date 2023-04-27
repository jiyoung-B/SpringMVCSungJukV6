package catgirl.spring4.sungjukv6.service;




import catgirl.spring4.sungjukv6.dao.SungJukV4DAO;
import catgirl.spring4.sungjukv6.dao.SungJukV6DAOImpl;
import catgirl.spring4.sungjukv6.model.SungJukVO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("sjsrv")
public class SungJukV6ServiceImpl implements SungJukV6Service {

    private SungJukV4DAO sjdao = null;
    private static final Logger logger = LogManager.getLogger(SungJukV6ServiceImpl.class);


    @Autowired
    public SungJukV6ServiceImpl(SungJukV4DAO sjdao) {
        this.sjdao = sjdao;
    }

    public SungJukVO readOneSungJuk(int sjno) {
        return sjdao.selectOneSungJuk(sjno);
    }
    public boolean modifySungJuk(SungJukVO sj) {
        boolean result = false;
        if(sjdao.updateSungJuk(sj) > 0) result = true;
        return result;
    }
    public boolean removeSungJuk(int sjno) {
        sjdao.deleteSungJuk(sjno);
        return true;
    }

    // 성적리스트 받아옴
    public List<SungJukVO> readSungJuk() {
        return sjdao.selectSungJuk();
    }
    // 성적 데이터 저장
    public boolean newSungJuk(SungJukVO sj) {
        boolean result = false;

        this.computeSungJuk(sj);
        logger.info(sj);

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
