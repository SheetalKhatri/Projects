package com.mh.trektrekker.daphehmis.cure.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author SheetalKhatri on 8/27/2020
 */

@Entity
@Data
public class Cure {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private int patientId;
    private int careBY;
    private int examineBy;
    private String diagnosisDescription;

}
