package com.aice.plugins;

import org.gradle.api.Plugin
import org.gradle.api.Project

class TestPlugins implements Plugin<Project> {
    @Override
    void apply(Project project) {
        println("执行自定义插件")
        project.task("haha"){
            doLast{
                println("执行自定义插件 haha task")
            }
        }
        println("执行自定义插件结束")
    }
}
