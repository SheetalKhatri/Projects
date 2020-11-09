package com.prestige.postalhmis.order.entity;

import com.prestige.postalhmis.enums.Status;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer id;
    private String sender;
    private String senderAddress;
    private String receiver;
    private String receiverAddress;
    private Status status;

}
