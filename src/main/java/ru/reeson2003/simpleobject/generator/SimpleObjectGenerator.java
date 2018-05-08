package ru.reeson2003.simpleobject.generator;

/**
 * Created by Pavel Gavrilov
 */
public class SimpleObjectGenerator {
    private String packageName = "com.test";
    private String className = "SimpleObject";
    private String valueClassNamePrefix = "Value";
    private String valueClassPropertyNamePrefix = "value";
    private String genericTypePrefix = "T";

    private SimpleObjectGenerator() {

    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private SimpleObjectGenerator instance;
        private Builder() {
            instance = new SimpleObjectGenerator();
        }

        public Builder packageName(String packageName) {
            instance.packageName = packageName;
            return this;
        }

        public Builder className(String className) {
            instance.className = className;
            return this;
        }

        public Builder valueClassNamePrefix(String valueClassNamePrefix) {
            instance.valueClassNamePrefix = valueClassNamePrefix;
            return this;
        }

        public Builder valueClassPropertyNamePrefix(String valueClassPropertyNamePrefix) {
            instance.valueClassPropertyNamePrefix = valueClassPropertyNamePrefix;
            return this;
        }

        public Builder genericTypePrefix(String genericTypePrefix) {
            instance.genericTypePrefix = genericTypePrefix;
            return this;
        }

        public SimpleObjectGenerator build() {
            return instance;
        }
    }

    public String generate(int valuesNumber) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append("package ")
                .append(packageName)
                .append(";\n")
                .append("\n")
                .append("public class ")
                .append(className)
                .append(" {\n" +
                        "    private ")
                .append(className)
                .append("() {\n" +
                        "    }\n");
        appendFactoryMethods(stringBuilder, valuesNumber);
        appendNestedClasses(stringBuilder, valuesNumber);
        stringBuilder
                .append("}");
        return stringBuilder.toString();
    }

    private  void appendNestedClasses(StringBuilder stringBuilder, int valuesNumber) {
        for (int i = 1; i <= valuesNumber; i++) {
            stringBuilder
                    .append("\n" +
                            "    public static class ")
                    .append(valueClassNamePrefix)
                    .append(i)
                    .append("<");
            appendTypes(stringBuilder, i)
                    .append("> ");
            appendExtends(stringBuilder, i)
                    .append("{\n" +
                            "        public final ")
                    .append(genericTypePrefix)
                    .append(i)
                    .append(" ")
                    .append(valueClassPropertyNamePrefix)
                    .append(i)
                    .append(";\n" +
                            "\n" +
                            "        private ")
                    .append(valueClassNamePrefix)
                    .append(i)
                    .append("(");
            appendParameters(stringBuilder, i)
                    .append(") {");
            appendConstructor(stringBuilder, i)
                    .append("\n")
                    .append("        }\n" +
                            "    }\n");

        }
    }

    private  StringBuilder appendConstructor(StringBuilder stringBuilder, int i) {
        if (i > 1) {
            stringBuilder
                    .append("\n" +
                            "            super(");
            appendArguments(stringBuilder, i - 1)
                    .append(");");
        }
        stringBuilder
                .append("\n")
                .append("            this.")
                .append(valueClassPropertyNamePrefix)
                .append(i)
                .append(" = ")
                .append(valueClassPropertyNamePrefix)
                .append(i)
                .append(";");
        return stringBuilder;
    }

    private  StringBuilder appendExtends(StringBuilder stringBuilder, int valuesNumber) {
        if (valuesNumber > 1) {
            stringBuilder
                    .append("extends ")
                    .append(valueClassNamePrefix)
                    .append(valuesNumber - 1)
                    .append("<");
            appendTypes(stringBuilder, valuesNumber - 1)
                    .append("> ");
        }
        return stringBuilder;
    }

    private  StringBuilder appendFactoryMethods(StringBuilder stringBuilder, int valuesNumber) {
        for (int i = 1; i <= valuesNumber; i++) {
            stringBuilder
                    .append("\n" +
                            "    public static <");
            appendTypes(stringBuilder, i);
            stringBuilder.append("> ")
                    .append(valueClassNamePrefix)
                    .append(i)
                    .append("<");
            appendTypes(stringBuilder, i);
            stringBuilder
                    .append("> of(");
            appendParameters(stringBuilder, i);
            stringBuilder
                    .append(") {\n" +
                            "        return new ")
                    .append(valueClassNamePrefix)
                    .append(i)
                    .append("<>(");
            appendArguments(stringBuilder, i);
            stringBuilder
                    .append(");\n" +
                            "    }")
                    .append("\n");
        }
        return stringBuilder;
    }

    private  StringBuilder appendParameters(StringBuilder stringBuilder, int i) {
        for (int j = 1; j <= i; j++) {
            stringBuilder
                    .append(genericTypePrefix)
                    .append(j)
                    .append(" ")
                    .append(valueClassPropertyNamePrefix)
                    .append(j)
                    .append(", ");
        }
        stringBuilder
                .deleteCharAt(stringBuilder.length() - 1)
                .deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder;
    }

    private  StringBuilder appendArguments(StringBuilder stringBuilder, int i) {
        for (int j = 1; j <= i; j++) {
            stringBuilder
                    .append(valueClassPropertyNamePrefix)
                    .append(j)
                    .append(", ");
        }
        stringBuilder
                .deleteCharAt(stringBuilder.length() - 1)
                .deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder;
    }

    private  StringBuilder appendTypes(StringBuilder stringBuilder, int i) {
        for (int j = 1; j <= i; j++) {
            stringBuilder.append(genericTypePrefix)
                    .append(j)
                    .append(", ");
        }
        stringBuilder
                .deleteCharAt(stringBuilder.length() - 1)
                .deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder;
    }
}
