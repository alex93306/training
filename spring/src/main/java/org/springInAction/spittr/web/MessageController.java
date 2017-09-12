package org.springInAction.spittr.web;

import org.springInAction.spittr.model.Message;
import org.springInAction.spittr.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServlet;
import java.util.List;

/**
 * Created by alex on 16.03.2016.
 */
@Controller
@RequestMapping("/messages")
public class MessageController extends HttpServlet {

    private IMessageService iMessageService;

    @Autowired
    public MessageController(IMessageService iMessageService) {
        this.iMessageService = iMessageService;
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<Message> messagesList() {
        return iMessageService.getAllMessages();
    }
}
