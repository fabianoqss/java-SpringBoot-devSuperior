package com.exercicio.dependencias.Exercicio.services;

import com.exercicio.dependencias.Exercicio.entities.Order;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {

    public double shipment(Order order){
        double value = order.getBasic();

        if(value < 100.0){
            return 20.0;
        }else if(value >= 100.0 && value <= 200.0){
            return 12.0;
        }
        return 0.0;
    }

}
