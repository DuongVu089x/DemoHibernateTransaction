package com.dav.hibernate.controller;

import java.util.List;

import javax.validation.Valid;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
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
    public String home(Model model) {
        model.addAttribute("userForm", new User());
        model.addAttribute("userFormMedium", new User());
        model.addAttribute("userFormHigh", new User());
        model.addAttribute("userFormImpossible", new User());
        return "login";
    }

    @RequestMapping(value = "low", method = RequestMethod.POST)
    public String login(@ModelAttribute(value = "userForm") User userForm, Model model) {
        Session session = factory.getCurrentSession();
        String hql = "SELECT * FROM users u WHERE u.username LIKE '" + userForm.getUsername() + "' AND u.password LIKE '" + userForm.getPassword() + "'";
        SQLQuery query = session.createSQLQuery(hql).addEntity(User.class);
        List<User> users = query.list();
        model.addAttribute("userlow", users.isEmpty() ? null : users.get(0));
        return "login";
    }

    @RequestMapping(value = "medium", method = RequestMethod.POST)
    public String loginMedium(@ModelAttribute(value = "userFormMedium") User userFormMedium, Model model) {
        Session session = factory.getCurrentSession();
        String hql = "SELECT * FROM users u WHERE u.username LIKE '" + userFormMedium.getUsername() + "' AND u.password LIKE '" + userFormMedium.getPassword() + "'";
        SQLQuery query = session.createSQLQuery(hql).addEntity(User.class);
        List<User> users = query.list();
        model.addAttribute("usermedium", users.isEmpty() ? null : users.get(0));
        return "login";
    }

    @RequestMapping(value = "high", method = RequestMethod.POST)
    public String loginHigh(@Valid User userFormHigh, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            System.out.println("123");
            return "login";
        } else {
            Session session = factory.getCurrentSession();
            String hql = "SELECT * FROM users u WHERE u.username LIKE '" + userFormHigh.getUsername() + "' AND u.password LIKE '" + userFormHigh.getPassword() + "'";
            SQLQuery query = session.createSQLQuery(hql).addEntity(User.class);
            List<User> users = query.list();
            model.addAttribute("userhigh", users.isEmpty() ? null : users.get(0));
            return "login";
        }
    }

    @RequestMapping(value = "impossible", method = RequestMethod.POST)
    public String loginImpossible(@ModelAttribute(value = "userFormImpossible") User userForm, Model model) {
        Session session = factory.getCurrentSession();
        String hql = "SELECT * FROM users u WHERE u.username LIKE '" + userForm.getUsername() + "' AND u.password LIKE '" + userForm.getPassword() + "'";
        SQLQuery query = session.createSQLQuery(hql).addEntity(User.class);
        List<User> users = query.list();
        model.addAttribute("userimpossible", users.isEmpty() ? null : users.get(0));
        return "login";
    }
}
