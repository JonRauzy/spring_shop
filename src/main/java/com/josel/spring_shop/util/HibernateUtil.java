package com.josel.spring_shop.util;

import com.josel.spring_shop.model.Item;
import com.josel.spring_shop.model.Order;
import lombok.Getter;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    @Getter
    private static final SessionFactory sessionFactory =
            new Configuration()
                    .addAnnotatedClass(Item.class)
                    .addAnnotatedClass(Order.class)
                    .buildSessionFactory();
}