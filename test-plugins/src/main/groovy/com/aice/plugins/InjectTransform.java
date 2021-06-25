package com.aice.plugins;

import com.android.build.api.transform.DirectoryInput;
import com.android.build.api.transform.Format;
import com.android.build.api.transform.QualifiedContent;
import com.android.build.api.transform.Transform;
import com.android.build.api.transform.TransformException;
import com.android.build.api.transform.TransformInput;
import com.android.build.api.transform.TransformInvocation;
import com.android.build.gradle.internal.pipeline.TransformManager;

import org.gradle.api.Project;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import static org.codehaus.groovy.runtime.DefaultGroovyMethods.println;

class InjectTransform extends Transform {

    private Project mProject;

    InjectTransform(Project project) {
        this.mProject = project;
    }

    @Override
    public String getName() {
        return "testTransform";
    }

    @Override
    public Set<QualifiedContent.ContentType> getInputTypes() {
        return TransformManager.CONTENT_CLASS;
    }

    @Override
    public Set<? super QualifiedContent.Scope> getScopes() {
        return TransformManager.SCOPE_FULL_PROJECT;
    }

    @Override
    public boolean isIncremental() {
        return true;
    }

    @Override
    public void transform(TransformInvocation transformInvocation) throws TransformException, InterruptedException, IOException {
        for (TransformInput transformInput : transformInvocation.getInputs()) {
            for (DirectoryInput directoryInput : transformInput.getDirectoryInputs()) {
                String path = directoryInput.getFile().getAbsolutePath();
                System.out.println("[InjectTransform] Begin to inject: " + path);
                File dest = transformInvocation.getOutputProvider().getContentLocation(directoryInput.getName(), directoryInput.getContentTypes(), directoryInput.getScopes(), Format.DIRECTORY);
                System.out.println("[InjectTransform] Directory output dest: " + dest.getAbsolutePath());
            }

        }

    }
}
