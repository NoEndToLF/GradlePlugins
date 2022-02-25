package com.aice.plugins;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.Task;
import org.gradle.api.tasks.TaskContainer;

import java.util.List;
import java.util.Set;


public class TestPlugins implements Plugin<Project> {
    @Override
    public void apply(Project project) {
        System.out.println("执行自定义插件");
        TestModel testModel = project.getExtensions().create("wxy", TestModel.class);
        Task testTask = project.task("haha");
        testTask.doFirst(task -> {
            System.out.println("执行自定义插件 haha task：" + testModel.fullName + "=" + testModel.age);
        });

        Set<Task> preLoad = project.getTasksByName("preBuild", true);
        for (Task task : preLoad) {
            task.dependsOn(testTask);
            System.out.println("task name: " + task.getName());
            return;
        }
    }
}
