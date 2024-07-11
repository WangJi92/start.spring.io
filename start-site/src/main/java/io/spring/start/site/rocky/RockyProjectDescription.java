package io.spring.start.site.rocky;

import io.spring.initializr.generator.project.MutableProjectDescription;
import io.spring.initializr.metadata.Type;

/**
 * <p> </p>
 *
 * @author wangji
 * @date 2024/7/11 22:55
 */
public class RockyProjectDescription  extends MutableProjectDescription {

    private Type buildType;

    public Type getBuildType() {
        return buildType;
    }

    public void setBuildType(Type buildType) {
        this.buildType = buildType;
    }
}
