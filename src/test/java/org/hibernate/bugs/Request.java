package org.hibernate.bugs;

import jakarta.persistence.*;

@Entity
public abstract class Request {


    @Id
    @GeneratedValue
    protected int id;

}
