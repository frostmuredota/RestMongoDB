package com.nisum.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.annotation.Generated;
import java.io.Serializable;

/**
 * Created by ramon on 20-01-16.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Person implements Serializable {

    private int id;
    private String name;
    private String lastname;
}
