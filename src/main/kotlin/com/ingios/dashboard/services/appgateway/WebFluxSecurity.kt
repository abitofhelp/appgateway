package com.ingios.dashboard.services.appgateway

import org.springframework.context.annotation.Bean
import org.springframework.http.HttpMethod
import org.springframework.security.config.Customizer.withDefaults
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity
import org.springframework.security.config.web.server.ServerHttpSecurity
import org.springframework.security.web.server.SecurityWebFilterChain
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.reactive.CorsWebFilter
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource

@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
class WebFluxSecurity {

    @Bean
    fun securityWebFilterChain(http: ServerHttpSecurity): SecurityWebFilterChain {
        /***
         * The configure method informs Spring Security to look for an
         * Authorization header with an access token.  It is where we
         * transform this API into an OAuth 2 Resource Server.
         */
        http
                //.csrf().disable()
                //.oauth2Client(withDefaults())
                .authorizeExchange { exchanges ->
                    exchanges
                            .pathMatchers(HttpMethod.GET, "/**").permitAll()
                            //.pathMatchers(HttpMethod.GET, "/userinfo/**")
                            //.hasAuthority("SCOPE_userinfo:groups")
                            .anyExchange()
                            .authenticated()

                }
                //.oauth2Client(withDefaults())
                //.oauth2Login {
                    // oauth2Login is only needed if you want to require
                    // authentication from a browser.
                //}
//                .oauth2ResourceServer { oauth2ResourceServer ->
//                    oauth2ResourceServer
//                            .jwt(withDefaults())
//                }

        // If oauth2Login() Send a 401 message to the browser (w/o this, you'll see a blank page)
        //Okta.configureResourceServer401ResponseBody(http)

        return http.build()
    }

////    @Bean
////    fun corsWebFilter(): CorsWebFilter? {
////        // Since our UI is an SPA, we need to configure CORS.
////        val corsConfig = CorsConfiguration()
////        corsConfig.allowedOrigins = listOf("*")
////        corsConfig.maxAge = 3600L
////        corsConfig.addAllowedMethod("*")
////        corsConfig.addAllowedHeader("*")
////        val source = UrlBasedCorsConfigurationSource()
////        source.registerCorsConfiguration("/**", corsConfig)
////        return CorsWebFilter(source)
////    }
//
////    /**
////     *  Instruct Spring Security that you wish to act
////     *  as an OAuth2 Client so that you can obtain an access gateway.
////     */
////    @Bean
////    @Throws(Exception::class)
////    fun configure(http: ServerHttpSecurity): SecurityWebFilterChain? {
////        http
////            .oauth2Client(withDefaults())
////           .csrf().disable()
////       return http.build()
////    }
}