package com.ingios.dashboard.services.appgateway.filters

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.cloud.gateway.filter.GatewayFilter
import org.springframework.cloud.gateway.filter.GatewayFilterChain
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory
import org.springframework.stereotype.Component
import org.springframework.web.server.ServerWebExchange
import reactor.core.publisher.Mono

@Component
class TenantTokenFilter : AbstractGatewayFilterFactory<TenantTokenFilter.Config>(Config::class.java) {
    val logger: Logger = LoggerFactory.getLogger(TenantTokenFilter::class.java)

    data class Config(
        val preLogger: Boolean = true,
        val postLogger: Boolean = true
    )

    override fun apply(config: Config?): GatewayFilter {
        return GatewayFilter { exchange: ServerWebExchange, chain: GatewayFilterChain ->
            // Pre-processing
            if (config != null) {
                if (config.preLogger) {
                    logger.error(">>>>>>>>>>>>>PRE GATEWAYFILTER LOGGING: CRACKING THE TENANTTOKEN'S SECRETS...")
                }
            }

            chain.filter(exchange)
                    .then(Mono.fromRunnable {
                        // Post-processing
                        if (config != null) {
                            if (config.postLogger) {
                                logger.error(">>>>>>>>>>>>>POST GATEWAYFILTER LOGGING: SECURING THE SECRETS FOR MICROSERVICES TO USE...")
                            }
                        }
                    })
        }
    }


}
