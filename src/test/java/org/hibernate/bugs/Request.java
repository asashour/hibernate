package org.hibernate.bugs;

import jakarta.persistence.*;
import org.hibernate.annotations.SQLRestriction;

@Entity
@SQLRestriction("tampered = false")
public abstract class Request {


    @Id
    @GeneratedValue
    protected int id;

}
