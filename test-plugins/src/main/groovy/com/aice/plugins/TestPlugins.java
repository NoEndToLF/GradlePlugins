package com.aice.plugins;

import com.android.build.gradle.AppExtension;

import org.gradle.api.Action;
import org.gradle.api.NamedDomainObjectContainer;
import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.Task;

import java.util.Collections;


class TestPlugins implements Plugin<Project> {
    @Override
    public void apply(Project project) {
        System.out.println("执行自定义插件");
        AppExtension appExtension = (AppExtension) project.getProperties().get("android");
        appExtension.registerTransform(new InjectTransform(project), Collections.EMPTY_LIST);
//        NamedDomainObjectContainer<TestModel> testModelContainer = project.container(TestModel.class);
//        project.getExtensions().add("test", testModelContainer);
//        TestModel extension = (TestModel) project.getExtensions().getByName("test");
//        Task task = project.task("haha");
//        task.doLast(task1 -> {
//            println("执行自定义插件 haha task");
//            println("参数：" + extension.name + "=" + extension.age);
//        });
        System.out.println("执行自定义插件结束");
    }
}
