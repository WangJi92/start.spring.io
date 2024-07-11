package io.spring.start.site.rocky.config;

import io.spring.initializr.metadata.InitializrMetadataProvider;
import io.spring.initializr.web.autoconfigure.InitializrAutoConfiguration;
import io.spring.initializr.web.controller.ProjectGenerationController;
import io.spring.initializr.web.project.DefaultProjectRequestPlatformVersionTransformer;
import io.spring.initializr.web.project.ProjectGenerationInvoker;
import io.spring.initializr.web.project.ProjectRequestPlatformVersionTransformer;
import io.spring.start.site.rocky.RockyWebProjectRequest;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p> </p>
 * <p>
 * {@link  InitializrAutoConfiguration.InitializrWebConfiguration#projectGenerationController 覆盖自动装配}
 *
 * @author wangji
 * @date 2024/7/11 22:45
 */
@Configuration
public class RockyProjectGenerationConfig {

    /**
     * 自定义类处理
     *
     * @param metadataProvider
     * @param platformVersionTransformer
     * @param applicationContext
     * @return
     */
    @Bean
    ProjectGenerationController<RockyWebProjectRequest> projectGenerationController(
            InitializrMetadataProvider metadataProvider,
            ObjectProvider<ProjectRequestPlatformVersionTransformer> platformVersionTransformer,
            ApplicationContext applicationContext) {
        ProjectGenerationInvoker<RockyWebProjectRequest> projectGenerationInvoker = new ProjectGenerationInvoker<>(
                applicationContext, new RockyProjectRequestToDescriptionConverter(platformVersionTransformer
                .getIfAvailable(DefaultProjectRequestPlatformVersionTransformer::new)));
        return new RockyProjectGenerationController(metadataProvider, projectGenerationInvoker);
    }
}
