package com.syj.prompt.config;

import springfox.documentation.spring.web.paths.AbstractPathProvider;
/**
 * @author syj
 * @since 2023/3/8 12:55
 */
public class ApiSwaggerPathProvider extends AbstractPathProvider {
    private String basePath;

    public ApiSwaggerPathProvider(String path) {
        this.basePath = path;
    }

    protected String applicationPath() {
        return this.basePath;
    }

    protected String getDocumentationPath() {
        return "/";
    }
}

