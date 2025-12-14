package com.julianburanits.abmgenerickotlin.infrastructure.web

import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Configuration

/**
 * Configuration that dynamically registers GenericCrudController instances
 * with specific base paths.
 *
 * To add a new entity, simply create a bean of type GenericCrudService<T, ID>
 * annotated with @Service and a custom name, then add it here with the desired path.
 *
 * Example: for users → path "/api/users"
 */
@Configuration
class RouterConfiguration(private val context: ApplicationContext) {

    // Uncomment and customize when a concrete service is added
    // @Bean
    // fun userRouter() = router {
    //     val userService = context.getBean("userCrudService", GenericCrudService::class.java)
    //     val controller = GenericCrudController(userService as GenericCrudService<User, Long>)
    //     "/api/users".nest {
    //         GET { controller.findAll() }
    //         GET("/{id}") { controller.findById(it.pathVariable("id").toLong()) }
    //         POST { controller.create(it.body(User::class.java)) }
    //         PUT("/{id}") { controller.update(it.pathVariable("id").toLong(), it.body(User::class.java)) }
    //         DELETE("/{id}") { controller.deleteById(it.pathVariable("id").toLong()); ServerResponse.noContent().build() }
    //     }
    // }

    // Placeholder: no routes registered yet
    // fun routes() = router { }
}