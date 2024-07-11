package io.spring.start.site.rocky.config;

import io.spring.initializr.metadata.InitializrMetadataProvider;
import io.spring.initializr.web.controller.ProjectGenerationController;
import io.spring.initializr.web.project.ProjectGenerationInvoker;
import io.spring.start.site.rocky.RockyWebProjectRequest;

import java.util.Map;

/**
 * <p> 自定义请求字段的信息</p>
 *
 * @author wangji
 * @date 2024/7/11 22:52
 */
public class RockyProjectGenerationController extends ProjectGenerationController<RockyWebProjectRequest> {

    public RockyProjectGenerationController(InitializrMetadataProvider metadataProvider,
                                            ProjectGenerationInvoker<RockyWebProjectRequest> projectGenerationInvoker) {
        super(metadataProvider, projectGenerationInvoker);
    }

    @Override
    public RockyWebProjectRequest projectRequest(Map<String, String> headers) {
        RockyWebProjectRequest request = new RockyWebProjectRequest();
        request.getParameters().putAll(headers);
        request.initialize(getMetadata());
        return request;
    }

}