package com.dav.hibernate.controller;

import java.util.List;

import javax.validation.Valid;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dav.hibernate.entity.User;

// TODO: Auto-generated Javadoc
/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("login")
@Transactional
public class LoginController {
    @Autowired
    SessionFactory factory;

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String home(Model  model) {
        model.addAttribute("userFormLow", new User());
        model.addAttribute("userFormMedium", new User());
        model.addAttribute("userFormHigh", new User());
        model.addAttribute("userFormImpossible", new User());
        return "login";
    }

    @RequestMapping(value = "low", method = RequestMethod.POST)
    public String login(User userFormLow, Model model) {
        Session session = factory.getCurrentSession();
        String sql = "SELECT * FROM users u WHERE u.username LIKE '" + userFormLow.getUsername() + "' AND u.password LIKE '" + userFormLow.getPassword() + "'";
        SQLQuery query = session.createSQLQuery(sql).addEntity(User.class);
        List<User> users = query.list();
        model.addAttribute("userlow", users.isEmpty() ? null : users.get(0));
        return "redirect:/login/index.htm";
    }

    @RequestMapping(value = "medium", method = RequestMethod.POST)
    public String loginMedium(User userFormMedium, Model model) {
        Session session = factory.getCurrentSession();
        String sql = "SELECT * FROM users u WHERE u.username LIKE '" + userFormMedium.getUsername() + "' AND u.password LIKE '" + userFormMedium.getPassword() + "'";
        SQLQuery query = session.createSQLQuery(sql).addEntity(User.class);
        List<User> users = query.list();
        model.addAttribute("usermedium", users.isEmpty() ? null : users.get(0));
        return "redirect:/login/index.htm";
    }

    @RequestMapping(value = "high", method = RequestMethod.POST)
    public String loginHigh(@Valid User userFormHigh, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "login";
        } else {
            Session session = factory.getCurrentSession();
            String sql = "SELECT * FROM users u WHERE u.username LIKE '" + userFormHigh.getUsername() + "' AND u.password LIKE '" + userFormHigh.getPassword() + "'";
            SQLQuery query = session.createSQLQuery(sql).addEntity(User.class);
            List<User> users = query.list();
            model.addAttribute("userhigh", users.isEmpty() ? null : users.get(0));
            return "redirect:/login/index.htm";
        }
    }

    @RequestMapping(value = "impossible", method = RequestMethod.POST)
    public String loginImpossible(@Valid User userFormImpossible, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "login";
        } else {
            Session session = factory.getCurrentSession();
            String hql = "FROM User u WHERE u.username LIKE :username";
            Query query = session.createQuery(hql);
            query.setParameter("username", userFormImpossible.getUsername());
            List<User> users = query.list();
            if(!users.isEmpty() && userFormImpossible.getPassword().equals(users.get(0).getPassword())){
                model.addAttribute("userimpossible", users.get(0));
                return "redirect:/login/index.htm";
            }
            model.addAttribute("message", "Invalid username or password");
            return "login";
        }
    }
}
