package catgirl.spring4.sungjukv6.controller;

import catgirl.spring4.sungjukv6.model.SungJukVO;
import catgirl.spring4.sungjukv6.service.SungJukV6Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SungjukController {
    private SungJukV6Service sjsrv;
    @Autowired
    public SungjukController(SungJukV6Service sjsrv) {
        this.sjsrv = sjsrv;
    }

    // 성적 리스트
    @GetMapping("/list")
    public ModelAndView list(){
        ModelAndView mv = new ModelAndView();

        // sungjuklist.jsp에 성적조회결과를 sjs라는 이름으로 넘김
        mv.addObject("sjs", sjsrv.readSungJuk());
        mv.setViewName("sungjuklist"); // 뷰 이름 지정
        return mv;
    }

    // 성적 입력폼 표시
    @GetMapping("/add")
    public String add() {
        return "sungjuk";
    }

    // 성적 입력 처리
    @PostMapping("/add")
    public ModelAndView addok(SungJukVO sj) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("sj", sj);
        mv.setViewName("sungjukok");

        return mv;
    }

}
