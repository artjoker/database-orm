package com.artjoker.orm;

import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.TypeSpec;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedOptions;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;



@SupportedAnnotationTypes({"*"})
@SupportedSourceVersion(SourceVersion.RELEASE_8)
@SupportedOptions("debug")
public class TableProcessor extends AbstractProcessor {

    public static final String PACKAGE_NAME = "orm";

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        for (Element e : roundEnv.getElementsAnnotatedWith(DatabaseTable.class)) {
            ContractGenerator.generateContractClass(e, this);
        }
        return true;
    }

    public void writeToFile(String packageName, TypeSpec clazz) {
        JavaFile javaFile = JavaFile.builder(packageName, clazz)
                .build();

        try {
            javaFile.writeTo(processingEnv.getFiler());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Constants for generated sources
     */
    public interface Prefix {
        String CONTRACT_SUFFIX = "Contract";
        String TABLE_SUFFIX = "TABLE";
        String COLUMNS_SUFFIX = "Columns";
        String CONTRACTS = ".contracts";
    }
}
