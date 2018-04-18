package com.maxrocky.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author yado
 * @create 2018-04-16 14:47
 * @desc
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable{

    private Integer id;

    private String name;

    private Integer age;

}