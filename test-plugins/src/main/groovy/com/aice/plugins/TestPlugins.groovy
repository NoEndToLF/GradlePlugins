package com.aice.plugins;

import org.gradle.api.Plugin
import org.gradle.api.Project

class TestPlugins implements Plugin<Project> {
    @Override
    void apply(Project project) {
        println("执行自定义插件")
        project.extensions.add('test',TestModel)
        TestModel extension = project.test
        project.task("haha"){
            doLast{
                println("执行自定义插件 haha task")
                println ">>>>>> name: ${extension.name} age:${extension.age}"
            }
        }
        println("执行自定义插件结束")
    }
}
