package com.ingios.dashboard.services.appgateway.config
//
//import org.apache.http.client.utils.URIBuilder
//import org.springframework.boot.actuate.health.*
//import org.springframework.context.annotation.Bean
//import org.springframework.stereotype.Component
//import org.springframework.web.reactive.function.client.WebClient
//import reactor.core.publisher.Mono
//import java.net.URI
//import java.util.*
//
//@Component
//class MyReactiveHealthComposite internal constructor() : CompositeReactiveHealthContributor {
//    /**
//     * Returns an iterator over the elements of this sequence that supports removing elements during iteration.
//     */
//    override fun iterator(): MutableIterator<NamedContributor<ReactiveHealthContributor>> {
//        return registerMicroServices().stream()
//                .map { NamedContributor.of(it.name, it.contributor) }.iterator()
//    }
//
//    /**
//     * Return the contributor with the given name.
//     * @param name the name of the contributor
//     * @return a contributor instance of `null`
//     */
//    override fun getContributor(name: String?): ReactiveHealthContributor =
//            registerMicroServices().getContributor(name)
//
//    @Bean
//    private fun doHealthCheck(uri: URI): Mono<Health> =
//        WebClient.create()
//                .get()
//                .uri(URIBuilder(uri).setFragment("/application/actuator/health").build())
//                .retrieve()
//                .bodyToMono(String::class.java)
//                .map { Health.Builder().up().build() }
//                .onErrorResume { ex -> Mono.just(Health.Builder().down(ex).build()) }
//                .log()
//
//    private fun ReactiveHealthContributorRegistry.regContributor(
//            name: String,
//            uri: URI):
//            ReactiveHealthContributorRegistry {
//
//        this.registerContributor(name, ReactiveHealthIndicator {
//            doHealthCheck(uri)
//                    .onErrorResume { ex ->
//                        Mono.just(Health.Builder().down(ex).build())
//                    }
//        })
//
//        return this
//    }
//
//    private fun registerMicroServices(): ReactiveHealthContributorRegistry =
//            DefaultReactiveHealthContributorRegistry(LinkedHashMap())
//                    .regContributor("consul-node2", URI("http://consul-node2"))
//                    .regContributor("consul-node3", URI("http://consul-node3"))
//                    .regContributor("dapisvc", URI("http://dapisvc"))
//                    .regContributor("eapisvc", URI("http://eapisvc"))
//                    .regContributor("mapisvc", URI("http://mapisvc"))
//                    .regContributor("sapisvc", URI("http://sapisvc"))
//                    .regContributor("trkapisvc", URI("http://trkapisvc"))
//                    .regContributor("vault-node1", URI("http://vault-node1"))
//}

