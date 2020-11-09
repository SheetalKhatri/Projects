package com.mh.trektrekker.daphehmis.cure.Controller;

import com.mh.trektrekker.daphehmis.cure.service.CureService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Sheetal Khatri on 08/27/2020
 */

@Controller
@AllArgsConstructor

public class CureController {

    private final CureService cureService;




    @GetMapping("/cure")
    public String getCureDashboard(ModelMap map) {
        map.put("users",cureService.getCureNeededUser());
        return "cure";
    }
}
