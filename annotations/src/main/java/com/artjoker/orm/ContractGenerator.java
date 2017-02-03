package com.artjoker.orm;

import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.TypeSpec;

import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.Modifier;

import static com.artjoker.orm.TableProcessor.Prefix.COLUMNS_SUFFIX;
import static com.artjoker.orm.TableProcessor.Prefix.CONTRACTS;
import static com.artjoker.orm.TableProcessor.Prefix.CONTRACT_SUFFIX;



public class ContractGenerator {

    public static final String STRING_FORMAT = "$S";
    public static final String SEPARATOR = "_";

    public static void generateContractClass(Element element, TableProcessor processor) {

        TypeSpec.Builder columns = generateFieldsInterface(element);

        TypeSpec.Builder clazz = TypeSpec.interfaceBuilder(element.getSimpleName() + CONTRACT_SUFFIX)
                .addModifiers(Modifier.PUBLIC, Modifier.STATIC);

        clazz.addField(FieldSpec.builder(String.class, TableProcessor.Prefix.TABLE_SUFFIX)
                .addModifiers(Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL)
                .initializer(STRING_FORMAT, element.getAnnotation(DatabaseTable.class).name())
                .build());

        clazz.addType(columns.build());
        processor.writeToFile(TableProcessor.PACKAGE_NAME + CONTRACTS, clazz.build());
    }



    private static TypeSpec.Builder generateFieldsInterface(Element element) {

        TypeSpec.Builder columns = TypeSpec.interfaceBuilder(element.getSimpleName() + COLUMNS_SUFFIX)
                .addModifiers(Modifier.PUBLIC, Modifier.STATIC);

        for (Element e : element.getEnclosedElements()) {

            if (e.getKind().equals(ElementKind.FIELD)) {

                if (e.getAnnotation(DatabaseField.class) != null) {
                    FieldSpec columnName;
                    if (e.getAnnotation(DatabaseField.class).name().isEmpty()) {
                        columnName = FieldSpec.builder(String.class, Utils.separateWords(e.getSimpleName().toString(), SEPARATOR).toUpperCase())
                                .addModifiers(Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL)
                                .initializer(STRING_FORMAT, e.getSimpleName().toString())
                                .build();

                    } else {
                        columnName = FieldSpec.builder(String.class, Utils.separateWords(e.getAnnotation(DatabaseField.class).name(), SEPARATOR).toUpperCase())
                                .addModifiers(Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL)
                                .initializer(STRING_FORMAT, e.getAnnotation(DatabaseField.class).name())
                                .build();
                    }
                    columns.addField(columnName);
                }
            }

        }
        return columns;
    }
}
