package com.ingios.dashboard.services.appgateway
//
//import org.springframework.context.annotation.Bean
//import org.springframework.context.annotation.Configuration
//import org.springframework.http.HttpHeaders
//import org.springframework.http.MediaType
//import org.springframework.security.oauth2.client.*
//import org.springframework.security.oauth2.client.registration.ReactiveClientRegistrationRepository
//import org.springframework.security.oauth2.client.web.reactive.function.client.ServerOAuth2AuthorizedClientExchangeFilterFunction
//import org.springframework.web.reactive.function.client.WebClient
//import reactor.core.publisher.Mono
//import java.util.function.Function
//
//@Configuration
//class WebClientConfig(
//    private val applicationProperties: ApplicationProperties
//) {
//
//    private val kClientRegistrationId = "airvantage"
//    private val kIoTServiceUri = "https://na.airvantage.net"
//
//    @Bean
//    fun authorizedClientManager(
//        clientRegistrationRepository: ReactiveClientRegistrationRepository?
//    ): ReactiveOAuth2AuthorizedClientManager? {
//
//        val authorizedClientProvider =
//            ReactiveOAuth2AuthorizedClientProviderBuilder.builder()
//                .refreshToken()
//                .password()
//                .build()
//
//        val authorizedClientManager = AuthorizedClientServiceReactiveOAuth2AuthorizedClientManager(
//            clientRegistrationRepository,
//            InMemoryReactiveOAuth2AuthorizedClientService(clientRegistrationRepository)
//        )
//
//        authorizedClientManager.setAuthorizedClientProvider(authorizedClientProvider)
//        // We need to add the username and password to the context.
//        authorizedClientManager.setContextAttributesMapper(contextAttributesMapper())
//        return authorizedClientManager
//    }
//
//    private fun contextAttributesMapper(): Function<OAuth2AuthorizeRequest, Mono<MutableMap<String, Any>>> {
//
//        return Function<OAuth2AuthorizeRequest, Mono<MutableMap<String, Any>>> { _ ->
//
//            // At this time, OAuth2 password grant flow does not include these attributes in application.yml.
//            val username = applicationProperties.security.oAuthPasswordFlowProperties.username
//            val password = applicationProperties.security.oAuthPasswordFlowProperties.password
//
//            Mono.just(
//                mutableMapOf<String, Any>(
//                    OAuth2AuthorizationContext.USERNAME_ATTRIBUTE_NAME to username,
//                    OAuth2AuthorizationContext.PASSWORD_ATTRIBUTE_NAME to password
//                )
//            )
//        }
//    }
//
//    @Bean
//    fun webClient(authorizedClientManager: ReactiveOAuth2AuthorizedClientManager?): WebClient? {
//        val oauth = ServerOAuth2AuthorizedClientExchangeFilterFunction(authorizedClientManager)
//        oauth.setDefaultOAuth2AuthorizedClient(true)
//        oauth.setDefaultClientRegistrationId(kClientRegistrationId)
//        return WebClient.builder()
//            .filter(oauth)
//            .baseUrl(kIoTServiceUri)
//            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
//            .build()
//    }
//}

