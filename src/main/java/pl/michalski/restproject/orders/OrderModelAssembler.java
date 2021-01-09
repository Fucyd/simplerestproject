package pl.michalski.restproject.orders;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class OrderModelAssembler implements RepresentationModelAssembler<Order, EntityModel<Order>> {
    @Override
    public EntityModel<Order> toModel(Order entity) {
        EntityModel<Order> orderModel = EntityModel.of(entity,
                linkTo(methodOn(OrderController.class).oneOrder(entity.getId())).withSelfRel(),
                linkTo(methodOn(OrderController.class).allOrders()).withRel("orders"));

        if(entity.getStatus() == Status.IN_PROGRESS){
            orderModel.add(
                    linkTo(methodOn(OrderController.class).cancelOrder(entity.getId())).withRel("cancel"));
            orderModel.add(
                    linkTo(methodOn(OrderController.class).completeOrder(entity.getId())).withRel("complete"));
        }
        return orderModel;
    }
}
