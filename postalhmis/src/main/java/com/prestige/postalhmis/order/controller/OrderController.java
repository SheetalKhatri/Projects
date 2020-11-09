package com.prestige.postalhmis.order.controller;

import com.prestige.postalhmis.enums.Status;
import com.prestige.postalhmis.order.entity.Order;
import com.prestige.postalhmis.order.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;


@Controller
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/orders")
    public Object getOrders(@RequestParam(required = false) Integer deleteId, ModelMap map, @ModelAttribute("flashAttribute") Object id) {
        if(deleteId != null) {
           orderService.deleteById(deleteId) ;
           map.clear();
           return new ModelAndView("redirect:/orders");
        }
        map.addAttribute("id",id);
        map.put("orders",orderService.findOrders());
        map.put("sheetal","Orders");
        return new ModelAndView("orderPage",map);
    }

    @RequestMapping(value = "/editOrder", method = RequestMethod.GET)
    public String getEditOrders(ModelMap map,@RequestParam int id) {
        map.put("status", Status.values());
        map.put("order", orderService.findOrderById(id));
        return "editOrderPage";
    }

    @RequestMapping(value = "/editOrder", method = RequestMethod.POST)
    public String handleOrdersUpdate(@ModelAttribute("order") Order order){
        System.out.println("Order :: " + order);

        // ID cannot be null for an update operation
        // The HTML form includes a hidden input field to make sure the POST body
        // contains the "id" value and ModelAttribute can therefore place it in the "order" object.
        assert(order.getId() != null);

        orderService.save(order);

        return "redirect:/orders";
    }

    @RequestMapping(value = "/createOrder", method = RequestMethod.GET)
    public String getCreateOrder(ModelMap map) {
        map.put("status",Status.values());
        return "createOrderPage";
    }

    @RequestMapping(value = "/createOrder", method = RequestMethod.POST)
    public RedirectView handleCreateOrder(@ModelAttribute("order") Order order, RedirectAttributes attributes) {
        int id;
        orderService.save(order);
        id = order.getId();
        attributes.addFlashAttribute("flashAttribute",id );
        attributes.addAttribute("id",id);
        return new RedirectView("/orders");
    }

    @RequestMapping(value = "/order/{id}", method = RequestMethod.GET)
    public String getOrderDetailsById(ModelMap map, @PathVariable("id") int id) {
        map.put("order",orderService.findOrderById(id));
        return "order";
    }
}
