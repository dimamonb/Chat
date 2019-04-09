package ru.sbrf.sandbox.sberchat.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.sbrf.sandbox.sberchat.domain.Message;
import ru.sbrf.sandbox.sberchat.domain.SberchatService;

import java.util.Random;

/**
 * Simple chat controller.
 */
@Controller
@RequestMapping(value = "/")
public class SberchatController {

    private static Random rnd = new Random();

    @Autowired
    private SberchatService sberchatService;

    @RequestMapping(method = RequestMethod.GET)
    public String list(ModelMap model) {
        model.addAttribute("messages", sberchatService.getMessages());
        model.addAttribute("defaultMessage", getRandom(msgs));
        model.addAttribute("defaultName", getRandom(names));
        return "sberchat";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String add(
            @RequestParam("name")String name, @RequestParam("text")String text,
            ModelMap model
    ) {
        Message message = new Message();
        message.setName(name);
        message.setText(text);
        sberchatService.addMessage(message);
        return "redirect:";
    }

    private String getRandom(String[] s) {
        return s[rnd.nextInt(s.length)];
    }

    private String[] msgs = {"привет", "как дела?", "ты с какова города?", ":)", "ты тут?", "я всё", "где все?", "ок",
                             "давно не виделись", "пошли гулять!", "ааааа!!!!!11111адынадын", "лол"};
    private String[] names = {"Вася", "Игорь", "Лена", "Миша"};
}
