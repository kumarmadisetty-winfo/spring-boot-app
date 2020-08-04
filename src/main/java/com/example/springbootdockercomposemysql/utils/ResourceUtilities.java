/*
 * package com.example.springbootdockercomposemysql.utils;
 * 
 * import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
 * import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
 * 
 * import org.springframework.hateoas.Resource; import
 * org.springframework.stereotype.Component;
 * 
 * import com.example.springbootdockercomposemysql.controller.CountryController;
 * import com.example.springbootdockercomposemysql.controller.UserController;
 * import com.example.springbootdockercomposemysql.entity.User;
 * 
 * @Component public class ResourceUtilities {
 * 
 * public static Resource<User> getUserResource(User user) { Resource<User>
 * resource = new Resource<User>(user);
 * resource.add(linkTo(methodOn(UserController.class).findByUserId(user.getId())
 * ).withSelfRel()); if (null != user.getCountry()) {
 * resource.add(linkTo(methodOn(CountryController.class).findByCountryId(user.
 * getCountry().getId()))
 * .withRel("Country").withTitle(user.getCountry().getName())); } return
 * resource; }
 * 
 * }
 */