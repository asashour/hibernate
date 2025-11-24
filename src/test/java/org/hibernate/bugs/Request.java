package org.hibernate.bugs;

import jakarta.persistence.*;
import org.hibernate.annotations.SQLRestriction;

@Entity
public abstract class Request {

    @Id
    @GeneratedValue
    protected int id;

}
